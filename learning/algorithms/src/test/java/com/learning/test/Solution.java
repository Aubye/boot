package com.learning.test;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    public static void main(String[] args) {
        ListNode l1a = new ListNode(2);
        ListNode l1b = new ListNode(4);
        ListNode l1c = new ListNode(3);

        l1b.next = l1c;
        l1a.next = l1b;

        ListNode l2a = new ListNode(5);
        ListNode l2b = new ListNode(6);
        ListNode l2c = new ListNode(7);

        l2b.next = l2c;
        l2a.next = l2b;

        ListNode listNode = addTwoNumbers(l1a, l2a);
        System.out.println(listNode.val);
    }
}