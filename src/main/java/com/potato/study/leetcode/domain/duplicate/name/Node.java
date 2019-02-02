package com.potato.study.leetcode.domain.duplicate.name;

import java.util.List;

/**
 * 多叉树的node
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val,List<Node> children) {
        this.val = val;
        this.children = children;
    }
}