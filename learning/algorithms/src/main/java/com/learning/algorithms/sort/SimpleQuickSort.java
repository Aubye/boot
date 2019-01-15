package com.learning.algorithms.sort;

import com.google.common.collect.Lists;

import java.util.List;

public class SimpleQuickSort {

    private static List<Integer> sort(List<Integer> items) {
        if (items.size() > 1) {
            List<Integer> smaller = Lists.newArrayList();
            List<Integer> same = Lists.newArrayList();
            List<Integer> larger = Lists.newArrayList();

            int mid = items.size() / 2;
            int midItem = items.get(mid);
            for (int item : items) {
                if (item < midItem) {
                    smaller.add(item);
                } else if (item > midItem) {
                    larger.add(item);
                } else {
                    same.add(item);
                }
            }

            sort(smaller);
            sort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
        return items;
    }

    public static void main(String[] args) {
        List<Integer> items = Lists.newArrayList(0, 5, 4, 6, 1, 3, 7, 8, 9, 2);
        List<Integer> sort = sort(items);
        System.out.println(sort);
    }

}
