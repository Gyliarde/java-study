package gyliarde.collections;

import gyliarde.collections.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionMap {

    private List<Person> personList;


    @Before
    public void setup() {
       personList = Arrays.asList(
                Person.onePerson(1,"John",30),
                Person.onePerson(1,"Peter",30),
                Person.onePerson(1,"Marie",25),
                Person.onePerson(1,"Olaf",26),
                Person.onePerson(1,"James",25)
        );
    }


    @Test
    public void shouldGroupEmployeeAge() {
        Map<Integer, List<Person>> personsByAge =
                personList.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(personsByAge);
    }

    @Test
    public void shouldSumEmployeeAge() {
        final Integer totalAgeOfEmployee = personList
                .stream()
                .collect(Collectors.summingInt(Person::getAge));

        System.out.println(totalAgeOfEmployee);
    }

    @Test
    public void shouldFilterEmployeeUnderThirty() {
        final Map<Boolean, List<Person>> partitionsPersonsUnderThirty = personList
                .stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() < 30));
        System.out.println(partitionsPersonsUnderThirty);

        final List<Person> filterPersonUnderTwentyEight = personList
                .stream()
                .filter(p -> p.getAge() < 28).collect(Collectors.toList());

        System.out.println(filterPersonUnderTwentyEight);
    }

    @Test
    public void shouldIterateFrequency() {
        String[] args =  {"if", "it" ,"is", "to", "be", "it", "is", "up", "to",
                "me", "to", "delegate"};
        executeFrequencyWithoutOrder(args);
        executeFrequencyWithOrder(args);
        executeFrequencyWithInputOrder(args);
    }

    private static void executeFrequencyWithoutOrder(String[] args) {
        Map<String, Integer> m = new HashMap<>();

        // Initialize frequency table from command line
        for (String a : args) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
    }

    private static void executeFrequencyWithOrder(String[] args) {
        Map<String, Integer> m = new TreeMap<>();

        // Initialize frequency table from command line
        for (String a : args) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
    }

    private static void executeFrequencyWithInputOrder(String[] args) {
        Map<String, Integer> m = new LinkedHashMap<>();

        // Initialize frequency table from command line
        for (String a : args) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
    }
}
