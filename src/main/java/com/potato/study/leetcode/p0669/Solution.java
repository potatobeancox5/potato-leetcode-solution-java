package com.potato.study.leetcode.p0669;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *         669. Trim a Binary Search Tree
 * 
 *         Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input:
1
/ \
0   2

L = 1
R = 2

Output:
1
\
2
Example 2:
Input:
3
/ \
0   4
\
2
/
1

L = 1
R = 3

Output:
3
/
2
/
1
 *
 *
 *
 *         思路：
 *          https://blog.csdn.net/hlljjy123/article/details/77895747
            递归修剪 是的所有的数字在这之间
            递归删除
                如果当前节点值小于 L 说明当前节点以及左子树的节点也都可以删除了 直接返回递归右子树的结果
                如果当前节点值大于 R 说明当前节点以及右子树的节点也都可以删除了 直接返回递归左子树的结果
                当前节点 L <= 当前节点值 <= R 说明当前节点可以留下，递归清理左子树和右子树，返回当前节点
 *
 *
 */
public class Solution {

    public TreeNode trimBST(TreeNode root, int left, int right) {
        if (null == root) {
            return root;
        }
        if (root.val < left) {
            return trimBST(root.right, left, right);
        }
        if (root.val > right) {
            return trimBST(root.left, left, right);
        }
        // 当前节点 L <= 当前节点值 <= R 说明当前节点可以留下，递归清理左子树和右子树，返回当前节点
        root.left =  trimBST(root.left, left, right);
        root.right = trimBST(root.right, left, right);
        return root;
    }
}
