package prv.mark.test.domain;

/**
 * Class implementing overridden equals() and hashCode() methods.
 *
 * Created by mlglenn on 5/16/2016.
 */
public class SoldierWithOverriddenEqualsAndHashCode {

    private String name;
    private String rank;
    private String serialNumber;

    public SoldierWithOverriddenEqualsAndHashCode(String name, String rank, String serialNumber) {
        this.name = name;
        this.rank = rank;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoldierWithOverriddenEqualsAndHashCode testOject = (SoldierWithOverriddenEqualsAndHashCode) o;

        return getSerialNumber().equals(testOject.getSerialNumber());
    }

    @Override
    public int hashCode() {
        return getSerialNumber().hashCode();
    }

    @Override
    public String toString() {
        return "SoldierWithOverriddenEqualsAndHashCode{" +
                "name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
