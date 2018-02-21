package com.potato.study.leetcode.p0094;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *         94. Binary Tree Inorder Traversal 
 *         
 *         Given a binary tree, return the
 *         inorder traversal of its nodes' values.
 * 
 *         For example: Given binary tree [1,null,2,3], 1 \ 2 / 3 return
 *         [1,3,2].
 * 
 *         Note: Recursive solution is trivial, could you do it iteratively?
 * 
 *			
 *         思路：
 *         二叉树的中序遍历
 *         递归
 *         遍历左子树
 *         访问节点
 *         遍历右子树
 *         要求使用迭代
 *         这就需要开一个数据结构存储下一个要访问的节点
 */
public class Solution {

	public List<Integer> inorderTraversal(TreeNode root) {
		// 存放当前结果
		List<Integer> result = new LinkedList<>();
		// 栈存放下个遍历的树上的节点
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		// 控制将 当前节点 放到 栈中 用于之后的遍历
		while(p!=null||!stack.isEmpty()){
			// 将最左边的节点放入栈中
 			while(p!=null){
				stack.push(p);
				p = p.left;
			}
 			// 左边的节点都进入到了栈中 开始 访问栈中的节点 边访问边将新的节点放在栈中
			if(!stack.isEmpty()){
				p = stack.pop();
				result.add(p.val);				
				p = p.right;
			}
		}
		return result;
    }
	//递归做法
//	public List<Integer> inorderTraversal(TreeNode root) {
//	List<Integer> result = new LinkedList<Integer>();
//	if(root!=null){
//		result.addAll(inorderTraversal(root.left));
//		result.add(root.val);
//		result.addAll(inorderTraversal(root.right));
//	}
//	return result;
//}
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> list = solution.inorderTraversal(root);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
