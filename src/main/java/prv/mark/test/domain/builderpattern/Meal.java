package prv.mark.test.domain.builderpattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mlglenn on 10/6/2016.
 */
public class Meal {

    private static final Logger LOGGER = LoggerFactory.getLogger(Meal.class);

    private List<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public float getMealCost() {
        float cost = 0.0f;
        for (Item item : itemList) {
            cost += item.price();
        }
        return cost;
    }

    public void showItemList() {
        for (Item item : itemList) {
            LOGGER.debug("Item: {}, Packing: {}, Price: {}", item.name(), item.packing().pack(), item.price());
        }
    }
}
