package prv.mark.test.domain;


import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by mlglenn on 10/6/2016.
 */
public class ShapeFactoryTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShapeFactoryTests.class);
    private static final ShapeFactory shapeFactory = ShapeFactory.getInstanceThreadSafe();

    @Before
    public void setup() {
        LOGGER.debug("setup()");
        assertNotNull(shapeFactory);
        LOGGER.debug("ShapeFactory instance: {}", shapeFactory);
    }

    @Test
    public void testCircle() {
        Shape shape = shapeFactory.getShape("circle");
        assertNotNull(shape);
        shape.draw();
    }

    @Test
    public void testSquare() {
        Shape shape = shapeFactory.getShape("square");
        assertNotNull(shape);
        shape.draw();
    }

    @Test
    public void testRectangle() {
        Shape shape = shapeFactory.getShape("rectangle");
        assertNotNull(shape);
        shape.draw();
    }

    @Test
    public void testNull() {
        Shape shape = shapeFactory.getShape("anything");
        assertNull(shape);
    }
}
