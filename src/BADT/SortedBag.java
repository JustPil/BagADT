package BADT;

import java.util.Comparator;
import java.util.Random;

public class SortedBag<T> implements BagInterface<T> {
    private int totalItems = 0;
    private final int CAPACITY = 50;
    private T[] array = (T[])new Object[CAPACITY];
    private Random random = new Random();
    private int foundPosition;
    private int insertPosition;
    private boolean finder;
    private Comparator<T> comp;

    /**
     * Constructor instantiates a Comparator object.
     */
    public SortedBag() {
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2)
            {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * binarySeach A binary search algorithm that finds the index of an element if contained in the Bag's internal 
     * array, or the index that the element should be inserted if not present.
     * @param element The element to search in the array.
     */
    private void binarySearch(T element) {
        finder = false;
        int start = 0;
        int end = totalItems - 1;
        foundPosition = -1;
        while(!finder && start <= end) {
            int mid = start + (end - start) / 2;
            if(comp.compare(array[mid], element) == 0) {
                finder = true;
                foundPosition = mid;
                return;
            } else if(comp.compare(array[mid], element) < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        insertPosition = start;
    }

    /**
     * add Adds an element to the Bag's internal array in sorted order if the array is not full.
     * @param element The element to add into the Bag's array.
     * @return True if the element is added, false if not.
     */
    public boolean add(T element) {
        if(totalItems == 0) {
            array[0] = element;
        } else if(isFull()) {
            return false;
        } else {
            binarySearch(element);
            int position = finder ? foundPosition : insertPosition;
            for(int i = totalItems - 1; i >= position; i--) {
                array[i + 1] = array[i];
            }
            array[position] = element;
        }
        totalItems++;
        return true;
    }
    /**
     * contains Searches the Bag's internal array for an element.
     * @param element The element to search for in the Bag's internal array.
     * @return True if the element is found, false otherwise.
     */
    public boolean contains(T element) {
        binarySearch(element);
        return finder;
    }

    /**
     * remove Removes a specified element from the Bag's internal array.
     * @param element The element to remove.
     * @return True if the element is removed, false otherwise.
     */
    public boolean remove(T element) {
        binarySearch(element);
        if(!finder) {
            return false;
        } else {
            boolean removeOnce = false;
            T[] newArray = (T[])new Object[CAPACITY];
            for(int i = 0; i < totalItems; i++) {
                if(array[i] == element && !removeOnce) {
                    removeOnce = true;
                } else if(!removeOnce) {
                    newArray[i] = array[i];
                } else {
                    newArray[i - 1] = array[i];
                }
            }
            array = newArray;
            totalItems--;
        }
        return true;
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
        return totalItems == 0 ? null : array[random.nextInt(totalItems)];
    }

    /**
     * count Counts the total number of occurrences of a specified element in the Bag's internal array.
     * @param element The element to be counted.
     * @return The total number of occurrences of the element.
     */
    public int count(T element) {
        int counter = 0;
        int moveRight;
        int moveLeft;
        binarySearch(element);
        if(finder) {
            counter++;
            moveLeft = foundPosition - 1;
            moveRight = foundPosition + 1;
            while(moveLeft >= 0 && comp.compare(array[moveLeft], element) == 0) {
                counter++;
                moveLeft--;
            }
            while(moveRight < totalItems && comp.compare(array[moveRight], element) == 0) {
                counter++;
                moveRight++;
            }
        }
        return counter;
    }

    /**
     * removeAll Removes all occurrences of a specified element from the Bag's internal array.
     * @param element The element to remove.
     * @return The number of removed occurrences of the element.
     */
    public int removeAll(T element) {
        int num = count(element);
        if(finder) {
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
     * clear Clears the Bag's internal array of all elements.
     */
    public void clear() {
        T[] newArray = (T[])new Object[CAPACITY];
        array = newArray;
        totalItems = 0;
    }

    /**
     * toString Outputs contents of the Bag in a String.
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
