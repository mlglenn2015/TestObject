package prv.mark.test.domain.builderpattern;

/**
 * Created by mlglenn on 10/6/2016.
 */
public class MealBuilder {

    public Meal buildVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal buildNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
