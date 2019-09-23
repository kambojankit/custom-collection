package com.techarha.java.collections.stack.questions;

import com.techarha.java.collections.stack.CustomListStack;
import com.techarha.java.collections.stack.CustomStack;


public class BalancedParenthesis {
    private static char[][] suppParenthesis = {
                                            {'{', '}'},
                                            {'[', ']'},
                                            {'(', ')'},
                                            {'<', '>'},
                                        };

    public static boolean isBalancedExpression(String input) {
        char[] inputCharArr = input.toCharArray();

        CustomStack<Character> stack = new CustomListStack<>();
        for (int i = 0; i < inputCharArr.length; i++) {
            char data = inputCharArr[i];

            if(isOpeningBrace(data))
                stack.push(data);

            if(isClosingBrace(data)) {
                if(isClosingBraceMatch(data, stack.peek()))
                    stack.pop();
                else return false;
            }


        }

        return stack.isEmpty();
    }

    private static boolean isClosingBrace(char input) {
       return checkMatch(false, input);
    }

    private static boolean isOpeningBrace(char input) {
        return checkMatch(true, input);
    }

    private static boolean isClosingBraceMatch(char inputData, char stackTop) {
        for (int row = 0; row < suppParenthesis.length; row++) {
            if(suppParenthesis[row][1] == inputData && suppParenthesis[row][0] == stackTop) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkMatch(boolean isOpeningBrace, char inputData) {
        int col = isOpeningBrace ? 0 : 1;
        for (int row = 0; row < suppParenthesis.length; row++) {
            if(suppParenthesis[row][col] == inputData) {
                return true;
            }
        }

        return false;
    }

}
