package org.example.optional;

import org.example.optional.model.Client;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MyExamples {

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        Client client = new Client();
        Optional<Client> optionalClient = Optional.of(client);
        assertTrue(optionalClient.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        Client client = null;
        Optional.of(client);
    }

    @Test
    public void givenNonNull_whenCreatesNullable_thenCorrect() {
        Client client = new Client();
        Optional<Client> optionalClient = Optional.ofNullable(client);
        assertTrue(optionalClient.isPresent());
    }

    @Test
    public void givenNull_whenCreatesNullable_thenCorrect() {
        Client client = null;
        Optional<Client> optionalClient = Optional.ofNullable(client);
        assertFalse(optionalClient.isPresent());
    }

    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
        Client client = new Client();
        Optional<Client> optionalClient = Optional.of(client);
        optionalClient.ifPresent(System.out::println);
    }

    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("Gyliarde");
        assertEquals("Gyliarde",name);
    }

    @Test
    public void whenOrElseGetWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "Gyliarde");
        assertEquals("Gyliarde",name);
    }

    private String getClientName() {
        String name = "John";
        System.out.println("Getting Default Value");
        return name;
    }

    @Test
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(this::getClientName);
        assertEquals("John", name);

        name = Optional.ofNullable(nullName).orElse(getClientName());
        assertEquals("John",name);
    }

    @Test
    public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
        String person = "Gyliarde";
        String name = Optional.ofNullable(person).orElseGet(this::getClientName);
        assertEquals(person, name);

        name = Optional.ofNullable(person).orElse(getClientName());
        assertEquals(person,name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenOrElseThrowWorks_thenCorrect() {
        Client clientNull = null;
        Optional.ofNullable(clientNull).orElseThrow(IllegalArgumentException::new);
    }

    @Test
    public void givenOptional_whenGetsValue_thenCorrect() {
        Client client = new Client();
        Optional<Client> client1 = Optional.of(client);
        Client client2 = client1.get();
        assertEquals(client,client2);
    }

    @Test(expected = NoSuchElementException.class)
    public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
        Client client = null;
        Optional<Client> client1 = Optional.ofNullable(client);
        Client client2 = client1.get();
    }

    @Test
    public void whenOptionalFilterWorks_thenCorrect() {
        Client client1 = new Client();
        client1.setName("Gyliarde");
        Optional<Client> client = Optional.of(client1);
        Boolean verifyName = client.filter( c -> c.getName().equals("Gyliarde")).isPresent();
        Assert.assertTrue(verifyName);
    }

    private Boolean isAdult(Client client) {
        Boolean isAdult = Boolean.FALSE;

        if (client != null) {
            if (client.getAge() != null) {
                if (client.getAge() >= 18) isAdult = Boolean.TRUE;
            }
        }

        return isAdult;
    }

    @Test
    public void whenFiltersWithoutOptional_thenCorrect() {
        assertTrue(isAdult(new Client(20)));
        assertFalse(isAdult(new Client(17)));
        assertFalse(isAdult(new Client(null)));
        assertFalse(isAdult(null));
    }

    private Boolean idAdultWithOptional(Client client) {
        return Optional.ofNullable(client)
                .map(Client::getAge)
                .filter(age -> age >= 18 )
                .isPresent();
    }

    @Test
    public void whenFiltersWithOptional_thenCorrect() {
        assertTrue(idAdultWithOptional(new Client(20)));
        assertFalse(idAdultWithOptional(new Client(17)));
        assertFalse(idAdultWithOptional(new Client(null)));
        assertFalse(idAdultWithOptional(null));
    }

    @Test
    public void givenOptional_whenMapWorks_thenCorrect() {
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        companyNames = null;
        Optional<List<String>> listOptional = Optional.ofNullable(companyNames);


        int size = listOptional
                .map(List::size)
                .orElse(0);
        assertEquals(0, size);
    }

    @Test
    public void givenOptional_whenMapWorks_thenCorrect2() {
        String name = "baeldung";
        Optional<String> nameOptional = Optional.of(name);

        int len = nameOptional
                .map(String::length)
                .orElse(0);
        assertEquals(8, len);
    }

    @Test
    public void givenOptional_whenMapWorksWithFilter_thenCorrect() {
        Client client = new Client();
        client.setName("John ");
        Boolean isJohn = Optional.of(client).map(Client::getName).filter(name -> name.equals("John")).isPresent();
        assertFalse(isJohn);
        isJohn = Optional.of(client).map(Client::getName).map(String::trim).filter(name -> name.equals("John")).isPresent();
        assertTrue(isJohn);
    }

    @Test
    public void givenOptional_whenFlatMapWorks_thenCorrect2() {
        Client client = new Client("Jonh",20,"jj");
        Optional<Client> client1 = Optional.of(client);

        final Optional<Optional<String>> shortName = client1.map(Client::getShortName);
        Optional<String> shortNameOptional = shortName.orElseThrow(IllegalArgumentException::new);
        String name1 = shortNameOptional.orElse("");

        assertEquals("jj",client1.map(Client::getShortName).map(Optional::get).orElse("tt"));
        assertEquals("jj", name1);

        String nameFlat = client1.flatMap(Client::getShortName).orElse("t");
        assertEquals("jj", nameFlat);
    }

    private Optional<String> getEmpty() {
        return Optional.empty();
    }

    private Optional<String> getHello() {
        return Optional.of("hello");
    }

    private Optional<String> getBye() {
        return Optional.of("bye");
    }

    @Test
    public void givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturned() {
        Optional<String> found = Stream.of(getEmpty(), getHello(), getBye())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();

        assertEquals(getHello(), found);
    }
}
