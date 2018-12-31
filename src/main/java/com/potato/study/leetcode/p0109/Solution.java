package com.potato.study.leetcode.p0109;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.domain.TreeNode;
import com.potato.study.leetcode.util.ListNodeUtil;
import com.potato.study.leetcode.util.TreeNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 109. Convert Sorted List to Binary Search Tree
 * 
 *         
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 *       
]
 *
 *     思路：
 *     https://www.cnblogs.com/warmland/p/6018133.html
 *     还是需要使用left 和 right 来控制左右两边树的平衡 
 *     由于给定的是列表结构，对于每个链表节点 要确定位置 然后在将链表指针后移 完成构建
 *     寻找当前点应该安放的位置 通过left和right 来确定当前node 应该何时安放
 *         
 */
public class Solution {

	public ListNode cur;
	
	public TreeNode sortedListToBST(ListNode head) {
        //计算有多长
		this.cur = head;
		ListNode p = head;
		int len = 0;
		while(null != p) {
			len++;
			p = p.next;
		}
		return createBSt(0, len - 1);
    }
	
	/**
	 * 使用left和right确定操作
	 * left == right 
	 * 说明当前node指向的节点就是root节点 且 没有孩子
	 * left>right 
	 * 说明 当前node 指向的节点 
	 * 不在当前这颗子树中 直接返回null
	 * left<right 当前node位于这个子树中 但是还没到放置的位置
	 * @param left
	 * @param right
	 * @return
	 */
	private TreeNode createBSt(int left, int right) {
		if (left > right) {
			return null;
		}
		if(left == right) {
			int val = this.cur.val;
			this.cur = this.cur.next;
			return new TreeNode(val);
		}
		// 先往左孩子移动，然后生成本身节点
		int mid = left + (right - left) / 2;
		TreeNode leftChild = createBSt(left, mid - 1);
		TreeNode root = new TreeNode(this.cur.val);
		this.cur = this.cur.next;
		root.left = leftChild;
		root.right = createBSt(mid + 1, right);
		return root;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode list = ListNodeUtil.stringToListNode("-10->-3->0->5->9");
		TreeNode root = solution.sortedListToBST(list);
		TreeNodeUtil.printBSTTreeNodeInArrayString(root, 3);
	}
}
