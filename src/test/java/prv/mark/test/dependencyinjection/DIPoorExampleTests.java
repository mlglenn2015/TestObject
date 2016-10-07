package prv.mark.test.dependencyinjection;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import prv.mark.test.domain.Circle;
import prv.mark.test.domain.Square;

/**
 * Created by mlglenn on 10/7/2016.
 */
public class DIPoorExampleTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(DIPoorExampleTests.class);

    @Before
    public void setup() {
        LOGGER.debug("setup()");
        LOGGER.info("setup()");
        LOGGER.error("setup()");
        LOGGER.trace("setup()");
    }

    @Test
    public void testConstructor() {
        LOGGER.debug("testConstructor()");
        LOGGER.info("testConstructor()");
        LOGGER.trace("testConstructor()");
        LOGGER.error("testConstructor()");

        Square square = new Square();
        Circle circle = new Circle();

        LOGGER.debug("circle: {}", circle);
        LOGGER.info("circle: {}", circle);
        LOGGER.error("circle: {}", circle);
        LOGGER.trace("circle: {}", circle);

        LOGGER.debug("square: {}", square);
        LOGGER.info("square: {}", square);
        LOGGER.error("square: {}", square);
        LOGGER.trace("square: {}", square);

        DIPoorExample example = new DIPoorExample(square, circle); //The caller is holding references to our internal objects and thus invalidate the state of DIPoorExample

        LOGGER.debug("example: {}", example);
        LOGGER.info("example: {}", example);
        LOGGER.error("example: {}", example);
        LOGGER.trace("example: {}", example);

        LOGGER.debug("example.getCircle(): {}", example.getCircle());
        LOGGER.info("example.getCircle(): {}", example.getCircle());
        LOGGER.error("example.getCircle(): {}", example.getCircle());
        LOGGER.trace("example.getCircle(): {}", example.getCircle());

        LOGGER.debug("example.getSquare(): {}", example.getSquare());
        LOGGER.info("example.getSquare(): {}", example.getSquare());
        LOGGER.error("example.getSquare(): {}", example.getSquare());
        LOGGER.trace("example.getSquare(): {}", example.getSquare());
    }
    /*
     10-07-2016 12:03:06.309 ERROR p.m.t.d.DIPoorExampleTests - setup()
     10-07-2016 12:03:06.319 ERROR p.m.t.d.DIPoorExampleTests - testConstructor()
     10-07-2016 12:03:06.321 ERROR p.m.t.d.DIPoorExampleTests - circle: prv.mark.test.domain.Circle@6736fa8d
     10-07-2016 12:03:06.323 ERROR p.m.t.d.DIPoorExampleTests - square: prv.mark.test.domain.Square@1cb346ea
     10-07-2016 12:03:06.324 ERROR p.m.t.d.DIPoorExampleTests - example: prv.mark.test.dependencyinjection.DIPoorExample@4c012563
     10-07-2016 12:03:06.324 ERROR p.m.t.d.DIPoorExampleTests - example.getCircle(): prv.mark.test.domain.Circle@6736fa8d
     10-07-2016 12:03:06.324 ERROR p.m.t.d.DIPoorExampleTests - example.getSquare(): prv.mark.test.domain.Square@1cb346ea
     */

}
