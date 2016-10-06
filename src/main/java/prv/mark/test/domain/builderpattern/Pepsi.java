package prv.mark.test.domain.builderpattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 10/6/2016.
 */
public class Pepsi extends ColdDrink {

    private static final Logger LOGGER = LoggerFactory.getLogger(Pepsi.class);

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }

}
