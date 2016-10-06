package prv.mark.test.domain.builderpattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://www.tutorialspoint.com/design_pattern/builder_pattern.htm
 * Created by mlglenn on 10/6/2016.
 */
public abstract class Burger implements Item {

    private static final Logger LOGGER = LoggerFactory.getLogger(Burger.class);

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
