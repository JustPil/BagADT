package BADT;

public interface BagInterface<T>
{
    boolean add(T element);
    boolean contains(T element);
    boolean remove(T element);
    boolean isFull();
    boolean isEmpty();
    int size();
    T grab();
    int count(T element);
    int removeAll(T element);
    void clear();
    String toString();
}
