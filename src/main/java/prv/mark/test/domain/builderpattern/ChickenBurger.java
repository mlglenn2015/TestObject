package prv.mark.test.domain.builderpattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 10/6/2016.
 */
public class ChickenBurger extends Burger {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChickenBurger.class);

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }

}
