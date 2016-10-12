package prv.mark.test.patterns.adapterpattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 *
 * Created by mlglenn on 10/12/2016.
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    private static final Logger LOGGER = LoggerFactory.getLogger(VlcPlayer.class);

    public void playVlc(String fileName) {
        LOGGER.debug("VlcPlayer.playVlc(): Playing filename {}", fileName);
    }

    public void playMp4(String fileName) {
        LOGGER.debug("VlcPlayer.playMp4(): Playing filename {}", fileName);
    }

}
