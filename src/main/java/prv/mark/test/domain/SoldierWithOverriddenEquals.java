package prv.mark.test.domain;

/**
 * Example class implementing overridden equals().
 *
 * Created by mlglenn on 5/16/2016.
 */
public class SoldierWithOverriddenEquals {

    private String name;
    private String rank;
    private String serialNumber;

    public SoldierWithOverriddenEquals(String name, String rank, String serialNumber) {
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

        SoldierWithOverriddenEquals that = (SoldierWithOverriddenEquals) o;

        return getSerialNumber().equals(that.getSerialNumber());
    }

    @Override
    public String toString() {
        return "SoldierWithOverriddenEquals{" +
                "name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
