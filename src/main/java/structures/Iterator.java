package structures;

public interface Iterator<T> {
    boolean hasNext();
    Node<T> next();
}
