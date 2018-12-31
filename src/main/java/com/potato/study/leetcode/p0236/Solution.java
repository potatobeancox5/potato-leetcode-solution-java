package com.potato.study.leetcode.p0236;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *      236. Lowest Common Ancestor of a Binary Tree
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

_______6______
/              \
___2__          ___8__
/      \        /      \
0      _4       7       9
/  \
3   5
Example 1:

Input: root, p = 2, q = 8
Output: 6 
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root, p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself 
according to the LCA definition.
 * 
 * 思路：寻找两个节点的公共祖先 普通二叉树
 *  递归查找pq
 *  0. root == null 返回null 用于标记没有找到
 *  1. 当前root 是pq 中的某一个 返回root
 *  2. 否则 左孩子中找两个节点 看看能不能找到 and 右孩子中找两个节点 看看能不能找到
 *      left right 都找到了 不为null 返回当前root
 *      否则 left == null 返回right
 *      left == null 返回left
 * https://blog.csdn.net/fumier/article/details/47903037
 * 二叉树与二叉搜索树区别
 * https://www.cnblogs.com/eudiwffe/p/6207196.html
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q); // 使用null 来标记没有找到
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q); // 记录左右孩子是否有值
        if (leftResult != null && rightResult != null) { // 真正记在这返回
            return root;
        } else if (leftResult != null) {
            return leftResult;
        } else if (rightResult != null) {
            return rightResult;
        }
        return null;
    }
	
    public static void main(String[] args) {
	}
}
