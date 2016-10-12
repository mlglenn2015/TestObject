package prv.mark.test.java8.lamdaexpressions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.journaldev.com/2763/java-8-functional-interfaces
 *
 * Created by mlglenn on 10/12/2016.
 */
public class NumberUtilsTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtilsTests.class);

    @Before
    public void setUp() {
        LOGGER.debug("NumberUtilsTests.setUp()");
    }

    @After
    public void tearDown() {
        LOGGER.debug("NumberUtilsTests.tearDown()");
    }


    @Test
    public void testPrimeNumbersTraditionalWay() {
        LOGGER.debug("NumberUtilsTests.testPrimeNumbersTraditionalWay()");
        for (int i=0; i<50; i++) {
            LOGGER.debug("Testing if {} is a Prime Number: {}", i, NumberUtils.isPrimeTraditionalWay(i));
        }
    }

    @Test
    public void testPrimeLambdaDeclarativeWay() {
        LOGGER.debug("NumberUtilsTests.testPrimeLambdaDeclarativeWay()");
        for (int i=0; i<50; i++) {
            LOGGER.debug("Testing if {} is a Prime Number: {}", i, NumberUtils.isPrimeLambdaDeclarativeWay(i));
        }
    }

    @Test
    public void testPrimeUsingLambdaPredicateWay() {
        LOGGER.debug("NumberUtilsTests.testPrimeLambdaDeclarativeWay()");
        for (int i=0; i<50; i++) {
            LOGGER.debug("Testing if {} is a Prime Number: {}", i, NumberUtils.isPrimeUsingLambdaPredicateWay(i));
        }
    }

    @Test
    public void testLambdaExpressionPassedAsArgument() {
        LOGGER.debug("NumberUtilsTests.testPrimeLambdaDeclarativeWay()");
        int theSum = 0;

        //sum of all numbers
        theSum = NumberUtils.sumWithCondition(getListOfNumbers(), n -> true);
        LOGGER.debug("Sum of all numbers in list: {}", theSum);

        //sum of all even numbers
        theSum = NumberUtils.sumWithCondition(getListOfNumbers(), i -> i % 2 == 0);
        LOGGER.debug("Sum of all even numbers in list: {}", theSum);

        //sum of all numbers greater than 5
        theSum = NumberUtils.sumWithCondition(getListOfNumbers(), i -> i > 5);
        LOGGER.debug("Sum of all numbers greater than 5 in list: {}", theSum);

        //sum of all numbers less than or equal to 5
        theSum = NumberUtils.sumWithCondition(getListOfNumbers(), i -> i <= 5);
        LOGGER.debug("Sum of all numbers less than or equal to 5 in list: {}", theSum);
    }
    /*
     10-12-2016 14:25:50.595 DEBUG p.m.t.j.l.NumberUtilsTests - NumberUtilsTests.setUp()
     10-12-2016 14:25:50.599 DEBUG p.m.t.j.l.NumberUtilsTests - NumberUtilsTests.testPrimeLambdaDeclarativeWay()
     10-12-2016 14:25:50.619 DEBUG p.m.t.j.l.NumberUtilsTests - Sum of all numbers in list: 300
     10-12-2016 14:25:50.622 DEBUG p.m.t.j.l.NumberUtilsTests - Sum of all even numbers in list: 156
     10-12-2016 14:25:50.622 DEBUG p.m.t.j.l.NumberUtilsTests - Sum of all numbers greater than 5 in list: 285
     10-12-2016 14:25:50.623 DEBUG p.m.t.j.l.NumberUtilsTests - Sum of all numbers less than or equal to 5 in list: 15
     10-12-2016 14:25:50.623 DEBUG p.m.t.j.l.NumberUtilsTests - NumberUtilsTests.tearDown()
     */

    @Test
    public void testGetMaximumOddNumberTraditionalWay() {
        LOGGER.debug("NumberUtilsTests.testGetMaximumOddNumberTraditionalWay()");
        int theNumber = 0;
        theNumber = NumberUtils.getMaximumOddNumberTraditionalWay(getListOfNumbers(3,11), 3, 11);
        LOGGER.debug("Largest odd integer between {} and {} is: {}", 3, 11, theNumber);
        theNumber = NumberUtils.getMaximumOddNumberTraditionalWay(getListOfNumbers(0,25), 0, 25);
        LOGGER.debug("Largest odd integer between {} and {} is: {}", 0, 25, theNumber);
    }
    /*
     10-12-2016 14:38:14.870 DEBUG p.m.t.j.l.NumberUtilsTests - NumberUtilsTests.setUp()
     10-12-2016 14:38:14.873 DEBUG p.m.t.j.l.NumberUtilsTests - NumberUtilsTests.testGetMaximumOddNumberTraditionalWay()
     10-12-2016 14:38:14.874 DEBUG p.m.t.j.l.NumberUtilsTests - Largest odd integer between 3 and 11 is: 9
     10-12-2016 14:38:14.876 DEBUG p.m.t.j.l.NumberUtilsTests - Largest odd integer between 0 and 25 is: 23
     10-12-2016 14:38:14.876 DEBUG p.m.t.j.l.NumberUtilsTests - NumberUtilsTests.tearDown()
     */

    @Test
    public void testGetMaximumOddNumberPredicateWay() {
        LOGGER.debug("NumberUtilsTests.getMaximumOddNumberPredicateWay()");
        int theNumber = 0;
        theNumber = NumberUtils.getMaximumOddNumberPredicateWay(getListOfNumbers(3,11));
        LOGGER.debug("Largest odd integer between {} and {} is: {}", 3, 11, theNumber);
    }
    /*
     10-12-2016 14:44:53.438 DEBUG p.m.t.j.l.NumberUtilsTests - NumberUtilsTests.setUp()
     10-12-2016 14:44:53.441 DEBUG p.m.t.j.l.NumberUtilsTests - NumberUtilsTests.getMaximumOddNumberPredicateWay()
     10-12-2016 14:44:53.457 DEBUG p.m.t.j.l.NumberUtilsTests - Largest odd integer between 3 and 11 is: 9
     10-12-2016 14:44:53.459 DEBUG p.m.t.j.l.NumberUtilsTests - NumberUtilsTests.tearDown()
     */


    private List<Integer> getListOfNumbers() {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            intList.add(i);
        }
        return intList;
    }

    private List<Integer> getListOfNumbers(int begin, int end) {
        List<Integer> intList = new ArrayList<>();
        for (int i = begin; i < end; i++) {
            intList.add(i);
        }
        return intList;
    }
}
