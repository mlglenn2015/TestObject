package prv.mark.test.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 10/6/2016.
 */
public class Rectangle implements Shape {

    private static Logger LOGGER = LoggerFactory.getLogger(Rectangle.class);

    @Override
    public void draw() {
        LOGGER.debug("Drawing a Rectangle ...");
    }
}
