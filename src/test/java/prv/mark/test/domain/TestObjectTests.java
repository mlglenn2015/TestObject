package prv.mark.test.domain;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by mlglenn on 5/16/2016.
 */
public class TestObjectTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestObjectTests.class);

    // Predicates
    Predicate<TestObject> allDrivers = p -> p.getAge() >= 16;
    Predicate<TestObject> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && EnumGender.MALE.getGenderType().equals(p.getGender());
    Predicate<TestObject> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;


    @Before
    public void setUp() {
        LOGGER.debug("TestObjectTests.setUp()");
    }

    @Test
    public void testListCreation() {
        List<TestObject> testObjectList = getTestObjectList();
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 10);
    }

    @Test
    public void testSortListUsingInnerClass() {
        List<TestObject> testObjectList = getTestObjectList();
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 10);

        //Example of sorting with an inner class
        Collections.sort(testObjectList, new Comparator<TestObject>() {
            @Override
            public int compare(TestObject o1, TestObject o2) {
                return o1.getSerialNumber().compareTo(o2.getSerialNumber());
            }
        });

        for (TestObject obj : testObjectList) {
            LOGGER.debug("testSortListUsingInnerClass(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }

    @Test
    public void testSortListUsingLambda() {
        List<TestObject> testObjectList = getTestObjectList();
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 10);

        //Example of sorting with Lambda
        Collections.sort(testObjectList, (TestObject o1, TestObject o2) -> o1.getSerialNumber().compareTo(o2.getSerialNumber()));
        LOGGER.debug("Ascending sort");
        for (TestObject obj : testObjectList) {
            LOGGER.debug("testSortListUsingLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }

        //Descending sort
        Collections.sort(testObjectList, (o1, o2) -> o2.getSerialNumber().compareTo(o1.getSerialNumber()));
        LOGGER.debug("Descending sort");
        for (TestObject obj : testObjectList) {
            LOGGER.debug("testSortListUsingLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }

    @Test
    public void testListCreationFromBuilder() {
        List<TestObject> testObjectList = getTestObjectListUsingBuilderPattern();
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 5);
        for (TestObject obj : testObjectList) {
            LOGGER.debug("testListCreationFromBuilder(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }

    @Test
    public void testListIsDrivingAgeUsingStreamAndLambda() {
        List<TestObject> testObjectList =
                getTestObjectListUsingBuilderPattern()
                .stream()
                .filter(p -> p.getAge() >= 16)
                .collect(Collectors.toList());
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 4);
        for (TestObject obj : testObjectList) {
            LOGGER.debug("testListIsDrivingAgeUsingStreamAndLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }

    @Test
    public void testListIsEligibleDrafteeUsingStreamAndLambda() {
        List<TestObject> testObjectList =
                getTestObjectListUsingBuilderPattern()
                .stream()
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 25 && EnumGender.MALE.getGenderType().equals(p.getGender()))
                .collect(Collectors.toList());
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 2);
        for (TestObject obj : testObjectList) {
            LOGGER.debug("testListIsEligibleDrafteeUsingStreamAndLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }

    @Test
    public void testListIsFlyingAgeUsingStreamAndLambda() {
        List<TestObject> testObjectList =
                getTestObjectListUsingBuilderPattern()
                .stream()
                .filter(p -> p.getAge() >= 23 && p.getAge() <= 65)
                .collect(Collectors.toList());
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 1);
        for (TestObject obj : testObjectList) {
            LOGGER.debug("testListIsEligibleDrafteeUsingStreamAndLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }

    @Test
    public void testListIsDrivingAgeUsingStreamAndLambdaPredicate() {
        List<TestObject> testObjectList =
                getTestObjectListUsingBuilderPattern()
                        .stream()
                        .filter(allDrivers)
                        .collect(Collectors.toList());
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 4);
        for (TestObject obj : testObjectList) {
            LOGGER.debug("testListIsDrivingAgeUsingStreamAndLambdaPredicate(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }

    @Test
    public void testListIsEligibleDrafteeUsingStreamAndLambdaPredicate() {
        List<TestObject> testObjectList =
                getTestObjectListUsingBuilderPattern()
                        .stream()
                        .filter(allDraftees)
                        .collect(Collectors.toList());
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 2);
        for (TestObject obj : testObjectList) {
            LOGGER.debug("testListIsEligibleDrafteeUsingStreamAndLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }

    @Test
    public void testListIsFlyingAgeUsingStreamAndLambdaPredicate() {
        List<TestObject> testObjectList =
                getTestObjectListUsingBuilderPattern()
                        .stream()
                        .filter(allPilots)
                        .collect(Collectors.toList());
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 1);
        for (TestObject obj : testObjectList) {
            LOGGER.debug("testListIsEligibleDrafteeUsingStreamAndLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }



    private List<TestObject> getTestObjectList() {
        int idx = 0;
        TestObject testObject;
        List<TestObject> objList = new ArrayList<>();
        do {
            testObject = getNewTestObject(++idx);
            objList.add(testObject);
            LOGGER.debug("Debugging testObject: {} {} {} {} {}",
                    testObject.getName(), testObject.getRank(), testObject.getSerialNumber(), testObject.getAge(), testObject.getGender());
        }
        while (idx < 10);
        return objList;
    }

    private TestObject getNewTestObject(int serialNumber) {
        return new TestObject("ObjectName_"+Integer.toString(serialNumber), "PrivateRank", "SN"+Integer.toString(serialNumber), 16, "M");
    }

    private List<TestObject> getTestObjectListUsingBuilderPattern() {
        List<TestObject> objList = new ArrayList<>();

        objList.add(
                new TestObject.Builder()
                        .name("Object1")
                        .rank("PrivateRank")
                        .serialNumber("SN100")
                        .age(14)
                        .gender("F")
                        .build()
        );

        objList.add(
                new TestObject.Builder()
                        .name("Object2")
                        .rank("PrivateRank")
                        .serialNumber("SN200")
                        .age(16)
                        .gender("M")
                        .build()
        );

        objList.add(
                new TestObject.Builder()
                        .name("Object3")
                        .rank("PrivateRank")
                        .serialNumber("SN300")
                        .age(18)
                        .gender("F")
                        .build()
        );

        objList.add(
                new TestObject.Builder()
                        .name("Object4")
                        .rank("PrivateRank")
                        .serialNumber("SN400")
                        .age(21)
                        .gender("M")
                        .build()
        );

        objList.add(
                new TestObject.Builder()
                        .name("Object5")
                        .rank("PrivateRank")
                        .serialNumber("SN500")
                        .age(23)
                        .gender("M")
                        .build()
        );

        return objList;
    }

    private boolean isDrivingAge(TestObject obj) {
        boolean retVal = false;
        if (obj.getAge() >= 16) {
            retVal = true;
        }
        return retVal;
    }

    private boolean isEligibleDraftee(TestObject obj) {
        boolean retVal = false;
        if (obj.getAge() >= 18 && obj.getAge() <= 25 && EnumGender.MALE.name().equals(obj.getGender())) {
            retVal = true;
        }
        return retVal;
    }

    private boolean isFlyingAge(TestObject obj) {
        boolean retVal = false;
        if (obj.getAge() >= 23 && obj.getAge() <= 65) {
            retVal = true;
        }
        return retVal;
    }
}
