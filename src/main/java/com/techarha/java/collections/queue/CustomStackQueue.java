package com.techarha.java.collections.queue;

import com.techarha.java.collections.stack.CustomListStack;
import com.techarha.java.collections.stack.CustomStack;

public class CustomStackQueue<T> implements CustomQueue<T> {

    CustomStack<T> pushStack;
    CustomStack<T> popStack;

    public CustomStackQueue() {
        pushStack = new CustomListStack<>();
        popStack = new CustomListStack<>();
    }

    @Override
    public void enqueue(T data) {
        pushStack.push(data);
    }

    @Override
    public T dequeue() {
        if(isEmpty()) return null;

        if(popStack.isEmpty())
            unloadPushStackToPopStack();

        return popStack.pop();
    }

    @Override
    public T peek() {
        if(isEmpty()) return null;

        if(popStack.isEmpty())
            unloadPushStackToPopStack();

        return popStack.peek();
    }

    @Override
    public boolean isEmpty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }

    private void unloadPushStackToPopStack() {
        while(!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }
}
