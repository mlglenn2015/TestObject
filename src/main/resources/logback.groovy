import ch.qos.logback.classic.Level
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

// filename: logback.groovy

setupAppenders()
setupLoggers()
//jmxConfigurator()

def setupAppenders() {
    def timestampFmt = "%d{MM-dd-yyyy HH:mm:ss.SSS}"
    def logArchiveDateFmt = "%d{MMddyyyy}"
    def logFmt = "${timestampFmt} %-5level %logger{36} - %msg%n"
    def statFmt = "${timestampFmt} %-5level %logger{36} - %msg%n"
    def logDir = System.getProperty('APP_LOG_LOCATION')
    def monitoringDir = System.getProperty('MONITOR_LOG_LOCATION')

    if (logDir == null) {
        logDir = "/tmp/log"
    }
    if (monitoringDir == null) {
        monitoringDir = "/tmp/monitoring"
    }

    def logFileName = "${logDir}/app.log"
    def monitorFileName = "${monitoringDir}/app_status.log"


    appender('console', ConsoleAppender) {
        encoder(PatternLayoutEncoder) {
            pattern = logFmt
        }
    }

    appender('log_file', RollingFileAppender) {
        file = logFileName
        encoder(PatternLayoutEncoder) {
            pattern = logFmt
        }
        rollingPolicy(TimeBasedRollingPolicy) {
            fileNamePattern = "${logFileName}.${logArchiveDateFmt}"
            maxHistory = 30
        }
    }

    appender('monitor_status', RollingFileAppender) {
        file = monitorFileName
        encoder(PatternLayoutEncoder) {
            pattern = statFmt
        }
        rollingPolicy(TimeBasedRollingPolicy) {
            fileNamePattern = "${monitorFileName}.${logArchiveDateFmt}"
            maxHistory = 3
        }
    }
}

def setupLoggers() {
    //def appLogLevel = getLogLevel()
    def appLogLevel = Level.DEBUG
    def statusLogLevel = Level.DEBUG

    // SOAP request/response logging to console
    logger 'org.springframework.ws.client.MessageTracing.sent', getSoapTracingLevel(), ['console'], false
    logger 'org.springframework.ws.client.MessageTracing.received', getSoapTracingLevel(), ['console'], false
    logger 'org.springframework.ws.server.MessageTracing.sent', getSoapTracingLevel(), ['console'], false
    logger 'org.springframework.ws.server.MessageTracing.received', getSoapTracingLevel(), ['console'], false

    // Application loggers
    logger 'prv.mark.test.domain', appLogLevel, ['console'], false
    logger 'prv.mark.test.java8', appLogLevel, ['console'], false
    logger 'prv.mark.test.patterns', appLogLevel, ['console'], false
    logger 'prv.mark.test.spring', appLogLevel, ['console'], false
    logger 'prv.mark.test.springlifecycle', appLogLevel, ['console'], false
    logger 'prv.mark.test.dependencyinjection', appLogLevel, ['console'], false
    logger 'prv.mark.test.util', appLogLevel, ['console'], false
    logger 'prv.mark.test.MarkSpringApplication', statusLogLevel, ['log_file','monitor_status','console'], false

    root Level.ERROR, ['console']
}

def getSoapTracingLevel() {
    def tracing = System.getProperty("app.soap.tracing")
    (tracing.equals("true") ? Level.TRACE : Level.ERROR)
}

def getLogLevel() {
    def env = System.getProperty("ENVIRONMENT")
    (env.equals("prod") ? Level.ERROR : Level.DEBUG )
}

