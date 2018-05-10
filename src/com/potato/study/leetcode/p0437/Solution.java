package com.potato.study.leetcode.p0437;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *   437. Path Sum III
 * 
 *   You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 * 			
 *     思路：	先序遍历 整个树 然后用 sum 减去 当前节点 的val 或者从这个节点开始遍历
 *     		当等于0 时 返回1 + 左右子树的遍历结果
 *     		否则  递归遍历左右子树 求和
 *     		达到指定的sum后 还需要继续查找 直到找到叶节点
 *     
 * 			
 * 	
 */	
public class Solution {
	
	/**
	 * 遍历每个节点 分别以每个节点为起点 开始查找 医用有多少个组合
	 * @param root
	 * @param sum
	 * @return
	 */
	public int pathSum(TreeNode root, int sum) {
		if(null == root) {
			return 0;
		} 
		int nums = pathSumWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
		return nums;
    }
	
	/**
	 * 递归查找 以root为顶点  path = sum 的数量
	 * @param root
	 * @param sum
	 * @return
	 */
	public int pathSumWithRoot(TreeNode root, int sum) {
		if(null == root) {
			return 0;
		}
		if(sum - root.val == 0) {
			return 1 + pathSumWithRoot(root.left, sum - root.val) + pathSumWithRoot(root.right, sum - root.val);
		} else {
			return pathSumWithRoot(root.left, sum - root.val) + pathSumWithRoot(root.right, sum - root.val);
		}
    }
	
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		//1,null,2,null,3,null,4,null,5
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		root.right.right.right.right = new TreeNode(5);
		int sum = 3;
		int num = solution.pathSum(root, sum);
		System.out.println(num);
	}
}
