package com.potato.study.leetcode.p0098;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         98. Validate Binary Search Tree
 *         
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
 * 
 *   思路： 
 *   合法的二叉树 根节点 大于左子树的所有节点 根节点大于右子树的所有节点
 *   
 *   遍历整个树 做两件事：
 *   1.当前节点是否大于左孩子 小于右孩子 是的话 继续2 不是的话 返回false
 *   2.当前节点是否大于左子树最大值，小于右子树最小值 是的话 分别对所有孩子做1 否则返回false
 * 		
 */
public class Solution {

	public boolean isValidBST(TreeNode root) {
        if(root == null) {
        	return true;
        }
        if(root.left == null && root.right == null) {
        	return true;
        }
        if(root.left == null) {
        	if(root.right.val > root.val) {
        		return isTargetRootMin(root, root.right) 
        				&& isValidBST(root.right);
        	} else {
        		return false;
        	}
        }
        if(root.right == null) {
        	if(root.left.val < root.val) {
        		return isTargetRootMax(root, root.left) && isValidBST(root.left);
        	} else {
        		return false;
        	}
        }
        //左右孩子均不为null
        if(root.left.val < root.val && root.right.val > root.val) {
        	return isTargetRootMax(root, root.left) 
        			&& isTargetRootMin(root, root.right) 
        			&& isValidBST(root.left)
        			&& isValidBST(root.right);
        } else {
        	return false;
        }
    }
	
	/**
	 * 判断root 是否是left 中最大的值
	 * @param root
	 * @param left
	 * @return
	 */
	private boolean isTargetRootMax(TreeNode root,TreeNode left) {
		TreeNode node = left;
		while(node.right != null) { // 找到左子树最右端的值
			node = node.right;
		}
		return node.val < root.val;
	}
	
	/**
	 * 判断root 是否是 right 中最小的值
	 * @param root
	 * @param right
	 * @return
	 */
	private boolean isTargetRootMin(TreeNode root,TreeNode right) {
		TreeNode node = right;
		while(node.left != null) { // 找到有子树最左端的值
			node = node.left;
		}
		return node.val > root.val;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[5,1,4,null,null,3,6]");
//		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[2,1,3]");
//		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[1,null,1]");
//		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[0,-1]");
		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[3,null,30,10,null,null,15,null,45]");
		boolean isValid = solution.isValidBST(root);
		System.out.println(isValid);
	}
}
