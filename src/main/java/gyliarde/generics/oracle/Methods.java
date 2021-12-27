package gyliarde.generics.oracle;

import gyliarde.generics.model.OrderedPair;
import gyliarde.generics.model.Util;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Methods {

    /**
     * Generic Methods
     *
     * Generic methods are methods that introduce their own type parameters.
     * This is similar to declaring a generic type, but the type parameter's scope is limited to the method where it
     * is declared. Static and non-static generic methods are allowed, as well as generic class constructors.
     */

    @Test
    public void shouldComparePairsIsFalse() {
        OrderedPair pair1 = new OrderedPair(1,"Cristiano Ronaldo");
        OrderedPair pair2 = new OrderedPair(2,"Messi");
        boolean comparePairs = Util.compare(pair1, pair2);
        assertThat(comparePairs,is(Boolean.FALSE));
    }

    @Test
    public void shouldComparePairsIsTrue() {
        OrderedPair pair1 = new OrderedPair(1,"Neymar");
        OrderedPair pair2 = new OrderedPair(1,"Neymar");
        boolean comparePairs = Util.<Integer,String>compare(pair1, pair2);
        assertThat(comparePairs,is(Boolean.TRUE));
    }
}
