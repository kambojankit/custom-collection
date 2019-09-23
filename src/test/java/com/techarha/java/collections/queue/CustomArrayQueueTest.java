package com.techarha.java.collections.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomArrayQueueTest {

    private CustomQueue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new CustomArrayQueue(String.class);
        queue.enqueue("A");
    }

    @Test
    public void enqueue() {
        assertEquals("A", queue.peek());
        queue.enqueue("B");
        assertEquals("A", queue.peek());
        queue.dequeue();
        assertEquals("B", queue.peek());
    }

    @Test
    public void dequeue() {
        queue.enqueue("B");
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
    }

    @Test
    public void peek() {
        assertEquals("A", queue.peek());
    }

    @Test
    public void isEmpty() {
        assertEquals(false, queue.isEmpty());
        queue.dequeue();
        assertEquals(true, queue.isEmpty());
    }
}
