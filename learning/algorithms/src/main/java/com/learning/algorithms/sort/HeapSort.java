package com.learning.algorithms.sort;

import com.learning.data.structure.heap.MaxHeap;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        Integer[] items = new Integer[] {8, 1, 3, 2, 7, 6, 4};
        MaxHeap maxHeap = new MaxHeap(items);
        System.out.println(Arrays.toString(maxHeap.sort()));
    }
}
