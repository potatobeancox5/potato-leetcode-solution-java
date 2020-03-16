package com.potato.study.leetcode.p1382;


import com.potato.study.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1382. Balance a Binary Search Tree
 *  
 *
Given a binary search tree, return a balanced binary search tree with the same node values.

A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.



Example 1:



Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.


Constraints:

The number of nodes in the tree is between 1 and 10^4.
The tree nodes will have distinct values between 1 and 10^5.
 *         
 *         思路：
 *          将一个二叉树 转换成平衡的
 *
 *          1. 中序遍历二叉树，并序列化成一个 list
 *
 *          2. 将list 还原成bst
 *
 *          https://leetcode.com/problems/balance-a-binary-search-tree/discuss/539686/JavaC%2B%2B-Sorted-Array-to-BST-O(N)-Clean-code

 *
 */
public class Solution {


    private List<Integer> sortedList = new ArrayList<>();


    public TreeNode balanceBST(TreeNode root) {
        inorderTraverse(root);
        return rebuildBst(0, sortedList.size() - 1);
    }

    /**
     * 重建二叉树
     * @param i     最小节点
     * @param j     最大节点
     * @return
     */
    private TreeNode rebuildBst(int i, int j) {

        if (i > j) {
            return null;
        }

        int mid = (i+j) / 2;
        TreeNode node = new TreeNode(sortedList.get(mid));
        node.left = rebuildBst(i, mid - 1);
        node.right = rebuildBst(mid + 1, j);

        return node;
    }

    /**
     * 中序遍历二叉树并将结果放入list中
     * @param root
     */
    private void inorderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }
        inorderTraverse(root.left);
        sortedList.add(root.val);
        inorderTraverse(root.right);
    }

    public static void main(String[] args) {
    }
}
