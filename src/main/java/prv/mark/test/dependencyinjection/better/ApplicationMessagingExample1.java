package prv.mark.test.dependencyinjection.better;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * THIS APPLICATION EXAMPLE IS CONSTRUCTOR-LEVEL DI
 *
 * http://www.journaldev.com/2394/java-dependency-injection-design-pattern-example-tutorial
 *
 * Dependency Injection in java requires at least following:
 *
 * 1. Service components should be designed with base class or interface. It’s better to prefer interfaces or
 *    abstract classes that would define contract for the services.
 * 2. Consumer classes should be written in terms of service interface.
 * 3. Injector classes that will initialize the services and then the consumer classes.
 *
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
public class ApplicationMessagingExample1 implements Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMessagingExample1.class);

    /*
     Notice that our application class is just using the service. It does not initialize the service
     that leads to better “separation of concerns“. Also use of service interface allows us to easily
     test the application by mocking the MessageService and bind the services at runtime rather than
     compile time.
     */
    private MessageService messageService;

    //This is using DI in the Constructor level
    public ApplicationMessagingExample1(MessageService service) {
        this.messageService = service;
    }


    public void processMessages(String message, String recipient) {

        //validation here

        //implemenation logic here

        this.messageService.sendMessage(message, recipient);
    }
}
