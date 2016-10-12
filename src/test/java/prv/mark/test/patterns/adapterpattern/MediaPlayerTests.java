package prv.mark.test.patterns.adapterpattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;


/**
 * https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 *
 * Created by mlglenn on 10/12/2016.
 */
public class MediaPlayerTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(MediaPlayerTests.class);
    private AudioPlayer audioPlayer;


    @Before
    public void setUp() {
        LOGGER.debug("setUp()");
        audioPlayer = new AudioPlayer();
        assertNotNull(audioPlayer);
    }

    @After
    public void tearDown() {
        LOGGER.debug("tearDown()");
        audioPlayer = null;
    }

    @Test
    public void testMp3Type() {
        audioPlayer.play("mp3", "beyond the horizon.mp3");
    }
    /*
    10-12-2016 17:43:35.939 DEBUG p.m.t.p.a.MediaPlayerTests - setUp()
10-12-2016 17:43:35.939 DEBUG p.m.t.p.adapterpattern.AudioPlayer - AudioPlayer.play(): Playing MP3 format beyond the horizon.mp3
10-12-2016 17:43:35.939 DEBUG p.m.t.p.a.MediaPlayerTests - tearDown()
     */

    @Test
    public void testMp4Type() {
        audioPlayer.play("mp4", "alone.mp4");
    }
    /*
    10-12-2016 17:43:35.939 DEBUG p.m.t.p.a.MediaPlayerTests - setUp()
10-12-2016 17:43:35.939 DEBUG p.m.t.p.adapterpattern.AudioPlayer - AudioPlayer.play(): Playing mp4 format alone.mp4
10-12-2016 17:43:35.940 DEBUG p.m.t.p.adapterpattern.Mp4Player - Mp4Player.playMp4(): Playing filename alone.mp4
10-12-2016 17:43:35.940 DEBUG p.m.t.p.a.MediaPlayerTests - tearDown()
     */

    @Test
    public void testVlcType() {
        audioPlayer.play("vlc", "far far away.vlc");
    }
    /*
    10-12-2016 17:43:35.937 DEBUG p.m.t.p.a.MediaPlayerTests - setUp()
10-12-2016 17:43:35.937 DEBUG p.m.t.p.adapterpattern.AudioPlayer - AudioPlayer.play(): Playing vlc format far far away.vlc
10-12-2016 17:43:35.938 DEBUG p.m.t.p.adapterpattern.VlcPlayer - VlcPlayer.playVlc(): Playing filename far far away.vlc
10-12-2016 17:43:35.939 DEBUG p.m.t.p.a.MediaPlayerTests - tearDown()
     */

    @Test
    public void testAviType() {
        audioPlayer.play("avi", "mind me.avi");
    }
    /*
    10-12-2016 17:43:35.928 DEBUG p.m.t.p.a.MediaPlayerTests - setUp()
10-12-2016 17:43:35.933 DEBUG p.m.t.p.adapterpattern.AudioPlayer - AudioPlayer.play(): Invalid media format: avi
10-12-2016 17:43:35.935 DEBUG p.m.t.p.a.MediaPlayerTests - tearDown()
     */
}
