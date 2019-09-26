package com.techarha.java.algorithms.sorting;

public class QuickSort implements CustomSort {
    @Override
    public Integer[] sort(Integer[] input) {
        quicksort(input, 0, input.length - 1);
        return input;
    }

    private void quicksort(Integer[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;
        int pivot = array[middle];

        int index = partition(array, left, right, pivot);
        quicksort(array, left, index - 1);
        quicksort(array, index, right);
    }

    private int partition(Integer[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if(left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(Integer[] array, int i, int j) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
