package com.potato.study.leetcode.p0968;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	968. Binary Tree Cameras
 *  
 *      Given a binary tree, we install cameras on the nodes of the tree.

Each camera at a node can monitor its parent, itself, and its immediate children.

Calculate the minimum number of cameras needed to monitor all nodes of the tree.



Example 1:


Input: [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
Example 2:


Input: [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

Note:

The number of nodes in the given tree will be in the range [1, 1000].
Every node has value 0.

 *         
 *         题目含义：
 *              先序列遍历整个树能被最少的camera覆盖
 *         思路：
 *              https://blog.csdn.net/fuxuemingzhu/article/details/85987492
 *          贪心算法
 *              https://www.cnblogs.com/ethanhong/p/10200550.html
 *
 *          https://leetcode-cn.com/problems/binary-tree-cameras/solution/jian-kong-er-cha-shu-by-leetcode-2/
 *
 *
 *
 *
 * 
 */
public class Solution {

    public int minCameraCover(TreeNode root) {
        int[] ans = solve(root);
        return Math.min(ans[1], ans[2]);
    }

    // 0: Strict ST; All nodes below this are covered, but not this one
    // 1: Normal ST; All nodes below and incl this are covered - no camera
    // 2: Placed camera; All nodes below this are covered, plus camera here
    public int[] solve(TreeNode node) {
        if (node == null)
            return new int[]{0, 0, 99999};

        int[] left = solve(node.left);
        int[] right = solve(node.right);
        int mL12 = Math.min(left[1], left[2]);
        int mR12 = Math.min(right[1], right[2]);

        int d0 = left[1] + right[1];
        int d1 = Math.min(left[2] + mR12, right[2] + mL12);
        int d2 = 1 + Math.min(left[0], mL12) + Math.min(right[0], mR12);
        return new int[]{d0, d1, d2};
    }




    public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode head = null;
        int i = solution.minCameraCover(head);
        System.out.println(i);
    }
}
