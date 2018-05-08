package com.potato.study.leetcode.p0226;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *      226. Invert Binary Tree
 * 
 * Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.	
 * *         
 * 思路： 采用先根遍历二叉树 每次 遍历是交换节点
 *  
 */
public class Solution {
	
	public TreeNode invertTree(TreeNode root) {
		if (null == root) {
			return root;
		}
		if(null != root.left) {
			invertTree(root.left);
		}
		if(null != root.right) {
			invertTree(root.right);			
		}
		// 交换左右孩子
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		return root;
	}
	
    public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[4,2,7,1,3,6,9]");
		TreeNode head = solution.invertTree(root);
		TreeNodeUtil.printBSTTreeNodeInArrayString(head, 3);
	}
}
