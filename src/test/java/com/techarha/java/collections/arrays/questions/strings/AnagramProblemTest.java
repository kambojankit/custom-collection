package com.techarha.java.collections.arrays.questions.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramProblemTest {

    @Test
    public void removeCharCountForAnagrams() {
        assertEquals(6, AnagramProblem.charCountToTurnAnagrams("hello", "billion"));
        assertEquals(4, AnagramProblem.charCountToTurnAnagrams("cde", "abc"));
    }
}
