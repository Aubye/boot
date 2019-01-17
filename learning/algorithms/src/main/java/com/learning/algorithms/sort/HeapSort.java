package com.learning.algorithms.sort;

import com.learning.data.structure.heap.MaxHeap;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] items = new int[] {8, 1, 3, 2, 7, 6, 4};
        MaxHeap maxHeap = new MaxHeap(items);
        System.out.println(Arrays.toString(maxHeap.sort()));
        int[] items1 = new int[] {8, 1, 3, 2, 7, 6, 4, 10, 12, 2, 3};
        MaxHeap maxHeap1 = new MaxHeap(items1);
        System.out.println(Arrays.toString(maxHeap1.sort()));
    }
}
