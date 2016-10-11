package prv.mark.test.spring.dependencyinjection;

import org.springframework.stereotype.Component;

/**
 * http://projects.spring.io/spring-framework/
 *
 * Created by mlglenn on 10/11/2016.
 */
@Component
public class MessagePrinter {

    private MessageServiceExmpl messageService = null;

    /*
      The below example did not work as portrayed on the springio website. I had to add
      the MessagePrinter bean definition and set the MessageServiceImpl in the bean
      definition. The MessagePrinter was not auto wiring in this class.
     */

    /*@Autowired
    public MessagePrinter(MessageServiceExmpl service) {
        this.messageService = service;
    }*/

    private MessageServiceExmpl getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageServiceExmpl messageService) {
        this.messageService = messageService;
    }

    public String getMessage() {
        return getMessageService().getMessage();
    }

    public void printMessage() {
        System.out.println(this.messageService.getMessage());
    }
}
