package com.techarha.java.collections.queue;

public interface CustomQueue<T> {
    void enqueue(T data);
    T dequeue();
    T peek();
    boolean isEmpty();
}
