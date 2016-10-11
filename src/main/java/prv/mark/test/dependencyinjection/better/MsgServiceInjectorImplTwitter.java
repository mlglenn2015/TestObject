package prv.mark.test.dependencyinjection.better;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 10/11/2016.
 */
public class MsgServiceInjectorImplTwitter implements MsgServiceInjector {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgServiceInjectorImplTwitter.class);

    //Now for every service, we will have to create injector classes


    public MsgServiceInjectorImplTwitter() {
        LOGGER.debug("Instantiating new MsgServiceInjectorImplTwitter class ...");
    }

    @Override
    public Consumer getMessageConsumer() {
        LOGGER.debug("MsgServiceInjectorImplTwitter: Getting Twitter Message Consumer (MsgServiceInjectorImplTwitter) ...");

        return new ConsumerImplConstructorInjection(new MessageServiceImplTwitter());

        /*
         When using DI at the setter level, it looks like this:

            ApplicationMessagingExample2 application = new ApplicationMessagingExample2();
            application.setMessageService(new EmailServiceImpl());
            return application;

         */
    }

}