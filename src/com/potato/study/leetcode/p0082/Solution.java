package com.potato.study.leetcode.p0082;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 82. Remove Duplicates from Sorted List II
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
 *   
 *  思路： 题意 生成的链表不能有重复的元素
 *  两个指针 一个记录当前的value 节点 另一个记录 目前比较的的节点
 *  先处理第一个节点 stay = first node  当前比较节点 current = first node - 》 next
 *  while current ！= null
 *  	如果current value 不是 stay value 
 *  		如果stay 元素重复了 则本次置换 stay 元素 
  			如果 stay元素没有出现重复情况  置换 stay next 值 stay = stay。next
  		  更新stay 重复情况
 *  	如果current value ==  stay value  current = current，next  记录 stay 重复情况
 *  
 *  // 令stay。next = null
 */
public class Solution {
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
        	return head;
        }
		ListNode stay = head;
		ListNode preStay = new ListNode(0);
		preStay.next = stay;
		ListNode current = head.next;
		boolean isStayDuplicate = false;
		while(current != null) {
			if(current.val != stay.val) {
				if(isStayDuplicate) {
					stay.val = current.val;
				} else {					
					stay.next.val = current.val;
					stay = stay.next;
					preStay = preStay.next;
				}
				isStayDuplicate = false;
			} else {
				isStayDuplicate = true;
			}
			current = current.next;
		}
		// 最后一个元素 是重复的
		if(isStayDuplicate) {
			if(head == stay) {
				head = null;
			} else {				
				preStay.next = null;
			}
			return head;
		}
		stay.next = null;
		return head;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
//		String string = "1->2->3->3->4->5->5";
//		String string = "1->1->1";
		String string = "1->1";
		ListNode head = ListNodeUtil.stringToListNode(string);
		ListNode result = solution.deleteDuplicates(head);
		ListNodeUtil.printListNode(result);
		
	}
}
