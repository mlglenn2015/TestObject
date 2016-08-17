package prv.mark.test.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example class for Java demos.
 *
 * This class also implements the {@link Builder} pattern to build instances.
 *
 * Created by mlglenn on 5/16/2016.
 */
public class Soldier extends Person {

    private static final Logger LOGGER = LoggerFactory.getLogger(Soldier.class);

    private String name;
    private String rank;
    private String serialNumber;
    private int age;
    private String gender;

    /***************************************************/
    public static class Builder {
        private String name;
        private String rank;
        private String serialNumber;
        private int age;
        private String gender;

        public Builder name(String value) {
            name = value;
            return this;
        }
        public Builder rank(String value) {
            rank = value;
            return this;
        }
        public Builder serialNumber(String value) {
            serialNumber = value;
            return this;
        }
        public Builder age(int value) {
            age = value;
            return this;
        }
        public Builder gender(String value) {
            gender = value;
            return this;
        }

        public Soldier build() {
            return new Soldier(this);
        }
    }
    private Soldier(Builder builder) {
        name = builder.name;
        rank = builder.rank;
        serialNumber = builder.serialNumber;
        age = builder.age;
        gender = builder.gender;
    }
    /***************************************************/

    public Soldier(String name, String rank, String serialNumber, int age, String gender) {
        this.name = name;
        this.rank = rank;
        this.serialNumber = serialNumber;
        this.age = age;
        this.gender = gender;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Soldier testOject = (Soldier) o;
        return getSerialNumber().equals(testOject.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return getSerialNumber().hashCode();
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
