package com.potato.study.leetcode.p0102;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *         102. Binary Tree Level Order Traversal
 * 
 *        Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 *
 *         思路：层序遍历二叉树 要求展昭层序输出遍历结果
 *         设置一个队列 queue 一个下一层数量计数器 nextLayer = 0 一个本层技术器 = 1 一个本层公有多少节点
 *         每次出队 本层计数器 ++ 并将孩子入队 下一层计数器相应增加 
 *         判断本层计数器是否达到本层节点数 达到了  换下一层 相应重置本层计数器 下一层计数器 本层最大值
 *         
 */
public class Solution {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(null == root) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		// 初始入队
		queue.add(root);
		int nextLayer = 0;
		int currentLayer = 1; // 本层应该有多少个节点
		int currentCount = 0;
		List<Integer> thisLayerResult = new ArrayList<>();
		while(!queue.isEmpty()) {
			TreeNode node = queue.remove();
			currentCount++;
			// 将孩子入队
			if (node.left != null) {
				queue.add(node.left);
				nextLayer++;
			}
			if(node.right != null) {
				queue.add(node.right);
				nextLayer++;
			}
			// node 加入本层结果
			thisLayerResult.add(node.val);
			//  判断本层是否结束
			if(currentCount == currentLayer) {
				result.add(thisLayerResult);
				thisLayerResult = new ArrayList<>();
				currentCount = 0;
				currentLayer = nextLayer;
				nextLayer = 0;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
 		List<List<Integer>> result = solution.levelOrder(root);
		System.out.println(result);
	}
}
