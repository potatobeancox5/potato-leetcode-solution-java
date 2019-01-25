package com.potato.study.leetcode.p0814;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	814. Binary Tree Pruning
 *  
 *         We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

Example 1:
Input: [1,null,0,0,1]
Output: [1,null,0,null,1]

Explanation:
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.


Example 2:
Input: [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]



Example 3:
Input: [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]



Note:

The binary tree will have at most 100 nodes.
The value of each node will only be 0 or 1.
 *         
 *         思路：
 *          先对子树进行遍历处理，在处理当前节点
 *          后序遍历一个二叉树
 *              当前节点是叶子节点且几点值为0 返回null
 *                  否则直接返回
 *              当前节点不是叶子节点
 *                  当前节点的左孩子 等于 递归省略掉左子树的节点
 *                  当前节点的右孩子 等于 递归省略掉右子树的节点
 * 
 */
public class Solution {

    public TreeNode pruneTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        // 非叶子节点 递归对左右化简
        if (root.left != null) {
            root.left = pruneTree(root.left);
        }
        if (root.right != null) {
            root.right = pruneTree(root.right);
        }
        // 处理当前节点 叶子节点 可以结束遍历，直接返回
        if (root.left == null && root.right == null) {
            if (root.val == 0) {
                return null;
            } else {
                return root;
            }
        }
        return root;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
//        int result = solution.pruneTree(grid);
//        System.out.println(result);
    }
}
