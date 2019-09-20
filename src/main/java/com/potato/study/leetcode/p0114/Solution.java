package com.potato.study.leetcode.p0114;


import java.util.LinkedList;
import java.util.Queue;

import com.potato.study.leetcode.domain.TreeNode;

/**
 * 
 * @author liuzhao11
 * 114. Flatten Binary Tree to Linked List
 * 
 * Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

 *         思路： 遍历先序遍历一遍树 并将比那里过的节点放到一个queue中 
 *         然后出队 将树节点连接起来
 *         
 *         另外一种解法
 *         https://www.cnblogs.com/nashiyue/p/5313767.html
 * 
 * 
 */
public class Solution {

	
	public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        visitTreeNode(root, queue);
        //出队生成新的树
        if(queue.isEmpty()) {
        	root = null;
        	return;
        }
        root = queue.remove();
        TreeNode pNode = root;
        while(!queue.isEmpty()) {
        	pNode.right = queue.remove();
        	pNode.left = null;
        	pNode = pNode.right;
        }
    }
	
	private void visitTreeNode(TreeNode root, Queue<TreeNode> queue) {
		if(root == null) {
			return;
		}
		queue.add(root);
		if(root.left != null) {
			visitTreeNode(root.left, queue);
		}
		if(root.right != null) {
			visitTreeNode(root.right, queue);
		}
	}

	public static void main(String[] args) {
//		 MyCalendarThree solution = new MyCalendarThree();
//		 solution.flatten(root);
	}
}
