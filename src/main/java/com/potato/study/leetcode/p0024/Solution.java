package com.potato.study.leetcode.p0024;


import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * 24. Swap Nodes in Pairs
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * 思路 ：交换数字链表相邻的两个节点 且不能改值
 * 
 * 
 * @author Administrator
 *
 */
public class Solution {
	
	public ListNode swapPairs(ListNode head) {
		// 移动 首对节点 
		if(null == head) {
			return head;
		}
		ListNode p = head;
		ListNode q = head.next;
		ListNode pre = p;
		if(q == null) {
			return head;
		}
		head = head.next;
		p.next = q.next;
		q.next = p;
		p = p.next;
		if(p == null) {
			return head;
		}
		q = p.next;
		// 移动之后的节点
		while(p!=null && q!=null) {
			p.next = q.next;
			q.next = p;
			pre.next = q;
			pre = p;
			p = p.next;
			if(p == null) {
				return head;
			}
			q = p.next;
		}
        return head;
    }
	
	/**
	 * nb闪闪的递归做法
	 * @param args
	 */
	public ListNode swapPairss(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}else{
			ListNode second = head.next;
			head.next = swapPairss(second.next);
			second.next = head;
			return second;
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int [] arr = {1,2,3,4};
//		int [] arr = {1,2,3};
		int [] arr = {1};
		ListNode head = ListNodeUtil.intArrayToListNode(arr);
		ListNode newLink = solution.swapPairs(head);
		ListNodeUtil.printListNode(newLink);
	}
}
