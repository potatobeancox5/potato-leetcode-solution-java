package com.potato.study.leetcode.p0112;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 112. Path Sum
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *         思路：  寻找指定叶节点 是否存在又跟到叶的一条路径 使得 路径的权值之和等于给定的值
 *         采用递归的思想 
 *         初值条件 当前节点是叶节点 且 值等于给定值时 返回true 否则返回false
 *         递归查找左子树和右子树 sum - 当前value
 *         
 * 
 * 
 */
public class Solution {

	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
        	return false;
        } 
        if(root.left == null && root.right == null) { // 到达叶子节点 返回
        	if(root.val == sum) {        		
        		return true;
        	} else { // 不等
        		return false;
        	}
        } 
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
	
	
	
	public static void main(String[] args) {
//		Solution solution = new Solution();
		
	}
}
