package com.potato.study.leetcode.p0938;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 	938. Range Sum of BST
 *  
 *       Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.



Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23


Note:

The number of nodes in the tree is at most 10000.
The final answer is guaranteed to be less than 2^31.
 *         
 *         题目含义：
 *          给一个二叉排序树，求从l到r之间的数字的和，包括l 和 r
 *
 *         思路：
 *          bst的中序遍历是有序的，判断
 *
 *
 * 
 */
public class Solution {


    public int rangeSumBST(TreeNode root, int l, int r) {
        if (root == null) {
            return 0;
        }
        // 遍历左子树
        int sum = 0;
        int leftSum = rangeSumBST(root.left, l, r);
        // 处理当前节点
        if (root.val > r) {
//            return 0;
        } else if (root.val < l) {
        } else { // 应该计算和 l <= val <= r
            sum += root.val;
        }
        // 遍历右子树
        int rightSum = rangeSumBST(root.right, l, r);
        return leftSum + sum + rightSum;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = TreeNodeUtil.generateTreeByArrayString("[10,5,15,3,7,null,18]");
        int result = solution.rangeSumBST(root, 7, 15);
        System.out.println(result);
    }
}
