package com.techarha.java.collections.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomCircularArrayQueueTest {
    private CustomQueue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new CustomCircularArrayQueue<>(String.class);
        queue.enqueue("M");
    }

    @Test
    public void enqueue() {
        assertEquals("M", queue.peek());
        queue.enqueue("N");
        assertEquals("M", queue.peek());
        queue.dequeue();
        assertEquals("N", queue.peek());
    }

    @Test
    public void dequeue() {
        queue.enqueue("N");
        assertEquals("M", queue.dequeue());
        assertEquals("N", queue.dequeue());
    }

    @Test
    public void peek() {
        assertEquals("M", queue.peek());
    }

    @Test
    public void capacityResizeTest() {
        queue.enqueue("N");
        queue.enqueue("O");
        queue.enqueue("P");
        queue.enqueue("Q");
        queue.enqueue("R");
        queue.enqueue("S");
        queue.enqueue("T");
        queue.enqueue("U");
        queue.enqueue("V");
        queue.enqueue("W");

        assertEquals("M", queue.dequeue());
        assertEquals("N", queue.dequeue());
        assertEquals("O", queue.dequeue());
        assertEquals("P", queue.dequeue());
        assertEquals("Q", queue.dequeue());
        assertEquals("R", queue.dequeue());
        assertEquals("S", queue.dequeue());
        assertEquals("T", queue.dequeue());
        assertEquals("U", queue.dequeue());
        assertEquals("V", queue.dequeue());
        assertEquals("W", queue.dequeue());

    }

    @Test
    public void isEmpty() {
        assertEquals(false, queue.isEmpty());
        queue.dequeue();
        assertEquals(true, queue.isEmpty());
    }
}
