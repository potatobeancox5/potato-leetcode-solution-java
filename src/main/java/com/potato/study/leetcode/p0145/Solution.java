package com.potato.study.leetcode.p0145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *         145. Binary Tree Postorder Traversal
 *         
 *          
 *     Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?



 *         思路：
 *         	非递归方式实现 二叉树的后序遍历  左  右 中
 *         两个栈 一个用来记录访问情况 另一个用来记录下一个访问节点
 *         初始root 进入 visitStack 和 nodeStack
 *         while  visitStack ！= null
 *         	visitStack。peek ==  nodeStack.peek	
 *         		visitStack.pop 并将非叶孩子 入栈visitStack 以及所有孩子入栈  nodeStack 右 左
 *      	visitStack。peek !=  nodeStack.peek	nodeStack依次出栈 直到空 或者相等
 *      	
 *      最终将nodeStack出栈到空
 *         
 *         更过实现方法 参考 
 *         https://blog.csdn.net/crazy1235/article/details/51494797
 *         
 * 
 */
public class Solution {
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(null == root) {
			return result;
		}
		Stack<TreeNode> visitStack = new Stack<>();
		Stack<TreeNode> nodeStack = new Stack<>();
		visitStack.push(root);
		nodeStack.push(root);
//		两个栈 一个用来记录访问情况 另一个用来记录下一个访问节点
//		 *         初始root 进入 visitStack 和 nodeStack
		while(!visitStack.isEmpty()) {
			if(visitStack.peek() == nodeStack.peek()) {
				TreeNode curNode = visitStack.pop();
				if(null != curNode.right) {
					if(curNode.right.left != null || curNode.right.right != null) {
						visitStack.push(curNode.right);
					}
					nodeStack.push(curNode.right);
				} 
				if(null != curNode.left) {
					if(curNode.left.left != null || curNode.left.right != null) {
						visitStack.push(curNode.left);
					}
					nodeStack.push(curNode.left);
				}
			} else { // 不相等的情况
				while(nodeStack.peek() != visitStack.peek()) {
					result.add(nodeStack.pop().val);
				}
			}
		}
		while(!nodeStack.isEmpty()) {
			result.add(nodeStack.pop().val);
		}
		return result;
    }
	
}
