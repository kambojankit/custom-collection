package com.techarha.java.collections.stack;

import com.techarha.java.collections.list.CustomLinkedList;
import com.techarha.java.collections.list.CustomList;

public class CustomListStack<T> implements CustomStack<T> {

    private CustomList<T> customList;

    public CustomListStack() {
        customList = new CustomLinkedList<>();
    }

    @Override
    public T push(T data) {
        customList.addToFront(data);
        return data;
    }

    @Override
    public T pop() {
        T data = peek();
        customList.removeFromFront();
        return data;
    }

    @Override
    public T peek() {
        if(isEmpty()) return null;
        return customList.get(0);
    }

    @Override
    public boolean isEmpty() {
        return customList.isEmpty();
    }
}
