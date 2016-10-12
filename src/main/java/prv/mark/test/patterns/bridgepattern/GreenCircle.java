package prv.mark.test.patterns.bridgepattern;

/**
 * https://www.tutorialspoint.com/design_pattern/bridge_pattern.htm
 *
 * Created by mlglenn on 10/12/2016.
 */
public class GreenCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }

}
