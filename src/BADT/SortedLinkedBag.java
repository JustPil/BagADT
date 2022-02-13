package BADT;

import java.util.Comparator;
import java.util.Random;

public class SortedLinkedBag<T> implements BagInterface<T>
{
    private Node<T> head;
    private Node<T> parser;
    private int totalNodes = 0;
    private Random random = new Random();
    private Comparator<T> comp;

    /**
     * Constructor instantiates a Comparator object.
     */
    public SortedLinkedBag()
    {
        comp = new Comparator<T>()
        {
            public int compare(T o1, T o2)
            {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * add Adds an element to the linked list in sorted order.
     * @param element The data for the new node to hold.
     * @return True if the new node is successfully added, false otherwise.
     */
    public boolean add(T element)
    {
        Node<T> node = new Node<>(element);
        if(totalNodes == 0)
        {
            head = node;
        }
        else
        {
            parser = head;
            while(parser != null)
            {/*node.getData() <= head.getData()*/
                if(comp.compare(node.getData(), head.getData()) >= 0 && parser == head)
                {
                    node.setNext(head);
                    head = node;
                    break;
                }/*node.getData() >= parser.getData()*/
                else if(comp.compare(node.getData(), parser.getData()) <= 0 && parser.getNext() == null)
                {
                    parser.setNext(node);
                    break;
                }/*node.getData() > parser.getData() && node.getData() <= parser.getNext().getData()*/
                else if(comp.compare(node.getData(), parser.getData()) < 0 &&
                        comp.compare(node.getData(), parser.getNext().getData()) >= 0)
                {
                    Node<T> helper = parser.getNext();
                    parser.setNext(node);
                    node.setNext(helper);
                    break;
                }
                parser = parser.getNext();
            }
        }
        totalNodes++;
        return true;
    }

    /**
     * contains Searches the linked list for a Node containing the specified data.
     * @param element The data to search for.
     * @return True if a Node containing the data is found, false otherwise.
     */
    public boolean contains(T element)
    {
        parser = head;
        while(parser != null)
        {
            if(comp.compare(parser.getData(), element) == 0)
            {
                return true;
            }
            else
            {
                parser = parser.getNext();
            }
        }
        return false;
    }

    /**
     * remove Removes a Node from the linked list if holding the specified element.
     * @param element The data to search for.
     * @return True if the Node is found and removed, false otherwise.
     */
    public boolean remove(T element)
    {
        parser = head;
        while(parser.getNext() != null)
        {
            if(comp.compare(parser.getNext().getData(), element) == 0 && parser != head)
            {
                parser.setNext(parser.getNext().getNext());
                totalNodes--;
                return true;
            }
            else if(comp.compare(head.getData(), element) == 0)
            {
                head = head.getNext();
                totalNodes--;
                return true;
            }/*parser.getNext().getData() == element && head.getData() != element*/
            else if(parser == head && comp.compare(parser.getNext().getData(), element) == 0 &&
            comp.compare(head.getData(), element) != 0)
            {
                parser.setNext(parser.getNext().getNext());
                totalNodes--;
                return true;
            }
            parser = parser.getNext();
        }
        if(totalNodes == 1 && comp.compare(head.getData(), element) == 0)
        {
            head = null;
            totalNodes--;
            return true;
        }
        return false;
    }

    /**
     * isFull Determines if the linked list is full.
     * @return False, a linked list is never full.
     */
    public boolean isFull()
    {
        return false;
    }

    /**
     * isEmpty Determines if the linked list is empty.
     * @return True if the linked list is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return totalNodes == 0;
    }

    /**
     * size Determines the number of Nodes in the linked list.
     * @return The total Nodes contained in the linked list.
     */
    public int size()
    {
        return totalNodes;
    }

    /**
     * grab Grabs a random Node from the linked list.
     * @return The data contained in the randomly selected Node.
     */
    public T grab()
    {
        int pick = random.nextInt(totalNodes);
        int tracker = 0;
        parser = head;
        T grabbedItem = null;
        while(parser != null)
        {
            if(tracker == pick)
            {
                grabbedItem = parser.getData();
                break;
            }
            else
            {
                parser = parser.getNext();
                tracker++;
            }
        }
        return grabbedItem;
    }

    /**
     * count Counts the total number of occurrences of a specified element contained by Node(s) in the linked list.
     * @param element The data to search for.
     * @return The total number of occurrences of the element.
     */
    public int count(T element)
    {
        parser = head;
        int counter = 0;
        while(parser != null)
        {
            if(comp.compare(parser.getData(), element) == 0)
            {
                counter++;
            }
            parser = parser.getNext();
        }
        return counter;
    }

    /**
     * removeAll Removes all Nodes containing a specified element from the linked list.
     * @param element The data to search for.
     * @return The total number of Nodes removed.
     */
    public int removeAll(T element)
    {
        int count = 0;
        if(totalNodes == 0)
        {
            return count;
        }
        boolean control = false;
        parser = head;
        while(parser.getNext() != null)
        {
            if(comp.compare(parser.getNext().getData(), element) == 0 && parser != head)
            {
                parser.setNext(parser.getNext().getNext());
                totalNodes--;
                count++;
                control = true;
            }/*parser.getNext().getData() == element && head.getData() != element*/
            else if(parser == head && comp.compare(parser.getNext().getData(), element) == 0 &&
            comp.compare(head.getData(), element) != 0)
            {
                parser.setNext(parser.getNext().getNext());
                totalNodes--;
                count++;
                control = true;
            }
            else if(comp.compare(head.getData(), element) == 0)
            {
                head = head.getNext();
                totalNodes--;
                count++;
                control = true;
            }
            if(!control)
            {
                parser = parser.getNext();
            }
            control = false;
        }
        if(totalNodes == 1 && comp.compare(head.getData(), element) == 0)
        {
            head = null;
            totalNodes--;
            return ++count;
        }
        return count;
    }

    /**
     * clear Clears the linked list of all Nodes.
     */
    public void clear()
    {
        head = null;
        totalNodes = 0;
    }

    /**
     * toString Outputs the contents of the linked list to a String.
     * @return A String containing the sequential data held by the Nodes.
     */
    public String toString()
    {
        StringBuilder str = new StringBuilder("[");
        parser = head;
        while(parser != null)
        {
            if(parser.getNext() == null)
            {
                str.append(parser.getData());
            }
            else
            {
                str.append(parser.getData()).append(" ");
            }
            parser = parser.getNext();
        }
        return str.append("]").toString();
    }
}

