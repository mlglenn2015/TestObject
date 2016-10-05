package prv.mark.test.domain;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Example LinkedHashSet from Java Code Geeks
 * Created by mlglenn on 10/4/2016.
 */
public class LinkedHashSetTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinkedHashSetTests.class);

    @Before
    public void setup() {
        LOGGER.debug("setup()");
    }

    @Test
    public void testPlanetsList() {
        LOGGER.debug("testPlanetsList()");

        Set<Planet> planets = new LinkedHashSet<>();

        planets.add(new Planet("Mercury",1));
        planets.add(new Planet("Saturn",6));

        //Try to add same object twice -- what happens?? //Replaces original Mercury,1 with new Mercury,1 - Sets do not contain duplicates
        planets.add(new Planet("Mercury",1));
        planets.add(new Planet("Venus",2));
        planets.add(new Planet("Earth",3));
        planets.add(new Planet("Mars",4));
        planets.add(new Planet("Jupiter",5));
        planets.add(new Planet("Uranus",7));

        //Try to add same object twice -- what happens? //Replaces original Mars,4 with new Mars,4 - Sets do not contain duplicates
        planets.add(new Planet("Mars",4));
        planets.add(new Planet("Pluto",9));

        //Try to add the same object twice -- what happens? //Replaces original Uranus,7 with new Uranus,7 - Sets do not contain duplicates
        planets.add(new Planet("Uranus",7));
        planets.add(new Planet("Neptune",8));

        LOGGER.debug("Number of planets: {}", planets.size());
        if (! planets.isEmpty()) {
            Iterator<Planet> it = planets.iterator();
            while (it.hasNext()) {
                LOGGER.debug("{}",it.next());
            }
        }

        planets.remove(new Planet("Pluto",9));
        planets.add(null);
        LOGGER.debug("");

        if (! planets.isEmpty()) {
            Iterator<Planet> it = planets.iterator();
            while (it.hasNext()) {
                LOGGER.debug("{}",it.next());
            }
        }
    }
    /* OUTPUT:

    10-05-2016 12:19:19.896 DEBUG prv.mark.test.domain.PlanetTests - setup()
    10-05-2016 12:19:19.900 DEBUG prv.mark.test.domain.PlanetTests - testPlanetsList()
    10-05-2016 12:19:19.901 DEBUG prv.mark.test.domain.PlanetTests - Number of planets: 9
    10-05-2016 12:19:19.902 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Mercury', positionFromTheSun=1}
    10-05-2016 12:19:19.902 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Saturn', positionFromTheSun=6}
    10-05-2016 12:19:19.902 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Venus', positionFromTheSun=2}
    10-05-2016 12:19:19.902 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Earth', positionFromTheSun=3}
    10-05-2016 12:19:19.902 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Mars', positionFromTheSun=4}
    10-05-2016 12:19:19.902 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Jupiter', positionFromTheSun=5}
    10-05-2016 12:19:19.902 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Uranus', positionFromTheSun=7}
    10-05-2016 12:19:19.902 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Pluto', positionFromTheSun=9}
    10-05-2016 12:19:19.902 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Neptune', positionFromTheSun=8}
    10-05-2016 12:19:19.903 DEBUG prv.mark.test.domain.PlanetTests -
    10-05-2016 12:19:19.903 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Mercury', positionFromTheSun=1}
    10-05-2016 12:19:19.903 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Saturn', positionFromTheSun=6}
    10-05-2016 12:19:19.903 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Venus', positionFromTheSun=2}
    10-05-2016 12:19:19.903 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Earth', positionFromTheSun=3}
    10-05-2016 12:19:19.903 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Mars', positionFromTheSun=4}
    10-05-2016 12:19:19.903 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Jupiter', positionFromTheSun=5}
    10-05-2016 12:19:19.903 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Uranus', positionFromTheSun=7}
    10-05-2016 12:19:19.903 DEBUG prv.mark.test.domain.PlanetTests - Planet{name='Neptune', positionFromTheSun=8}
    10-05-2016 12:19:19.903 DEBUG prv.mark.test.domain.PlanetTests - null
     */
}
