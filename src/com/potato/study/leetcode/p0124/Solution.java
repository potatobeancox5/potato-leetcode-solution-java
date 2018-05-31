package com.potato.study.leetcode.p0124;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         124. Binary Tree Maximum Path Sum
 *         
 *          
 *       Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 *         
 *         
 *         思路：
 *         	见
 *         https://www.cnblogs.com/wennian/p/5036880.html
 *         
 *         
 * 
 */
public class Solution {
	
	private int max = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
        //遍历整颗树 求每一个节点的最大值
		maxNodePathSum(root);
		return this.max;
	}
	
	/**
	 * 找以某个节点开始的最大值
	 * @param root 当前节点
	 * @return 包含这个节点的最大值
	 */
	private int maxNodePathSum(TreeNode root) {
        
		if (root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			if(root.val > this.max) {
				this.max = root.val;
			}
			return root.val;
		} 
		int value = root.val;
		int leftMax = maxNodePathSum(root.left);
		int rightMax = maxNodePathSum(root.right); 
		if(leftMax > 0) {
			value += leftMax;
		}
		if(rightMax > 0) {
			value += rightMax;
		}
		if(value > this.max) {
			this.max = value;
		}
		//只能返回一条边的情况
		// 两边都小于0的情况下
		if(leftMax <= 0 && rightMax <= 0) {
			return root.val;
		}
		return leftMax > rightMax ? root.val + leftMax : root.val + rightMax;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[-10,9,20,null,null,15,7]");
		int max = solution.maxPathSum(root);
		System.out.println(max);
	}
}
