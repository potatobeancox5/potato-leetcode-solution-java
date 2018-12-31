package com.potato.study.leetcode.p0021;


import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * 
 * 21. Merge Two Sorted Lists Merge two sorted linked lists and return it
 * as a new list. The new list should be made by splicing together the nodes of
 * the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 * 
 * 思路 ：
 * 合并两个有序链表
 * 新开一个链表 current，将小的 放在新的那个链表里边
 * 两个指针 p q 分别指向当前链表的节点 从头开始遍历链表
 * 	若p == null 且 q == null 此时 遍历结束 返回 head （将链表放在p上边）
 * 	若p != null 且 q ！= null 此时 进行比较   将小的到current。next处 并移动
 * 	若p ！= null 且 q == null 将p中的节点 放到current处
 *  若 p == null 且 q ！= null 放q
 * @author Administrator
 *
 */
public class Solution {
	
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode current = head;
        while(l1 != null || l2 != null) {
        	if(l1 == null) {
        		current.next = l2;
        		current = current.next;
        		l2 = l2.next;
        		// 一方连接完了可以直接结束了
        		break;
        	} else if (l2 == null) {
        		current.next = l1;
        		current = current.next;
        		l1 = l1.next;
        		break;
        	} else {//p != null 且 q ！= null
        		if(l1.val <= l2.val) {
        			current.next = l1;
            		current = current.next;
            		l1 = l1.next;
        		} else {
        			current.next = l2;
            		current = current.next;
            		l2 = l2.next;
        		}
        	}
        }
        return head.next;
    }
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] arr1 = {1,2,4};
		int[] arr1 = {};
		int[] arr2 = {1,3,4};
		ListNode l1 = ListNodeUtil.intArrayToListNode(arr1);
		ListNode l2 = ListNodeUtil.intArrayToListNode(arr2);
		ListNode head = solution.mergeTwoLists(l1, l2);
		ListNodeUtil.printListNode(head);
		
	}
}
