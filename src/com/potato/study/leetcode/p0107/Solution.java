package com.potato.study.leetcode.p0107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 107. Binary Tree Level Order Traversal II
 * 
 *         
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 *       
]
 *
 *         思路： 二叉树的层序遍历 (反向输出)
 *         一种简单的想法 利用之前的层序遍历 构造结果时，采用从头部插入的方式进行
 *         
 */
public class Solution {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
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
//				result.add(thisLayerResult);
				result.add(0, thisLayerResult);
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
 		List<List<Integer>> result = solution.levelOrderBottom(root);
		System.out.println(result);	
	}
}
