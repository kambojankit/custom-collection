package com.techarha.java.collections.stack.questions;

import com.techarha.java.collections.stack.CustomListStack;
import com.techarha.java.collections.stack.CustomStack;

public class ReverseUsingStack {

    public static String reverseProvidedString(String input) {
        char[] inputCharArr = input.toCharArray();

        CustomStack<Character> charStack = new CustomListStack<>();
        for (int i = 0; i < inputCharArr.length; i++) {
            charStack.push(inputCharArr[i]);
        }

        StringBuffer buff = new StringBuffer();
        while(charStack.peek() != null) {
            buff.append(charStack.pop());
        }

        return buff.toString();
    }
}
