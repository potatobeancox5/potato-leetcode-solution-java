package com.potato.study.leetcode.p0563;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         563. Binary Tree Tilt
 * 
 *         Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input:
1
/   \
2     3
Output: 1
Explanation:
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
Note:

The sum of node values in any subtree won't exceed the range of 32-bit integer.
All the tilt values won't exceed the range of 32-bit integer.
 * 
 * 
 *         思路：
 *
 *       
 *          
 */
public class Solution {

    private int totalSum = 0;

    public int findTilt(TreeNode root) {
        this.travselTreeNode(root);
        return totalSum;
    }

    private void travselTreeNode(TreeNode root) {
        if (root == null) {
            return;
        }
        int left = sumOfSubtree(root.left);
        int right = sumOfSubtree(root.right);
        totalSum += Math.abs(left - right);
        travselTreeNode(root.left);
        travselTreeNode(root.right);
    }



    private Map<TreeNode, Integer> sumCache = new HashMap<>();
    /**
     * 计算一侧树的值
     * @param root
     * @return
     */
    public int sumOfSubtree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (sumCache.get(root) != null) {
            return sumCache.get(root);
        }
        int sum = 0;
        sum += (root.val + sumOfSubtree(root.left) + sumOfSubtree(root.right));
        sumCache.put(root, sum);
        return sum;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        TreeNode root = null;
        int sum = solution.findTilt(root);
        System.out.println(sum);
    }
}
