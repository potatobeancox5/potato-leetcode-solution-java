package com.potato.study.leetcode.p0206;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         206. Reverse Linked List
 * 
 * 			Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
 *         思路： 要求 即使用递归 又使用正常办法 对链表进行反转  
 * 
 */
public class Solution {
	
	//采用正常反转方法 
	// 封存原因 体感要求 还得用递归实现一次
//	public ListNode reverseList(ListNode head) {
//        if(head == null) {
//        	return head;
//        }
//        ListNode q = head;
//        if(q.next == null) { // 只有一个节点情况 直接返回
//        	return head;
//        }
//        ListNode p = q.next;
//        while(p != null) {
//        	ListNode k = p.next;
//        	p.next = q;
//        	q = p;
//        	p = k;
//        }
//        //改变头结点 next指针 （之前没有改变）
//        head.next = null;
//        head = q;
//        return head;
//    }
	
	public ListNode reverseList(ListNode head){
		if(head == null) {
        	return head;
        }
		if(head.next == null) {
			return head;
		}
		ListNode afterTail = new ListNode(-1);
		ListNode newHead = reverseElement(head, afterTail);
		afterTail.next.next = null;
		return newHead;
	}
	
	/**
	 * 递归倒转列表
	 * @param head			链表head
	 * @param afterTail		next指向倒转后的链表tail
	 * @return				倒转后的链表的head
	 */
	private ListNode reverseElement(ListNode head, ListNode afterTail) {
		if(head.next != null) {
			ListNode newHead = reverseElement(head.next, afterTail);
			afterTail.next.next = head;
			afterTail.next = afterTail.next.next;
			return newHead;
		} else {			
			//知道最后一个节点
			afterTail.next = head;
			return head;
		}
	}
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		String str = "1->2->3->4->5";
		ListNode head = ListNodeUtil.stringToListNode(str);
		ListNode newHead = solution.reverseList(head);
		ListNodeUtil.printListNode(newHead);
	}
}
