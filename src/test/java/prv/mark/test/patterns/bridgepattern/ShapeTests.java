package prv.mark.test.patterns.bridgepattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://www.tutorialspoint.com/design_pattern/bridge_pattern.htm
 *
 * Created by mlglenn on 10/12/2016.
 */
public class ShapeTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShapeTests.class);

    @Test
    public void testRedCircle() {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        redCircle.draw();
    }
    /*
    Drawing Circle[ color: red, radius: 10, x: 100, 100]
     */

    @Test
    public void testGreenCircle() {
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());
        greenCircle.draw();
    }
    /*
    Drawing Circle[ color: green, radius: 10, x: 100, 100]
     */
}
