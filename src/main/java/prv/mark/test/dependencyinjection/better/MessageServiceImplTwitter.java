package prv.mark.test.dependencyinjection.better;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 10/11/2016.
 */
public class MessageServiceImplTwitter implements MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImplTwitter.class);

    public MessageServiceImplTwitter() {
        LOGGER.debug("Instantiating new MessageServiceImplTwitter class...");
    }


    @Override
    public void sendMessage(String msg, String recipient) {
        LOGGER.debug("MessageServiceImplTwitter: Sending twitter msg ({}) to ({}) ...", msg, recipient);

        // implementation code here
    }
}
