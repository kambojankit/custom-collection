package com.techarha.java.collections.queue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomCircularArrayQueue<T> implements CustomQueue<T> {
    private T[] storage;
    private int front;
    private int rear;

    private static final int INITIAL_CAPACITY = 5;

    public CustomCircularArrayQueue(Class<T> clazz) {
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

        rear = getNextIndexFor(rear);
        storage[rear] = data;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) return null;

        T data = peek();
        storage[front]= null;

        if(rear == front) rear = front = -1;
        else front = getNextIndexFor(front);

        return data;
    }

    @Override
    public T peek() {
        return isEmpty()? null : storage[front];
    }

    @Override
    public boolean isEmpty() {
        return front == rear && front == -1;
    }

    private boolean isFull() {
        return getNextIndexFor(rear) == front;
    }

    private int getNextIndexFor(int front) {
        return (front + 1) % storage.length;
    }

    private void resizeStorage() {
        storage = Arrays.copyOf(storage, storage.length * 2);
    }
}
