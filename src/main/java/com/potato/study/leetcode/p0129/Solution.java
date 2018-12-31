package com.potato.study.leetcode.p0129;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *       129. Sum Root to Leaf Numbers
 *         
 *    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026. *         
 *        
 *         
 *         思路：
 *        	先序遍历整个树
 *        	如果该节点是叶子节点  计算当前数字 并将其加入sum中 
 * 
 */
public class Solution {
	
	
	public int sumNumbers(TreeNode root) {
		int sum = 0;
		int currentNum = 0;
		return sumNumbersNode(root, sum, currentNum);
	}
	
	private int sumNumbersNode(TreeNode root, int sum, int currentNum) {
		if(root == null) {
			return sum;
		}
		currentNum *= 10;
		currentNum += root.val;
		if(root.left == null && root.right == null) {
			// 当前是叶子节点
			sum += currentNum;
		} else {
			// 计算当前值
			if(null != root.left) {				
				sum = sumNumbersNode(root.left, sum, currentNum);
			} 
			if (null != root.right) {
				sum = sumNumbersNode(root.right, sum, currentNum);
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[1,2,3]");
		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[4,9,0,5,1]");
		int sum = solution.sumNumbers(root);
		System.out.println(sum);
		
	}
}
