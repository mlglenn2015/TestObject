package prv.mark.test.domain;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 8/16/2016.
 */
public class EnumDayofWeekTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnumDayofWeekTests.class);

    @Before
    public void setUp() {
        LOGGER.debug("EnumDayofWeekTests.setUp()");
    }

    @Test
    public void testEnumDayofWeek() {
        for (EnumDayofWeek w : EnumDayofWeek.values()) {
            LOGGER.debug("Day {} is {}", w, w.getDayNumber());
        }
    }
}
