package prv.mark.test.domain;

/**
 * Created by mlglenn on 8/16/2016.
 */
public enum EnumGender {
    MALE("M"),
    FEMALE("F");

    private String genderType;

    EnumGender(String genderType) {
        this.genderType = genderType;
    }

    public String getGenderType() {
        return genderType;
    }
}
