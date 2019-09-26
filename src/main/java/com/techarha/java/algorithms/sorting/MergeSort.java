package com.techarha.java.algorithms.sorting;


public class MergeSort implements CustomSort {
    @Override
    public Integer[] sort(Integer[] input) {
        mergeSort(input, 0, input.length - 1, new Integer[input.length]);
        return input;
    }

    private void mergeSort(Integer[] input, int leftStart, int rightEnd, Integer[] tempArr) {
        if(leftStart >= rightEnd) return;

        int middle = (leftStart + rightEnd) / 2;
        mergeSort(input, leftStart, middle, tempArr);
        mergeSort(input, middle + 1, rightEnd, tempArr);
        mergeHalves(input, leftStart, rightEnd, tempArr);
    }

    private void mergeHalves(Integer[] input, int leftStart, int rightEnd, Integer[] tempArr) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if(input[left] <= input[right]) {
                tempArr[index] = input[left];
                left++;
            }else {
                tempArr[index] = input[right];
                right++;
            }
            index++;
        }

        System.arraycopy(input, left, tempArr, index, leftEnd - left + 1);
        System.arraycopy(input, right, tempArr, index, rightEnd - right + 1);

        System.arraycopy(tempArr, leftStart, input, leftStart, size);
    }
}
