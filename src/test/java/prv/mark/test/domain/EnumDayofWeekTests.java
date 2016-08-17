package prv.mark.test.domain;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit tests for the {@link EnumDayofWeek} class.
 *
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
    /*
    10:13:20.862 [main] DEBUG p.m.test.domain.EnumDayofWeekTests - EnumDayofWeekTests.setUp()
10:13:20.873 [main] DEBUG p.m.test.domain.EnumDayofWeekTests - Day SUNDAY is 1
10:13:20.875 [main] DEBUG p.m.test.domain.EnumDayofWeekTests - Day MONDAY is 2
10:13:20.875 [main] DEBUG p.m.test.domain.EnumDayofWeekTests - Day TUESDAY is 3
10:13:20.875 [main] DEBUG p.m.test.domain.EnumDayofWeekTests - Day WEDNESDAY is 4
10:13:20.875 [main] DEBUG p.m.test.domain.EnumDayofWeekTests - Day THURSDAY is 5
10:13:20.875 [main] DEBUG p.m.test.domain.EnumDayofWeekTests - Day FRIDAY is 6
10:13:20.875 [main] DEBUG p.m.test.domain.EnumDayofWeekTests - Day SATURDAY is 7
     */
}
