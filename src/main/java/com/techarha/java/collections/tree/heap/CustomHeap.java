package com.techarha.java.collections.tree.heap;

public interface CustomHeap<T> {
    T peek();
    T poll();
    void add(T data);
}
