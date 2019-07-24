package com.potato.study.leetcode.p0687;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *         687. Longest Univalue Path
 * 
 *         GGiven a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.



Example 1:

Input:

5
/ \
4   5
/ \   \
1   1   5
Output: 2



Example 2:

Input:

1
/ \
4   5
/ \   \
4   4   5
Output: 2



Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 *
 *         思路：
 *
 *
 *
 *
 */
public class Solution {

    private int maxCount = 0;

    public int longestUnivaluePath(TreeNode root) {
        getLongestUnivalueOfThisNode(root);
        return maxCount;
    }

    /**
     * 获取这个节点作为根节点，连续的节点个数
     * @return
     */
    private int getLongestUnivalueOfThisNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 后续遍历获取子节点的连续的个数
        int leftChildNum = getLongestUnivalueOfThisNode(root.left);
        int rightChildNum = getLongestUnivalueOfThisNode(root.right);
        // 判断自节点是否与当前节点相同
        if (root.left != null && root.val == root.left.val
                && root.right != null && root.val == root.right.val) {
            maxCount = Math.max(maxCount, leftChildNum + rightChildNum);
        }
        // 不相同 重置当前节点自节点的值
        if (root.left != null && root.val != root.left.val) {
            leftChildNum = 0;
        }
        if (root.right != null && root.val != root.right.val) {
            rightChildNum = 0;
        }
        maxCount = Math.max(maxCount, Math.max(leftChildNum, rightChildNum));
        return Math.max(leftChildNum, rightChildNum) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getLongestUnivalueOfThisNode(null);
    }

}
