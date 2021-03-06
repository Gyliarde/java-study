package gyliarde.generics.oracle;

import gyliarde.generics.model.Car;
import gyliarde.generics.model.Ferrari;
import gyliarde.generics.model.Porshe;
import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

/**
 * In generic code, the question mark (?), called the wildcard, represents an unknown type.
 * The wildcard can be used in a variety of situations: as the type of a parameter, field, or local variable;
 * sometimes as a return type (though it is better programming practice to be more specific).
 * The wildcard is never used as a type argument for a generic method invocation,
 * a generic class instance creation, or a supertype.
 */

public class WildCards {

    /**
     * Upper Bounded Wildcards
     *
     * To declare an upper-bounded wildcard, use the wildcard character ('?'), followed by the extends keyword,
     * followed by its upper bound. Note that, in this context, extends is used in a general sense to mean
     * either "extends" (as in classes) or "implements" (as in interfaces).
     *
     * To write the method that works on lists of Number and the subtypes of Number, such as Integer, Double,
     * and Float, you would specify List<? extends Number>. The term List<Number> is more restrictive
     * than List<? extends Number> because the former matches a list of type Number only,
     * whereas the latter matches a list of type Number or any of its subclasses.
     *
     * The wildcard is commonly used with lists
     */

    @Test
    public void shouldSumListOfInteger() {
        List<Integer> list = Arrays.asList(1,2,3);
        double sum = sumOfList(list);
        Assert.assertThat(sum,is(6.0));
    }

    @Test
    public void shouldSumListOfDouble() {
        List<Double> list = Arrays.asList(1.0,2.0,3.0);
        double sum = sumOfList(list);
        Assert.assertThat(sum,is(6.0));
    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    /**
     * Unbounded Wildcards
     *
     * The unbounded wildcard type is specified using the wildcard character (?), for example, List<?>.
     * This is called a list of unknown type
     *
     * There are two scenarios where an unbounded wildcard is a useful approach:
     *
     * if you are writing a method that can be implemented using functionality provided in the Object class.
     *
     * When the code is using methods in the generic class that don't depend on the type parameter.
     *
     * For example, List.size or List.clear.
     * In fact, Class<?> is so often used because most of the methods in Class<T> do not depend on T.
     */

    @Test
    public void shouldInvokeUnboundedPrintList() {
        List<String> list = Arrays.asList("Test-One","Test-Two");
        printList(list);
    }


    public static <T> void printList(List<T> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    @Test
    public void shouldInvokeUnboundedPrintListTwo() {
        printListTwo(String.class);
    }

    public static void printListTwo(Class<?> clazz) {
        System.out.println(clazz);
    }

    /**
     * Lower Bounded Wildcards
     *
     * The Upper Bounded Wildcards section shows that an upper bounded wildcard restricts the unknown type to be a
     * specific type or a subtype of that type and is represented using the extends keyword.
     *
     * In a similar way,
     * a lower bounded wildcard restricts the unknown type to be a specific type or a super type of that type.
     *
     * A lower bounded wildcard is expressed using the wildcard character ('?'), following by the super keyword,
     * followed by its lower bound: <? super A>.
     *
     */

    /**
     *
     * To write the method that works on lists of Integer and the supertypes of Integer, such as Integer, Number,
     * and Object, you would specify List<? super Integer>. The term List<Integer> is more restrictive than List<? super Integer>
     * because the former matches a list of type Integer only, whereas the latter matches a list of any type that is a supertype of Integer.
     */
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    @Test
    public void shouldAddNumberWhenSuperTypeOfInteger() {
        List<Integer> integerList = Arrays.asList(1);
        List<Number> numberList = Arrays.asList(2);
        List<Serializable> serializableList = Arrays.asList(3);

        addNumbers(integerList);
        addNumbers(numberList);
        addNumbers(serializableList);
    }

}
