package com.techarha.java.collections.stack.questions;

import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedParenthesisTest {

    @Test
    public void isBalancedExpression() {
        assertEquals(false, BalancedParenthesis.isBalancedExpression("{{<(])>}}"));
        assertEquals(true, BalancedParenthesis.isBalancedExpression("{{<([])>}}"));
        assertEquals(false, BalancedParenthesis.isBalancedExpression("{{([])>}}"));
        assertEquals(false, BalancedParenthesis.isBalancedExpression("{asd{12sd1([asfv] ewe) > }wdwd }"));
    }
}
