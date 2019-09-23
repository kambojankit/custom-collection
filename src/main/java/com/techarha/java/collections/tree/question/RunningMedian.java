package com.techarha.java.collections.tree.question;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

    public static double[] getMedians(int[] array) {
        return getMediansPriorityQueue(array);
    }

    private static double[] getMediansPriorityQueue(int[] array) {
        PriorityQueue<Integer> highersMinHeap = new PriorityQueue<Integer>(Comparator.naturalOrder()); // minHeap, since smallest number will be in queue front
        PriorityQueue<Integer> lowersMaxHeap = new PriorityQueue<Integer>((a, b) -> -1 * a.compareTo(b)); // maxHeap, since largest number will be in queue front

        double[] medians = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            addNumber(number, lowersMaxHeap, highersMinHeap);
            rebalance(lowersMaxHeap, highersMinHeap);

            medians[i] = getMedian(lowersMaxHeap, highersMinHeap);
        }

        return medians;
    }

    private static double getMedian(PriorityQueue<Integer> lowersMaxHeap, PriorityQueue<Integer> highersMinHeap) {
        PriorityQueue<Integer> biggerHeap = highersMinHeap.size() > lowersMaxHeap.size() ? highersMinHeap : lowersMaxHeap;
        PriorityQueue<Integer> smallerHeap = lowersMaxHeap.size() < highersMinHeap.size() ? lowersMaxHeap : highersMinHeap;

        if(biggerHeap.size() == smallerHeap.size()) {
            return ((double)biggerHeap.peek() + lowersMaxHeap.peek()) / 2;
        }else {
            return biggerHeap.peek();
        }
    }

    // If lowers and highers differ by one element, then we ok, else we need to move elements from higher to lower
    private static void rebalance(PriorityQueue<Integer> lowersMaxHeap, PriorityQueue<Integer> highersMinHeap) {
        PriorityQueue<Integer> biggerHeap = highersMinHeap.size() > lowersMaxHeap.size() ? highersMinHeap : lowersMaxHeap;
        PriorityQueue<Integer> smallerHeap = lowersMaxHeap.size() < highersMinHeap.size() ? lowersMaxHeap : highersMinHeap;

        if(biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }

    }

    private static void addNumber(int number, PriorityQueue<Integer> lowersMaxHeap, PriorityQueue<Integer> highersMinHeap) {
        if(lowersMaxHeap.size() == 0 || number < lowersMaxHeap.peek()) {
            lowersMaxHeap.add(number);
        }else {
            highersMinHeap.add(number);
        }
    }
}
