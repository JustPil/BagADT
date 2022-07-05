package bags;

import nodes.Node;

import java.util.Comparator;
import java.util.Random;

public class SortedLinkedBag<T> implements BagInterface<T> {
    private Node<T> head;
    private Node<T> parser;
    private int totalNodes = 0;
    private Random random = new Random();
    private Comparator<T> comp;

    /**
     * Constructor instantiates a Comparator object.
     */
    public SortedLinkedBag() {
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2)
            {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * add Adds an element to the Bag's internal linked list in sorted order.
     * @param element The data for the new node to hold.
     * @return True if the new node is successfully added, false otherwise.
     */
    public boolean add(T element) {
        Node<T> node = new Node<>(element);
        if(totalNodes == 0) {
            head = node;
        } else {
            parser = head;
            while(parser != null) {
                if(comp.compare(node.getData(), head.getData()) >= 0 && parser == head) {
                    node.setNext(head);
                    head = node;
                    break;
                } else if(comp.compare(node.getData(), parser.getData()) <= 0 && parser.getNext() == null) {
                    parser.setNext(node);
                    break;
                } else if(comp.compare(node.getData(), parser.getData()) < 0 &&
                        comp.compare(node.getData(), parser.getNext().getData()) >= 0) {
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
     * contains Searches the Bag's internal linked list for a Node containing the specified data.
     * @param element The data to search.
     * @return True if a Node containing the data is found, false otherwise.
     */
    public boolean contains(T element) {
        parser = head;
        while(parser != null) {
            if(comp.compare(parser.getData(), element) == 0) {
                return true;
            } else {
                parser = parser.getNext();
            }
        }
        return false;
    }

    /**
     * remove Removes a Node from the Bag's internal linked list.
     * @param element The data to search for.
     * @return True if the Node is found and removed, false otherwise.
     */
    public boolean remove(T element) {
        if(totalNodes == 0) {
            return false;
        }
        parser = head;
        while(parser.getNext() != null) {
            if(comp.compare(parser.getNext().getData(), element) == 0 && parser != head) {
                parser.setNext(parser.getNext().getNext());
                totalNodes--;
                return true;
            } else if(comp.compare(head.getData(), element) == 0) {
                head = head.getNext();
                totalNodes--;
                return true;
            } else if(parser == head && comp.compare(parser.getNext().getData(), element) == 0 &&
                    comp.compare(head.getData(), element) != 0) {
                parser.setNext(parser.getNext().getNext());
                totalNodes--;
                return true;
            }
            parser = parser.getNext();
        }
        if(totalNodes == 1 && comp.compare(head.getData(), element) == 0) {
            head = null;
            totalNodes--;
            return true;
        }
        return false;
    }

    /**
     * isFull Determines if the Bag is full.
     * @return False, a Bag implemented with a linked list is never full.
     */
    public boolean isFull() {
        return false;
    }

    /**
     * isEmpty Determines if the Bag is empty.
     * @return True if the Bag's internal linked list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return totalNodes == 0;
    }

    /**
     * size Determines the number of elements in the Bag.
     * @return The total elements in the Bag.
     */
    public int size() {
        return totalNodes;
    }

    /**
     * grab Grabs a pseudorandom element from the Bag.
     * @return A randomly selected element.
     */
    public T grab() {
        int pick = random.nextInt(totalNodes);
        int tracker = 0;
        parser = head;
        T grabbedItem = null;
        while(parser != null) {
            if(tracker == pick) {
                grabbedItem = parser.getData();
                break;
            } else {
                parser = parser.getNext();
                tracker++;
            }
        }
        return grabbedItem;
    }

    /**
     * count Counts the total number of occurrences of a specified element contained by Node(s) in the Bag's
     * internal linked list.
     * @param element The data to search for.
     * @return The total number of occurrences of the element.
     */
    public int count(T element) {
        parser = head;
        int counter = 0;
        while(parser != null) {
            if(comp.compare(parser.getData(), element) == 0) {
                counter++;
            }
            parser = parser.getNext();
        }
        return counter;
    }

    /**
     * removeAll Removes all occurrences of an element from the Bag.
     * @param element The data to search for.
     * @return The total number of elements removed.
     */
    public int removeAll(T element) {
        int count = 0;
        if(totalNodes == 0) {
            return count;
        }
        boolean control = false;
        parser = head;
        while(parser.getNext() != null) {
            if(comp.compare(parser.getNext().getData(), element) == 0 && parser != head) {
                parser.setNext(parser.getNext().getNext());
                totalNodes--;
                count++;
                control = true;
            } else if(parser == head && comp.compare(parser.getNext().getData(), element) == 0) {
                parser.setNext(parser.getNext().getNext());
                totalNodes--;
                count++;
                control = true;
            } else if(comp.compare(head.getData(), element) == 0) {
                head = head.getNext();
                totalNodes--;
                count++;
                control = true;
            }
            if(!control) {
                parser = parser.getNext();
            }
            control = false;
        }
        if(totalNodes == 1 && comp.compare(head.getData(), element) == 0) {
            head = null;
            totalNodes--;
            return ++count;
        }
        return count;
    }

    /**
     * clear Clears the Bag of all elements.
     */
    public void clear() {
        head = null;
        totalNodes = 0;
    }

    /**
     * toString Outputs the contents of the Bag to a String.
     * @return A String containing the elements of the Bag.
     */
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        parser = head;
        while(parser != null) {
            if(parser.getNext() == null) {
                str.append(parser.getData());
            } else {
                str.append(parser.getData()).append(" ");
            }
            parser = parser.getNext();
        }
        return str.append("]").toString();
    }
}
