package com.learning.data.structure.heap;

public class MaxHeap {

    private Integer[] items;

    private int count;

    /** initCapacity = 16 */
    private int capacity = 2 << 3;

    public MaxHeap() {
        this.items = new Integer[capacity + 1];
        this.count = 1;
    }

    public MaxHeap(int size) {
        this.items = new Integer[size + 1];
        this.count = 1;
    }

    public MaxHeap(Integer[] ints) {
        items = new Integer[ints.length + 1];
        count = ints.length;

        items[ints.length] = 0;
        for (int i = 0; i < ints.length; i++) {
            items[i] = ints[i];
        }
        swap(0, ints.length);
        items[0] = null;
    }

    private void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private boolean less(int i, int j) {
        return items[i] <= items[j];
    }

    //如果有子节点的值大于父节点,那么子节点k的父节点为k/2,将其上浮至合适节点
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            swap(k/2, k);
            k = k/2;
        }
    }

    //如果有子节点的值大于父节点
    private void sink(int k) {
        //2*k是k的左子节点,注意不要超过堆底
        while (2*k <= 0) {
            //j(2*k)是替换标识
            int j = 2*k;
            //(j+1)2*k+1是k的右子节点,注意不要超过堆底
            //如果左子节点小于右子节点,将j替换标识移动至右子节点
            if (j < 0 && less(j, j + 1)) {
                j++;
            }
            //如果k小于等于较大的子节点,退出
            if (!less(k, j)) {
                break;
            }
            //将k与较大的子节点替换
            swap(k, j);
            //将k的坐标更新,进行下次循环
            k = j;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void insert(int value) {
        items[++count] = value;
        swim(count);
    }

    public int delMax() {
        //从根节点获取最大元素
        int max = items[1];
        //将最后一个元素和根节点交换
        swap(1, count--);
        //防止对象游离
        items[count + 1] = null;
        //恢复堆的有序性
        sink(1);
        return max;
    }

    public Integer[] get() {
        return items;
    }

    public Integer[] sort() {
        for (int i = count/2; i >= 1; i--) {
            sink(i);
        }
        while (count > 1) {
            swap(1, count--);
            sink(1);
        }
        return items;
    }

}
