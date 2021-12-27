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
}
