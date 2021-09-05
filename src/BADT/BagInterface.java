package BADT;

public interface BagInterface
{
    boolean add(int element);
    boolean contains(int element);
    boolean remove(int element);
    boolean isFull();
    boolean isEmpty();
    int size();
    int grab();
    int count(int element);
    int removeAll(int element);
    void clear();
    String toString();
}
