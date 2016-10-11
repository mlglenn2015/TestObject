package prv.mark.test.spring.dependencyinjection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * http://projects.spring.io/spring-framework/
 *
 * Created by mlglenn on 10/11/2016.
 */
public class MessageServiceTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceTests.class);

    @Before
    public void setUp() {
        LOGGER.debug("setUp()");
    }

    @After
    public void tearDown() {
        LOGGER.debug("tearDown()");
    }

    @Test
    public void testDependencyInjection() {
        LOGGER.debug("testDependencyInjection() entry");
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);
        assertNotNull(context);
        LOGGER.debug("Application context: {}", context);

        /*
         The example shows the basic concept of dependency injection.

         This test case represents the client. This client is only aware of the MessagePrinter, and is
         not aware of the service that actually provides the implementation. The MessagePrinter is therefore
         decoupled from the MessageService implementation, with Spring Framework wiring everything together.
         */
        MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
        assertNotNull(messagePrinter);
        LOGGER.debug("MessagePrinter: {}", messagePrinter);
        //messagePrinter.printMessage();

        String message = messagePrinter.getMessage();
        LOGGER.debug("Message to print: {}", message);
    }
    /*
    10-11-2016 15:01:45.627 DEBUG p.m.t.s.d.MessageServiceTests - setUp()
10-11-2016 15:01:45.630 DEBUG p.m.t.s.d.MessageServiceTests - testDependencyInjection() entry
10-11-2016 15:01:46.039 DEBUG p.m.t.s.d.MessageServiceTests - Application context: org.springframework.context.annotation.AnnotationConfigApplicationContext@6736fa8d: startup date [Tue Oct 11 15:01:45 EDT 2016]; root of context hierarchy
10-11-2016 15:01:46.041 DEBUG p.m.t.s.d.MessageServiceTests - MessagePrinter: prv.mark.test.spring.dependencyinjection.MessagePrinter@5e8ac0e1
10-11-2016 15:01:46.041 DEBUG p.m.t.s.d.MessageServiceTests - Message to print: MessageServiceExmplImpl.getMessage(): Hello World!
10-11-2016 15:01:46.041 DEBUG p.m.t.s.d.MessageServiceTests - tearDown()
     */
}
