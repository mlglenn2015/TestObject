package prv.mark.test.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public final class DateUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

    public static final String DATE_FORMAT_M_D_YYYY_H_M_S_A = "M/d/yyyy h:m:s a";
    public static final String DATE_FORMAT_M_D_YYYY = "M/d/yyyy";
    public static final String Date_FORMAT_MM_DD_YYYY = "MM/dd/yyyy";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_VAL_00_00_0000 = "00/00/0000";



    /**
     * Returns a date string according to the format specified with the input format.
     *
     * @param formatString {@link String}
     * @return {@link String}
     */
    public static String getFormattedDateString(final String formatString) {
        String returnString;
        LocalDateTime localDateTime = LocalDateTime.now();
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(formatString);
            returnString = localDateTime.format(format);
        } catch (DateTimeException | IllegalArgumentException e) {
            LOGGER.debug("%s can't be formatted!%n", localDateTime);
            e.printStackTrace();
            return null;
        }
        return returnString;
    }

    /**
     * Converts a {@link java.util.Date} to {@link java.util.Calendar}.
     *
     * @param inDate {@link java.util.Date}
     * @return {@link java.util.Calendar}
     */
    public static Calendar javaDateToCalendar(Date inDate) {
        Calendar cal = Calendar.getInstance();
        try {
            if (inDate == null) {
                return cal;
            }
            cal.setTime(inDate);
            return cal;
        } catch (IllegalArgumentException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    /**
     * Returns an XMLGregorianCalendar with Year, Month and Day set.
     *
     * @param cal {@link java.util.Calendar} to convert.
     * @return {@link XMLGregorianCalendar} containing the date, otherwise null.
     */
    public static XMLGregorianCalendar cal2XmlGregorianCalendar(final Calendar cal) {

        XMLGregorianCalendar xc = null;

        try {
            if (cal != null) {
                xc = DatatypeFactory.newInstance().newXMLGregorianCalendar();
                LOGGER.trace("cal.get(Calendar.YEAR):{}", cal.get(Calendar.YEAR));
                LOGGER.trace("cal.get(Calendar.MONTH):{}", cal.get(Calendar.MONTH));
                LOGGER.trace("cal.get(Calendar.DAY_OF_MONTH):{}", cal.get(Calendar.DAY_OF_MONTH));

                xc.setYear(cal.get(Calendar.YEAR));
                xc.setMonth(cal.get(Calendar.MONTH) + 1); //ordinal is 0 (January)
                xc.setDay(cal.get(Calendar.DAY_OF_MONTH));
            }
        } catch (IllegalArgumentException | DatatypeConfigurationException e) {
            LOGGER.error("Exception caught in DateUtils.cal2XmlGregorianCalendar(): " + e);
            return null;
        }
        return xc;
    }

    /**
     * Returns a date string in the M/d/yyyy h:m:s a format.
     *
     * @return {@link String} containing the date.
     */
    public static String getCurrentDateMdyyyyhmsa() {
        return getFormattedDateString(DATE_FORMAT_M_D_YYYY_H_M_S_A);
    }

    /**
     * Returns a date string in the yyyyMMdd format.
     *
     * @return {@link String} containing the date.
     */
    public static String getCurrentDateyyyyMMdd() {
        return getFormattedDateString(DATE_FORMAT_YYYYMMDD);
    }

    /**
     * Converts an {@link XMLGregorianCalendar} passed in SOAP message to a date string.
     *
     * @param xmlCal date in SOAP request
     * @return {@link String} containing date in MM/DD/YYYY format, otherwise null.
     */
    public static String convertXmlDateToMMddyyyy(final XMLGregorianCalendar xmlCal) {
        if (xmlCal == null) {
            return null;
        }
        return getFormattedDateString(Date_FORMAT_MM_DD_YYYY);
    }

    /**
     * Returns a date string in the M/d/yyyy format.
     *
     * @return {@link String} containing the date, otherwise null.
     */
    public static String getCurrentDateMdyyyy() {
        return getFormattedDateString(DATE_FORMAT_M_D_YYYY);
    }
}