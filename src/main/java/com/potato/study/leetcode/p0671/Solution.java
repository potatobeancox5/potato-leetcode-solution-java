package com.potato.study.leetcode.p0671;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *         671. Second Minimum Node In a Binary Tree
 * 
 *         Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:

Input:
2
/ \
2   5
/ \
5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.


Example 2:

Input:
2
/ \
2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 *
 *
 *
 *         思路：
 *
 *
 *
 */
public class Solution {

    public int findSecondMinimumValue(TreeNode root) {
        int leftMin = findSeconeMinValue(root.left, root.val);
        int rightMin = findSeconeMinValue(root.right, root.val);
        return judgeTheMin(leftMin, rightMin);

    }

    private int judgeTheMin(int leftMin, int rightMin) {
        if (leftMin != -1 && rightMin != -1) {
            return Math.min(leftMin, rightMin);
        } else if (leftMin != -1) {
            return leftMin;
        } else if (rightMin != -1) {
            return rightMin;
        } else {
            return -1;
        }
    }

    private int findSeconeMinValue (TreeNode node, int fatherVal) {
        if (node == null) {
            return -1;
        }
        if (node.val > fatherVal) {
            return node.val;
        } else if (node.val == fatherVal) {
            int leftMin = findSeconeMinValue(node.left, node.val);
            int rightMin = findSeconeMinValue(node.right, node.val);
            return judgeTheMin(leftMin, rightMin);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int value = solution.findSecondMinimumValue(null);
        System.out.println(value);
    }
}
