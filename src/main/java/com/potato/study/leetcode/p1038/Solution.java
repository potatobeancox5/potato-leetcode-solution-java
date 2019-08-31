package com.potato.study.leetcode.p1038;


import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreePrintUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 	1038. Binary Search Tree to Greater Sum Tree
 *  
 *        Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:



Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]


Note:

The number of nodes in the tree is between 1 and 100.
Each node will have value between 0 and 100.
The given tree is a binary search tree.
 *         
 *
 *         题目含义：
 *          树变形，变形之后每隔节点的val变成大于等于这个节点的值的和
 *
 *         思路：
 *          全局变量sum = 0， 记录当前遍历的和
 *
 *          遍历右孩子
 *          更改 sum当前值
 *          设置该节点为sum
 *          遍历左孩子
 *
 *
 */
public class Solution {


    private int sum;

    public TreeNode bstToGst(TreeNode root) {
        traverseTheTree(root);
        return root;
    }

    private void traverseTheTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            traverseTheTree(root.right);
        }
        sum += root.val;
        root.val = sum;
        if (root.left != null) {
            traverseTheTree(root.left);
        }
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);


        TreePrintUtil.pirnt(root);
    }
}
