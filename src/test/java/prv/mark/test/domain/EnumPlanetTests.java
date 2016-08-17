package prv.mark.test.domain;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JUnit tests for the {@link EnumPlanet} class.
 *
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
    /*
    10:13:50.336 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - EnumPlanetTests.setUp()
10:13:50.341 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on MERCURY is 66.10758266016366
10:13:50.344 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on VENUS is 158.37484247218296
10:13:50.344 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on EARTH is 174.99999999999997
10:13:50.344 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on MARS is 66.27900720649754
10:13:50.344 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on JUPITER is 442.8475669617546
10:13:50.344 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on SATURN is 186.55271929202414
10:13:50.344 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on URANUS is 158.39725989314937
10:13:50.344 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on NEPTUNE is 199.20741268219012
     */

    @Test
    public void test175UnitsMarsWeight() {
        double earthWeight = Double.parseDouble("175");
        double mass = earthWeight/EnumPlanet.MARS.surfaceGravity();
        for (EnumPlanet p : EnumPlanet.values()) {
            LOGGER.debug("Your weight on {} is {}", p, p.surfaceWeight(mass));
        }
    }
    /*
    10:14:11.544 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - EnumPlanetTests.setUp()
10:14:11.551 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on MERCURY is 174.5473786214847
10:14:11.554 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on VENUS is 418.1655489540128
10:14:11.555 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on EARTH is 462.06183964985115
10:14:11.555 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on MARS is 175.0
10:14:11.555 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on JUPITER is 1169.274065570337
10:14:11.555 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on SATURN is 492.5651009585997
10:14:11.555 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on URANUS is 418.2247388669954
10:14:11.555 [main] DEBUG prv.mark.test.domain.EnumPlanetTests - Your weight on NEPTUNE is 525.9779632903992
     */

    /*private double surfaceGravity(double mass, double radius) {
        return EnumPlanet.G * mass / (radius * radius);
    }
    private double surfaceWeight(double otherMass, double mass, double radius) {
        return otherMass * surfaceGravity(mass, radius);
    }*/

}
