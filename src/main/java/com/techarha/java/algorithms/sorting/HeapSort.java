package com.techarha.java.algorithms.sorting;

public class HeapSort {

    public static Integer[] sort(Integer[] input) {
        if(input == null || input.length <= 0) {
            return null;
        }

        return createAndSortMaxHeap(input);
    }

    private static Integer[] createAndSortMaxHeap(Integer[] input) {
        Integer[] temp = new Integer[input.length];

        for (int i = 0; i < input.length; i++) {
            temp[i] = input[i];
            heapifyUp(temp, i);
        }

        int last = temp.length - 1;
        for (int i = 0; i < temp.length; i++) {
            if(temp[0] >= temp[last - i]) swap(temp, 0, last - i);
            heapifyDown(temp, 0, last - i);
        }
        return temp;
    }

    private static  void heapifyDown(Integer[] arr, int curr, int last) {
        int lIndex = leftChildIndex(curr);
        int rIndex = rightChildIndex(curr);

        if(lIndex >= last) return;
        if(rIndex >= last) return;

        if(arr[lIndex] >= arr[curr] && arr[lIndex] > arr[rIndex]) {
            swap(arr, lIndex, curr);
            heapifyDown(arr, lIndex, last);
        }else if(arr[rIndex] >= arr[curr]) {
            swap(arr, rIndex, curr);
            heapifyDown(arr, rIndex, last);
        }
    }


    private static void heapifyUp(Integer[] arr, int curr) {
        if(curr <= 0) {
            return;
        }
        int pIndex = parentIndex(curr);
        if(arr[curr] >= arr[pIndex]) {
            swap(arr, curr, pIndex);
        }
        heapifyUp(arr, pIndex);
    }

    private static int parentIndex(int childIndex) {
        return (childIndex-1) / 2;
    }

    private static int leftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    private static int rightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    private static void swap(Integer[] arr, int lIndex, int rIndex) {
        Integer temp = arr[lIndex];
        arr[lIndex] = arr[rIndex];
        arr[rIndex] = temp;
    }
}
