package com.learning.algorithms.sort;

import java.util.Arrays;

/**
 * 选择排序
 * O(n^2)
 * Simple
 * 外部循环找到最小的数，从0开始，然后换到第一个，然后再找第二个最小的数依次递推
 */
public class SelectionSort {

    private static void sort(int[] items) {
        for (int i = 0; i < items.length; i++) {
            int min = i;
            for (int j = i; j < items.length; j++) {
                if (items[j] <= items[min]) {
                    min = j;
                }
            }
            swap(items, i, min);
        }
    }

    private static void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public static void main(String[] args) {
        int[] items = new int[] {8, 1, 3, 2, 7, 6, 4};
        sort(items);
        System.out.println("items:" + Arrays.toString(items));

        int[] items2 = new int[] {8, 1, 3, 2, 7, 6, 4, 10, 12, 2, 3};
        sort(items2);
        System.out.println("items2:" + Arrays.toString(items2));
    }

}
