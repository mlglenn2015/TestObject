package prv.mark.test.patterns.adapterpattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 *
 * Created by mlglenn on 10/12/2016.
 */
public class MediaAdapter implements MediaPlayer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MediaAdapter.class);
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {

        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {

        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }

}
