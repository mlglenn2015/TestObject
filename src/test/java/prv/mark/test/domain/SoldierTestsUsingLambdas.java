package prv.mark.test.domain;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by mlglenn on 5/16/2016.
 */
public class SoldierTestsUsingLambdas {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoldierTestsUsingLambdas.class);

    // Predicates
    Predicate<Soldier> allDrivers = p -> p.getAge() >= 16;
    Predicate<Soldier> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && EnumGender.MALE.getGenderType().equals(p.getGender());
    Predicate<Soldier> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;


    @Before
    public void setUp() {
        LOGGER.debug("TestObjectTests.setUp()");
    }

    @Test
    public void testListCreation() {
        List<Soldier> testObjectList = getTestObjectList();
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 10);
    }
    /*
    10:07:36.429 [main] DEBUG prv.mark.test.domain.TestObjectTests - TestObjectTests.setUp()
10:07:36.435 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_1 PrivateRank SN1 16 M
10:07:36.436 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_2 PrivateRank SN2 16 M
10:07:36.437 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_3 PrivateRank SN3 16 M
10:07:36.437 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_4 PrivateRank SN4 16 M
10:07:36.437 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_5 PrivateRank SN5 16 M
10:07:36.437 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_6 PrivateRank SN6 16 M
10:07:36.437 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_7 PrivateRank SN7 16 M
10:07:36.437 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_8 PrivateRank SN8 16 M
10:07:36.437 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_9 PrivateRank SN9 16 M
10:07:36.437 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_10 PrivateRank SN10 16 M
     */

    @Test
    public void testSortListUsingInnerClass() {
        List<Soldier> testObjectList = getTestObjectList();
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 10);

        //Example of sorting with an inner class
        Collections.sort(testObjectList, new Comparator<Soldier>() {
            @Override
            public int compare(Soldier o1, Soldier o2) {
                return o1.getSerialNumber().compareTo(o2.getSerialNumber());
            }
        });

        for (Soldier obj : testObjectList) {
            LOGGER.debug("testSortListUsingInnerClass(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }
    /*
    10:08:13.645 [main] DEBUG prv.mark.test.domain.TestObjectTests - TestObjectTests.setUp()
10:08:13.650 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_1 PrivateRank SN1 16 M
10:08:13.652 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_2 PrivateRank SN2 16 M
10:08:13.652 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_3 PrivateRank SN3 16 M
10:08:13.652 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_4 PrivateRank SN4 16 M
10:08:13.652 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_5 PrivateRank SN5 16 M
10:08:13.652 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_6 PrivateRank SN6 16 M
10:08:13.652 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_7 PrivateRank SN7 16 M
10:08:13.652 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_8 PrivateRank SN8 16 M
10:08:13.652 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_9 PrivateRank SN9 16 M
10:08:13.652 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_10 PrivateRank SN10 16 M
10:08:13.653 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingInnerClass(): ObjectName_1 PrivateRank SN1 16 M
10:08:13.653 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingInnerClass(): ObjectName_10 PrivateRank SN10 16 M
10:08:13.653 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingInnerClass(): ObjectName_2 PrivateRank SN2 16 M
10:08:13.653 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingInnerClass(): ObjectName_3 PrivateRank SN3 16 M
10:08:13.653 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingInnerClass(): ObjectName_4 PrivateRank SN4 16 M
10:08:13.653 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingInnerClass(): ObjectName_5 PrivateRank SN5 16 M
10:08:13.653 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingInnerClass(): ObjectName_6 PrivateRank SN6 16 M
10:08:13.653 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingInnerClass(): ObjectName_7 PrivateRank SN7 16 M
10:08:13.653 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingInnerClass(): ObjectName_8 PrivateRank SN8 16 M
10:08:13.653 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingInnerClass(): ObjectName_9 PrivateRank SN9 16 M
     */

    @Test
    public void testSortListUsingLambda() {
        List<Soldier> testObjectList = getTestObjectList();
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 10);

        //Example of sorting with Lambda
        Collections.sort(testObjectList, (Soldier o1, Soldier o2) -> o1.getSerialNumber().compareTo(o2.getSerialNumber()));
        LOGGER.debug("Ascending sort");
        for (Soldier obj : testObjectList) {
            LOGGER.debug("testSortListUsingLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }

        //Descending sort
        Collections.sort(testObjectList, (o1, o2) -> o2.getSerialNumber().compareTo(o1.getSerialNumber()));
        LOGGER.debug("Descending sort");
        for (Soldier obj : testObjectList) {
            LOGGER.debug("testSortListUsingLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }
    /*
    10:08:52.690 [main] DEBUG prv.mark.test.domain.TestObjectTests - TestObjectTests.setUp()
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_1 PrivateRank SN1 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_2 PrivateRank SN2 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_3 PrivateRank SN3 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_4 PrivateRank SN4 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_5 PrivateRank SN5 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_6 PrivateRank SN6 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_7 PrivateRank SN7 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_8 PrivateRank SN8 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_9 PrivateRank SN9 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - Debugging testObject: ObjectName_10 PrivateRank SN10 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - Ascending sort
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_1 PrivateRank SN1 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_10 PrivateRank SN10 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_2 PrivateRank SN2 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_3 PrivateRank SN3 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_4 PrivateRank SN4 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_5 PrivateRank SN5 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_6 PrivateRank SN6 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_7 PrivateRank SN7 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_8 PrivateRank SN8 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_9 PrivateRank SN9 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - Descending sort
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_9 PrivateRank SN9 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_8 PrivateRank SN8 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_7 PrivateRank SN7 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_6 PrivateRank SN6 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_5 PrivateRank SN5 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_4 PrivateRank SN4 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_3 PrivateRank SN3 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_2 PrivateRank SN2 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_10 PrivateRank SN10 16 M
10:08:52.705 [main] DEBUG prv.mark.test.domain.TestObjectTests - testSortListUsingLambda(): ObjectName_1 PrivateRank SN1 16 M
     */

    @Test
    public void testListCreationFromBuilder() {
        List<Soldier> testObjectList = getTestObjectListUsingBuilderPattern();
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 5);
        for (Soldier obj : testObjectList) {
            LOGGER.debug("testListCreationFromBuilder(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }
    /*
    10:09:25.893 [main] DEBUG prv.mark.test.domain.TestObjectTests - TestObjectTests.setUp()
10:09:25.893 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListCreationFromBuilder(): Object1 PrivateRank SN100 14 F
10:09:25.893 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListCreationFromBuilder(): Object2 PrivateRank SN200 16 M
10:09:25.893 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListCreationFromBuilder(): Object3 PrivateRank SN300 18 F
10:09:25.893 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListCreationFromBuilder(): Object4 PrivateRank SN400 21 M
10:09:25.893 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListCreationFromBuilder(): Object5 PrivateRank SN500 23 M
     */

    @Test
    public void testListIsDrivingAgeUsingStreamAndLambda() {
        List<Soldier> testObjectList =
                getTestObjectListUsingBuilderPattern()
                .stream()
                .filter(p -> p.getAge() >= 16)
                .collect(Collectors.toList());
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 4);
        for (Soldier obj : testObjectList) {
            LOGGER.debug("testListIsDrivingAgeUsingStreamAndLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }
    /*
    10:09:51.141 [main] DEBUG prv.mark.test.domain.TestObjectTests - TestObjectTests.setUp()
10:09:51.165 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsDrivingAgeUsingStreamAndLambda(): Object2 PrivateRank SN200 16 M
10:09:51.166 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsDrivingAgeUsingStreamAndLambda(): Object3 PrivateRank SN300 18 F
10:09:51.167 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsDrivingAgeUsingStreamAndLambda(): Object4 PrivateRank SN400 21 M
10:09:51.167 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsDrivingAgeUsingStreamAndLambda(): Object5 PrivateRank SN500 23 M
     */

    @Test
    public void testListIsEligibleDrafteeUsingStreamAndLambda() {
        List<Soldier> testObjectList =
                getTestObjectListUsingBuilderPattern()
                .stream()
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 25 && EnumGender.MALE.getGenderType().equals(p.getGender()))
                .collect(Collectors.toList());
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 2);
        for (Soldier obj : testObjectList) {
            LOGGER.debug("testListIsEligibleDrafteeUsingStreamAndLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }
    /*
    10:10:30.223 [main] DEBUG prv.mark.test.domain.TestObjectTests - TestObjectTests.setUp()
10:10:30.236 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsEligibleDrafteeUsingStreamAndLambda(): Object4 PrivateRank SN400 21 M
10:10:30.238 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsEligibleDrafteeUsingStreamAndLambda(): Object5 PrivateRank SN500 23 M
     */

    @Test
    public void testListIsFlyingAgeUsingStreamAndLambda() {
        List<Soldier> testObjectList =
                getTestObjectListUsingBuilderPattern()
                .stream()
                .filter(p -> p.getAge() >= 23 && p.getAge() <= 65)
                .collect(Collectors.toList());
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 1);
        for (Soldier obj : testObjectList) {
            LOGGER.debug("testListIsEligibleDrafteeUsingStreamAndLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }
    /*
    10:10:57.311 [main] DEBUG prv.mark.test.domain.TestObjectTests - TestObjectTests.setUp()
10:10:57.324 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsEligibleDrafteeUsingStreamAndLambda(): Object5 PrivateRank SN500 23 M
     */

    @Test
    public void testListIsDrivingAgeUsingStreamAndLambdaPredicate() {
        List<Soldier> testObjectList =
                getTestObjectListUsingBuilderPattern()
                        .stream()
                        .filter(allDrivers)
                        .collect(Collectors.toList());
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 4);
        for (Soldier obj : testObjectList) {
            LOGGER.debug("testListIsDrivingAgeUsingStreamAndLambdaPredicate(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }
    /*
    10:11:22.784 [main] DEBUG prv.mark.test.domain.TestObjectTests - TestObjectTests.setUp()
10:11:22.791 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsDrivingAgeUsingStreamAndLambdaPredicate(): Object2 PrivateRank SN200 16 M
10:11:22.794 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsDrivingAgeUsingStreamAndLambdaPredicate(): Object3 PrivateRank SN300 18 F
10:11:22.794 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsDrivingAgeUsingStreamAndLambdaPredicate(): Object4 PrivateRank SN400 21 M
10:11:22.794 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsDrivingAgeUsingStreamAndLambdaPredicate(): Object5 PrivateRank SN500 23 M
     */

    @Test
    public void testListIsEligibleDrafteeUsingStreamAndLambdaPredicate() {
        List<Soldier> testObjectList =
                getTestObjectListUsingBuilderPattern()
                        .stream()
                        .filter(allDraftees)
                        .collect(Collectors.toList());
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 2);
        for (Soldier obj : testObjectList) {
            LOGGER.debug("testListIsEligibleDrafteeUsingStreamAndLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }
    /*
    10:11:49.354 [main] DEBUG prv.mark.test.domain.TestObjectTests - TestObjectTests.setUp()
10:11:49.375 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsEligibleDrafteeUsingStreamAndLambda(): Object4 PrivateRank SN400 21 M
10:11:49.377 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsEligibleDrafteeUsingStreamAndLambda(): Object5 PrivateRank SN500 23 M
     */

    @Test
    public void testListIsFlyingAgeUsingStreamAndLambdaPredicate() {
        List<Soldier> testObjectList =
                getTestObjectListUsingBuilderPattern()
                        .stream()
                        .filter(allPilots)
                        .collect(Collectors.toList());
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 1);
        for (Soldier obj : testObjectList) {
            LOGGER.debug("testListIsEligibleDrafteeUsingStreamAndLambda(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
    }
    /*
    10:12:25.209 [main] DEBUG prv.mark.test.domain.TestObjectTests - TestObjectTests.setUp()
10:12:25.221 [main] DEBUG prv.mark.test.domain.TestObjectTests - testListIsEligibleDrafteeUsingStreamAndLambda(): Object5 PrivateRank SN500 23 M
     */

    @Test
    public void testListAverageAgeUsingParallelStream() {
        List<Soldier> testObjectList = getTestObjectListUsingBuilderPattern();
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 5);

        OptionalDouble averageAge = testObjectList
                .parallelStream()
                .mapToDouble(p -> p.getAge())
                .average();

        for (Soldier obj : testObjectList) {
            LOGGER.debug("testListAverageAgeUsingParallelStream(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
        LOGGER.debug("averageAge:{}", averageAge);
    }
    /*
    08-17-2016 13:40:00.910 DEBUG p.m.t.d.SoldierTestsUsingLambdas - TestObjectTests.setUp()
08-17-2016 13:40:00.925 DEBUG p.m.t.d.SoldierTestsUsingLambdas - testListAverageAgeUsingParallelStream(): Object1 PrivateRank SN100 14 F
08-17-2016 13:40:00.927 DEBUG p.m.t.d.SoldierTestsUsingLambdas - testListAverageAgeUsingParallelStream(): Object2 PrivateRank SN200 16 M
08-17-2016 13:40:00.927 DEBUG p.m.t.d.SoldierTestsUsingLambdas - testListAverageAgeUsingParallelStream(): Object3 PrivateRank SN300 18 F
08-17-2016 13:40:00.927 DEBUG p.m.t.d.SoldierTestsUsingLambdas - testListAverageAgeUsingParallelStream(): Object4 PrivateRank SN400 21 M
08-17-2016 13:40:00.927 DEBUG p.m.t.d.SoldierTestsUsingLambdas - testListAverageAgeUsingParallelStream(): Object5 PrivateRank SN500 23 M
08-17-2016 13:40:00.927 DEBUG p.m.t.d.SoldierTestsUsingLambdas - averageAge:OptionalDouble[18.4]
     */

    @Test
    public void testListSumAgesUsingStream() {
        List<Soldier> testObjectList = getTestObjectListUsingBuilderPattern();
        assertNotNull(testObjectList);
        assertEquals(testObjectList.size(), 5);

        long sumAge = testObjectList
                .stream()
                .mapToInt(p -> p.getAge())
                .sum();

        for (Soldier obj : testObjectList) {
            LOGGER.debug("testListSumAgesUsingStream(): {} {} {} {} {}",
                    obj.getName(), obj.getRank(), obj.getSerialNumber(), obj.getAge(), obj.getGender());
        }
        LOGGER.debug("sumAge:{}", sumAge);
    }
    /*
    08-17-2016 13:39:07.951 DEBUG p.m.t.d.SoldierTestsUsingLambdas - TestObjectTests.setUp()
08-17-2016 13:39:07.965 DEBUG p.m.t.d.SoldierTestsUsingLambdas - testListSumAgesUsingStream(): Object1 PrivateRank SN100 14 F
08-17-2016 13:39:07.967 DEBUG p.m.t.d.SoldierTestsUsingLambdas - testListSumAgesUsingStream(): Object2 PrivateRank SN200 16 M
08-17-2016 13:39:07.967 DEBUG p.m.t.d.SoldierTestsUsingLambdas - testListSumAgesUsingStream(): Object3 PrivateRank SN300 18 F
08-17-2016 13:39:07.967 DEBUG p.m.t.d.SoldierTestsUsingLambdas - testListSumAgesUsingStream(): Object4 PrivateRank SN400 21 M
08-17-2016 13:39:07.968 DEBUG p.m.t.d.SoldierTestsUsingLambdas - testListSumAgesUsingStream(): Object5 PrivateRank SN500 23 M
08-17-2016 13:39:07.968 DEBUG p.m.t.d.SoldierTestsUsingLambdas - sumAge:92
     */


    private List<Soldier> getTestObjectList() {
        int idx = 0;
        Soldier testObject;
        List<Soldier> objList = new ArrayList<>();
        do {
            testObject = getNewTestObject(++idx);
            objList.add(testObject);
            LOGGER.debug("Debugging testObject: {} {} {} {} {}",
                    testObject.getName(), testObject.getRank(), testObject.getSerialNumber(), testObject.getAge(), testObject.getGender());
        }
        while (idx < 10);
        return objList;
    }

    private Soldier getNewTestObject(int serialNumber) {
        return new Soldier("ObjectName_"+Integer.toString(serialNumber), "PrivateRank", "SN"+Integer.toString(serialNumber), 16, "M");
    }

    private List<Soldier> getTestObjectListUsingBuilderPattern() {
        List<Soldier> objList = new ArrayList<>();

        objList.add(
                new Soldier.Builder()
                        .name("Object1")
                        .rank("PrivateRank")
                        .serialNumber("SN100")
                        .age(14)
                        .gender("F")
                        .build()
        );

        objList.add(
                new Soldier.Builder()
                        .name("Object2")
                        .rank("PrivateRank")
                        .serialNumber("SN200")
                        .age(16)
                        .gender("M")
                        .build()
        );

        objList.add(
                new Soldier.Builder()
                        .name("Object3")
                        .rank("PrivateRank")
                        .serialNumber("SN300")
                        .age(18)
                        .gender("F")
                        .build()
        );

        objList.add(
                new Soldier.Builder()
                        .name("Object4")
                        .rank("PrivateRank")
                        .serialNumber("SN400")
                        .age(21)
                        .gender("M")
                        .build()
        );

        objList.add(
                new Soldier.Builder()
                        .name("Object5")
                        .rank("PrivateRank")
                        .serialNumber("SN500")
                        .age(23)
                        .gender("M")
                        .build()
        );

        return objList;
    }

    private boolean isDrivingAge(Soldier obj) {
        boolean retVal = false;
        if (obj.getAge() >= 16) {
            retVal = true;
        }
        return retVal;
    }

    private boolean isEligibleDraftee(Soldier obj) {
        boolean retVal = false;
        if (obj.getAge() >= 18 && obj.getAge() <= 25 && EnumGender.MALE.name().equals(obj.getGender())) {
            retVal = true;
        }
        return retVal;
    }

    private boolean isFlyingAge(Soldier obj) {
        boolean retVal = false;
        if (obj.getAge() >= 23 && obj.getAge() <= 65) {
            retVal = true;
        }
        return retVal;
    }
}
