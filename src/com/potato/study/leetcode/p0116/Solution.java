package com.potato.study.leetcode.p0116;

import com.potato.study.leetcode.domain.TreeLinkNode;

/**
 * 
 * @author liuzhao11
 * 116. Populating Next Right Pointers in Each Node
 * 
 * Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

 *         思路： 使用递归进行层序遍历
 *         先根遍历树
 *         
 *         由于任何一个数均是满二叉树，所以，有左孩子一定存在右孩子
 *         存在左孩子 root.left.next = root.right   
 *         root.next == null ?
 *         root.right.next = root.next.left 或者null 
 */
public class Solution {

	
	public void connect(TreeLinkNode root) {
		// 处理当前节点
        if(root == null) {
        	return;
        }
        if(root.left == null) {
        	return;
        }
        root.left.next = root.right;
        if(root.next != null) {
        	root.right.next = root.next.left;
        }
        //处理左孩子
        connect(root.left);
        //处理右孩子
        connect(root.right);
    }

	public static void main(String[] args) {
//		 Solution solution = new Solution();
	}
}
