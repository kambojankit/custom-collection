package com.techarha.java.collections.tree.heap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomMaxHeapTest {

    CustomHeap<Integer> maxHeap;

    @Before
    public void setUp() throws Exception {
        maxHeap = new CustomMaxHeap(Integer.class);
        maxHeap.add(10);
        maxHeap.add(15);
        maxHeap.add(20);
        maxHeap.add(17);
        maxHeap.add(35);
        maxHeap.add(14);
        maxHeap.add(8);
        maxHeap.add(11);
        maxHeap.add(23);
    }

    @Test
    public void peek() {
        assertEquals(new Integer(35), maxHeap.peek());
    }

    @Test
    public void poll() {
        assertEquals(new Integer(35), maxHeap.peek());
        assertEquals(new Integer(35), maxHeap.poll());
        assertEquals(new Integer(23), maxHeap.peek());
    }

    @Test
    public void add() {
        assertEquals(new Integer(35), maxHeap.peek());
        assertEquals(new Integer(35), maxHeap.poll());
        assertEquals(new Integer(23), maxHeap.peek());
        maxHeap.add(40);
        assertEquals(new Integer(40), maxHeap.peek());
    }
}
