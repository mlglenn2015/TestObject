package prv.mark.test.spring.dependencyinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * http://projects.spring.io/spring-framework/
 *
 * Created by mlglenn on 10/11/2016.
 */
@Configuration
public class MessageConfig {


    /*
      The below example did not work as portrayed on the springio website. I had to add
      the MessagePrinter bean definition and set the MessageServiceImpl in the bean
      definition.
     */
    @Bean
    public MessagePrinter getMessagePrinter() {
        MessagePrinter messagePrinter = new MessagePrinter();
        MessageServiceExmpl messageService = new MessageServiceExmplImpl();
        messagePrinter.setMessageService(messageService);
        return messagePrinter;
    }

    /*@Bean(name="messageServiceExmplImpl")
    public MessageServiceExmpl messageServiceExmplImpl() {
        return new MessageServiceExmplImpl();
    }*/

    /*@Bean(name="messageServiceExmplImpl")
    public MessageServiceExmpl messageServiceExmplImpl() {
        return new MessageServiceExmpl() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }*/

    /*@Bean  did not compile "No such bean definition" error
    public MessageService messageService() {

        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };

    }*/
}
