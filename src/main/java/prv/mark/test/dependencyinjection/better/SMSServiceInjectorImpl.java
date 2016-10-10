package prv.mark.test.dependencyinjection.better;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://www.journaldev.com/2394/java-dependency-injection-design-pattern-example-tutorial
 *
 * Java Dependency Injection design pattern allows us to remove the hard-coded dependencies and make our application loosely
 * coupled, extendable and maintainable. We can implement dependency injection in java to move the dependency resolution from
 * compile-time to runtime.
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
public class SMSServiceInjectorImpl implements MessageServiceInjector {

    private static final Logger LOGGER = LoggerFactory.getLogger(SMSServiceInjectorImpl.class);

    //Now for every service, we will have to create injector classes

    @Override
    public Consumer getMessageConsumer() {
        LOGGER.debug("SMSServiceInjectorImpl: Getting SMS Message Consumer...");
        LOGGER.error("SMSServiceInjectorImpl: Getting SMS Message Consumer...");
        LOGGER.info("SMSServiceInjectorImpl: Getting SMS Message Consumer...");
        LOGGER.trace("SMSServiceInjectorImpl: Getting SMS Message Consumer...");

        return new ApplicationMessagingExample1(new SMSServiceImpl());
    }
}
