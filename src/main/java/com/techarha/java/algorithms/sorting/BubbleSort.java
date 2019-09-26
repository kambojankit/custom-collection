package com.techarha.java.algorithms.sorting;

public class BubbleSort implements CustomSort {

    @Override
    public Integer[] sort(Integer[] input) {
        bubbleSort(input);
        return input;
    }

    private void bubbleSort(Integer[] input) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < input.length - 1; i++) {
                if(input[i] >= input[i+1]) {
                    swap(input, i, i + 1);
                    isSorted = false;
                }
            }
        }
    }

    private void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
