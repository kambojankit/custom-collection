package com.techarha.java.collections.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomArrayStack<T> implements CustomStack<T>{

    private T[] storage;
    private static final int INITIAL_CAPACITY = 10;
    private int top = -1;

    public CustomArrayStack(Class<T> clazz) {
        storage = (T[]) Array.newInstance(clazz, INITIAL_CAPACITY);
    }

    @Override
    public T push(T data) {
        if(isFull())
            resizeStorage();

        storage[++top] = data;
        return data;
    }

    @Override
    public T pop() {
        if(isEmpty()) return null;

        T data = peek();
        storage[top--] = null;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public T peek() {
        if(isEmpty()) return null;
        return storage[top];
    }

    private boolean isFull() {
        return top >= storage.length;
    }

    private void resizeStorage() {
        storage = Arrays.copyOf(storage, storage.length * 2);
    }
}
