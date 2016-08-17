package prv.mark.test.domain;

import com.fasterxml.jackson.annotation.JsonView;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mlglenn on 8/17/2016.
 */
public class JsonViewEmployee {

    @JsonView(Views.Normal.class)
    private String fname;
    @JsonView(Views.Normal.class)
    private String lname;
    @JsonView(Views.Normal.class)
    private String mname;
    @JsonView(Views.Normal.class)
    private String otherName;
    @JsonView(Views.Normal.class)
    private String gender;
    //private LocalDate birthDate;
    @JsonView(Views.Manager.class)
    private String idNumber;
    @JsonView(Views.Normal.class)
    private String position;
    @JsonView(Views.Manager.class)
    private BigDecimal salary;
    @JsonView(Views.Normal.class)
    private List<String> skills;

    public JsonViewEmployee() {}

    public JsonViewEmployee(String fname, String lname, String mname, String otherName, String gender, String idNumber,
                            String position, BigDecimal salary, List<String> skills) {
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.otherName = otherName;
        this.gender = gender;
        this.idNumber = idNumber;
        this.position = position;
        this.salary = salary;
        this.skills = skills;
    }

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "JsonViewEmployee{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", mname='" + mname + '\'' +
                ", otherName='" + otherName + '\'' +
                ", gender='" + gender + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
