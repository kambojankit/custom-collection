package com.techarha.java.collections.tree.heap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomMinHeapTest {

    CustomHeap<Integer> minHeap;

    @Before
    public void setUp() throws Exception {
        minHeap = new CustomMinHeap(Integer.class);
        minHeap.add(10);
        minHeap.add(15);
        minHeap.add(20);
        minHeap.add(17);
        minHeap.add(14);
        minHeap.add(8);
        minHeap.add(11);
        minHeap.add(23);
    }

    @Test
    public void peek() {
        assertEquals(new Integer(8), minHeap.peek());
    }

    @Test
    public void poll() {
        assertEquals(new Integer(8), minHeap.peek());
        assertEquals(new Integer(8), minHeap.poll());
        assertEquals(new Integer(10), minHeap.peek());
    }

    @Test
    public void add() {
        assertEquals(new Integer(8), minHeap.peek());
        assertEquals(new Integer(8), minHeap.poll());
        minHeap.add(5);
        assertEquals(new Integer(5), minHeap.peek());
    }
}
