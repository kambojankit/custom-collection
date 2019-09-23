package com.techarha.java.collections.queue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomArrayQueue<T> implements CustomQueue<T> {

    private T[] storage;
    private int front;
    private int rear;

    private static final int INITIAL_CAPACITY = 10;

    public CustomArrayQueue(Class<T> clazz) {
        storage = (T[]) Array.newInstance(clazz, INITIAL_CAPACITY);
        front = -1;
        rear = -1;
    }

    @Override
    public void enqueue(T data) {
        if(isEmpty())
            ++front;

        if(isFull())
            resizeStorage();

        storage[++rear] = data;

    }

    @Override
    public T dequeue() {
        if(isEmpty()) return null;

        T data = peek();
        storage[front++] = null;

        if(front > rear) {
            front = -1;
            rear = -1;
        }
        return data;
    }

    @Override
    public T peek() {
        return isEmpty()? null : storage[front];
    }

    @Override
    public boolean isEmpty() {
        return rear < 0;
    }

    private boolean isFull() {
        return rear >= storage.length;
    }

    private void resizeStorage() {
        storage = Arrays.copyOf(storage, storage.length * 2);
    }

}
