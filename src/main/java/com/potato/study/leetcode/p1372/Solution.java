package com.potato.study.leetcode.p1372;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	1372. Longest ZigZag Path in a Binary Tree
 *  
 *
Given a binary tree root, a ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right then move to the right child of the current node otherwise move to the left child.
Change the direction from right to left or right to left.
Repeat the second and third step until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.



Example 1:



Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
Example 2:



Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
Example 3:

Input: root = [1]
Output: 0


Constraints:

Each tree has at most 50000 nodes..
Each node's value is between [1, 100].
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/longest-zigzag-path-in-a-binary-tree/solution/javazi-di-xiang-shang-shu-xing-dp-by-jackie-tien/
 *
 */
public class Solution {

    private int maxPath = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    private int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = 1 + left[1];
        res[1] = 1 + right[0];
        maxPath = Math.max(maxPath, Math.max(res[0], res[1]));
        return res;
    }

}