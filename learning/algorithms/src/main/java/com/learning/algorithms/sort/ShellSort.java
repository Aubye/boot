package com.learning.algorithms.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * Normal
 * https://www.cnblogs.com/chengxiao/p/6104371.html
 */
public class ShellSort {

    private static void sort(int[] items) {
        sort(items, 3);
    }

    private static void sort(int[] items, int interval) {
        int n = items.length;
        int e = 1;
        while (e < n / interval) {
            e = interval * e + 1;
        }
        while (e >= 1) {
            for (int i = e; i < n; i++) {
                for (int j = i; j >= e && items[j] <= items[j - e]; j -= e) {
                    swap(items, j, j - e);
                }
            }
            e = e / interval;
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
    }

}
