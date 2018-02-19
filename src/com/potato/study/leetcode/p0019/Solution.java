package com.potato.study.leetcode.p0019;

import com.potato.study.leetcode.domain.ListNode;

/**
 * 19. Remove Nth Node From End of List Given a linked list, remove the nth node
 * from the end of list and return its head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 * 
 * 思路 ：遍历一遍链表 设置快慢指针 两者之间相差 n个几点
 * 先将快指针从头开始遍历 并计数  
 * 当计数器count == n时 将慢指针设置到head 开始同时移动快慢指针 知道块指针 ，next == null 停止移动
 * 此时慢指针指向的位置就是要删除的位置的前一个位置 此时 将慢指针.next = 慢指针.next.next,若此时慢指针==null时，证明 刚好可以移动head指针
 * 即head = head.next 
 * 
 * @author Administrator
 *
 */
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 快指针先走n步，慢指针再开始走
		ListNode fast = head;
		while (fast != null && n-- >= 0) {
			fast = fast.next;
		}
		//刚好走到队尾 删除对头元素
		if (fast == null && n == 0) {
			return head.next;
		}
		ListNode slow = head;
		// 快指针走到头时，慢指针的next就是要删除的对象
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		//因为一定有这个元素
		slow.next = slow.next.next;
		return head;
	}
}
