package com.potato.study.leetcode.p0513;

import com.potato.study.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 *         513. Find Bottom Left Tree Value
 * 
 *         Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

2
/ \
1   3

Output:
1
Example 2:
Input:

1
/ \
2   3
/   / \
4   5   6
/
7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.


 * 
 * 
 *         思路：
 *          层序遍历
 *
            https://blog.csdn.net/cloudox_/article/details/60866956
 *          
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode firstNode = root;
        int currentLayerCount = 1;
        int nextLayerCount = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            currentLayerCount--;
            if (currentNode.left != null) {
                queue.add(currentNode.left);
                nextLayerCount++;
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
                nextLayerCount++;
            }
            // 处理最后每层最后一个节点带来的问题
            if (currentLayerCount == 0) {
                if (!queue.isEmpty()) {
                    firstNode = queue.peek();
                }
                currentLayerCount = nextLayerCount;
                nextLayerCount = 0;
            }
        }
        return firstNode.val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        int value = solution.findBottomLeftValue(root);
        System.out.println(value);
    }
}
