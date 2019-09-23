package com.techarha.java.algorithms.searching;

public class BinarySearch {

    public static boolean isPresent(int[] array, int value) {
        return search(array, value) > -1;
    }

    private static int search(int[] array, int value) {
        int start = 0;
        int end = array.length - 1 ;
        return search(array, value, start, end);
    }

    private static int search(int[] array, int value, int start, int end) {
        if(start < 0 || end > array.length - 1 || start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if(array[mid] == value) return mid;
        else if(array[mid] > value) return search(array, value, start, mid-1);
        else return search(array, value, mid + 1, end);
    }
}
