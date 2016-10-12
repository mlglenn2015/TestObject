package prv.mark.test.patterns.adapterpattern;

/**
 * https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
 *
 * Created by mlglenn on 10/12/2016.
 */
public interface AdvancedMediaPlayer {

    public void playVlc(String fileName);
    public void playMp4(String fileName);
}
