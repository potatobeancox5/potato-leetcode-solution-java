package com.potato.study.leetcode.p0142;

import com.potato.study.leetcode.domain.ListNode;

/**
 * 
 * @author liuzhao11
 * 
 *         142. Linked List Cycle II
 *         
 *          
 *       Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.




Follow up:
Can you solve it without using extra space?
 *
 *         题目需求：
 *         给了一个带环的链表 找到环开始的地方
 *
 *         思路：
 *         https://blog.csdn.net/willduan1/article/details/50938210
 *         快慢指针 快一次2步 慢一次1步 快走的过程中遇到 null 说明没有环 返回null
 *         如果两者能相遇 那么能找到第一次相遇的那个点
 *          如果相遇点就是其实点 那么从起始点开始 就是环开始的点了
 *         找到相遇点 从相遇点和开始点开始 分别步长为 1 再次相遇点就是环的开始的点
 *
 *
 *
 *         提炼util
 *         生成字符串->ListNode的工具类
 *         [3,2,0,-4] 1 表示 3 -> 2 -> 0 -> -4 最后一个节点连到pos = 1（2） 位置
 *
 *
 *         
 * 
 */
public class Solution {

	/**
	 * 找到并返回链表中 环的开始的点
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		if (null == head) {
			return null;
		}
		ListNode slow = head;// step = 1
		ListNode fast = head;// step = 2
		// 找相遇点
		do {
			if(fast.next == null || fast.next.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;

		} while(slow != fast);
		// 环在中间 相遇点和开始点分别步长1找相遇
		fast = head;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();

	}
}
