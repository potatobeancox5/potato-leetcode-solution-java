package com.potato.study.leetcode.p0404;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         404. Sum of Left Leaves
 * 
 *       Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * 
 * 
 *         思路： 
			对于每个非叶节点 若 他的左孩子是叶子节点 返回左孩子的值 加上右子树的左孩子的值 
					         若 他的左孩子是非叶子节点 返回左子树左孩子  加上右子树的左孩子的值
					         若 他的左孩子是null 返回右子树左孩子节点
			对于叶子节点 返回0
 * 
 */
public class Solution {
	
	public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
        	return 0;
        } 
        if(root.left == null) {
        	return sumOfLeftLeaves(root.right);
        } 
        if(root.left.left == null && root.left.right == null) {
        	return root.left.val + sumOfLeftLeaves(root.right);
        } else { //左孩子非叶节点
        	return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[3,9,20,null,null,15,7]");
		int sum = solution.sumOfLeftLeaves(root);
		System.out.println(sum);
	}
}
