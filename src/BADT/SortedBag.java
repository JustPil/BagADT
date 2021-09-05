package BADT;

import java.util.Random;

public class SortedBag implements BagInterface
{
    private int totalItems = 0;
    private final int CAPACITY = 50;
    private int[] array = new int[CAPACITY];
    private final Random random = new Random();
    private int foundPosition;
    private int insertPosition;
    private boolean finder;

    /**
     * binarySeach A binary search algorithm that finds the index of an element if contained in the array, or the
     * index that the element should be inserted if not present.
     * @param element The element to search in the array.
     */
    private void binarySearch(int element)
    {
        finder = false;
        int start = 0;
        int end = totalItems - 1;
        foundPosition = -1;
        while(!finder && start <= end)
        {
            int mid = (start + end) / 2;
            if(array[mid] == element)
            {
                finder = true;
                foundPosition = mid;
                return;
            }
            else if(array[mid] > element)
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        insertPosition = start;
    }

    /**
     * add Adds an element to the array in sorted order if the array is not full.
     * @param element The element to add into the array.
     * @return True if the item is added, false if not.
     */
    public boolean add(int element)
    {
        if(totalItems == 0)
        {
            array[0] = element;
        }
        else if(isFull())
        {
            return false;
        }
        else
        {
            binarySearch(element);
            int position = finder ? foundPosition : insertPosition;
            for(int i = totalItems - 1; i >= position; i--)
            {
                array[i + 1] = array[i];
            }
            array[position] = element;
        }
        totalItems++;
        return true;
    }
    /**
     * contains Searches the array for an element.
     * @param element The element to search for in the array.
     * @return True if the element is found, false otherwise.
     */
    public boolean contains(int element)
    {
        binarySearch(element);
        if(finder)
        {
            return true;
        }
        return false;
    }

    /**
     * remove Removes a specified element from the array.
     * @param element The element to remove.
     * @return True if the element is removed, false otherwise.
     */
    public boolean remove(int element)
    {
        binarySearch(element);
        if(!finder)
        {
            return false;
        }
        else
        {
            boolean removeOnce = false;
            int[] newArray = new int[CAPACITY];
            for(int i = 0; i < totalItems; i++)
            {
                if(array[i] == element && !removeOnce)
                {
                    removeOnce = true;
                }
                else if(!removeOnce)
                {
                    newArray[i] = array[i];
                }
                else
                {
                    newArray[i - 1] = array[i];
                }
            }
            array = newArray;
            totalItems--;
        }
        return true;
    }

    /**
     * isFull Determines if the array is full.
     * @return True if the array is full, false otherwise.
     */
    public boolean isFull()
    {
        return totalItems == CAPACITY;
    }

    /**
     * isEmpty Determines if the array is empty.
     * @return True if the array is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return totalItems == 0;
    }

    /**
     * size Determines the number of elements in the array.
     * @return The number of elements in the array.
     */
    public int size()
    {
        return totalItems;
    }

    /**
     * grab Grabs a random element from the array.
     * @return The randomly chosen element.
     */
    public int grab()
    {
        int pick = random.nextInt(totalItems);
        return array[pick];
    }

    /**
     * count Counts the total number of occurrences of a specified element in the array.
     * @param element The element to be counted.
     * @return The total number of occurrences of the element.
     */
    public int count(int element)
    {
        int counter = 0;
        int moveRight;
        int moveLeft;
        binarySearch(element);
        if(finder)
        {
            counter++;
            moveLeft = foundPosition - 1;
            moveRight = foundPosition + 1;
            while(moveLeft >= 0 && array[moveLeft] == element)
            {
                counter++;
                moveLeft--;
            }
            while(moveRight < totalItems && array[moveRight] == element)
            {
                counter++;
                moveRight++;
            }
        }
        return counter;
    }

    /**
     * removeAll Removes all occurrences of a specified element from the array.
     * @param element The element to remove.
     * @return The number of removed occurrences of the element.
     */
    public int removeAll(int element)
    {
        int num = count(element);
        if(finder)
        {
            int offset = 0;
            int[] newArray = new int[CAPACITY];
            for(int i = 0; i < totalItems; i++)
            {
                if(array[i] == element)
                {
                    i += num - 1;
                }
                else
                {
                    newArray[offset] = array[i];
                    offset++;
                }
            }
            array = newArray;
            totalItems -= num;
        }
        return num;
    }

    /**
     * clear Clears the array of all elements.
     */
    public void clear()
    {
        int[] newArray = new int[CAPACITY];
        array = newArray;
        totalItems = 0;
    }

    /**
     * toString Outputs contents of the array in a String.
     * @return A String containing the output of the array elements.
     */
    public String toString()
    {
        String str = "[";
        for(int i = 0; i < totalItems; i++)
        {
            str += array[i];
            str += i != totalItems - 1 ? " " : "";
        }
        return str + "]";
    }
}
