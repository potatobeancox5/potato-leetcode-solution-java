package com.potato.study.leetcode.p0654;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *         654. Maximum Binary Tree
 * 
 *         Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

6
/   \
3     5
\    /
2  0
\
1
Note:
The size of the given array will be in the range [1,1000].
 * 
 *         思路：
 *
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return this.constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        if (left > right) {
            return null;
        }

        // 找最大值 index
        int maxIndex = left;
        for (int i = left; i <= right ; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        // 创建节点
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = this.constructMaximumBinaryTree(nums, left, maxIndex - 1);
        root.right = this.constructMaximumBinaryTree(nums, maxIndex + 1, right);
        return root;
    }

	
	public static void main(String[] args) {
//		Solution solution = new Solution();
    }
}
