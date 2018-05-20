package com.potato.study.leetcode.p0108;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 108. Convert Sorted Array to Binary Search Tree
 * 
 *         
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 *       
]
 *
 *         思路：
 *         https://www.cnblogs.com/yuanzhaoyi/p/5876268.html
 *         要满足一下条件，对于没有排序的数组来说，就比较麻烦，但对于已排序的数组，大都用二分递归转换方法来处理。

算法逻辑很简单，就是先找到中间元素，创建根节点，左右子树分别用中间元素左边（即小于中间节点的元素）和中间元素右边（即大于中间节点的元素）递归创建。

这样，节点的左子树永远比节点小，右子树永远比节点大，且由于平均递归创建每一层的子树，所以两个子树的高度差不会超过1。
 *         
 */
public class Solution {

	public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }
	
	private TreeNode createBST(int[] nums, int left, int right) {
		if(right < left) {
			return null;
		} 
		if(left == right) {
			return new TreeNode(nums[left]);
		}
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = createBST(nums, left, mid - 1);
		root.right = createBST(nums, mid + 1, right);
		return root;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {-10,-3,0,5,9};
		TreeNode root = solution.sortedArrayToBST(nums);
		TreeNodeUtil.printBSTTreeNodeInArrayString(root, 3);
	}
}
