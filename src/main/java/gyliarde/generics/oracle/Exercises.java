package gyliarde.generics.oracle;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class Exercises {

    /** Question 1
     * Write a generic method to count the number of elements in a collection that have a specific property
     * (for example, odd integers, prime numbers, palindromes).
     */

    @Test
    public void shouldCountODDNumbersFromCollecion() {
        PropertyNumbers<Integer> oddProperty = new OddProperty();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6,7);
        List<String> list2 = Arrays.asList("1");
        final long totalOdd = countElementCollection(list2,oddProperty);
        Assert.assertThat(totalOdd,is(4));
    }

    private  <T> long countElementCollection(Collection<T> collection, PropertyNumbers propertyNumbers) {
        long total = collection.stream().filter(value -> propertyNumbers.test(value)).count();
        return total;
    }

    public interface PropertyNumbers<T> {
        boolean test(T obj);
    }

    public class OddProperty implements PropertyNumbers<Integer> {
        @Override
        public boolean test(Integer value) {
             return value % 2 != 0;
        }
    }

    /** Question 2
     *     Will the following class compile? If not, why?
     *     public final class Algorithm {
     *         public static <T> T max(T x, T y) {
     *             return x > y ? x : y;
     *         }
     *     }
     *
     *      No. The greater than (>) operator applies only to primitive numeric types.
     */

}
