package gyliarde.generics.oracle;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class MethodsAndBoundedTypes {

    @Test
    public void shouldInvokeMethodWithBoundTypes() {
        Integer elem = 10;
        Integer[] anArrayInt = new Integer[3];
        anArrayInt[0] = 5;
        anArrayInt[1] = 15;
        anArrayInt[2] = 20;
        int countGreaterThan = countGreaterThan(anArrayInt, elem);
        Assert.assertThat(countGreaterThan,is(2));
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray) {
            if ( e.compareTo(elem) > 0 ) {
                count ++;
            }
        }
        return count;
    }
}
