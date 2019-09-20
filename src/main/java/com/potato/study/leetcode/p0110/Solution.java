package com.potato.study.leetcode.p0110;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 110. Balanced Binary Tree
 *       
 *       Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
 *       
 *
 *         思路： 
 *         给定一颗二叉树 判断该树是否是平衡的
 *         递归判断左右子树高度是否相差2 是的话  返回false 不是返回true
 *         
 */
public class Solution {

	
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		} 
		return isBalanced(root.left) 
				&& isBalanced(root.right) 
				&& maxDepth(root.left) - maxDepth(root.right) < 2 
				&& maxDepth(root.left) - maxDepth(root.right) > -2;
    }
	
	public int maxDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }
	
	
	public static void main(String[] args) {
//		MyCalendarThree solution = new MyCalendarThree();
		
	}
}
