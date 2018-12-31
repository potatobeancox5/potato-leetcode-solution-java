package com.potato.study.leetcode.p0104;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *         104. Maximum Depth of Binary Tree
 *         
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 *       
]
 *
 *         思路： 求一颗二叉树的高度
 *          递归 二叉树高度 = max{左子树高度，右子树高度} + 1
 */
public class Solution {

	public int maxDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		int height = solution.maxDepth(root);
		System.out.println(height);
		
	}
}
