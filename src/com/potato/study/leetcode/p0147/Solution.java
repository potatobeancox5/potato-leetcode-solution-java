package com.potato.study.leetcode.p0147;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *      147. Insertion Sort List
 *         
 *          
 *   Sort a linked list using insertion sort.


A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list


Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

 *
 *         题目需求：
 *         实现插入排序一个数组
 *
 *         思路：
 *
 */
public class Solution {

	public ListNode insertionSortList(ListNode head) {
		if (null == head) {
			return head;
		}
		if(head.next == null) {
			return head;
		}
		ListNode p = head.next;
		head.next = null;
		while(p != null) {
			ListNode q = head;
			ListNode pre = null;
			// 找到插入位置
			while(null != p && q != null && p.val > q.val) { // 直到q > p 或者q = null
				pre = q;
				q = q.next;
			}
			// 插入
			if(q == null) { // 插入最后
				pre.next = p;
				p = p.next;
				pre.next.next = null;
			} else { // 插入q前面 需要判断是否需要重置head
				ListNode pNext = p.next;
				if(null != pre) {
					pre.next = p;
				}
				p.next = q;
				//是否需要重置head
				if (head == q) {
					head = p;
				}
				p = pNext;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] arr = {4,2,1,3};
		ListNode head = ListNodeUtil.intArrayToListNode(arr);
		head = solution.insertionSortList(head);
		ListNodeUtil.printListNode(head);

	}
}
