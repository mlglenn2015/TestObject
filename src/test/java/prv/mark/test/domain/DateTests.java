package prv.mark.test.domain;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 * Testing differences between java.util.Date and java.sql.Date and others.
 *
 * Created by mlglenn on 10/13/2016.
 */
public class DateTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateTests.class);

    @Test
    public void testJavaUtilDate() {
        java.util.Date theDate = new java.util.Date();
        LOGGER.debug("java.util.Date instance {}", theDate);  // java.util.Date instance Thu Oct 13 10:33:54 EDT 2016
        LOGGER.debug("theDate.getTime() {}", theDate.getTime()); // theDate.getTime() 1476369305497
    }

    @Test
    public void testJavaSqlDate() {
        java.util.Date javaUtilDate = new java.util.Date();
        java.sql.Date javaSqlDate = new java.sql.Date(javaUtilDate.getTime()); // SQL Date is instantiated with a milliseconds argument
        LOGGER.debug("java.sql.Date instance {}", javaSqlDate);               // java.sql.Date instance 2016-10-13 (SQL Date represents Date only)
    }

    @Test
    public void testJavaUtilCalendar() {
        Calendar cal = Calendar.getInstance();
        LOGGER.debug("java.util.Calendar instance {}", cal);
        /*
        java.util.Calendar instance java.util.GregorianCalendar[time=1476369471245,areFieldsSet=true,areAllFieldsSet=true,
        lenient=true,zone=sun.util.calendar.ZoneInfo[id="America/New_York",offset=-18000000,dstSavings=3600000,useDaylight=true,
        transitions=235,lastRule=java.util.SimpleTimeZone[id=America/New_York,offset=-18000000,dstSavings=3600000,useDaylight=true,
        startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,
        endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2016,MONTH=9,
        WEEK_OF_YEAR=42,WEEK_OF_MONTH=3,DAY_OF_MONTH=13,DAY_OF_YEAR=287,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=2,AM_PM=0,HOUR=10,
        HOUR_OF_DAY=10,MINUTE=37,SECOND=51,MILLISECOND=245,ZONE_OFFSET=-18000000,DST_OFFSET=3600000]
         */

        LOGGER.debug("cal.getTime() {}", cal.getTime());                 // cal.getTime() Thu Oct 13 10:37:51 EDT 2016
        LOGGER.debug("cal.getTimeInMillis() {}", cal.getTimeInMillis()); // cal.getTimeInMillis() 1476369471245
    }

    /* JSR 310 Joda Date Time */
    @Test
    public void testJavaDateTime() {

    }
}
