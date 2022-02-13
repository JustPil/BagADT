package BADT;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        String choice = "";
        Scanner scn = new Scanner(System.in);
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("Bag ADT Implementations\n1 - Sorted Bag (Array)\n2 - Sorted Bag (Linked List)" +
                    "\n3 - Unsorted Bag (Array)\nX - Terminate\nEnter choice: ");
            choice = scn.nextLine();
            if(choice.equals("1"))
            {
                sortedBag(scn);
            }
            else if(choice.equals("2"))
            {
                sortedLinkedBag(scn);
            }
            else if(choice.equals("3"))
            {
                unsortedBag(scn);
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
        scn.close();
    }

    /**
     * sortedBag A Test Driver for the Bag ADT implemented with a sorted Array.
     * @param s A Scanner object to relay user input.
     */
    public static void sortedBag(Scanner s)
    {
        SortedBag<Integer> bag = new SortedBag<>();
        String choice = "";
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("\nMethods for Sorted Bag (Array Implementation)\n1 - ADD - Adds an element to the bag" +
                    "\n2 - CONTAINS - Checks if an element is contained in the bag\n3 - REMOVE - Removes one " +
                    "occurrence of an element from the bag\n4 - IS FULL - Checks if the bag is full\n5 - IS EMPTY " +
                    "Checks if the bag is empty\n6 - SIZE - Reports the number of elements in the bag\n7 - GRAB - Grabs" +
                    " a random element from the bag\n8 - COUNT - Counts the total number of occurrences of a specific" +
                    " element contained in the bag\n9 - REMOVE ALL - Removes all occurrences of an element from the " +
                    "bag\n10 - CLEAR - Empties the bag\n11 - TO STRING - Lists all elements contained in the bag " +
                    "sequentially\nX - Terminate\n\nEnter choice: ");
            choice = s.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter an integer to add to the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Added: " + bag.add(input));
            }
            else if(choice.equals("2"))
            {
                System.out.print("Enter an integer to check if the element is contained in the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Contains: " + bag.contains(input));
            }
            else if(choice.equals("3"))
            {
                System.out.print("Enter an integer to remove from the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Removed: " + bag.remove(input));
            }
            else if(choice.equals("4"))
            {
                System.out.println("Full bag: " + bag.isFull());
            }
            else if(choice.equals("5"))
            {
                System.out.println("Empty bag: " + bag.isEmpty());
            }
            else if(choice.equals("6"))
            {
                System.out.println("Size: " + bag.size());
            }
            else if(choice.equals("7"))
            {
                System.out.println("Grab random integer from the bag: " + bag.grab());
            }
            else if(choice.equals("8"))
            {
                System.out.print("Enter an integer to count all occurrences in the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Count: " + bag.count(input));
            }
            else if(choice.equals("9"))
            {
                System.out.print("Enter an integer to remove all occurrences from the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Removed: " + bag.removeAll(input));
            }
            else if(choice.equals("10"))
            {
                bag.clear();
                System.out.println("Cleared");
            }
            else if(choice.equals("11"))
            {
                System.out.println(bag.toString());
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * unsortedBag A Test Driver for the Bag ADT implemented with an unsorted Array.
     * @param s A Scanner object to relay user input.
     */
    public static void unsortedBag(Scanner s)
    {
        UnsortedBag<Integer> bag = new UnsortedBag<>();
        String choice = "";
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("\nMethods for Unsorted Bag (Array Implementation)\n1 - ADD - Adds an element to" +
                    " the bag\n2 - CONTAINS - Checks if an element is contained in the bag\n3 - REMOVE - Removes one" +
                    " occurrence of an element from the bag\n4 - IS FULL - Checks if the bag is full\n5 - IS EMPTY - " +
                    "Checks if the bag is empty\n6 - SIZE - Reports the number of elements in the bag\n7 - GRAB - " +
                    "Grabs a random element from the bag\n8 - COUNT - Counts the total number of occurrences of a " +
                    "specific element contained in the bag\n9 - REMOVE ALL - Removes all occurrences of an element" +
                    " from the bag\n10 - CLEAR - Empties the bag\n11 - TO STRING - Lists all elements contained in " +
                    "the bag sequentially\nX - Terminate\n\nEnter choice: ");
            choice = s.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter an integer to add to the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Added: " + bag.add(input));
            }
            else if(choice.equals("2"))
            {
                System.out.print("Enter an integer to check if the element is contained in the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Contains: " + bag.contains(input));
            }
            else if(choice.equals("3"))
            {
                System.out.print("Enter an integer to remove from the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Removed: " + bag.remove(input));
            }
            else if(choice.equals("4"))
            {
                System.out.println("Full bag: " + bag.isFull());
            }
            else if(choice.equals("5"))
            {
                System.out.println("Empty bag: " + bag.isEmpty());
            }
            else if(choice.equals("6"))
            {
                System.out.println("Size: " + bag.size());
            }
            else if(choice.equals("7"))
            {
                System.out.println("Grab random integer from the bag: " + bag.grab());
            }
            else if(choice.equals("8"))
            {
                System.out.print("Enter an integer to count all occurrences in the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Count: " + bag.count(input));
            }
            else if(choice.equals("9"))
            {
                System.out.print("Enter an integer to remove all occurrences from the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Removed: " + bag.removeAll(input));
            }
            else if(choice.equals("10"))
            {
                bag.clear();
                System.out.println("Cleared");
            }
            else if(choice.equals("11"))
            {
                System.out.println(bag.toString());
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * sortedLinkedBag A Test Driver for the Bag ADT implemented with a sorted Linked List.
     * @param s A Scanner object to relay user input.
     */
    public static void sortedLinkedBag(Scanner s)
    {
        SortedLinkedBag<Integer> bag = new SortedLinkedBag<>();
        String choice = "";
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("\nMethods for Sorted Bag (Linked List Implementation)\n1 - ADD - Adds an element to" +
                    " the bag\n2 - CONTAINS - Checks if an element is contained in the bag\n3 - REMOVE - Removes one" +
                    " occurrence of an element from the bag\n4 - IS FULL - Checks if the bag is full\n5 - IS EMPTY - " +
                    "Checks if the bag is empty\n6 - SIZE - Reports the number of elements in the bag\n7 - GRAB - " +
                    "Grabs a random element from the bag\n8 - COUNT - Counts the total number of occurrences of a " +
                    "specific element contained in the bag\n9 - REMOVE ALL - Removes all occurrences of an element" +
                    " from the bag\n10 - CLEAR - Empties the bag\n11 - TO STRING - Lists all elements contained in " +
                    "the bag sequentially\nX - Terminate\n\nEnter choice: ");
            choice = s.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter an integer to add to the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Added: " + bag.add(input));
            }
            else if(choice.equals("2"))
            {
                System.out.print("Enter an integer to check if the element is contained in the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Contains: " + bag.contains(input));
            }
            else if(choice.equals("3"))
            {
                System.out.print("Enter an integer to remove from the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Removed: " + bag.remove(input));
            }
            else if(choice.equals("4"))
            {
                System.out.println("Full bag: " + bag.isFull());
            }
            else if(choice.equals("5"))
            {
                System.out.println("Empty bag: " + bag.isEmpty());
            }
            else if(choice.equals("6"))
            {
                System.out.println("Size: " + bag.size());
            }
            else if(choice.equals("7"))
            {
                System.out.println("Grab random integer from the bag: " + bag.grab());
            }
            else if(choice.equals("8"))
            {
                System.out.print("Enter an integer to count all occurrences in the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Count: " + bag.count(input));
            }
            else if(choice.equals("9"))
            {
                System.out.print("Enter an integer to remove all occurrences from the bag: ");
                int input = s.nextInt();
                s.nextLine();
                System.out.println("Removed: " + bag.removeAll(input));
            }
            else if(choice.equals("10"))
            {
                bag.clear();
                System.out.println("Cleared");
            }
            else if(choice.equals("11"))
            {
                System.out.println(bag.toString());
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }
}
