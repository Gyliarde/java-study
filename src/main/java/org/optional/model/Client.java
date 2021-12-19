package org.optional.model;

import java.util.Optional;

public class Client {
    private String name;
    private Integer age;
    private String shortName;

    public Client() {
    }

    public Client(String name, Integer age, String shortName) {
        this.name = name;
        this.age = age;
        this.shortName = shortName;
    }

    public Client(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Client(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Optional<String> getShortName() {
        return  Optional.ofNullable(shortName);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
