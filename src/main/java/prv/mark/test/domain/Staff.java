package prv.mark.test.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mlglenn on 8/17/2016.
 */
public class Staff extends Person {

    private String position;
    private BigDecimal salary;
    private List<String> skills;

    public Staff() {}

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
        return "Staff{" +
                "position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
