package com.potato.study.leetcode.p0101;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *         101. Symmetric Tree
 * 
 *         Given a binary tree, check whether it is a mirror of itself (ie,
 *         symmetric around its center).
 *
 *
 *         For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 * 
 *         1
 * 
 *         / \
 * 
 *         2 2 / \ / \ 3 4 4 3 But the following [1,2,2,null,3,null,3] is not: 1
 *         / \ 2 2 \ \ 3 3
 * 
 *         思路：检查一个二叉树 是否是对称的
 *         用遍历的方法 
 *         递归 方法 这个数是对称的 因为 左子树 对称于右子树
 */
public class Solution {
	
	public boolean isSymmetric(TreeNode root) {
        if(root == null) {
        	return true;
        }
        return isSame(root.left, root.right);
    }
	
	private boolean isSame(TreeNode a , TreeNode b) {
		if(null == a && null == b) {
			return true;
		}
		if(null != a && null != b) {
			// a的左子树与b的右子树是否相同, a的右子树是否与b的左子树相同
			return a.val == b.val && isSame(a.left, b.right) && isSame(a.right, b.left);
		}		
		return false;
	}
	
	public static void main(String[] args) {
//		MyCalendarThree solution = new MyCalendarThree();
//		solution.isSymmetric(root);
	}
}
