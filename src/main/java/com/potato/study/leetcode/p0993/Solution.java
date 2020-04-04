package com.potato.study.leetcode.p0993;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	  993. Cousins in Binary Tree
 *  
 *         WIn a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.



Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false


Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
 *         
 *         思路：
 *
 *          https://www.cnblogs.com/douzujun/p/10922786.html
 *          https://gist.github.com/karlbishnu/a3f879d4c69813e5776269c50fa39e2f
 *
 */
public class Solution {


    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // 本层是否有xy 呢
            boolean hasX = false;
            boolean hasY = false;
            // 遍历本层查找下层
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (checkIsSameParent(node, x, y)) {
                    return false;
                }

                hasX = hasX || x == node.val;
                hasY = hasY || y == node.val;
            }


            // 该层遍历结束
            if (hasX || hasY) {
                // 相等都是 true 确实是 表兄弟
                return hasX == hasY;
            }
        }


        return false;
    }


    /**
     * 检查xy 是否是 parent 的孩子
     * @param parent
     * @param x
     * @param y
     * @return
     */
    private boolean checkIsSameParent(TreeNode parent, int x, int y) {
        if (parent == null || parent.left == null || parent.right == null) {
            return false;
        }
        if ( parent.left.val == x &&  parent.right.val == y) {
            return true;
        }
        if ( parent.left.val == y &&  parent.right.val == x) {
            return true;
        }
        return false;
    }


	public static void main(String[] args) {
    }
}
