package gyliarde.collections;

import gyliarde.collections.model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * A Set is a Collection that cannot contain duplicate elements.
 * It models the mathematical set abstraction. The Set interface contains only methods inherited
 * from Collection and adds the restriction that duplicate elements are prohibited.
 *
 * Set also adds a stronger contract on the behavior of the equals and hashCode operations,
 * allowing Set instances to be compared meaningfully even if their implementation types differ.
 * Two Set instances are equal if they contain the same elements.
 *
 * The Java platform contains three general-purpose
 * Set implementations: HashSet, TreeSet, and LinkedHashSet.
 * HashSet, which stores its elements in a hash table, is the best-performing implementation;
 * however it makes no guarantees concerning the order of iteration.
 * TreeSet, which stores its elements in a red-black tree, orders its elements based on their values; it is substantially slower than HashSet. LinkedHashSet, which is implemented as a hash table with a linked list running through it, orders its elements based on the order in which they were inserted into the set (insertion-order). LinkedHashSet spares its clients from the unspecified, generally chaotic ordering provided by HashSet at a cost that is only slightly higher.
 */

public class CollectionSet {

    @Test
    public void shouldNotDuplicateElements() {
        final List<Integer> list = Arrays.asList(1,1,1,1,2,2,2,3,3);

        final Collection<Integer> noDuplicated = new HashSet<>(list);
        final Collection<Integer> noDuplicatedByStream = list.stream().collect(Collectors.toSet());

        System.out.println(noDuplicated.size());
        assertThat(noDuplicated.size(),is(3));
        assertThat(noDuplicatedByStream.size(),is(3));
    }

    @Test
    public void shouldNotDuplicatePersonName() {
        final Person person1 = new Person(1, "John");
        final Person person2 = new Person(2, "John");
        final Person person3 = new Person(3, "Marie");
        final Person person4 = new Person(4, "Marie");
        final Person person5 = new Person(5, "Anderson");
        final Person person6 = new Person(6, "Anderson");
        final List<Person> personList = Arrays.asList(person1, person2, person3, person4,person5,person6);

        // TreeSet use Natural order of elements
        Set<String> personNames = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(TreeSet::new));

        // LinkedHashSet use insertion order of elements
        Set<String> personNamesOrdered = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println("Tree Set using natual order (Comparator)");
        personNames.stream().forEach(System.out::println);
        System.out.println("LinkedHashSet Set using insert element order )");
        personNamesOrdered.stream().forEach(System.out::println);
        assertThat(personNames.size(),is(2));
        assertThat(personNamesOrdered.size(),is(2));
    }
}
