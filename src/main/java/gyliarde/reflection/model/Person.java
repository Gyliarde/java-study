package gyliarde.reflection.model;

public class Person {
    private long id;
    private String name;
    private String lastName;
    public int age;

    public Person() {
    }

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }

    public Person(long id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
