package prv.mark.test.dependencyinjection.better;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 10/11/2016.
 */
public class MessageServiceImplFaceBook implements MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImplFaceBook.class);

    public MessageServiceImplFaceBook() {
        LOGGER.debug("Instantiating new MessageServiceImplFaceBook class...");
    }


    @Override
    public void sendMessage(String msg, String recipient) {
        LOGGER.debug("MessageServiceImplFaceBook: Sending text msg ({}) to ({}) ...", msg, recipient);

        // implementation code here
    }
}
