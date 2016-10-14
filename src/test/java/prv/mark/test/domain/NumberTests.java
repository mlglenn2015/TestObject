package prv.mark.test.domain;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;


/**
 * http://javarevisited.blogspot.com/2012/02/java-mistake-1-using-float-and-double.html
 *
 * Created by mlglenn on 10/12/2016.
 */
public class NumberTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberTests.class);

    @Test
    public void testBigDecimal() {
        //Use BigDecimal for financial calculation
        //NOTE:  always use BigDecimal with String constructor
        BigDecimal amount3 = new BigDecimal("2.15");
        BigDecimal amount4 = new BigDecimal("1.10") ;
        BigDecimal difference = amount3.subtract(amount4);
        LOGGER.debug("The difference between 2.15 and 1.0 using BigDecimal is: {}", difference);
    }
    /*
    10-12-2016 19:24:39.693 DEBUG prv.mark.test.domain.NumberTests - The difference between 2.15 and 1.0 using BigDecimal is: 1.05
     */

    @Test
    public void testDouble() {
        //floating point calculation
        double amount1 = 2.15;
        double amount2 = 1.10;
        double difference = amount1 - amount2;
        LOGGER.debug("The difference between 2.15 and 1.0 using double is: {}", difference);
    }
    /*
    10-12-2016 19:22:59.764 DEBUG prv.mark.test.domain.NumberTests - The difference between 2.15 and 1.0 using double is: 1.0499999999999998
     */

    @Test
    public void testFloat() {
        //floating point calculation
        float amount1 = 2.15f;
        float amount2 = 1.10f;
        float difference = amount1 - amount2;
        LOGGER.debug("The difference between 2.15 and 1.0 using float is: {}", difference);
    }
    /*
    10-13-2016 10:24:53.837 DEBUG prv.mark.test.domain.NumberTests - The difference between 2.15 and 1.0 using float is: 1.0500001
     */

}
