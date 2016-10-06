package prv.mark.test.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 10/6/2016.
 */
public class Square implements Shape {

    private static final Logger LOGGER = LoggerFactory.getLogger(Square.class);

    public void draw() {
        LOGGER.debug("Drawing a Square ...");
    }
}
