package prv.mark.test.dependencyinjection.better;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://www.journaldev.com/2394/java-dependency-injection-design-pattern-example-tutorial
 *
 * Dependency Injection in java requires at least following:
 *
 * 1. Service components should be designed with base class or interface. It’s better to prefer interfaces or
 *    abstract classes that would define contract for the services.
 * 2. Consumer classes should be written in terms of service interface.
 * 3. Injector classes that will initialize the services and then the consumer classes.
 *
 * BENEFITS of Java Dependency Injection
 *
 * Some of the benefits of using Dependency Injection in Java are:
 *
 * 1. Separation of Concerns
 * 2. Boilerplate Code reduction in application classes because all work to initialize dependencies is
 *    handled by the injector component
 * 3. Configurable components makes application easily extendable
 * 4. Unit testing is easy with mock objects
 *
 * Disadvantages of Java Dependency Injection
 *
 * 1. If overused, it can lead to maintenance issues because effect of changes are known at runtime.
 * 2. Dependency injection in java hides the service class dependencies that can lead to runtime errors
 *    that would have been caught at compile time.
 *
 * Created by mlglenn on 10/7/2016.
 */
public class MessageServiceTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceTests.class);
    private MessageServiceInjector messageServiceInjector;
    //private Consumer consumer;

    @Before
    public void setup() {
        LOGGER.debug("setup()");
        LOGGER.error("setup()");
        LOGGER.info("setup()");
        LOGGER.trace("setup()");
    }

    @After
    public void tearDown(){
        messageServiceInjector = null;
    }

    @Test
    public void testSendEmail() {
        LOGGER.debug("testSendEmail()");
        LOGGER.error("testSendEmail()");
        LOGGER.info("testSendEmail()");
        LOGGER.trace("testSendEmail()");

        String message = "Hi Mark";
        String recipientEmailAddress = "mark@abc.com";

        messageServiceInjector = new EmailMessageServiceInjectorImpl();
        messageServiceInjector.getMessageConsumer().processMessages(message, recipientEmailAddress);
    }

    @Test
    public void testSendSMS() {
        LOGGER.debug("testSendSMS()");
        LOGGER.error("testSendSMS()");
        LOGGER.info("testSendSMS()");
        LOGGER.trace("testSendSMS()");

        String message = "Hi Mark";
        String recipientphone = "1234567890";

        messageServiceInjector = new SMSServiceInjectorImpl();
        messageServiceInjector.getMessageConsumer().processMessages(message, recipientphone);
    }

    /*
     From Pankaj:

     As you can see that our application classes are responsible only for using the service. Service classes
     are created in injectors. Also if we have to further extend our application to allow facebook messaging,
     we will have to write Service classes and injector classes only.

     So dependency injection implementation solved the problem with hard-coded dependency and helped us in making
     our application flexible and easy to extend. Now let’s see how easily we can test our application class by
     mocking the injector and service classes.

     See MessageServiceMockedTests and MessageServiceTests2

     */

}
