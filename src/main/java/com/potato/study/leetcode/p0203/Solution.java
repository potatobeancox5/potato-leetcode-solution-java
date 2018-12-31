package com.potato.study.leetcode.p0203;

import com.potato.study.leetcode.domain.ListNode;

/**
 * 
 * @author liuzhao11
 * 
 *         203. Remove Linked List Elements
 * 
 *        Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 *
 *         思路：  
 *         删除链表中数字位 val 的所有值
 *
 *         删除 注意head就可以了
 * 
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if(null == head) {
            return head;
        }
        ListNode preHead = new ListNode(999); // 简化删除流程 将所有节点的删除变成链表中节点的删除
        preHead.next = head;
        ListNode p = head;
        ListNode pre = preHead;
        while(p != null) {
            if(p.val == val) {
                pre.next = p.next;
                p.next = null;// 利于释放
                p = pre.next;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }
        return preHead.next;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();

	}
}
