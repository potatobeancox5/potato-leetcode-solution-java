package com.potato.study.leetcode.p0141;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         141. Linked List Cycle
 *         
 *          
 *       Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?    
 *         思路：
 *         	快慢指针 块指针一次一步 慢指针一次两部 如果两个指针相遇了 说明 存在环 
 *         否则 如果慢指针到了终点都没有遇到块指针 说明不存在环
 *         
 *         
 * 
 */
public class Solution {
	
	public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(slow != null && slow.next != null 
        		&& fast != null && fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast) {
        		return true;
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String str = "";
		ListNode head = ListNodeUtil.stringToListNode(str);
		boolean hasCycle = solution.hasCycle(head);
		System.out.println(hasCycle);
	}
}
