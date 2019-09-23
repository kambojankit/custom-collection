package com.techarha.java.collections.list;

public interface CustomList<T>{

    void addToFront(T data);
    void removeFromFront();

    void addToEnd(T data);
    void removeFromEnd();

    boolean insert(T data);

    boolean remove(T data);
    boolean removeAt(int index);

    T get(int index);
    boolean set(int index, T data);

    boolean isEmpty();
    int size();

    String toString();

    boolean contains(T data);
}
