package com.techarha.java.collections.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomStackQueueTest {
    private CustomQueue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new CustomStackQueue<>();
        queue.enqueue("X");
        queue.enqueue("Y");
    }

    @Test
    public void enqueue() {
        assertEquals("X", queue.peek());
        queue.enqueue("Z");
        assertEquals("X", queue.peek());
        queue.dequeue();
        queue.dequeue();
        assertEquals("Z", queue.peek());
    }

    @Test
    public void dequeue() {
        queue.enqueue("Z");
        assertEquals("X", queue.dequeue());
        assertEquals("Y", queue.dequeue());
        assertEquals("Z", queue.dequeue());
    }

    @Test
    public void peek() {
        assertEquals("X", queue.peek());
    }

    @Test
    public void isEmpty() {
        assertEquals(false, queue.isEmpty());
        queue.dequeue();
        queue.dequeue();
        assertEquals(true, queue.isEmpty());
    }
}
