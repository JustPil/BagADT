package bagtests;

import bags.SortedLinkedBag;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class SortedLinkedBagTests {
    private final SortedLinkedBag<Integer> bag = new SortedLinkedBag<>();

    @Test
    public void addInitialElement() {
        bag.add(1);
        var result = bag.contains(1);
        Assertions.assertTrue(result);
    }

    @Test
    public void addMultipleElements() {
        for(int i = 0; i < 10; i++) {
            bag.add(i);
        }
        var result = bag.size();
        Assertions.assertEquals(10, result);
    }

    @Test
    public void findIfElementExists() {
        bag.add(1);
        var result = bag.contains(1);
        Assertions.assertTrue(result);
    }

    @Test
    public void findIfElementExistsInFullBag() {
        for(int i = 0; i < 50; i++) {
            bag.add(i);
        }
        var result = bag.contains(25);
        Assertions.assertTrue(result);
    }

    @Test
    public void findIfElementExistsInEmptyBag() {
        var result = bag.contains(1);
        Assertions.assertFalse(result);
    }

    @Test
    public void removeElement() {
        bag.add(1);
        var result = bag.remove(1);
        Assertions.assertTrue(result);
    }

    @Test
    public void removeElementEmptyBag() {
        var result = bag.remove(1);
        Assertions.assertFalse(result);
    }

    @Test
    public void removeElementInFullBag() {
        for(int i = 0; i < 50; i++) {
            bag.add(i);
        }
        var result = bag.remove(25);
        Assertions.assertTrue(result);
    }

    @Test
    public void emptyBagCheck() {
        bag.add(1);
        var result = bag.isEmpty();
        Assertions.assertFalse(result);
    }

    @Test
    public void countOccurrencesOfAnElement() {
        for(int i = 0; i < 10; i++) {
            if(i < 5) {
                bag.add(1);
            } else {
                bag.add(2);
            }
        }
        var result = bag.count(2);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void removeAllOfASpecificElement() {
        for(int i = 0; i < 10; i++) {
            if(i < 5) {
                bag.add(1);
            } else {
                bag.add(2);
            }
        }
        var result = bag.removeAll(2);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void clearAllElementsFromBag() {
        for(int i = 0; i < 5; i++) {
            bag.add(i);
        }
        bag.clear();
        var result = bag.size();
        Assertions.assertEquals(0, result);
    }

    @Test
    public void getAllElementsAsString() {
        bag.add(3);
        bag.add(1);
        bag.add(4);
        bag.add(5);
        bag.add(2);
        var result = bag.toString();
        Assertions.assertEquals("[5 4 3 2 1]", result);
    }
}
