package gyliarde.generics.oracle;


import gyliarde.generics.model.AbstractFactory;
import gyliarde.generics.model.Ferrari;
import gyliarde.generics.model.OrderedPair;
import gyliarde.generics.model.Porshe;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Bounded Type Parameters
 *
 * There may be times when you want to restrict the types that can be used as type arguments in a parameterized type.
 * For example, a method that operates on numbers might only want to accept instances of Number or its subclasses.
 * This is what bounded type parameters are for.
 *
 * To declare a bounded type parameter, list the type parameter's name,
 * followed by the extends keyword, followed by its upper bound, which in this example is Number.
 * Note that, in this context, extends is used in a general sense to mean either "extends" (as in classes)
 * or "implements" (as in interfaces).
 */

public class BoundedTypes {

    @Test
    public void shouldInvokeBoundedMethod(){
        AbstractFactory<Porshe> porsheFactory = new AbstractFactory<>();
        porsheFactory.setT(new Porshe());
        OrderedPair inspect = porsheFactory.inspect(new OrderedPair(1, new Ferrari()));
        assertThat(porsheFactory.getT(),instanceOf(Porshe.class));
        assertThat(inspect,instanceOf(OrderedPair.class));
    }
}
