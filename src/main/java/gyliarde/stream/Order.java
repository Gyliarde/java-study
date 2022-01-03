package gyliarde.stream;

public class Order  implements Comparable<Order> {
    private TypeOrder type;
    private double value;
    private int id;

    public Order (TypeOrder type, double value, int id ) {
        this.type = type;
        this.value = value;
        this.id = id;
    }

    public TypeOrder getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Order o) {
        return (int) ( o.getValue() - this.getValue());
    }
}
