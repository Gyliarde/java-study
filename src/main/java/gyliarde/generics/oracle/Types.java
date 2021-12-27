package gyliarde.generics.oracle;

import gyliarde.generics.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Types {

    /**
     * Why Use Generics?
     *
     * In a nutshell, generics enable types (classes and interfaces) to be parameters when defining classes,
     * interfaces and methods. Much like the more familiar formal parameters used in method declarations,
     * type parameters provide a way for you to re-use the same code with different inputs.
     * The difference is that the inputs to formal parameters are values, while the inputs to type parameters are types.
     *
     * - Stronger type check in compile time
     * - Elimination of casts
     * - Enabling programmers to implement generic algorithms.
     *  - By using generics, programmers can implement generic algorithms that work on collections of different types,
     *  can be customized, and are type safe and easier to read.
     */

    @Test
    public void whenWrittenCodeWithoutGenericsMustBeCasting() {
        List list = new ArrayList<>();
        list.add("Hello");
        String s = (String) list.get(0);
        assertThat(s, is("Hello"));
        assertThat( s, instanceOf(String.class));
    }

    @Test
    public void whenWrittenCodeWithGenericsWillNotNeedInsertCasting() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        String s = list.get(0);
        assertThat(s, is("Hello"));
        assertThat(s, instanceOf(String.class));
    }

    /**
     * Generic Types
     *
     * A generic type is a generic class or interface that is parameterized over types
     */

    @Test
    public void instantiateCarFromGenericFactory(){
        AbstractFactory<Ferrari> abstractFactory = new AbstractFactory<>();
        abstractFactory.setT(new Ferrari());
        assertThat(abstractFactory.getT(), instanceOf(Ferrari.class));
    }

    /**
     * Multiple Generic Types
     */

    @Test
    public void instantiateOrderedPairWithMultipleGenericTypes() {
        Pair<String, Integer> p1 = new OrderedPair<>("Even", 8);
        Pair<String, String>  p2 = new OrderedPair<>("hello", "world");
    }

    /**
     * Raw Types
     *
     * A raw type is the name of a generic class or interface without any type arguments.
     * Raw types show up in legacy code because lots of API classes (such as the Collections classes) were not generic prior to JDK 5.0.
     * When using raw types, you essentially get pre-generics behavior
     *
     * Raw types must be avoided
     */

    @Test
    public void instantiateAbstractFactoryNonParametrized() {
        AbstractFactory<Ferrari> ferrariAbstractFactory = new AbstractFactory<>();
        AbstractFactory abstractFactory = ferrariAbstractFactory;
        abstractFactory.setT(10);
    }
}
