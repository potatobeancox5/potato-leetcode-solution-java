package com.potato.study.leetcode.p0894;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhao11
 * <p>
 * 894. All Possible Full Binary Trees
 * <p>
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 * <p>
 * Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
 * <p>
 * Each node of each tree in the answer must have node.val = 0.
 * <p>
 * You may return the final list of trees in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 7
 * Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 20
 * <p>
 * <p>
 * 题目含义：
 * <p>
 * 思路：穷举法
 */
public class Solution {

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (n % 2 == 0) {
            // 偶数不可能是全二叉树
            return allTrees;
        }
        // 构造当前节点
        if (n == 1) {
            TreeNode currentNode = new TreeNode(0);
            allTrees.add(currentNode);
            return allTrees;
        }
        // 构造二叉树
        for (int i = 1; i <= n - 1; i = i + 2) {
            // 控制左子树 节点数目
            List<TreeNode> leftChildTreeNodes = allPossibleFBT(i);
            List<TreeNode> rightChildTreeNodes = allPossibleFBT(n - 1 - i);
            for (TreeNode left : leftChildTreeNodes) {
                for (TreeNode right : rightChildTreeNodes) {
                    TreeNode currentNode = new TreeNode(0);
                    currentNode.left = left;
                    currentNode.right = right;
                    allTrees.add(currentNode);
                }
            }
        }
        return allTrees;
    }


    public static void main(String[] args) {
//		Solution solution = new Solution();
    }
}
