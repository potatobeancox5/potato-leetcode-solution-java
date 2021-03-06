package com.potato.study.leetcode.p0701;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	701. Insert into a Binary Search Tree
 *  
 *         Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

For example,

Given the tree:
4
/ \
2   7
/ \
1   3
And the value to insert: 5
You can return this binary search tree:

4
/   \
2     7
/ \   /
1   3 5
This tree is also valid:

5
/   \
2     7
/ \
1   3
\
4
 *         
 *         题目解释：
 *          向二叉搜索树中插入一个值
 *         思路：
 *
 *         
 *
 *
 * 
 */
public class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // root is null
        if (root == null) {
            return new TreeNode(val);
        }
        // root is not null
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
	

	
	public static void main(String[] args) {
//		MyCalendarThree solution = new MyCalendarThree();
    }
}
