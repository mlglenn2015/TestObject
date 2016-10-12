package prv.mark.test.patterns.adapterpattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 *
 * Created by mlglenn on 10/12/2016.
 */
public class AudioPlayer implements MediaPlayer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AudioPlayer.class);
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {

        if (audioType.equalsIgnoreCase("mp3")) {
            //automatically built to play mp3 files
            LOGGER.debug("AudioPlayer.play(): Playing MP3 format {} ", fileName);

        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {

            LOGGER.debug("AudioPlayer.play(): Playing {} format {} ", audioType, fileName);
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);

        } else {
            LOGGER.debug("AudioPlayer.play(): Invalid media format: {} ", audioType);
        }
    }

}
