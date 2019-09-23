package com.techarha.java.collections.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomDoublyLinkedListTest {

    CustomList<Integer> integerDoublyList;

    @Before
    public void setUp() throws Exception {
        integerDoublyList = new CustomDoublyLinkedList<>();
        integerDoublyList.addToFront(8);
        integerDoublyList.addToFront(6);
        integerDoublyList.addToFront(4);
        integerDoublyList.addToFront(3);
    }

    @Test
    public void addToFront() {
        integerDoublyList.addToFront(23);
        assertEquals("23, 3, 4, 6, 8", integerDoublyList.toString());
    }

    @Test
    public void removeFromFront() {
        integerDoublyList.removeFromFront();
        assertEquals("4, 6, 8", integerDoublyList.toString());
    }

    @Test
    public void removeFromFront2() {
        integerDoublyList.removeFromFront();
        integerDoublyList.removeFromFront();
        integerDoublyList.removeFromFront();
        integerDoublyList.removeFromFront();
        assertEquals("", integerDoublyList.toString());
    }

    @Test
    public void isEmpty() {
        integerDoublyList = new CustomLinkedList<>();
        assertEquals(true, integerDoublyList.isEmpty());
    }

    @Test
    public void addToEnd() {
        integerDoublyList.addToEnd(44);
        assertEquals("3, 4, 6, 8, 44", integerDoublyList.toString());
    }

    @Test
    public void removeFromEnd() {
        integerDoublyList.removeFromEnd();
        assertEquals("3, 4, 6", integerDoublyList.toString());
    }

    @Test
    public void removeFromEnd2() {
        integerDoublyList.removeFromEnd();
        integerDoublyList.removeFromEnd();
        integerDoublyList.removeFromEnd();
        integerDoublyList.removeFromEnd();
        assertEquals("", integerDoublyList.toString());
    }

    @Test
    public void remove() {
        assertEquals(true, integerDoublyList.remove(4));
        assertEquals("3, 6, 8", integerDoublyList.toString());
    }


    @Test
    public void remove2() {
        assertEquals(true, integerDoublyList.remove(4));
        assertEquals(false, integerDoublyList.remove(11));
        assertEquals("3, 6, 8", integerDoublyList.toString());
    }

    @Test
    public void removeAt() {
        assertEquals(true, integerDoublyList.removeAt(2));
        assertEquals(false, integerDoublyList.removeAt(11));
        assertEquals("3, 4, 8", integerDoublyList.toString());
    }


    @Test
    public void removeAt2() {
        assertEquals(true, integerDoublyList.removeAt(3));
        assertEquals("3, 4, 6", integerDoublyList.toString());
    }


    @Test
    public void get() {
        assertEquals(new Integer(6), integerDoublyList.get(2));
        assertEquals(null, integerDoublyList.get(7));
    }


    @Test
    public void set() {
        assertEquals(true, integerDoublyList.set(0, 18));
        assertEquals("18, 3, 4, 6, 8", integerDoublyList.toString());
    }


    @Test
    public void set2() {
        assertEquals(true, integerDoublyList.set(2, 21));
        assertEquals("3, 4, 21, 6, 8", integerDoublyList.toString());
    }


    @Test
    public void set3() {
        assertEquals(true, integerDoublyList.set(4, 32));
        assertEquals("3, 4, 6, 8, 32", integerDoublyList.toString());
    }


    @Test
    public void size() {
        assertEquals(4, integerDoublyList.size());
    }



}
