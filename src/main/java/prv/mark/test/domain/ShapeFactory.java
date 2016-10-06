package prv.mark.test.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example Singleton Factory class https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 * Created by mlglenn on 10/6/2016.
 */
public class ShapeFactory {

    private static Logger LOGGER = LoggerFactory.getLogger(ShapeFactory.class);
    private static ShapeFactory theInstance;
    private static boolean firstThread = true;

    private ShapeFactory() {}

    /*
    If a thread is preempted at Line 2 before the assignment is made, the instance member variable
    will still be null, and another thread can subsequently enter the if block. In that case, two
    distinct singleton instances will be created. Unfortunately, that scenario rarely occurs and
    is therefore difficult to produce during testing.
     */
    public static ShapeFactory getInstance() {
        if (theInstance == null) {
            theInstance = new ShapeFactory();
        }
        return theInstance;
    }

    public static ShapeFactory getInstanceThreadSafe() {
        if (theInstance == null) {
            simulateRandomActivity();
            theInstance = new ShapeFactory();
        }
        LOGGER.debug("Returning ShapeFactory instance...");
        return theInstance;
    }

    public synchronized static ShapeFactory getSynchronizedInstance() {
        if (theInstance == null) {
            theInstance = new ShapeFactory();
        }
        return theInstance;
    }

    public Shape getShape(String shapeType) {

        if (shapeType.isEmpty()) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }


    private static void simulateRandomActivity() {
        try {
            if(firstThread) {
                firstThread = false;
                LOGGER.debug("sleeping...");
                // This nap should give the second thread enough time
                // to get by the first thread.
                Thread.currentThread().sleep(50);
            }
        }
        catch(InterruptedException ex) {
            LOGGER.debug("Sleep interrupted");
        }
    }
}
