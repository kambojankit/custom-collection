package com.techarha.java.collections.stack.questions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathematicalNotationsTest {

    @Test
    public void evaluatePostfixExpression() {
        assertEquals("36", MathematicalNotations.Evaluation.evaluatePostfixExpression("3 2 * 5 6 * +"));
        assertEquals("17", MathematicalNotations.Evaluation.evaluatePostfixExpression("2 3 * 5 4 * + 9 -"));
    }

    @Test
    public void evaluatePrefixExpression() {
        assertEquals("36", MathematicalNotations.Evaluation.evaluatePrefixExpression("+ * 3 2 * 5 6"));
        assertEquals("17", MathematicalNotations.Evaluation.evaluatePrefixExpression("- + * 2 3 * 5 4 9"));
    }

    @Test
    public void convertInfixToPostfixExpression() {
        assertEquals("3 2 * 5 6 * +", MathematicalNotations.Conversion.convertInfixToPostfix("3 * 2 + 5 * 6"));
        assertEquals("2 3 * 5 4 * + 9 -", MathematicalNotations.Conversion.convertInfixToPostfix("2 * 3 + 5 * 4 - 9"));
    }
}
