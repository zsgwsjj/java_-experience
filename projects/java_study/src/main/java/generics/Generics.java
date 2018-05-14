package generics;

public class Generics<T> {
    private T key;

    public Generics() {
    }

    public Generics(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public Generics<T> setKey(T key) {
        this.key = key;
        return this;
    }
}
