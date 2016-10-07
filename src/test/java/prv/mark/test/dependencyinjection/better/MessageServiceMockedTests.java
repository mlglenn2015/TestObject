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
public class MessageServiceMockedTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceMockedTests.class);
    private MessageServiceInjector messageServiceInjector;
    private Consumer consumer;

    @Before
    public void setUp() {

        //mock the injector with anonymous class
        messageServiceInjector = new MessageServiceInjector() {

            @Override
            public Consumer getMessageConsumer() {
                //mock the message service
                return new ApplicationMessagingExample1(new MessageService() {
                    @Override
                    public void sendMessage(String msg, String rec) {
                        LOGGER.debug("Mock Message Service implementation");
                        LOGGER.error("Mock Message Service implementation");
                        LOGGER.info("Mock Message Service implementation");
                        LOGGER.trace("Mock Message Service implementation");
                    }
                });
            }

        }; //anonymous class
    }

    @After
    public void tearDown(){
        messageServiceInjector = null;
    }

    @Test
    public void testMockedEmailConsumer() {
        String message = "Hi Mark";
        String recipientEmailAddress = "mark@abc.com";
        Consumer consumer = messageServiceInjector.getMessageConsumer();
        consumer.processMessages(message, recipientEmailAddress);
    }

    /*
     From Pankaj:

     As you can see that I am using anonymous classes to mock the injector and service classes and
     I can easily test my application methods. I am using JUnit 4 for above test class, so make sure
     it’s in your project build path if you are running above test class.

     See MessageServiceTests2
     */
}
