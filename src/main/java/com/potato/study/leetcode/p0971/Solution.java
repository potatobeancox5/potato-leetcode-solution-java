package com.potato.study.leetcode.p0971;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	971. Flip Binary Tree To Match Preorder Traversal
 *  
 *       Given a binary tree with N nodes, each node has a different value from {1, ..., N}.

A node in this binary tree can be flipped by swapping the left child and the right child of that node.

Consider the sequence of N values reported by a preorder traversal starting from the root.  Call such a sequence of N values the voyage of the tree.

(Recall that a preorder traversal of a node means we report the current node's value, then preorder-traverse the left child, then preorder-traverse the right child.)

Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.

If we can do so, then return a list of the values of all nodes flipped.  You may return the answer in any order.

If we cannot do so, then return the list [-1].



Example 1:



Input: root = [1,2], voyage = [2,1]
Output: [-1]
Example 2:



Input: root = [1,2,3], voyage = [1,3,2]
Output: [1]
Example 3:



Input: root = [1,2,3], voyage = [1,2,3]
Output: []


Note:

1 <= N <= 100
 *         
 *         题目含义：
 *          给一个树的根和一个先序列遍历的数组，翻转最少的节点，能够是的节点与给定的先序遍历匹配
 *          返回一个列表，
 *         思路：
 *
 *
 *
 * 
 */
public class Solution {

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return null;
    }


	
	public static void main(String[] args) {
		Solution solution = new Solution();
    }
}
