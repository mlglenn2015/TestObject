package prv.mark.test.domain;


import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * This tests the usage of equals() and hashCode(), and why they should be overridden together.
 *
 * Created by mlglenn on 5/16/2016.
 */
public class EqualsAndHashCodeMethodTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(EqualsAndHashCodeMethodTests.class);


    @Before
    public void setUp() {
        LOGGER.debug("EqualsAndHashCodeMethodTests.setUp()");
    }

    @Test
    public void testOverriddenEqualsAndHashCode() {
        LOGGER.debug("testOverriddenEqualsAndHashCode()");

        SoldierWithOverriddenEqualsAndHashCode gi1 = new SoldierWithOverriddenEqualsAndHashCode("John Smith", "Corporal", "1S0123456789");
        LOGGER.debug("*** gi1: {}", gi1);
        LOGGER.debug("*** gi1.toString(): {}", gi1.toString());
        LOGGER.debug("*** gi1.hashCode(): {}", gi1.hashCode());
        LOGGER.debug("*** gi1 Original hashCode(): {}", System.identityHashCode(gi1));
        int gi1HashCodeValue = gi1.hashCode();

        SoldierWithOverriddenEqualsAndHashCode gi2 = new SoldierWithOverriddenEqualsAndHashCode("John Smith", "Corporal", "1S0123456789");
        LOGGER.debug("*** gi2: {}", gi2);
        LOGGER.debug("*** gi2.toString(): {}", gi2.toString());
        LOGGER.debug("*** gi2.hashCode(): {}", gi2.hashCode());
        LOGGER.debug("*** gi2 Original hashCode(): {}", System.identityHashCode(gi2));
        int gi2HashCodeValue = gi2.hashCode();

        assertTrue(gi1HashCodeValue == gi2HashCodeValue);
        assertEquals(gi1, gi2);

        LOGGER.debug("END testOverriddenEqualsAndHashCode()");
    }
    /* Output:

05-16-2016 16:24:53.177 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - EqualsAndHashCodeMethodTests.setUp()
05-16-2016 16:24:53.177 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - testOverriddenEqualsAndHashCode()
05-16-2016 16:24:53.178 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1: SoldierWithOverriddenEqualsAndHashCode{name='John Smith', rank='Corporal', serialNumber='1S0123456789'}
05-16-2016 16:24:53.178 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1.toString(): SoldierWithOverriddenEqualsAndHashCode{name='John Smith', rank='Corporal', serialNumber='1S0123456789'}
05-16-2016 16:24:53.178 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1.hashCode(): -391515683
05-16-2016 16:24:53.179 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1 Original hashCode(): 304715920
05-16-2016 16:24:53.179 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2: SoldierWithOverriddenEqualsAndHashCode{name='John Smith', rank='Corporal', serialNumber='1S0123456789'}
05-16-2016 16:24:53.179 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2.toString(): SoldierWithOverriddenEqualsAndHashCode{name='John Smith', rank='Corporal', serialNumber='1S0123456789'}
05-16-2016 16:24:53.179 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2.hashCode(): -391515683
05-16-2016 16:24:53.179 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2 Original hashCode(): 800735172
05-16-2016 16:24:53.179 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - END testOverriddenEqualsAndHashCode()

    */

    @Test
    public void testNegativeOverriddenEqualsAndHashCode() {
        LOGGER.debug("testNegativeOverriddenEqualsAndHashCode()");

        SoldierWithOverriddenEqualsAndHashCode gi1 = new SoldierWithOverriddenEqualsAndHashCode("John Smith", "Corporal", "1S0123456789");
        LOGGER.debug("*** gi1: {}", gi1);
        LOGGER.debug("*** gi1.toString(): {}", gi1.toString());
        LOGGER.debug("*** gi1.hashCode(): {}", gi1.hashCode());
        LOGGER.debug("*** gi1 Original hashCode(): {}", System.identityHashCode(gi1));
        int gi1HashCodeValue = gi1.hashCode();

        SoldierWithOverriddenEqualsAndHashCode gi2 = new SoldierWithOverriddenEqualsAndHashCode("Bruce Markle", "Private", "1S1112223334");
        LOGGER.debug("*** gi2: {}", gi2);
        LOGGER.debug("*** gi2.toString(): {}", gi2.toString());
        LOGGER.debug("*** gi2.hashCode(): {}", gi2.hashCode());
        LOGGER.debug("*** gi2 Original hashCode(): {}", System.identityHashCode(gi2));
        int gi2HashCodeValue = gi2.hashCode();

        assertFalse(gi1HashCodeValue == gi2HashCodeValue);
        assertNotEquals(gi1, gi2);

        LOGGER.debug("END testNegativeOverriddenEqualsAndHashCode()");
    }
    /* Output:

05-16-2016 16:24:53.182 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - EqualsAndHashCodeMethodTests.setUp()
05-16-2016 16:24:53.182 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - testNegativeOverriddenEqualsAndHashCode()
05-16-2016 16:24:53.182 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1: SoldierWithOverriddenEqualsAndHashCode{name='John Smith', rank='Corporal', serialNumber='1S0123456789'}
05-16-2016 16:24:53.182 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1.toString(): SoldierWithOverriddenEqualsAndHashCode{name='John Smith', rank='Corporal', serialNumber='1S0123456789'}
05-16-2016 16:24:53.182 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1.hashCode(): -391515683
05-16-2016 16:24:53.182 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1 Original hashCode(): 473524237
05-16-2016 16:24:53.182 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2: SoldierWithOverriddenEqualsAndHashCode{name='Bruce Markle', rank='Private', serialNumber='1S1112223334'}
05-16-2016 16:24:53.182 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2.toString(): SoldierWithOverriddenEqualsAndHashCode{name='Bruce Markle', rank='Private', serialNumber='1S1112223334'}
05-16-2016 16:24:53.182 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2.hashCode(): -1232184384
05-16-2016 16:24:53.182 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2 Original hashCode(): 1652764753
05-16-2016 16:24:53.182 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - END testNegativeOverriddenEqualsAndHashCode()

     */


    /**
     * The default implementation of hashCode() provides the memory address of an object
     * represented as an integer. The values will not be equal in this case.
     */
    @Test
    public void testOverriddenEquals() {
        LOGGER.debug("testOverriddenEquals()");

        SoldierWithOverriddenEquals gi1 = new SoldierWithOverriddenEquals("Bruce Markle", "Private", "1S1112223334");
        LOGGER.debug("*** gi1: {}", gi1);
        LOGGER.debug("*** gi1.toString(): {}", gi1.toString());
        LOGGER.debug("*** gi1.hashCode(): {}", gi1.hashCode());
        LOGGER.debug("*** gi1 Original hashCode(): {}", System.identityHashCode(gi1));
        int gi1HashCodeValue = gi1.hashCode();

        SoldierWithOverriddenEquals gi2 = new SoldierWithOverriddenEquals("Bruce Markle", "Private", "1S1112223334");
        LOGGER.debug("*** gi2: {}", gi2);
        LOGGER.debug("*** gi2.toString(): {}", gi2.toString());
        LOGGER.debug("*** gi2.hashCode(): {}", gi2.hashCode());
        LOGGER.debug("*** gi2 Original hashCode(): {}", System.identityHashCode(gi2));
        int gi2HashCodeValue = gi2.hashCode();

        assertFalse(gi1HashCodeValue == gi2HashCodeValue);

        if (gi1.equals(gi2)) {
            LOGGER.debug("*** gi1.equals(gi2) : This is a false positive, and is why equals() and hashCode() need to be overridden together.");
        } else {
            LOGGER.debug("*** The objects are not equal");
        }

        LOGGER.debug("END testOverriddenEquals()");
    }
    /* Output:

05-16-2016 16:47:44.962 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - EqualsAndHashCodeMethodTests.setUp()
05-16-2016 16:47:44.962 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - testOverriddenEquals()
05-16-2016 16:47:44.963 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1: SoldierWithOverriddenEquals{name='Bruce Markle', rank='Private', serialNumber='1S1112223334'}
05-16-2016 16:47:44.963 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1.toString(): SoldierWithOverriddenEquals{name='Bruce Markle', rank='Private', serialNumber='1S1112223334'}
05-16-2016 16:47:44.963 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1.hashCode(): 304715920
05-16-2016 16:47:44.963 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1 Original hashCode(): 304715920
05-16-2016 16:47:44.963 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2: SoldierWithOverriddenEquals{name='Bruce Markle', rank='Private', serialNumber='1S1112223334'}
05-16-2016 16:47:44.964 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2.toString(): SoldierWithOverriddenEquals{name='Bruce Markle', rank='Private', serialNumber='1S1112223334'}
05-16-2016 16:47:44.964 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2.hashCode(): 800735172
05-16-2016 16:47:44.964 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2 Original hashCode(): 800735172
05-16-2016 16:47:44.964 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1.equals(gi2) : This is a false positive, and is why equals() and hashCode() need to be overridden together.
05-16-2016 16:47:44.964 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - END testOverriddenEquals()

    */

    @Test
    public void testOverriddenHashCode() {
        LOGGER.debug("testOverriddenHashCode()");

        SoldierWithOverriddenHashCode gi1 = new SoldierWithOverriddenHashCode("Bruce Markle", "Private", "1S1112223334");
        LOGGER.debug("*** gi1: {}", gi1);
        LOGGER.debug("*** gi1.toString(): {}", gi1.toString());
        LOGGER.debug("*** gi1.hashCode(): {}", gi1.hashCode());
        LOGGER.debug("*** gi1 Original hashCode(): {}", System.identityHashCode(gi1));
        int gi1HashCodeValue = gi1.hashCode();

        SoldierWithOverriddenHashCode gi2 = new SoldierWithOverriddenHashCode("Bruce Markle", "Private", "1S1112223334");
        LOGGER.debug("*** gi2: {}", gi2);
        LOGGER.debug("*** gi2.toString(): {}", gi2.toString());
        LOGGER.debug("*** gi2.hashCode(): {}", gi2.hashCode());
        LOGGER.debug("*** gi2 Original hashCode(): {}", System.identityHashCode(gi2));
        int gi2HashCodeValue = gi2.hashCode();

        //The calculated hashCodes are equal, but the objects are not
        assertTrue(gi1HashCodeValue == gi2HashCodeValue);

        if (gi1.equals(gi2)) {
            LOGGER.debug("*** gi1.equals(gi2)");
        } else {
            LOGGER.debug("*** The objects are not equal");
        }

        LOGGER.debug("END testOverriddenHashCode()");
    }
    /* Output:

05-16-2016 16:50:46.771 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - EqualsAndHashCodeMethodTests.setUp()
05-16-2016 16:50:46.776 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - testOverriddenHashCode()
05-16-2016 16:50:46.777 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1: SoldierWithOverriddenHashCode{name='Bruce Markle', rank='Private', serialNumber='1S1112223334'}
05-16-2016 16:50:46.780 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1.toString(): SoldierWithOverriddenHashCode{name='Bruce Markle', rank='Private', serialNumber='1S1112223334'}
05-16-2016 16:50:46.780 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1.hashCode(): -1232184384
05-16-2016 16:50:46.780 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi1 Original hashCode(): 1201454821
05-16-2016 16:50:46.780 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2: SoldierWithOverriddenHashCode{name='Bruce Markle', rank='Private', serialNumber='1S1112223334'}
05-16-2016 16:50:46.781 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2.toString(): SoldierWithOverriddenHashCode{name='Bruce Markle', rank='Private', serialNumber='1S1112223334'}
05-16-2016 16:50:46.781 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2.hashCode(): -1232184384
05-16-2016 16:50:46.781 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** gi2 Original hashCode(): 1508038883
05-16-2016 16:50:46.781 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - *** The objects are not equal
05-16-2016 16:50:46.781 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - END testOverriddenHashCode()

     */

    /*
     Testing .equals() and ==
     Both == and .equals() refers to the same object if you don't override .equals()
     */
    @Test
    public void testEqualsMethodVsDoubleEqualsSign() {

        //I have 3 Mangoes
        String mango1 = "mango";
        String mango2 = "mango";
        String mango3 = new String("mango");

        LOGGER.debug("mango1: {} ", mango1);
        LOGGER.debug("mango2: {} ", mango2);
        LOGGER.debug("mango3: {} ", mango3);

        LOGGER.debug("System.identityHashCode(mango1): {}", System.identityHashCode(mango1));
        LOGGER.debug("System.identityHashCode(mango2): {}", System.identityHashCode(mango2));
        LOGGER.debug("System.identityHashCode(mango3): {}", System.identityHashCode(mango3));

        /*
        10-06-2016 17:49:31.121 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - EqualsAndHashCodeMethodTests.setUp()
        10-06-2016 17:49:31.125 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - mango1: mango
        10-06-2016 17:49:31.127 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - mango2: mango
        10-06-2016 17:49:31.127 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - mango3: mango
        10-06-2016 17:49:31.127 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - System.identityHashCode(mango1): 481511146
        10-06-2016 17:49:31.127 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - System.identityHashCode(mango2): 481511146
        10-06-2016 17:49:31.127 DEBUG p.m.t.d.EqualsAndHashCodeMethodTests - System.identityHashCode(mango3): 1275143523
         */

        LOGGER.debug("mango1 != mango2: {}", mango1 != mango2); //false; why? Because the identity hashcodes are equal
        LOGGER.debug("mango1 == mango2: {}", mango1 == mango2); //true Because the identity hashcodes are equal

        LOGGER.debug("mango1.equals(mango2): {}", mango1.equals(mango2)); //true because String values are being compared

        LOGGER.debug("mango3 != mango2: {}", mango3 != mango2); //true because identity hashcodes are not equal
        LOGGER.debug("mango3 == mango2: {}", mango3 == mango2); //false

        LOGGER.debug("mango3.equals(mango2): {}", mango3.equals(mango2)); //true because String values are being compared
    }
}
