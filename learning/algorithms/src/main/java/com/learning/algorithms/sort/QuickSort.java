package com.learning.algorithms.sort;

import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] items, int left, int right) {
        int i = left;
        int j = right;
        int pivot = items[right];

        for (int k = left; k < j; k++) {
            if (items[k] < pivot) {
                swap(items, k, i);
                i++;
            }
        }

        swap(items, i, j);
        return i;
    }

    private static void sort(int[] items) {
        sort(items, 0, items.length - 1);
    }

    private static void sort(int[] items, int left, int right) {
        if(left < right) {
            int center = partition(items, left, right);
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
            swap(items, i, j);
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

    private static void quickSort(int[] items) {
        quickSort(items, 0, items.length - 1);
    }

    private static void quickSort(int[] items, int left, int right) {
        if (right <= left) {
            return;
        }
        int center = quickPartition(items, left, right);
        quickSort(items, left, center - 1);
        quickSort(items, center + 1, right);
    }

    private static int quickPartition(int[] items, int left, int right) {
        int i = left;
        int j = right + 1;
        int pivot = items[left];
        while (true) {
            while (items[++i] <= pivot) {
                if (i == right) {
                    break;
                }
            }
            while (items[--j] >= pivot) {
                if (j == left) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(items, i, j);
        }
        swap(items, left, j);
        return j;
    }

    private static void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("-------- sort --------");
        int[] items = new int[] {8, 1, 3, 2, 7, 6, 4};
        sort(items);
        System.out.println("items:" + Arrays.toString(items));

        int[] items2 = new int[] {8, 1, 3, 2, 7, 6, 4, 10, 12, 2, 3};
        sort(items2);
        System.out.println("items2:" + Arrays.toString(items2));

        System.out.println("-------- quickSort --------");
        int[] items3 = new int[] {8, 1, 3, 2, 7, 6, 4};
        quickSort(items3);
        System.out.println("items3:" + Arrays.toString(items3));

        int[] items4 = new int[] {8, 1, 3, 2, 7, 6, 4, 10, 12, 2, 3};
        quickSort(items4);
        System.out.println("items4:" + Arrays.toString(items4));
    }

}
