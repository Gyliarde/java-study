package gyliarde.generics.model;

/**
 * Generic version of the Car class.
 * @param <T> the type of the value being boxed
 */
public class AbstractFactory<T> {
    // T stands for "Type"
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    /**
     * Bounded type defined by extent class or interface
     */
    public <U extends Object & Pair> U inspect(U u) {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
        return u;
    }
}
