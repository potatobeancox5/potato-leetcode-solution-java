package com.potato.study.leetcode.p0429;


import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *   429. N-ary Tree Level Order Traversal
 * 
 *   Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:







We should return its level order traversal:

[
[1],
[3,2,4],
[5,6]
]


Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.

 * 			
 *     思路：
 *      队列 记录当前层信息
 *     
 * 			
 * 	
 */	
public class Solution {

    public List<List<Integer>> levelOrder(Node root) {

        return null;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
