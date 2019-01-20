package com.learning.data.structure.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BinarySearchTreeNode {
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;

    private Integer key;
    private Integer value;

    private Integer count;
}
