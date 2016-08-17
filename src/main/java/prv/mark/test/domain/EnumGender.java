package prv.mark.test.domain;

/**
 * Enumeration representing gender types.
 *
 * Created by mlglenn on 8/16/2016.
 */
public enum EnumGender {
    MALE("M"),
    FEMALE("F");

    private String genderType;

    EnumGender(String genderType) {
        this.genderType = genderType;
    }

    /**
     * Returns a string value representing the shorthand gender.
     *
     * @return {@link java.lang.String}
     */
    public String getGenderType() {
        return genderType;
    }
}
