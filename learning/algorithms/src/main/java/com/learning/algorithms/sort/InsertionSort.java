package com.learning.algorithms.sort;

import java.util.Arrays;

/**
 * 插入排序
 * O(n^2)
 * 从左往右逐步,保证每次从左边起都是到右边都是有序的,再每次i时都对比换位直到不小于当前为止
 */
public class InsertionSort {

    private static void sort(int[] items) {
        for (int i = 1; i < items.length; i++) {
            int value = items[i];
            int j = i - 1;
            while (j >= 0 && items[j] > value) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] items = {0, 5, 4, 6, 1, 3, 7, 8, 9, 2};
        sort(items);
        System.out.println(Arrays.toString(items));
    }

}
