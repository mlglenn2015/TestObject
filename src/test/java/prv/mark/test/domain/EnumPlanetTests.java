package prv.mark.test.domain;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mlglenn on 8/16/2016.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("test")
public class EnumPlanetTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnumPlanetTests.class);

    @Before
    public void setUp() {
        LOGGER.debug("EnumPlanetTests.setUp()");
    }

    @Test
    public void test175UnitsEarthWeight() {
        double earthWeight = Double.parseDouble("175");
        double mass = earthWeight/EnumPlanet.EARTH.surfaceGravity();
        for (EnumPlanet p : EnumPlanet.values()) {
            LOGGER.debug("Your weight on {} is {}", p, p.surfaceWeight(mass));
        }
    }

    @Test
    public void test175UnitsMarsWeight() {
        double earthWeight = Double.parseDouble("175");
        double mass = earthWeight/EnumPlanet.MARS.surfaceGravity();
        for (EnumPlanet p : EnumPlanet.values()) {
            LOGGER.debug("Your weight on {} is {}", p, p.surfaceWeight(mass));
        }
    }

    /*private double surfaceGravity(double mass, double radius) {
        return EnumPlanet.G * mass / (radius * radius);
    }
    private double surfaceWeight(double otherMass, double mass, double radius) {
        return otherMass * surfaceGravity(mass, radius);
    }*/

}
