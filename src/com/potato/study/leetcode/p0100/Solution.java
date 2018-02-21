package com.potato.study.leetcode.p0100;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11 
 * 
 * 		100. Same Tree
 * 
 * 		   Given two binary trees, write a function to check if they
 *         are the same or not.
 * 
 *         Two binary trees are considered the same if they are structurally
 *         identical and the nodes have the same value.
 * 
 *         思路：
 *         先序遍历 并比较 一旦不一致 直接返回 
 */
public class Solution {
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(null == p && q == null) {
			return true;
		}
		if(null != p && null != q) {
			//比较当前节点，比较左子树 , 比较右子树
			return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} 
		return false;		
    }	
	
	public static void main(String[] args) {
		//Solution solution = new Solution();
		
	}
}
