package com.techarha.java.collections.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomListStackTest {

    CustomStack<String> customStack;

    @Before
    public void setUp() throws Exception {
        customStack = new CustomListStack<>();

        customStack.push("A");
        customStack.push("B");
        customStack.push("C");
        customStack.push("D");
    }

    @Test
    public void push() {
        assertEquals("D", customStack.peek());
        customStack.push("F");
        assertEquals("F", customStack.peek());
    }

    @Test
    public void pop() {
        assertEquals("D", customStack.peek());
        customStack.push("F");
        assertEquals("F", customStack.pop());
        assertEquals("D", customStack.peek());
    }

    @Test
    public void isEmpty() {
        customStack = new CustomListStack<>();
        customStack.push("A");
        customStack.push("B");
        customStack.push("C");

        customStack.pop();
        customStack.pop();
        customStack.pop();
        assertEquals(true, customStack.isEmpty());
    }

    @Test
    public void peek() {
        assertEquals("D", customStack.peek());
    }
}
