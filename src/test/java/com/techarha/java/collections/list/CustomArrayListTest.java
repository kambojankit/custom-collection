package com.techarha.java.collections.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomArrayListTest {
    CustomList<Integer> integerList;

    @Before
    public void setUp() throws Exception {
        integerList = createDefaultEmplyList();
        integerList.insert(4);
        integerList.insert(6);
        integerList.insert(7);
        integerList.insert(9);
        integerList.insert(11);
    }

    @Test
    public void addToFront() {
        assertEquals(new Integer(4), integerList.get(0));
        integerList.addToFront(12);
        assertEquals(new Integer(12), integerList.get(0));
        assertEquals(6, integerList.size());
    }

    @Test
    public void removeFromFront() {
        assertEquals(new Integer(4), integerList.get(0));
        integerList.removeFromFront();
        assertEquals(new Integer(6), integerList.get(0));
        assertEquals(4, integerList.size());
    }

    @Test
    public void addToEnd() {
        assertEquals(new Integer(11), integerList.get(integerList.size() - 1));
        integerList.addToEnd(44);
        assertEquals(new Integer(44), integerList.get(integerList.size() - 1));
        assertEquals(6, integerList.size());
    }

    @Test
    public void removeFromEnd() {
        assertEquals(new Integer(11), integerList.get(integerList.size() - 1));
        integerList.removeFromEnd();
        assertEquals(new Integer(9), integerList.get(integerList.size() - 1));
        assertEquals(4, integerList.size());
    }

    @Test
    public void insert() {
        assertEquals(new Integer(7), integerList.get(2));
        assertEquals(5, integerList.size());
    }

    @Test
    public void remove() {
        integerList.remove(7);
        assertEquals(new Integer(9), integerList.get(2));
        assertEquals(4, integerList.size());
    }

    @Test
    public void removeAt() {
        integerList.removeAt(2);
        assertEquals(new Integer(9), integerList.get(2));
        assertEquals(4, integerList.size());
    }

    @Test
    public void get() {
        assertEquals(new Integer(9), integerList.get(3));
        assertEquals(5, integerList.size());
    }

    @Test
    public void set() {
        integerList.set(2, 17);
        assertEquals(new Integer(17), integerList.get(2));
        assertEquals(5, integerList.size());
    }

    @Test
    public void isEmpty() {
        assertEquals(false, integerList.isEmpty());

        integerList = createDefaultEmplyList();
        assertEquals(true, integerList.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(5, integerList.size());

        integerList = createDefaultEmplyList();
        assertEquals(0, integerList.size());
    }

    private CustomList<Integer> createDefaultEmplyList() {
        return new CustomArrayList(Integer.class);
    }
}
