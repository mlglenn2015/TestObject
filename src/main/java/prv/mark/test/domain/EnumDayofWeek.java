package prv.mark.test.domain;

/**
 * Enumeration class representing the days of the week.
 *
 * Created by mlglenn on 8/16/2016.
 */
public enum EnumDayofWeek {

    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    private int dayNumber;

    EnumDayofWeek(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    /**
     * Returns the ordinal value of the day of the week.
     *
     * @return int value representing the day of the week
     */
    public int getDayNumber() {
        return dayNumber;
    }
}
