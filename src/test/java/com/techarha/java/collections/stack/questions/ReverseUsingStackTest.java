package com.techarha.java.collections.stack.questions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseUsingStackTest {

    @Test
    public void reverseProvidedString() {
        assertEquals("OLLEH", ReverseUsingStack.reverseProvidedString("HELLO"));
    }
}
