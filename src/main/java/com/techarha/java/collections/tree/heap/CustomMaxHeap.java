package com.techarha.java.collections.tree.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomMaxHeap<T extends Comparable<T>> implements CustomHeap<T> {

    T[] storage;
    private static final int INITIAL_CAPACITY = 10;
    private int currentCapacity = INITIAL_CAPACITY;
    private int position = 0;

    public CustomMaxHeap(Class<T> clazz) {
        this.storage = (T[]) Array.newInstance(clazz, INITIAL_CAPACITY);
    }

    @Override
    public T peek() {
        if (position == 0) return null;
        return storage[0];
    }

    @Override
    public T poll() {
        if(position == 0) return null;
        T data = peek();

        swap(0, --position);
        storage[position] = null;
        heapifyDown(0);

        return data;
    }

    @Override
    public void add(T data) {
        if(isFull())
            resizeStorage();

        storage[position++] = data;
        heapifyUp(position - 1);
    }


    private boolean isFull() {
        return position >= currentCapacity;
    }

    private void heapifyUp(int index) {
        if(index < 0) return;
        T current = storage[index];

        if(isParentSmaller(index, current)) {
            int parentIndex = getParentIndex(index);
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private boolean isParentSmaller(int currentIndex, T current) {
        return hasParent(currentIndex) && current.compareTo(parent(currentIndex)) > 0;
    }

    private void heapifyDown(int index) {
        if(index >= position) return;
        T current = storage[index];

        int greaterChildIndex = -1;
        if(hasLeftChild(index)) {
            greaterChildIndex = getLeftChildIndex(index);
        }

        if(hasRightChild(index)) {
            greaterChildIndex = hasLeftChild(index) && isLeftChildGreaterThanRight(index) ? getLeftChildIndex(index) : getRightChildIndex(index);
        }

        if(isCurrentSmallerThanChild(current, greaterChildIndex)) {
            swap(index, greaterChildIndex);
            heapifyDown(greaterChildIndex);
        }
    }

    private boolean isCurrentSmallerThanChild(T current, int childIndex) {
        if(childIndex >= position || childIndex < 0) return false;

        T child = storage[childIndex];
        return current.compareTo(child) <= 0;
    }

    private boolean isLeftChildGreaterThanRight(int index) {
        if(!hasLeftChild(index)) return false;
        if(!hasRightChild(index)) return true;

        return leftChild(index).compareTo(rightChild(index)) > 0;
    }

    private int getLeftChildIndex(int parentIndex) { return 2*parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2*parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < position; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < position; }
    private boolean hasParent(int index) { return index != 0 && getParentIndex(index) >= 0; }

    private T leftChild(int index) {return storage[getLeftChildIndex(index)]; }
    private T rightChild(int index) {return storage[getRightChildIndex(index)]; }
    private T parent(int index) {return storage[getParentIndex(index)]; }

    private void swap(int indexOne, int indexTwo) {
        T temp = storage[indexTwo];

        storage[indexTwo] = storage[indexOne];
        storage[indexOne] = temp;
    }

    private void resizeStorage() {
        int newCapacity = 2*currentCapacity;
        storage = Arrays.copyOf(storage, newCapacity);
        currentCapacity = newCapacity;
    }
}
