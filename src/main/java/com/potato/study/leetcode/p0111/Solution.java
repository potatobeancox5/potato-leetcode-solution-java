package com.potato.study.leetcode.p0111;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 111. Minimum Depth of Binary Tree
 *         Given a binary tree, find its minimum depth.
 * 
 *         The minimum depth is the number of nodes along the shortest path from
 *         the root node down to the nearest leaf node.
 *
 *         思路： 找出一刻二叉树的最短路径
 *         递归 最小路径 是左子树右子树中最小的那个
 * 
 * 
 */
public class Solution {

	
	public int minDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        if(root.left != null && root.right != null) {
        	int leftHeight = minDepth(root.left);
            int rightHeight = minDepth(root.right);
            return (leftHeight > rightHeight ? rightHeight :leftHeight) + 1;
        } else if(root.left == null && root.right == null) {
        	return 1;
        } else if (root.left != null) {
        	return minDepth(root.left) + 1;
        } else { // && root.right != null
        	return minDepth(root.right) + 1;
        }
        
    }
	
	
	public static void main(String[] args) {
//		MyCalendarThree solution = new MyCalendarThree();
		
	}
}
