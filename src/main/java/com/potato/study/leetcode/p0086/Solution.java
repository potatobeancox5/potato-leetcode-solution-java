package com.potato.study.leetcode.p0086;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         86. Partition List
 *         
 *          
 *       Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
 * 
 *         思路：
 *         顺序找到第一个大于value的节点 申请一个新的节点node node。next指向这个节点
 *         	如果此时node。next指向null 正面所有的节点小于给定值 不用改变
 *         subHead = new Node 
 *         pSubHead = subHead
 *         q = node next    p = q.next 开始查找
 *         while p!=null
 *         	如果 p value 大于等于value p = p。next q = q.next
 *          如果 p value 小于 value 那么pSubHead .next =  p   
 *          		 pSubHead = pSubHead.next
 *   				 改变以前链表 
 *   				q.next = p.next 
 *   				p = p.next
 *  		最终如果subHead。next 不为空
 *  		判断node 是不是head 
 *  			是的话 直接将head = subHead。next  pSubHead.next = node.next
 * 				不是的话  pSubHead.next = node.next
 * 				node.next = subHead.next
 */
public class Solution {

	
	public ListNode partition(ListNode head, int x) {
		if (null == head) {
			return head;
		}
		ListNode node = new ListNode(99);
		node.next = head;
		while(node.next != null && node.next.val < x) {
			node = node.next;
		}
//		顺序找到第一个大于value的节点 申请一个新的节点node node。next指向这个节点
		if(node.next == null) {
			return head;
		}
//		 *         	如果此时node。next指向null 正面所有的节点小于给定值 不用改变
//		 *         subHead = new Node 
		ListNode subHead = new ListNode(11);
//		 *         pSubHead = subHead
		ListNode pSubHead = subHead;
//		 *         q = node next    p = q.next 开始查找
		ListNode q = node.next;
		ListNode p = q.next;
//		 *         while p!=null
		while (p!=null) {
//		 *         	如果 p value 大于等于value p = p。next q = q.next
			if(p.val >= x) {
				p = p.next;
				q = q.next;
			} else {
//		 *          如果 p value 小于 value 那么pSubHead .next =  p 
				pSubHead.next = p;
//		 *          		 pSubHead = pSubHead.next
//		 *   				 改变以前链表 
//		 *   				q.next = p.next 
//		 *   				p = p.next
				pSubHead = pSubHead.next;
				q.next = p.next;
				p = p.next;
			}
		}
//		 *  		最终如果subHead。next 不为空
		if(subHead.next != null) {
//		 *  		判断node next 是不是head 
			if(node.next == head) {
//		 *  			是的话 直接将head = subHead。next  pSubHead.next = node.next
				head = subHead.next;
				pSubHead.next = node.next;
			} else {
//		 * 				不是的话  pSubHead.next = node.next
				pSubHead.next = node.next;
//		 * 				node.next = subHead.next
				node.next = subHead.next;
			}
		}
		return head;
    }
	
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		String str = "1->4->3->2->5->2";
		ListNode head = ListNodeUtil.stringToListNode(str);
		int x = 3;
		ListNode newHead = solution.partition(head, x);
		ListNodeUtil.printListNode(newHead);
	}
}
