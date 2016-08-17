package prv.mark.test.domain;

/**
 * Class implementing overridden hashCode().
 *
 * Created by mlglenn on 5/16/2016.
 */
public class SoldierWithOverriddenHashCode {

    private String name;
    private String rank;
    private String serialNumber;

    public SoldierWithOverriddenHashCode(String name, String rank, String serialNumber) {
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
    public int hashCode() {
        return getSerialNumber().hashCode();
    }

    @Override
    public String toString() {
        return "SoldierWithOverriddenHashCode{" +
                "name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
