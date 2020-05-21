package generics;

public class BoundedGenericClass<T extends Comparable<T>> {
    private final T object;

    BoundedGenericClass(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
