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
 *
 *
 */
public class Solution {

    public TreeNode trimBST(TreeNode root, int L, int R) {

        return null;
    }
}
