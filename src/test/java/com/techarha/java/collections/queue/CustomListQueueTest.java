package com.techarha.java.collections.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomListQueueTest {

    private CustomQueue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new CustomListQueue<>();
        queue.enqueue("X");
    }

    @Test
    public void enqueue() {
        assertEquals("X", queue.peek());
        queue.enqueue("Y");
        assertEquals("X", queue.peek());
        queue.dequeue();
        assertEquals("Y", queue.peek());
    }

    @Test
    public void dequeue() {
        queue.enqueue("Y");
        assertEquals("X", queue.dequeue());
        assertEquals("Y", queue.dequeue());
    }

    @Test
    public void peek() {
        assertEquals("X", queue.peek());
    }

    @Test
    public void isEmpty() {
        assertEquals(false, queue.isEmpty());
        queue.dequeue();
        assertEquals(true, queue.isEmpty());
    }
}
