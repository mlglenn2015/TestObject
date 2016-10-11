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
public class MessageServiceConstructorInjectionTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceConstructorInjectionTests.class);
    private MsgServiceInjector messageServiceInjector;
    private Consumer consumer; //this may not be necessary

    @Before
    public void setUp() {
        LOGGER.debug("setUp()");
    }

    @After
    public void tearDown() {
        LOGGER.debug("tearDown()");
        consumer = null;
        messageServiceInjector = null;
    }


    @Test
    public void testSendEmail() {
        LOGGER.debug("MessageServiceConstructorInjectionTeststestSendEmail()");

        String message = "Hi Mark";
        String recipientEmailAddress = "mark@abc.com";

        messageServiceInjector = new MsgServiceInjectorImplEmail();
        consumer = messageServiceInjector.getMessageConsumer();
        consumer.processMessages(message, recipientEmailAddress);
    }
    /*
     10-11-2016 17:35:07.776 DEBUG p.m.t.d.b.MessageServiceConstructorInjectionTests - setUp()
     10-11-2016 17:35:07.779 DEBUG p.m.t.d.b.MessageServiceConstructorInjectionTests - testSendEmail()
     10-11-2016 17:35:07.781 DEBUG p.m.t.d.b.MsgServiceInjectorImplEmail - Instantiating new MsgServiceInjectorImplEmail class ...
     10-11-2016 17:35:07.781 DEBUG p.m.t.d.b.MsgServiceInjectorImplEmail - MsgServiceInjectorImplEmail: Getting Email Message Consumer (MessageServiceImplEmail) ...
     10-11-2016 17:35:07.782 DEBUG p.m.t.d.b.MessageServiceImplEmail - Instantiating new MessageServiceImplEmail class...
     10-11-2016 17:35:07.782 DEBUG p.m.t.d.b.ConsumerImplConstructorInjection - ConsumerImplConstructorInjection.processMessages()...
     10-11-2016 17:35:07.782 DEBUG p.m.t.d.b.MessageServiceImplEmail - MessageServiceImplEmail: Sending email msg Hi Mark to mark@abc.com...
     10-11-2016 17:35:07.784 DEBUG p.m.t.d.b.MessageServiceConstructorInjectionTests - tearDown()
     */

    @Test
    public void testSendSMS() {
        LOGGER.debug("MessageServiceConstructorInjectionTeststestSendSMS()");

        String message = "Hi Mark";
        String recipientphone = "1234567890";

        messageServiceInjector = new MsgServiceInjectorImplSMS();
        consumer = messageServiceInjector.getMessageConsumer();
        consumer.processMessages(message, recipientphone);
    }
    /*
     10-11-2016 17:36:02.329 DEBUG p.m.t.d.b.MessageServiceConstructorInjectionTests - setUp()
     10-11-2016 17:36:02.333 DEBUG p.m.t.d.b.MessageServiceConstructorInjectionTests - testSendSMS()
     10-11-2016 17:36:02.334 DEBUG p.m.t.d.b.MsgServiceInjectorImplSMS - Instantiating new MsgServiceInjectorImplSMS class ...
     10-11-2016 17:36:02.334 DEBUG p.m.t.d.b.MsgServiceInjectorImplSMS - MsgServiceInjectorImplSMS: Getting SMS Message Consumer (MessageServiceImplSMS)...
     10-11-2016 17:36:02.336 DEBUG p.m.t.d.better.MessageServiceImplSMS - Instantiating new MessageServiceImplSMS class...
     10-11-2016 17:36:02.336 DEBUG p.m.t.d.b.ConsumerImplConstructorInjection - ConsumerImplConstructorInjection.processMessages()...
     10-11-2016 17:36:02.336 DEBUG p.m.t.d.better.MessageServiceImplSMS - MessageServiceImplSMS: Sending SMS msg Hi Mark to 1234567890...
     10-11-2016 17:36:02.338 DEBUG p.m.t.d.b.MessageServiceConstructorInjectionTests - tearDown()
     */


    @Test
    public void testPostToFaceBook() {
        LOGGER.debug("MessageServiceConstructorInjectionTeststestPostToFaceBook()");

        String message = "Hi Mark";
        String recipientEmailAddress = "mark@facebook.com";

        messageServiceInjector = new MsgServiceInjectorImplFaceBook();
        consumer = messageServiceInjector.getMessageConsumer();
        consumer.processMessages(message, recipientEmailAddress);
    }
    /*
     10-11-2016 17:42:39.118 DEBUG p.m.t.d.b.MessageServiceConstructorInjectionTests - setUp()
     10-11-2016 17:42:39.122 DEBUG p.m.t.d.b.MessageServiceConstructorInjectionTests - testPostToFaceBook()
     10-11-2016 17:42:39.123 DEBUG p.m.t.d.b.MsgServiceInjectorImplFaceBook - Instantiating new MsgServiceInjectorImplFaceBook class ...
     10-11-2016 17:42:39.123 DEBUG p.m.t.d.b.MsgServiceInjectorImplFaceBook - MsgServiceInjectorImplFaceBook: Getting FaceBook Message Consumer (MessageServiceImplFaceBook) ...
     10-11-2016 17:42:39.124 DEBUG p.m.t.d.b.MessageServiceImplFaceBook - Instantiating new MessageServiceImplFaceBook class...
     10-11-2016 17:42:39.125 DEBUG p.m.t.d.b.ConsumerImplConstructorInjection - ConsumerImplConstructorInjection.processMessages()...
     10-11-2016 17:42:39.125 DEBUG p.m.t.d.b.MessageServiceImplFaceBook - MessageServiceImplFaceBook: Sending email msg (Hi Mark) to (mark@facebook.com) ...
     10-11-2016 17:42:39.126 DEBUG p.m.t.d.b.MessageServiceConstructorInjectionTests - tearDown()
     */

    @Test
    public void testPostToTwitter() {
        LOGGER.debug("MessageServiceConstructorInjectionTeststestPostToTwitter()");

        String message = "Hi Mark";
        String recipientEmailAddress = "@marky123";

        messageServiceInjector = new MsgServiceInjectorImplTwitter();
        consumer = messageServiceInjector.getMessageConsumer();
        consumer.processMessages(message, recipientEmailAddress);
    }
    /*
     10-11-2016 17:48:06.851 DEBUG p.m.t.d.b.MessageServiceConstructorInjectionTests - setUp()
     10-11-2016 17:48:06.856 DEBUG p.m.t.d.b.MessageServiceConstructorInjectionTests - testPostToTwitter()
     10-11-2016 17:48:06.857 DEBUG p.m.t.d.b.MsgServiceInjectorImplTwitter - Instantiating new MsgServiceInjectorImplTwitter class ...
     10-11-2016 17:48:06.857 DEBUG p.m.t.d.b.MsgServiceInjectorImplTwitter - MsgServiceInjectorImplTwitter: Getting Twitter Message Consumer (MsgServiceInjectorImplTwitter) ...
     10-11-2016 17:48:06.858 DEBUG p.m.t.d.b.MessageServiceImplTwitter - Instantiating new MessageServiceImplTwitter class...
     10-11-2016 17:48:06.858 DEBUG p.m.t.d.b.ConsumerImplConstructorInjection - ConsumerImplConstructorInjection.processMessages()...
     10-11-2016 17:48:06.859 DEBUG p.m.t.d.b.MessageServiceImplTwitter - MessageServiceImplTwitter: Sending twitter msg (Hi Mark) to (@marky123) ...
     10-11-2016 17:48:06.860 DEBUG p.m.t.d.b.MessageServiceConstructorInjectionTests - tearDown()
     */


    /*
     From Pankaj:

     As you can see that our application classes are responsible only for using the service. Service classes
     are created in injectors. Also if we have to further extend our application to allow facebook messaging,
     we will have to write Service classes and injector classes only.

     So dependency injection implementation solved the problem with hard-coded dependency and helped us in making
     our application flexible and easy to extend. Now let’s see how easily we can test our application class by
     mocking the injector and service classes.

     See MessageServiceMockedTests and MessageServiceSetterInjectionTests

     */

}
