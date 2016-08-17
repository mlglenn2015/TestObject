package prv.mark.test.domain;

/**
 * Example Person superclass for Java demos.
 *
 * Created by mlglenn on 8/16/2016.
 */
public class Person {

    private String fname;
    private String lname;
    private String mname;
    private String otherName;
    private String gender;
    //private LocalDate birthDate;
    private String idNumber;

    public Person() {}

    /**
     * Method to calculate a person's age based on the date they were
     * born and the current date.
     *
     * @return int value containing the age in years of the person
     */
    /*public int getAge() {
        LocalDate today = LocalDate.now();
        if ((birthDate != null) && (today != null)) {
            return Period.between(birthDate, today).getYears();
        } else {
            return 0;
        }
    }*/

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /*public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }*/

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
