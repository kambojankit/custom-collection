package com.techarha.java.collections.list;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {

    private T[] storage;
    private static final int INITIAL_CAPACITY = 10;
    private int currentPosition = -1;

    public CustomArrayList(Class<T> clazz) {
        this(clazz, INITIAL_CAPACITY);
    }

    public CustomArrayList(Class<T> clazz, int size) {
        storage = (T[]) Array.newInstance(clazz, size);
    }

    @Override
    public void addToFront(T data) {
        shiftForward(0);
        storage[0] = data;
    }

    @Override
    public void removeFromFront() {
        shiftBackward(0);
    }

    @Override
    public void addToEnd(T data) {
        insert(data);
    }

    @Override
    public void removeFromEnd() {
        removeAt(currentPosition);
    }

    @Override
    public boolean insert(T data) {
        if(isFull()) { resizeStorage(); }
        storage[++currentPosition] = data;
        return true;
    }

    @Override
    public boolean remove(T data) {
        if(isEmpty())
            return false;

        return removeAt(findIndex(data));
    }

    @Override
    public boolean removeAt(int index) {
        if(index == -1) { return false; }
        return shiftBackward(index);
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size()) return null;
        return storage[index];
    }

    @Override
    public boolean set(int index, T data) {
        if (index < 0 || index >= size()) {
            return false;
        } else {
            storage[index] = data;
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return currentPosition < 0;
    }

    @Override
    public int size() {
        return currentPosition+1;
    }

    @Override
    public boolean contains(T data) {
        return findIndex(data) >= 0;
    }

    private boolean isFull() {
        return currentPosition >= storage.length - 1;
    }

    private void resizeStorage() {
        int newCapacity = storage.length * 2;
        T[] temp = Arrays.copyOf(storage, newCapacity);
        clearCurrentArray();
        storage = temp;
    }

    private void clearCurrentArray() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    private int findIndex(T data) {
        for (int i = 0; i <= currentPosition; i++) {
            if(storage[i] == data)
                return i;
        }
        return -1;
    }

    private boolean shiftForward(int start){
        if(isFull())
            resizeStorage();

        for (int i = currentPosition; i >= start; i--) {
            storage[i+1] = storage[i];
        }
        currentPosition++;

        return true;
    }

    private boolean shiftBackward(int start){
        if(start < 0) return false;

        for (int i = start; i < currentPosition; i++) {
           storage[i] = storage[i+1];
        }
        storage[currentPosition--] = null;
        return true;
    }

}
