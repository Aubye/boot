package com.learning.data.structure.linked;

public class LinkedListNode<T> {

    private T node;

    private LinkedListNode<T> nextNode;

    public LinkedListNode() {
    }

    public LinkedListNode(T node, LinkedListNode<T> nextNode) {
        this.node = node;
        this.nextNode = nextNode;
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public LinkedListNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedListNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}
