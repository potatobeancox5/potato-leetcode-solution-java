package com.potato.study.leetcode.p0117;

import com.potato.study.leetcode.domain.TreeLinkNode;

/**
 * 
 * @author liuzhao11
 * 117. Populating Next Right Pointers in Each Node II
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
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL

			与116区别在于没有规定该数一定是满二叉树
 *         思路： 使用递归进行层序遍历  直接修不行 因为正常遍历的时候存在条节点的情况 会导致有的节点没有被完全设置
 *         	上面这个问题是因为左子树的生成依赖于上一层的右子树的生产 那么我们先递归右子树就可以将其解决
 *         先根遍历树
 *         存在左孩子    
 *         		存在有孩子root.left.next = root.right   
 *         		不存在右孩子 p = root.next while p!= null 
 *         					p存在左孩子 那么 root.left.next = p.left; break;
 *         					p存在右孩子 那么 root.left.next = p.left; break;
 *         					p没有左右孩子 p = p.next
 *         存在右孩子
 *         		p = root.next while p!= null 
 *         					p存在左孩子 那么 root.left.next = p.left; break;
 *         					p存在右孩子 那么 root.left.next = p.left; break;
 *         					p没有左右孩子 p = p.next
 *         root.next == null ?
 *         root.right.next = root.next.left 或者null 
 */
public class Solution {

	
	public void connect(TreeLinkNode root) {
		// 处理当前节点
        if(root == null) {
        	return;
        }
        if(root.left == null && root.right == null) {
        	return;
        }
        if(root.left != null && root.right != null) {
        	// 设置左孩子
        	root.left.next = root.right;
        	// 设置右孩子
        	TreeLinkNode p = root.next;
        	while(p != null) {
        		if(p.left != null ) { // 有左孩子
        			root.right.next = p.left;
        			break;
        		} else if(p.right != null) { // 没有左孩子 只有右孩子
        			root.right.next = p.right;
        			break;
        		} else { // 没有孩子
        			p = p.next;
        		}
        	}
        } else { // 左右孩子有一个孩子空缺
        	TreeLinkNode child = (root.left != null ? root.left : root.right);
        	TreeLinkNode p = root.next;
        	while(p != null) {
        		if(p.left != null ) { // 有左孩子
        			child.next = p.left;
        			break;
        		} else if(p.right != null) { // 没有左孩子 只有右孩子
        			child.next = p.right;
        			break;
        		} else { // 没有孩子
        			p = p.next;
        		}
        	}
        	
        }
        //处理右孩子
        connect(root.right);
        //处理左孩子
        connect(root.left);
    }

	public static void main(String[] args) {
//		 MyCalendarThree solution = new MyCalendarThree();
		 
	}
}
