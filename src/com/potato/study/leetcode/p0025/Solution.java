package com.potato.study.leetcode.p0025;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5


 * 
 * 
 * 思路 ：
 * 倒置链表 先确定每个元组的head 和 tail 然后改变中间的链接
 * 链表为null 或者  k == 0 时 直接返回 
 * 否则 
 * head 标记当前新的头
 * tail 标记新的尾部（进过转换的列表的一段） tail = head
 * p 左边的交换链表节点
 * q 右边的交换链表节点
 * 
 * 循环 知道计数器count > k 
 * 交换动作
 * 设置新的head tail.next
 * head = q
 * tail.next = q.next
 * 重置内部链接
 * q.next = p
 * 移动p q
 * p = q
 * q = tail.next 
 * 
 * 最后返回head
 * @author Administrator
 *
 */
public class Solution {

	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null ||  k == 1) {
			return head;
		}
		// 一共整几个组
		ListNode tmp = head;
		int length = 0;
		while (tmp != null) {
			length++;
			tmp = tmp.next;
		}
		int times = length / k;
		if(times < 1) {
			return head;
		}
		ListNode tail = head;
		ListNode p = head;
		ListNode q = head.next;
		int count = 1;
		while(count < k && q != null) {
			//设置新的head tail.next
			head = q;
			tail.next = q.next;
//			 * 重置内部链接
			q.next = p;
//			 * 移动p q
			p = q;
			q = tail.next; 
			count++;
		}
		//第二次 到第times次
		for(int i = 2 ; i <= times ;i++) {
			ListNode groupHead = tail;
			tail = groupHead.next;
			p = groupHead.next;
			q = groupHead.next.next;
			count = 1;
			while(count < k && q != null) {
				//设置新的head tail.next
				groupHead.next = q;
				tail.next = q.next;
//				 * 重置内部链接
				q.next = p;
//				 * 移动p q
				p = q;
				q = tail.next; 
				count++;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int k = 2;
		int[] arr = {1,2,3,4,5,6};
		ListNode head = ListNodeUtil.intArrayToListNode(arr);
		ListNode result = solution.reverseKGroup(head, k);
		ListNodeUtil.printListNode(result);
	}
}
