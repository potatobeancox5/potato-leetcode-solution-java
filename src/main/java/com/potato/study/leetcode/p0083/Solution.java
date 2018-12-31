package com.potato.study.leetcode.p0083;


import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 *         83. Remove Duplicates from Sorted List
 *         
 *          
 *         Given a sorted linked list,
 *         delete all duplicates such that each element appear only once.
 *         For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return
 *         1->2->3.
 * 
 *         思路：
 *         两个指针 1个指向当前遍历到的节点current 一个指向 插入的节点（插入操作：node.next = current）
 *         当两个节点值不一样时 将node.next = current
 * 
 * 
 */
public class Solution {

	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
        	return head;
        }
        ListNode insertNode = head;
        ListNode current = head.next;
        while(null != current) {
        	if(insertNode.val != current.val) {
        		insertNode.next = current;
        		insertNode = insertNode.next;
        	}
        	current = current.next;
        }
        //处理掉剩下的一样的节点 
        insertNode.next = null;
        return head;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {1,1,2,2,3,3,3};
		ListNode head = ListNodeUtil.intArrayToListNode(arr);
		ListNode uniqueHead = solution.deleteDuplicates(head);
		ListNodeUtil.printListNode(uniqueHead);
	}
}
