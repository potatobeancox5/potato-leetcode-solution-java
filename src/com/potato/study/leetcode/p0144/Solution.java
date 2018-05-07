package com.potato.study.leetcode.p0144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         144. Binary Tree Preorder Traversal
 *         
 *          
 *       Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?  
要求使用非递归方式 
 *         思路：
 *         	非递归方式实现 二叉树的先序遍历 中 左  右
 *         使用一个栈记录下一个遍历节点的顺序
 *         首先 将root 入栈
 *         while 栈非空
 *         		出栈  依次将有右孩子 左孩子 入栈（如果有左右孩子的话）
 *         		访问出来的节点
 *         
 *         
 * 
 */
public class Solution {
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode curNode = stack.pop();
        	list.add(curNode.val);
        	if(curNode.right != null) {
        		stack.push(curNode.right);
        	}
        	if(curNode.left != null) {
        		stack.push(curNode.left);
        	}
        }
		return list;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[1,null,2,3]");
		List<Integer> result = solution.preorderTraversal(root);
		System.out.println(result);
	}
}
