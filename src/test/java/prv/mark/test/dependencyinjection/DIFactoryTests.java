package prv.mark.test.dependencyinjection;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://programmers.stackexchange.com/questions/232229/understanding-dependency-injection?rq=1
 * Created by mlglenn on 10/7/2016.
 */
public class DIFactoryTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(DIFactoryTests.class);

    @Before
    public void setup() {
        LOGGER.debug("setup()");
        LOGGER.info("setup()");
        LOGGER.error("setup()");
        LOGGER.trace("setup()");
    }

    @Test
    public void testDIFactoryExample1() {
        LOGGER.debug("testDIFactoryExample1()");
        LOGGER.info("testDIFactoryExample1()");
        LOGGER.trace("testDIFactoryExample1()");
        LOGGER.error("testDIFactoryExample1()");

        /*
         We can introduce more abstraction by using factories:
         */
        MyDIFactoryInterface factory = new ProductionDIFactory(); //Depends on Test or Production

        LOGGER.debug("factory: {}", factory);
        LOGGER.info("factory: {}", factory);
        LOGGER.error("factory: {}", factory);
        LOGGER.trace("factory: {}", factory);

        /*
         Now, the caller does not hold a reference to our internal objects and thus invalidate our state
         */
        DIPoorExample example = factory.makeDIPoorExample();

        /*
         Another option is to pass a factory to the constructor:

            interface DependencyManager {
                public Square makeSquare();
                public Circle makeCircle();
            }
            class ProductionDM implements DependencyManager {
                public Square makeSquare() { return new Square() }
                public Circle makeCircle() { return new Circle() }
            }
            class TestDM implements DependencyManager {
                public Square makeSquare() { return new SquareMock() }
                public Circle makeCircle() { return new CircleMock() }
            }
            class DIExampleWithDependencyManager {
                private Square square;
                private Circle circle;

                public DIExampleWithDependencyManager(DependencyManager dm) {
                    square = dm.makeSquare();
                    circle = dm.makeCircle();
                }
            }
         */


        LOGGER.debug("example.getCircle(): {}", example.getCircle());
        LOGGER.info("example.getCircle(): {}", example.getCircle());
        LOGGER.error("example.getCircle(): {}", example.getCircle());
        LOGGER.trace("example.getCircle(): {}", example.getCircle());

        LOGGER.debug("example.getSquare(): {}", example.getSquare());
        LOGGER.info("example.getSquare(): {}", example.getSquare());
        LOGGER.error("example.getSquare(): {}", example.getSquare());
        LOGGER.trace("example.getSquare(): {}", example.getSquare());
    }
}
