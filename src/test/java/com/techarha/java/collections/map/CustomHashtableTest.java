package com.techarha.java.collections.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomHashtableTest {

    private CustomMap<String, Integer> map;

    @Before
    public void setUp() throws Exception {
        map = new CustomHashtable<>();
        map.put("A", 5);
        map.put("B", 6);
        map.put("C", 2);
        map.put("D", 4);
    }

    @Test
    public void put() {
        map.put("A", 5);
        assertEquals(new Integer(5), map.get("A"));
    }

    @Test
    public void get() {
        assertEquals(new Integer(2), map.get("C"));
        assertEquals(new Integer(6), map.get("B"));
    }

    @Test
    public void containsKey() {
        assertEquals(true, map.containsKey("A"));
        assertEquals(false, map.containsKey("F"));
    }

    @Test
    public void entrySet() {
        assertEquals(4, map.entrySet().size());
        map.put("G", 10);
        assertEquals(5, map.entrySet().size());
    }

    @Test
    public void keySet() {
        assertEquals(false, map.keySet().contains("G"));
        map.put("G", 3);
        assertEquals(true, map.keySet().contains("G"));
    }

    @Test
    public void isEmpty() {
        assertEquals(false, map.isEmpty());
        map.remove("A");
        map.remove("B");
        map.remove("C");
        map.remove("D");
        assertEquals(true, map.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(4, map.size());
        map.put("G", 3);
        assertEquals(5, map.size());
    }

    @Test
    public void values() {
        assertEquals(false, map.values().contains(3));
        map.put("G", 3);
        assertEquals(true, map.values().contains(3));
    }

    @Test
    public void remove() {
        assertEquals(true, map.containsKey("C"));
        map.remove("C");
        assertEquals(false, map.containsKey("C"));
    }
}
