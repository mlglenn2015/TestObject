package prv.mark.test.spring.dependencyinjection;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by mlglenn on 10/11/2016.
 */
@Service
@Component
public class MessageServiceExmplImpl implements MessageServiceExmpl {

    public String getMessage() {
        return "MessageServiceExmplImpl.getMessage(): Hello World!";
    }
}
