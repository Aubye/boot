package com.learning.data.structure.linked;

import java.util.Iterator;

public class SingleLinkedList<T> implements LinkedList<T> {

    private LinkedListNode<T> header;

    private LinkedListNode<T> footer;

    private int lastIndex;

    private void init(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data, null);
        header = node;
        footer = node;
    }

    private void appendWithFooter(T data) {
        LinkedListNode<T> node = new LinkedListNode<>(data, null);
        footer.setNext(node);
        footer = node;
    }

    private LinkedListNode<T> getNode(int index) {
        if (index == 0) {
            return header;
        }
        LinkedListNode<T> next = header.getNext();
        for (int i = 1; i <= index; i++) {
            if (next == null) {
                break;
            }
        }
        return next;
    }

    @Override
    public void append(T data) {
        if (footer == null) {
            init(data);
        } else {
            appendWithFooter(data);
            lastIndex++;
        }
    }

    @Override
    public void insert(int index, T data) {
        if (index > lastIndex + 1) {
            throw new IllegalArgumentException("cannot insert data with index " + index);
        } else if (index == lastIndex + 1) {
            appendWithFooter(data);
        } else if (index == 0) {
            if (header == null) {
                init(data);
            } else {
                header = new LinkedListNode<>(data, null);
            }
        } else {
            LinkedListNode<T> previousNode = getNode(index - 1);
            LinkedListNode<T> oldNodeWithIndex = previousNode.getNext();
            LinkedListNode<T> node = new LinkedListNode<>(data, oldNodeWithIndex);
            previousNode.setNext(node);
        }
        lastIndex++;
    }

    @Override
    public void removeWithIndex(int index) {
        if (index <= lastIndex) {
            if (index == 0) {
                if (header != null) {
                    LinkedListNode<T> next = header.getNext();
                    if (next != null) {
                        header.setNext(null);
                        header = next;
                    } else {
                        header = null;
                        footer = null;
                    }
                }
            } else {
                LinkedListNode<T> previousNode = getNode(index - 1);
                LinkedListNode<T> node = previousNode.getNext();
                LinkedListNode<T> nodeNext = node.getNext();
                previousNode.setNext(nodeNext);
            }
        }
        lastIndex--;
    }

    @Override
    public T get(int index) {
        if (index == 0) {
            return header == null? null : header.getData();
        }
        LinkedListNode<T> next = header;
        for (int i = 1; i <= index; i++) {
            next = next.getNext();
            if (next == null) {
                break;
            }
        }
        return next == null? null : next.getData();
    }

    @Override
    public int size() {
        return lastIndex + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new SingleLinkedListIterator<>(header);
    }


    /**
     * 单链表反转
     */
    public void reverse() {
        LinkedListNode<T> node = header;
        LinkedListNode<T> prev = null;
        footer = header;
        while (node != null) {
            LinkedListNode<T> next = node.getNext();
            if (next == null) {
                header = node;
            }
            node.setNext(prev);
            prev = node;
            node = next;
        }
    }

    /**
     * 单链表反转 递归版
     */
    public void reverseRecursion() {

    }

    /**
     * 检测链表中是否有环
     * 快慢指针算法
     */
    public <T> Boolean checkIsCycle(LinkedListNode<T> header) {
        return null;
    }
}
