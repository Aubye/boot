package com.learning.data.structure.tree;

public class BinarySearchTree {

    private BinarySearchTreeNode root;

    public int size() {
        return size(root);
    }

    public Integer size(BinarySearchTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.getCount();
        }
    }

    public Integer getValue(Integer key) {
        return getValue(root, key);
    }

    public Integer getValue(BinarySearchTreeNode node, Integer key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            return getValue(node.getRight(), key);
        } else if (cmp > 0) {
            return getValue(node.getLeft(), key);
        } else {
            return node.getValue();
        }
    }
}
