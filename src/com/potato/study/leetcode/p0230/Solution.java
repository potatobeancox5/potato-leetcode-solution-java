package com.potato.study.leetcode.p0230;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 
 *      230. Kth Smallest Element in a BST
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
3
/ \
1   4
\
2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
5
/ \
3   6
/ \
2   4
/
1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
How would you optimize the kthSmallest routine?
 *
 * 题目解释：
 *  查找二叉搜索树中 第k小的值
 * 思路：
 *  利用bst性质 左 中 右 中序列遍历bst 使用count ++ 直到 count == k 返回节点
 *  
 */
public class Solution {

    private int count = 0;

    private int k = 0;

    private int value;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrderSeach(root);
        return value;
    }


    public void inOrderSeach(TreeNode root) {
        if (root.left != null) {
            inOrderSeach(root.left);
        }
        count++;
        if (count == k) {
            value = root.val;
            return;
        }
        if (root.right != null) {
            inOrderSeach(root.right);
        }
    }

}
