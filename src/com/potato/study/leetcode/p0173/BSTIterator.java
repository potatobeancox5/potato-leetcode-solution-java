package com.potato.study.leetcode.p0173;

/**
 * 
 * @author liuzhao11
 * 
 *    173. Binary Search Tree Iterator
 *         
 *          
 *  Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.



 *
 *         依次返回最小的数字
 *         思路：
 *          用一个栈记录
 *          首先将根节点和所有的左孩子以及左孩子的左孩子入栈
 *          next的时候 将当前节点出栈 然后将对应的左孩子以及左边节点一次进展
 *
 *         
 *        
 */

import com.potato.study.leetcode.domain.TreeNode;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        // 左子树以及做孩子都进栈
        stack = new Stack<>();
        TreeNode p = root;
        while(p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if(node.right != null) {
            TreeNode p = node.right;
            while(p != null) {
                stack.push(p);
                p = p.left;
            }
        }
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
