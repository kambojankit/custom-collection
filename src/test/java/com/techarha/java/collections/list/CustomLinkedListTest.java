package com.techarha.java.collections.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    CustomList<Integer> integerList;

    @Before
    public void setUp() throws Exception {
        integerList = new CustomLinkedList<>();
        integerList.addToFront(8);
        integerList.addToFront(6);
        integerList.addToFront(4);
        integerList.addToFront(3);
    }

    @Test
    public void addToFront() {
        integerList.addToFront(23);
        assertEquals("23, 3, 4, 6, 8", integerList.toString());
    }

    @Test
    public void removeFromFront() {
        integerList.removeFromFront();
        assertEquals("4, 6, 8", integerList.toString());
    }

    @Test
    public void removeFromFront2() {
        integerList.removeFromFront();
        integerList.removeFromFront();
        integerList.removeFromFront();
        integerList.removeFromFront();
        assertEquals("", integerList.toString());
    }

    @Test
    public void isEmpty() {
        integerList = new CustomLinkedList<>();
        assertEquals(true, integerList.isEmpty());
    }

    @Test
    public void addToEnd() {
        integerList.addToEnd(44);
        assertEquals("3, 4, 6, 8, 44", integerList.toString());
    }

    @Test
    public void removeFromEnd() {
        integerList.removeFromEnd();
        assertEquals("3, 4, 6", integerList.toString());
    }

    @Test
    public void removeFromEnd2() {
        integerList.removeFromEnd();
        integerList.removeFromEnd();
        integerList.removeFromEnd();
        integerList.removeFromEnd();
        assertEquals("", integerList.toString());
    }

    @Test
    public void remove() {
        assertEquals(true, integerList.remove(4));
        assertEquals("3, 6, 8", integerList.toString());
    }


    @Test
    public void remove2() {
        assertEquals(true, integerList.remove(4));
        assertEquals(false, integerList.remove(11));
        assertEquals("3, 6, 8", integerList.toString());
    }

    @Test
    public void removeAt() {
        assertEquals(true, integerList.removeAt(2));
        assertEquals(false, integerList.removeAt(11));
        assertEquals("3, 4, 8", integerList.toString());
    }


    @Test
    public void removeAt2() {
        assertEquals(true, integerList.removeAt(3));
        assertEquals("3, 4, 6", integerList.toString());
    }


    @Test
    public void get() {
        assertEquals(new Integer(6), integerList.get(2));
        assertEquals(null, integerList.get(7));
    }


    @Test
    public void set() {
        assertEquals(true, integerList.set(0, 18));
        assertEquals("18, 3, 4, 6, 8", integerList.toString());
    }


    @Test
    public void set2() {
        assertEquals(true, integerList.set(2, 21));
        assertEquals("3, 4, 21, 6, 8", integerList.toString());
    }


    @Test
    public void set3() {
        assertEquals(true, integerList.set(4, 32));
        assertEquals("3, 4, 6, 8, 32", integerList.toString());
    }


    @Test
    public void size() {
        assertEquals(4, integerList.size());
    }

    @Test
    public void printListIterative() {
        assertEquals("3 -> 4 -> 6 -> 8", ((CustomLinkedList)integerList).printListIterative());
    }

    @Test
    public void printListRecursive() {
        assertEquals("3, 4, 6, 8, ", ((CustomLinkedList)integerList).printListRecursive());
    }

    @Test
    public void reverseListIterative() {
        ((CustomLinkedList)integerList).reverseList(false);
        assertEquals("8 -> 6 -> 4 -> 3", ((CustomLinkedList)integerList).printListIterative());
        ((CustomLinkedList)integerList).reverseList(false);
        assertEquals("3 -> 4 -> 6 -> 8", ((CustomLinkedList)integerList).printListIterative());
    }

    @Test
    public void reverseListRecursive() {
        ((CustomLinkedList)integerList).reverseList(true);
        assertEquals("8 -> 6 -> 4 -> 3", ((CustomLinkedList)integerList).printListIterative());
        ((CustomLinkedList)integerList).reverseList(true);
        assertEquals("3 -> 4 -> 6 -> 8", ((CustomLinkedList)integerList).printListIterative());
    }


}
