package com.potato.study.leetcode.p0061;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 
 *         61. Rotate List
 *     
 *      Given a list, rotate the list to the right by k places, where k is non-negative.


Example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.
 * 
 * 
 *         思路：
 *         初始p q 都是指向第一个节点
 *         将p向前移动 k 个位置	
 *         然后 移动 pq 知道 q.next == null
 *         
 *         此时
 *         p.next = head;
 *         head = q.next;
 *         q.next = null
 */
public class Solution {
	
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null) {
			return head;
		}
		// 遍历列表 计算长度与k关系
		ListNode tmp = head;
		int len = 0;
		while(tmp != null) {
			len++;
			tmp = tmp.next;
		}
		if(k >= len) {
			k = k % len;
		}
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < k; i++) {
        	if(p == null || p.next == null) {
        		return head;
        	}
			p = p.next;
		}
        while(p.next != null) {
        	p = p.next;
        	q = q.next;
        }
        //final
        p.next = head;
        head = q.next;
        q.next = null;
        return head;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {1,2,3,4,5};
		ListNode head = ListNodeUtil.intArrayToListNode(arr);
		ListNode result = solution.rotateRight(head, 2);
		ListNodeUtil.printListNode(result);
	}
}
