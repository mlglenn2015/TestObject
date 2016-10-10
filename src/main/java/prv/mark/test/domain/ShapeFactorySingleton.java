package prv.mark.test.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example Singleton Factory class https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 * Created by mlglenn on 10/6/2016.
 */
public class ShapeFactorySingleton {

    private static Logger LOGGER = LoggerFactory.getLogger(ShapeFactorySingleton.class);
    private static ShapeFactorySingleton theInstance;
    private static boolean firstThread = true;
    private static Object mutex;

    private ShapeFactorySingleton() {}

    /* Not Thread Safe
    If a thread is preempted at Line 2 before the assignment is made, the instance member variable
    will still be null, and another thread can subsequently enter the if block. In that case, two
    distinct singleton instances will be created. Unfortunately, that scenario rarely occurs and
    is therefore difficult to produce during testing.
     */
    public static ShapeFactorySingleton getInstance() {
        if (theInstance == null) {
            theInstance = new ShapeFactorySingleton();
        }
        return theInstance;
    }

    /* Home grown method implements thread safety */
    public static ShapeFactorySingleton getInstanceHomeGrownThreadSafe() {
        if (theInstance == null) {
            simulateRandomActivity();
            theInstance = new ShapeFactorySingleton();
        }
        LOGGER.debug("Returning ShapeFactory instance...");
        return theInstance;
    }

    /* synchronized keyword can be resource intensive but guarantees thread safety */
    public static synchronized ShapeFactorySingleton getSynchronizedInstanceThreadSafe() {
        if (theInstance == null) {
            theInstance = new ShapeFactorySingleton();
        }
        return theInstance;
    }

    /* synchronized block using mutex Object() guarantees thread safety */
    public static ShapeFactorySingleton getInstanceWithSynchronizedBlockThreadSafe() {
        if (theInstance == null) {

            synchronized (mutex) {
                if (theInstance == null) {
                    theInstance = new ShapeFactorySingleton();
                }
            }
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
