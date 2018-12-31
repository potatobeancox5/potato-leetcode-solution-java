package com.potato.study.leetcode.p0148;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *      148. Sort List
 *         
 *          
 *   Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 *
 *         题目需求：
 *         链表排序 归并排序 递归版
 *         1. 找到当前链表中间节点
 *         2. 断开链表
 *         3. 对每一段排序（递归）
 *		   4. 合并两个链表
 *         思路：
 *
 */
public class Solution {

	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
//		1. 找到当前链表中间节点
		ListNode firstHead = head;
		ListNode middleNode = this.findMiddleNode(head);
		ListNode secondHead = middleNode.next;
//		2. 断开链表
		middleNode.next = null;
//		3. 对每一段排序（递归）
		firstHead = sortList(firstHead);
		secondHead = sortList(secondHead);
//		4. 合并两个链表
		return mergeSoredList(firstHead, secondHead);
	}

	/**
	 * 找到中间点
	 * odd fast 会保证每次都会走两步 直到走完 返回中间的那个点
	 * even fast途中就端了 返回中间的两个点前面的那个点
	 * @param head
	 * @return
	 */
	private ListNode findMiddleNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null) {
			fast = fast.next;
			if(fast.next == null) {
				break;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	/**
	 * 按照升序 合并两个链表 合并后链表是有序的
	 * @param first
	 * @param second
	 * @return
	 */
	private ListNode mergeSoredList(ListNode first, ListNode second) {
		ListNode head = new ListNode(555);
		ListNode p = first;
		ListNode q = second;
		ListNode current = head;

		while(p != null && q != null) {
			if(p.val <= q.val) {
				current.next = p;
				current = current.next;
				p = p.next;

			} else {
				current.next = q;
				current = current.next;
				q = q.next;
			}
		}
		if(p == null) {
			current.next = q;
		} else if(q == null) {
			current.next = p;
		}
		return head.next;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] arr = {4,2,1};
		ListNode head = ListNodeUtil.intArrayToListNode(arr);
		head = solution.sortList(head);
		ListNodeUtil.printListNode(head);

	}
}
