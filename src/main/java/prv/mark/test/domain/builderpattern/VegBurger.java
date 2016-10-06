package prv.mark.test.domain.builderpattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 10/6/2016.
 */
public class VegBurger extends Burger {

    private static final Logger LOGGER = LoggerFactory.getLogger(VegBurger.class);

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
