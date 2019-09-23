package com.techarha.java.collections.stack;

public interface CustomStack<T>{
    T push(T data);
    T pop();
    boolean isEmpty();
    T peek();
}
