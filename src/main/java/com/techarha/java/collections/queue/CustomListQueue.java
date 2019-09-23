package com.techarha.java.collections.queue;

import com.techarha.java.collections.list.CustomLinkedList;
import com.techarha.java.collections.list.CustomList;

public class CustomListQueue<T> implements CustomQueue<T> {

    CustomList<T> list;

    public CustomListQueue() {
        this.list = new CustomLinkedList<>();
    }

    @Override
    public void enqueue(T data) {
        list.addToEnd(data);
    }

    @Override
    public T dequeue() {
        if(isEmpty()) return null;

        T data = peek();
        list.removeFromFront();
        return data;
    }

    @Override
    public T peek() {
        return isEmpty()? null : list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
