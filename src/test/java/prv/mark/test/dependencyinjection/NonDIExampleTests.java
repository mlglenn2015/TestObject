package prv.mark.test.dependencyinjection;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 10/7/2016.
 */
public class NonDIExampleTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(NonDIExampleTests.class);

    @Before
    public void setup() {
        LOGGER.debug("setup()");
    }

    @Test
    public void test1() {
        LOGGER.debug("test1()");
        LOGGER.info("test1()");
        LOGGER.error("test1()");
        LOGGER.trace("test1()");
    }

    @Test
    public void testConstructor() {
        LOGGER.debug("testConstructor()");
        LOGGER.info("testConstructor()");
        LOGGER.trace("testConstructor()");
        LOGGER.error("testConstructor()");

        NonDIExample example = new NonDIExample();

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
     10-07-2016 12:01:47.219 ERROR p.m.t.d.NonDIExampleTests - testConstructor()
     10-07-2016 12:01:47.225 ERROR p.m.t.d.NonDIExampleTests - example: prv.mark.test.dependencyinjection.NonDIExample@50313382
     10-07-2016 12:01:47.226 ERROR p.m.t.d.NonDIExampleTests - example.getCircle(): prv.mark.test.domain.Circle@14a50707
     10-07-2016 12:01:47.227 ERROR p.m.t.d.NonDIExampleTests - example.getSquare(): prv.mark.test.domain.Square@4d518b32
     */
}
