package com.learning.algorithms.sort;

import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] items, int left, int right) {
        int i = left;
        int pivot = items[right];

        int temp;
        for (int j = left; j < right; j++) {
            if (items[j] < pivot) {
                temp = items[i];
                items[i] = items[j];
                items[j] = temp;
                i++;
            }
        }
        items[right] = items[i];
        items[i] = pivot;
        return i;
    }

    private static void sort(int[] items, int left, int right) {
        int center;
        if(left < right) {
            center = partition(items, left, right);
            sort(items, left,center - 1);
            sort(items,center + 1, right);
        }
    }

    private static int partition2(int[] items, int left, int right) {
        int main = items[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (i < j && items[i] <= main) {
                i++;
            }
            while (i < j && items[j] >= main) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int temp = items[i];
            items[i] = items[j];
            items[j] = temp;
        }
        items[left] = items[j];
        items[j] = main;
        return j;
    }

    private static void sort2(int[] items, int left, int right) {
        int center;
        if(left < right) {
            center = partition2(items, left, right);
            sort2(items, left,center - 1);
            sort2(items,center + 1, right);
        }
    }

    void quicksort(int[] items, int left, int right) {
        int i, j, t, temp;
        if(left > right) {
            return;
        }
        temp = items[left];
        i = left;
        j = right;
        while(i != j) {
            while(items[j] >= temp && i < j) {
                j--;
            }
            while(items[i] <= temp && i < j) {
                i++;
            }
            if(i < j){
                t = items[i];
                items[i] = items[j];
                items[j] = t;
            }
        }
        items[left] = items[i];
        items[i] = temp;

        quicksort(items,left, i - 1);
        quicksort(items,i + 1, right);
    }

    public static void main(String[] args) {
        int[] items = new int[] {8, 1, 3, 2, 7, 6, 4};
        sort(items, 0, items.length - 1);
        System.out.println("items:" + Arrays.toString(items));

        int[] items2 = new int[] {8, 1, 3, 2, 7, 6, 4};
        sort2(items2, 0, items.length - 1);
        System.out.println("items2:" + Arrays.toString(items2));

        int[] items3 = new int[] {8, 1, 3, 2, 7, 6, 4, 10, 12, 2, 3};
        sort(items3, 0, items.length - 1);
        System.out.println("items3:" + Arrays.toString(items3));

        int[] items4 = new int[] {8, 1, 3, 2, 7, 6, 4, 10, 12, 2, 3};
        sort2(items4, 0, items.length - 1);
        System.out.println("items4:" + Arrays.toString(items4));

        int[] items5 = new int[] {8, 1, 3, 2, 7, 6, 4, 10, 12, 2};
        sort2(items5, 0, items.length - 1);
        System.out.println("items5:" + Arrays.toString(items5));
    }

}
