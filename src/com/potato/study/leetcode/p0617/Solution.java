package com.potato.study.leetcode.p0617;

import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         617. Merge Two Binary Trees
 * 
 *         Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
Note: The merging process must start from the root nodes of both trees.
 * 
 *         思路：分别先序遍历节点 如果都有的话 节点值 为两个节点之和 递归遍历左子树 右子树 返回结果等于 之前节点左孩子和右孩子
 *         TreeNode node = 如果都有的话 节点值 为两个节点之和 否则有哪个就是那个 否则返回null
 *         不返回null时node。left = mergeTrees(TreeNode t1, TreeNode t2)
 *         node。right = mergeTrees(TreeNode t1, TreeNode t2)
 */
public class Solution { 
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 != null && t2 != null) {
        	TreeNode head = new TreeNode(t1.val + t2.val);
        	head.left = mergeTrees(t1.left, t2.left);
			head.right = mergeTrees(t1.right, t2.right);
        	return head;
        } else if (t1 != null) {
			TreeNode head = new TreeNode(t1.val);
			head.left = mergeTrees(t1.left, null);
			head.right = mergeTrees(t1.right, null);
			return head;
		} else if (t2 != null) {
			TreeNode head = new TreeNode(t2.val);
			head.left = mergeTrees(null, t2.left);
			head.right = mergeTrees(null, t2.right);
			return head;
		} else { // t1 ==null && t2 == null
			return null;
		}
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode t1 = null;
		TreeNode t2 = null;
		TreeNode head = solution.mergeTrees(t1, t2);
		TreeNodeUtil.printBSTTreeNodeInArrayString(head, 3);
	}
}
