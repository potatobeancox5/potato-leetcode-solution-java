package com.potato.study.leetcode.p0143;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         143. Reorder List
 *         
 *          
 *       Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 *         题目需求：
 *			打乱一个单链表的顺序
 *
 *         思路：
 *			找到中间节点，断开，把后半截单链表 reverse倒置 一下，再合并两个单链表。
 *
 *
 *         
 * 
 */
public class Solution {

	public void reorderList(ListNode head) {
		if(null == head) {
			return;
		}
		// 找到中间点
		ListNode mid = this.findMiddleNode(head);
		if (mid.next == null) { // 一个节点
			return;
		}
		ListNode firstPartHead = head;
		ListNode secondPartHead = mid.next;
		// 断开
		mid.next = null;
		secondPartHead = this.reverse(secondPartHead); // secondPartHead 比 firstPartHead短
		// one by one 合并两个链表
		ListNode p = firstPartHead;
		ListNode q = secondPartHead;
		while (q != null) {
			ListNode pNext = p.next;
			ListNode qNext = q.next;
			p.next = q;
			p = pNext;
			q.next = p;
			q = qNext;
		}
		return;
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
	 * 倒置单链表
	 * @param head
	 * @return
	 */
	private ListNode reverse(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode p = head;
		ListNode pre = null;
		while (p != null) {
			ListNode s = p.next;
			p.next = pre;
			pre = p;
			p = s;
			if (s == null) {
				break;
			}
			s = s.next;
		}
		return pre;
	}


	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String str = "1->2->3->4->5->6->7";
		ListNode head = ListNodeUtil.stringToListNode(str);
		solution.reorderList(head);
		ListNodeUtil.printListNode(head);

	}
}
