package com.potato.study.leetcode.p1373;


import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	1373. Maximum Sum BST in Binary Tree
 *  
 *
Given a binary tree root, the task is to return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:



Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20
Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
Example 2:



Input: root = [4,3,null,1,2]
Output: 2
Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
Example 3:

Input: root = [-4,-2,-5]
Output: 0
Explanation: All values are negatives. Return an empty BST.
Example 4:

Input: root = [2,1,3]
Output: 6
Example 5:

Input: root = [5,4,8,3,null,6,3]
Output: 7


Constraints:

The given binary tree will have between 1 and 40000 nodes.
Each node's value is between [-4 * 10^4 , 4 * 10^4].
 *         
 *         思路：
 *
 *
 *          https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/solution/shen-du-you-xian-sou-suo-zui-you-jie-yi-ding-zai-b/
 *
 */
public class Solution {

    public int maxSumBST(TreeNode root) {
        int[] res = {0};
        maxSumBST(res, root);
        return res[0];
    }

    /**
     * 判断root为根节点的树是否是二叉搜索树
     *
     * @param root root节点
     * @param min  最小值
     * @param max  最大值
     * @return 是否是二叉搜索树
     */
    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        return min < root.val && root.val < max && isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    /**
     * 求节点和的最大值
     *
     * @param res res
     * @param node node
     * @return 较大节点和
     */
    private void maxSumBST(int[] res, TreeNode node) {
        // 这个节点是BST，直接求和了
        if (isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            // 是二叉搜索树，求节点和，节点和的最优解，肯定在子节点求和的过程中
            sumNodeValue(res, node);
            return;
        }
        // 不是BST，递归进入左右子树
        maxSumBST(res, node.left);
        maxSumBST(res, node.right);
    }

    /**
     * 以node为root的节点求和
     *
     * @param res  结果集
     * @param node node
     * @return 节点之和
     */
    private int sumNodeValue(int[] res, TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 二叉搜索树节点和的最大值，一定在子节点中会出现
        int sum = node.val + sumNodeValue(res, node.left) + sumNodeValue(res, node.right);
        // 这里记录结果的最大值
        res[0] = Math.max(res[0], sum);
        return sum;
    }


}
