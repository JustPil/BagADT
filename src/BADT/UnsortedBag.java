package BADT;

import java.util.Comparator;
import java.util.Random;

public class UnsortedBag<T> implements BagInterface<T> {
    private int totalItems = 0;
    private final int CAPACITY = 50;
    private T[] array = (T[])new Object[CAPACITY];
    private Random random = new Random();
    private Comparator<T> comp;

    /**
     * Constructor instantiates a Comparator object.
     */
    public UnsortedBag() {
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2)
            {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * add Adds an element to the Bag's internal array if the array is not full.
     * @param element The element to add into the Bag's internal array.
     * @return True if the element is added, false if not.
     */
    public boolean add(T element) {
        if(isFull()) {
            return false;
        }
        array[totalItems++] = element;
        return true;
    }

    /**
     * contains Searches the Bag's internal array for an element.
     * @param element The element to search for in the Bag's internal array.
     * @return True if the element is found, false otherwise.
     */
    public boolean contains(T element) {
        for(int i = 0; i < totalItems; i++) {
            if(comp.compare(array[i], element) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * remove Removes a specified element from the Bag's internal array.
     * @param element The element to remove.
     * @return True if the element is removed, false otherwise.
     */
    public boolean remove(T element) {
        for(int i = 0; i < totalItems; i++) {
            if(comp.compare(array[i], element) == 0) {
                array[i] = array[totalItems - 1];
                array[totalItems-- - 1] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * isFull Determines if the Bag is full.
     * @return True if the Bag is full, false otherwise.
     */
    public boolean isFull() {
        return totalItems == CAPACITY;
    }

    /**
     * isEmpty Determines if the Bag is empty.
     * @return True if the Bag is empty, false otherwise.
     */
    public boolean isEmpty() {
        return totalItems == 0;
    }

    /**
     * size Determines the number of elements in the Bag.
     * @return The number of elements in the Bag.
     */
    public int size() {
        return totalItems;
    }

    /**
     * grab Grabs a pseudorandom element from the Bag.
     * @return The randomly chosen element.
     */
    public T grab() {
        return array[random.nextInt(totalItems)];
    }

    /**
     * count Counts the total number of occurrences of a specified element in the Bag's internal array.
     * @param element The element to be counted.
     * @return The total number of occurrences of the element.
     */
    public int count(T element) {
        int count = 0;
        for(int i = 0; i < totalItems; i++) {
            if(comp.compare(array[i], element) == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * removeAll Removes all occurrences of a specified element from the Bag's internal array.
     * @param element The element to remove.
     * @return The number of removed occurrences of the element.
     */
    public int removeAll(T element) {
        int num = count(element);
        if(num >= 1) {
            int offset = 0;
            T[] newArray = (T[])new Object[CAPACITY];
            for(int i = 0; i < totalItems; i++) {
                if(comp.compare(array[i], element) == 0) {
                    i += num - 1;
                } else {
                    newArray[offset++] = array[i];
                }
            }
            array = newArray;
            totalItems -= num;
        }
        return num;
    }

    /**
     * clear Clears the Bag of all elements by referencing a newly created internal array.
     */
    public void clear() {
        T[] newArray = (T[])new Object[CAPACITY];
        array = newArray;
        totalItems = 0;
    }

    /**
     * toString Outputs contents of the Bag's internal array in a String.
     * @return A String containing the output of the Bag's elements.
     */
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for(int i = 0; i < totalItems; i++) {
            str.append(array[i]);
            str.append(i != totalItems - 1 ? " " : "");
        }
        return str.append("]").toString();
    }
}
