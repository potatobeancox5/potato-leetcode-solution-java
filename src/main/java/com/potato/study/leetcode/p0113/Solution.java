package com.potato.study.leetcode.p0113;


import java.util.ArrayList;
import java.util.List;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 113. Path Sum II
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

 *         思路：  寻找指定叶节点 是否存在又跟到叶的一条路径 使得 路径的权值之和等于给定的值 记录当前的list路径
 *         采用递归的思想 
 *         初值条件 当前节点是叶节点 且 值等于给定值时 返回true 否则返回false
 *         递归查找左子树和右子树 sum - 当前value
 *         
 * 
 * 
 */
public class Solution {

	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		List<Integer> path = new ArrayList<>();
		path(root, sum, path, result);
		return result;
	}

	public void path(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) { // 到达叶子节点 返回
			if (root.val == sum) {
				path.add(root.val);
				result.add(new ArrayList<>(path));
				return;
			} else { // 不等
				return;
			}
		}
		List<Integer> leftPath = new ArrayList<>(path);
		leftPath.add(root.val);
		path(root.left, sum - root.val, leftPath, result);
		List<Integer> rightPath = new ArrayList<>(path);
		rightPath.add(root.val);
		path(root.right, sum - root.val, rightPath, result);
	}

	public static void main(String[] args) {
		// MyCalendarThree solution = new MyCalendarThree();

	}
}
