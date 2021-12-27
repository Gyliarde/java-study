package gyliarde.generics.model;

public class House extends Building {

    public House(String color) {
        this.color = color;
    }

    private String color;

    @Override
    public void paint() {
        System.out.println("My house is " + color);
    }
}
