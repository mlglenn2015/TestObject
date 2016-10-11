package prv.mark.test.dependencyinjection.better;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 10/11/2016.
 */
public class MsgServiceInjectorImplFaceBook implements MsgServiceInjector {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgServiceInjectorImplFaceBook.class);

    //Now for every service, we will have to create injector classes


    public MsgServiceInjectorImplFaceBook() {
        LOGGER.debug("Instantiating new MsgServiceInjectorImplFaceBook class ...");
    }

    @Override
    public Consumer getMessageConsumer() {
        LOGGER.debug("MsgServiceInjectorImplFaceBook: Getting FaceBook Message Consumer (MessageServiceImplFaceBook) ...");

        return new ConsumerImplConstructorInjection(new MessageServiceImplFaceBook());

        /*
         When using DI at the setter level, it looks like this:

            ApplicationMessagingExample2 application = new ApplicationMessagingExample2();
            application.setMessageService(new EmailServiceImpl());
            return application;

         */
    }

}
