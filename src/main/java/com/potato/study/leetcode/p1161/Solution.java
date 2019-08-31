package com.potato.study.leetcode.p1161;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1161. Maximum Level Sum of a Binary Tree
 *  
 *
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.



Example 1:



Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.


Note:

The number of nodes in the given tree is between 1 and 10^4.
-10^5 <= node.val <= 10^5
 *         
 *         思路：
 *         层序遍历 求最大层的index(从1开始计数)
 *
 *

 *
 */
public class Solution {

    public int maxLevelSum(TreeNode root) {
        int thisLayerNodeCount = 1;
        int nextLayerNodeCount = 0;
        int maxSum = 0;
        int maxLayerIndex = 0;
        int thisLayerSum = 0;
        int thisLayerIndex = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            thisLayerSum += node.val;
            thisLayerNodeCount--;
            // 将孩子加入下一层计数的队列中
            if (node.left != null) {
                queue.add(node.left);
                nextLayerNodeCount++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLayerNodeCount++;
            }
            if (thisLayerNodeCount == 0) {
                // 当前层遍历完了最后一个节点 可以进行计数
                if (maxSum < thisLayerSum) {
                    maxSum = thisLayerSum;
                    maxLayerIndex = thisLayerIndex;
                }
                // 重设初始值
                thisLayerSum = 0;
                thisLayerIndex++;
                thisLayerNodeCount = nextLayerNodeCount;
                nextLayerNodeCount = 0;
            }

        }
        return maxLayerIndex;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(7);
        root.left = root1;
        TreeNode root2 = new TreeNode(0);
        root.right = root2;

        TreeNode root3 = new TreeNode(7);
        root1.left = root3;
        TreeNode root4 = new TreeNode(11);
        root1.right = root4;


        int res = solution.maxLevelSum(root);
        System.out.println(res);
    }
}
