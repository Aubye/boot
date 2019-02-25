package com.learning.test;

import java.util.Arrays;
import java.util.HashMap;

public class TowSum {
    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    private int[] toSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int diff = target - number;
            Integer index = hashMap.get(diff);
            if (index != null && index != i) {
                return new int[] {i, index};
            }
            hashMap.put(number, i);
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new TowSum().toSum(numbers, target)));
    }
}
