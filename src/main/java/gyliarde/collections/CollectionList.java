package gyliarde.collections;

import gyliarde.collections.model.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static gyliarde.collections.model.Person.onePerson;
import static java.lang.System.out;

public class CollectionList {

    /**
     * A List is an ordered Collection (sometimes called a sequence).
     * Lists may contain duplicate elements. In addition to the operations inherited from Collection,
     * the List interface includes operations for the following:
     */

    @Test
    public void shouldTestList() {
        List<Person> list ;
        list = Arrays.asList(onePerson(1, "John",25), onePerson(2,"Peter",30));
        List<String> personNames = list.stream().map(Person::getName).collect(Collectors.toList());
        personNames.parallelStream().forEach(out::println);
    }
}
