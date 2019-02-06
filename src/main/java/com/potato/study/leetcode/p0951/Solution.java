package com.potato.study.leetcode.p0951;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 	951. Flip Equivalent Binary Trees
 *  
 *       For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Write a function that determines whether two binary trees are flip equivalent.  The trees are given by root nodes root1 and root2.



Example 1:

Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.
Flipped Trees Diagram


Note:

Each tree will have at most 100 nodes.
Each value in each tree will be a unique integer in the range [0, 99].
 *
 *         题目含义：
 *
 *
 *          思路：
 *          https://blog.csdn.net/u011732358/article/details/84790975
 *          也可以不旋转
 *          判断两棵树 是否是翻转相等的
 *          遍历 每次返回每个节点的比较结果
 *
 *
 */
public class Solution {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) {
            return true;
        } else if (null != root1 && null != root2) {
            if (root1.val == root2.val) {
                return (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
                        || (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ;
            }
        } else {
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root1 = TreeNodeUtil.generateTreeByArrayString("[1,2,3,4,5,6,null,null,null,7,8]");
        TreeNode root2 = TreeNodeUtil.generateTreeByArrayString("[1,3,2,null,6,4,5,null,null,null,null,8,7]");
        boolean result = solution.flipEquiv(root1, root2);
        System.out.println(result);
    }

}
