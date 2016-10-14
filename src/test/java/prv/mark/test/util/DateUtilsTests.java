package prv.mark.test.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


/**
 *
 */
public class DateUtilsTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtilsTests.class);


    @Test
    public void testLocalDateTime() {
        LOGGER.debug("testLocalDateTime()");
        LocalDateTime localDateTime = LocalDateTime.now();
        LOGGER.debug("localDateTime: {}", localDateTime);
        LOGGER.debug("localDateTime.toLocalDate(): {}",localDateTime.toLocalDate());
        LOGGER.debug("localDateTime.toLocalTime(): {}",localDateTime.toLocalTime());
        //localDateTime.get(TemporalField)

        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss.SSSSSS Z");
        LOGGER.debug(ZonedDateTime.now().format(FORMATTER));

        localDateTime = null;
        LOGGER.debug("localDateTime: {}", localDateTime);
    }
    /*
    10-14-2016 16:24:39.172 DEBUG prv.mark.test.util.DateUtilsTests - testLocalDateTime()
    10-14-2016 16:24:39.201 DEBUG prv.mark.test.util.DateUtilsTests - localDateTime: 2016-10-14T16:24:39.186
    10-14-2016 16:24:39.203 DEBUG prv.mark.test.util.DateUtilsTests - localDateTime.toLocalDate(): 2016-10-14
    10-14-2016 16:24:39.203 DEBUG prv.mark.test.util.DateUtilsTests - localDateTime.toLocalTime(): 16:24:39.186
    10-14-2016 16:24:39.210 DEBUG prv.mark.test.util.DateUtilsTests - 20161014 16:24:39.209000 -0400
    10-14-2016 16:24:39.210 DEBUG prv.mark.test.util.DateUtilsTests - localDateTime: null
     */

    @Test
    public void testInvalidDateFormat() {
        LOGGER.debug("testInvalidDateFormat()");
        String returnedDate = DateUtils.getFormattedDateString("XXXXXXXXXXXXXXXXXX");
        assertNull(returnedDate);
    }

    @Test
    public void testConvertXmlDateToMMddyyyy() {
        LOGGER.debug("testConvertXmlDateToMMddyyyy()");
        String controlDate = "";
        Calendar cal = Calendar.getInstance();
        assertNotNull(cal);
        LocalDateTime localDateTime  = LocalDateTime.now();

        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(DateUtils.Date_FORMAT_MM_DD_YYYY);
            controlDate = localDateTime.format(format);

        } catch (DateTimeException e) {
            LOGGER.debug("%s could not be formatted!%n", localDateTime);
            e.printStackTrace();
        }

        String returnedDate;
        try {
            XMLGregorianCalendar xmlCal =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) cal);
            assertNotNull(xmlCal);
            returnedDate = DateUtils.convertXmlDateToMMddyyyy(xmlCal);

        } catch (DatatypeConfigurationException e) {
            returnedDate = DateUtils.DATE_VAL_00_00_0000;
        }

        assertNotNull(controlDate);
        assertNotNull(returnedDate);
        assertEquals(controlDate, returnedDate);
    }

    @Test
    public void testNegativeConvertXmlDateToMMddyyyy() {
        LOGGER.debug("DateUtilsTests.testNegativeConvertXmlDateToMMddyyyy()");
        assertNull(DateUtils.convertXmlDateToMMddyyyy(null));
    }

    @Test
    public void testGetCurrentDateMdyyyy() {
        LOGGER.debug("testGetCurrentDateMdyyyy()");
        String controlDate = returnControlDate(DateUtils.DATE_FORMAT_M_D_YYYY);
        String returnedDate = DateUtils.getCurrentDateMdyyyy();
        assertNotNull(returnedDate);
        assertEquals(controlDate, returnedDate);
    }

    @Test
    public void testCal2XmlGregorianCalendar() {
        LOGGER.debug("testCal2XmlGregorianCalendar()");
        XMLGregorianCalendar controlDate = null;
        Calendar cal = Calendar.getInstance();

        assertNotNull(cal);

        try {
            controlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar();
            assertNotNull(controlDate);
            controlDate.setYear(cal.get(Calendar.YEAR));
            controlDate.setMonth(cal.get(Calendar.MONTH) + 1); //ordinal is 0 (January)
            controlDate.setDay(cal.get(Calendar.DAY_OF_MONTH));

        } catch (IllegalArgumentException | DatatypeConfigurationException e) {
            LOGGER.error("Exception caught in DateUtils.cal2XmlGregorianCalendar(): " + e);
        }

        XMLGregorianCalendar returnedDate = DateUtils.cal2XmlGregorianCalendar(Calendar.getInstance());
        assertNotNull(returnedDate);
        assertNotNull(controlDate);
        assertEquals(controlDate.getYear(), returnedDate.getYear());
        assertEquals(controlDate.getMonth(), returnedDate.getMonth());
        assertEquals(controlDate.getDay(), returnedDate.getDay());
    }

    @Test
    public void testNegativeCal2XmlGregorianCalendar() {
        LOGGER.debug("DateUtilsTests.testNegativeCal2XmlGregorianCalendar()");
        XMLGregorianCalendar xmlCal = DateUtils.cal2XmlGregorianCalendar(null);
        assertNull(xmlCal);
    }

    @Test
    public void testGetCurrentDateMdyyyyhmsa() {
        LOGGER.debug("testGetCurrentDateMdyyyyhmsa()");
        String controlDate = returnControlDate(DateUtils.DATE_FORMAT_M_D_YYYY_H_M_S_A);
        String returnedDate = DateUtils.getCurrentDateMdyyyyhmsa();  //e.g. 12/28/2015 2:55:47 PM
        assertNotNull(returnedDate);
        //String newDate = controlDate.substring(0,13);
        //assertEquals(controlDate, returnedDate); //sometimes the 2 dates are not equal and are off by a second
    }

    @Test
    public void testJavaDateToCalendar() {
        LOGGER.debug("testJavaDateToCalendar()");
        Calendar controlDate = Calendar.getInstance();
        assertNotNull(controlDate);
        Calendar cal = DateUtils.javaDateToCalendar(controlDate.getTime());
        assertNotNull(cal);
        assertEquals(controlDate, cal);
    }

    @Test
    public void testGetCurrentDateYyyyMMdd() {
        LOGGER.debug("testGetCurrentDateYyyyMMdd()");
        String controlDate = returnControlDate(DateUtils.DATE_FORMAT_YYYYMMDD);
        String returnedDate = DateUtils.getCurrentDateyyyyMMdd();
        assertNotNull(returnedDate);
        //String newDate = controlDate.substring(0,13);
        assertEquals(controlDate, returnedDate); //sometimes the 2 dates are not equal and are off by a second
    }



    private XMLGregorianCalendar returnControlXmlCal() {
        XMLGregorianCalendar controlXmlCal = null;
        Calendar cal = Calendar.getInstance();
        assertNotNull(cal);

        try {
            DatatypeFactory dtf = DatatypeFactory.newInstance();
            controlXmlCal = dtf.newXMLGregorianCalendar();
            controlXmlCal.setYear(cal.get(Calendar.YEAR));
            controlXmlCal.setMonth(cal.get(Calendar.MONTH) + 1);
            controlXmlCal.setDay(cal.get(Calendar.DAY_OF_MONTH));
            controlXmlCal.setHour(cal.get(Calendar.HOUR_OF_DAY));
            controlXmlCal.setMinute(cal.get(Calendar.MINUTE));
            controlXmlCal.setSecond(cal.get(Calendar.SECOND));
            controlXmlCal.setMillisecond(cal.get(Calendar.MILLISECOND));
            int offsetInMinutes =
                    (cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET)) / (60 * 1000);
            controlXmlCal.setTimezone(offsetInMinutes);

        } catch (IllegalArgumentException | DatatypeConfigurationException e) {
            LOGGER.error(e.getMessage());
        }
        return controlXmlCal;
    }

    private String returnControlDate(String datePattern) {
        String controlDate = "";
        LocalDateTime localDateTime  = LocalDateTime.now();
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(datePattern);
            controlDate = localDateTime.format(format);
            assertNotNull(controlDate);
        } catch (DateTimeException e) {
            LOGGER.debug("%s could not be formatted!%n", localDateTime);
            e.printStackTrace();
        }
        return controlDate;
    }

}

