package gyliarde.generics;

import gyliarde.generics.model.Building;
import gyliarde.generics.model.House;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.hasItems;

public class BaeldungExamples {

    @Test
    public void testOne() {
        List list = new LinkedList();
        list.add(new Integer(1));
        Integer i = (Integer) list.iterator().next();

        System.out.printf(i.toString());
    }

    @Test
    public void testTwo() {
        List<Integer> list = new LinkedList();
        list.add(new Integer(1));
        Integer i = list.iterator().next();

        System.out.printf(i.toString());
    }

    @Test
    public void givenArrayOfIntegers_thanListOfStringReturnedOK() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<String> stringList
                = BaeldungExamples.fromArrayToList(intArray, Object::toString);

       Assert.assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
    }


    /**
     *
     * The <T> in the method signature implies that the method will be dealing with generic type T.
     * This is needed even if the method is returning void.
     */
    public <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }

    /**
     * Note that Oracle recommendation is to use an uppercase letter to represent a generic type and to choose a more descriptive letter to represent formal types. 
     * In Java Collections, we use T for type, K for key and V for value
     */

    public static void paintAllBuildings(List<Building> buildings) {
        buildings.forEach(Building::paint);
    }

    @Test
    public void shouldPaintBuildingsButNotInstancedSubtype() {
        List<Building> buildings = Arrays.asList(new House("Blue"));
       paintAllBuildings(buildings);
    }

    /**
     * Wildcards are represented by the question mark ? in Java, and we use them to refer to an unknown type. Wildcards are particularly useful with generics and can be used as a parameter type.
     * But first, there is an important note to consider. We know that Object is the supertype of all Java classes. However, a collection of Object is not the supertype of any collection.
     * For example, a List<Object> is not the supertype of List<String>, and assigning a variable of type List<Object> to a variable of type List<String> will cause a compiler error. This is to prevent possible conflicts that can happen if we add heterogeneous types to the same collection.
     * The same rule applies to any collection of a type and its subtypes.
     */

    public static  void paintAllBuildingsAndSubtypes(List<? extends Building> buildings) {
        buildings.forEach(Building::paint);
    }

    @Test
    public void shouldPaintBuildingsAntInstancedSubtype() {
        List<House> buildings = Arrays.asList(new House("Blue"));
        paintAllBuildingsAndSubtypes(buildings);
    }

    /**
     * Now this method will work with type Building and all its subtypes. This is called an upper-bounded wildcard, where type Building is the upper bound.
     * We can also specify wildcards with a lower bound, where the unknown type has to be a supertype of the specified type. Lower bounds can be specified using the super keyword followed by the specific type. For example, <? super T> means unknown type that is a superclass of T (= T and all its parents).
     */


    public static void printListObject(List<Object> list) {
        for (Object element : list) {
            System.out.print(element + " ");
        }
    }

    public static <T> void printListParametrized(List<T> list) {
        for (Object element : list) {
            System.out.print(element + " ");
        }
    }

    public static void printListWildCard(List<?> list) {
        for (Object element: list) {
            System.out.print(element + " ");
        }
    }

    @Test
    public void testWildCard() {
        List<Integer> li = Arrays.asList(1, 2, 3);
        printListParametrized(li);
        printListWildCard(li);
    }

}
