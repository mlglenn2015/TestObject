package prv.mark.test.domain;

/**
 * Example LinkedHashSet from Java Code Geeks
 * Created by mlglenn on 10/4/2016.
 */
public class Planet {

    private String name;
    private int positionFromTheSun;

    public Planet() {}

    public Planet(String name, int positionFromTheSun) {
        this.name = name;
        this.positionFromTheSun = positionFromTheSun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPositionFromTheSun() {
        return positionFromTheSun;
    }

    public void setPositionFromTheSun(int positionFromTheSun) {
        this.positionFromTheSun = positionFromTheSun;
    }


    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", positionFromTheSun=" + positionFromTheSun +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Planet planet = (Planet) o;

        if (getPositionFromTheSun() != planet.getPositionFromTheSun()) return false;
        return getName().equals(planet.getName());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getPositionFromTheSun();
        return result;
    }
}
