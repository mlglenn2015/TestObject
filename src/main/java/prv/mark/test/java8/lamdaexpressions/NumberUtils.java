package prv.mark.test.java8.lamdaexpressions;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * http://www.journaldev.com/2763/java-8-functional-interfaces
 *
 * Created by mlglenn on 10/12/2016.
 */
public class NumberUtils {

    /*
     The problem with the code is that it's sequential in nature, if the number is very huge then it
     will take significant amount of time. Another problem with code is that there are so many exit
     points and it's not readable. Let's see how we can write the same method using lambda expressions
     and stream API.
     */
    public static boolean isPrimeTraditionalWay(int number) {
        if (number < 2) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    /*
     IntStream is a sequence of primitive int-valued elements supporting sequential and parallel aggregate
     operations. This is the int primitive specialization of Stream.
     */
    public static boolean isPrimeLambdaDeclarativeWay(int number) {
        //boolean result = false;
        return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
    }

    /*
     IntStream using a declared Predicate
     */
    public static boolean isPrimeUsingLambdaPredicateWay(int number) {
        IntPredicate isDivisible = index -> number % index == 0;
        return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);
    }

    /*
     Let's see how we can use lambda expressions to pass behavior of a method with a simple example. Let's
     say we have to write a method to sum the numbers in a list if they match a given criteria. We can use
     Predicate and write a method like below.
     */
    public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.parallelStream()
                .filter(predicate)
                .mapToInt(i -> i)
                .sum();
    }

    /*
     One more advantage of using lambda expression is the lazy evaluation, for example let's say we need
     to write a method to find out the maximum odd number in the range 3 to 11 and return square of it.

     Usually we will write code for this method like this:
     */
    public static int getMaximumOddNumberTraditionalWay(List<Integer> numbers, int begin, int end) {
        int max = 0;
        for (int i : numbers) {
            if ((i % 2 != 0) && (i > begin) && (i < end) && (i > max)) {
                max = i;
            }
        }
        return max;
    }

    /*
     If you are surprised with the double colon (::) operator, it's introduced in Java 8 and used
     for method references. Java Compiler takes care of mapping the arguments to the called method.
     It's short form of lambda expressions i -> isGreaterThan3(i) or i -> NumberTest.isGreaterThan3(i).
     */
    public static int getMaximumOddNumberPredicateWay(List<Integer> numbers) {
        return numbers.stream()
                .filter(NumberUtils::isOdd)             // Predicate is functional interface and
                .filter(NumberUtils::isGreaterThan3)    // we are using lambdas to initialize it
                .filter(NumberUtils::isLessThan11)      // rather than anonymous inner classes
                .max(Comparator.naturalOrder())
                .map(i -> i)
                .get();
    }
    public static boolean isOdd(int i) {
        return i % 2 != 0;
    }
    public static boolean isGreaterThan3(int i) {
        return i > 3;
    }
    public static boolean isLessThan11(int i) {
        return i < 11;
    }

}
