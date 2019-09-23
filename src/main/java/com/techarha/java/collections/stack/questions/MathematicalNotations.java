package com.techarha.java.collections.stack.questions;

import com.techarha.java.collections.stack.CustomListStack;
import com.techarha.java.collections.stack.CustomStack;

import java.util.regex.Pattern;

public class MathematicalNotations {

    static class Evaluation {
        public static String evaluatePrefixExpression(String expression) {
            String[] expressionArray = expression.split(" ");
            CustomStack<String> stack = new CustomListStack<>();

            for (int i = expressionArray.length - 1; i >= 0; i--) {
                String data = expressionArray[i];

                if(isNumericValue(data))
                    stack.push(data);

                if(isOperator(data)){
                    calculateValueForPrefixExpr(stack, data);
                }

            }
            return stack.peek();
        }

        private static void calculateValueForPrefixExpr(CustomStack<String> stack, String data) {
            Integer left = Integer.parseInt(stack.pop());
            Integer right = Integer.parseInt(stack.pop());
            Integer result = calculateValue(left, right, data);
            stack.push(result+ "");
        }

        public static String evaluatePostfixExpression(String expression) {
            String[] expressionArray = expression.split(" ");
            CustomStack<String> stack = new CustomListStack<>();

            for (int i = 0; i < expressionArray.length; i++) {
                String data = expressionArray[i];

                if(isNumericValue(data))
                    stack.push(data);

                if(isOperator(data)){
                    calculateValueForPostfixExpr(stack, data);
                }

            }
            return stack.peek();
        }

        private static void calculateValueForPostfixExpr(CustomStack<String> stack, String data) {
            Integer left = Integer.parseInt(stack.pop());
            Integer right = Integer.parseInt(stack.pop());
            Integer result = calculateValue(right, left, data);
            stack.push(result+ "");
        }

        private static Integer calculateValue(Integer left, Integer right, String data) {
            Integer result = 1;

            switch (data) {
                case "*":
                    result = left * right;
                    break;
                case "/":
                    result = left / right;
                    break;
                case "+":
                    result = left + right;
                    break;
                case "-":
                    result = left - right;
                    break;
            }
            return result;
        }

        private static boolean isNumericValue(String input) {
            return Pattern.matches("\\d+", input);
        }

        private static boolean isOperator(String input) {
            return Pattern.matches("[*/+\\-]?", input);
        }
    }

    static class Conversion {
        public static  String convertInfixToPostfix(String infixString) {
            String[] infixArr = infixString.split(" ");

            StringBuffer postfixExpression = new StringBuffer();

            CustomStack<String> stack = new CustomListStack<>();
            for (int i = 0; i < infixArr.length; i++) {
                String data = infixArr[i];

                if(isOperator(data)) {
                    if(!stack.isEmpty() && isStackTopOfHigherPrecedence(stack.peek(), data)) {
                        addStackOperationsToPostfixExpression(stack, postfixExpression);
                    }
                    stack.push(data);
                }else {
                    postfixExpression.append(data + " ");
                }
            }

            if(!stack.isEmpty()) {
                addStackOperationsToPostfixExpression(stack, postfixExpression);
            }

            postfixExpression.deleteCharAt(postfixExpression.lastIndexOf(" "));
            return postfixExpression.toString();

        }

        private static void addStackOperationsToPostfixExpression(CustomStack<String> stack, StringBuffer postfixExpression) {
            while (!stack.isEmpty()) {
                postfixExpression.append(stack.pop()+ " ");
            }
        }


        private static boolean isStackTopOfHigherPrecedence(String top, String operator) {
            switch (top) {
                case "*":
                case "/":
                    return isAdditionOrSubtractionOperator(operator);
                case "+":
                case "-":
                    return !isMultiplicationOrDivisionOperator(operator);

            }
            return true;
        }

        private static boolean isOperator(String input) {
            return Pattern.matches("[*/+\\-]?", input);
        }

        private static boolean isMultiplicationOrDivisionOperator(String input) {
            return Pattern.matches("[*/]?", input);
        }

        private static boolean isAdditionOrSubtractionOperator(String input) {
            return Pattern.matches("[+\\-]?", input);
        }

    }
}
