package com.potato.study.leetcode.p0092;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         92. Reverse Linked List II
 *         
 *         
 *         Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

 * 
 *
 *         思路：
 *         将给定数组指定位置进行反转
 *         设置一个节点 start 设置一个节点end start。next 指向开始的节点 end 指向终止的节点
 *         遍历这个链表
 *         
 *         
 *         
 */
public class Solution {

	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n) {
        	return head;
        }
        ListNode p = head;
        ListNode q = head; 
        ListNode start = null;
        ListNode preStartNode = null;
        ListNode end = null;
        ListNode afterEnd = null;
        //处理第一个节点
        if(p.next == null) { // 只有一个节点的情况
        	return head;
        }
        // 节点数 》2
        p = p.next; // p指向当前访问的节点
        int count = 2;
        if(m == 1) {
        	start = head;
        }
        while(count <= n) {
        	if(count == m) {
        		// 判断当前p是否指向开始节点
        		start = p;
        		preStartNode = q;
        		count++;
            	p = p.next;
            	q = q.next;
        	} else if (m < count && count <= n) {
        		//判断当前 p 是否位于开始节点和结束节点之间
        		// 记录p next 然后置换p next 指向
        		ListNode tmp = p.next;
        		p.next = q;
        		q = p;
        		p = tmp;
        		if(count == n) {
        			end = q;
        			afterEnd = p;
        		}
        		count++;
        	} else {
        		count++;
            	p = p.next;
            	q = q.next;
        	}
        }
        //  处理开始节点是head的情况
        if(start == head) {
        	head = end;
        	start.next = afterEnd;
        } else {
        	preStartNode.next = end;
        	start.next = afterEnd;
        }
        return head;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
		int m = 2;
		int n = 4;
		String str = "1->2->3->4->5";
		ListNode head = ListNodeUtil.stringToListNode(str);
		ListNode result = solution.reverseBetween(head, m, n);
		ListNodeUtil.printListNode(result);
	}
}
