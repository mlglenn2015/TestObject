package prv.mark.test.domain.builderpattern;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 10/6/2016.
 */
public class MealTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealTests.class);

    MealBuilder mealBuilder = new MealBuilder();

    @Before
    public void setup() {
        LOGGER.debug("setup()");
    }

    @Test
    public void testVegMeal() {
        LOGGER.debug("testVegMeal()");
        Meal meal = mealBuilder.buildVegMeal();
        meal.showItemList();
        LOGGER.debug("Total Cost: {}", meal.getMealCost());
    }

    @Test
    public void testChickenMeal() {
        LOGGER.debug("testChickenMeal()");
        Meal meal = mealBuilder.buildNonVegMeal();
        meal.showItemList();
        LOGGER.debug("Total Cost: {}", meal.getMealCost());
    }

}
