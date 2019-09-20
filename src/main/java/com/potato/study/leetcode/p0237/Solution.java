package com.potato.study.leetcode.p0237;

import com.potato.study.leetcode.domain.ListNode;

/**
 * 
 * @author liuzhao11
 * 
 *      237. Delete Node in a Linked List
 * 
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 * 
 * 
 * 思路：寻找两个节点的公共祖先
 *   这个题主要难点在题意的解读
 *   不给链表head 只给要删除的节点node 让你删除节点 
 *   解答就是 不删节点 只修改内容 然后删除最后一个节点（前提node不是最终节点）
 *   https://blog.csdn.net/sunao2002002/article/details/47083975
 */
public class Solution {
	
	public void deleteNode(ListNode node) {
        if(node == null) {
        	return;
        }
        ListNode p = node;
        if(node.next == null) {
        	return;
        }
        ListNode q = node.next;
        while(q != null) {
        	p.val = q.val;
        	if(q.next == null) {
        		break;
        	}
        	p = p.next;
        	q = q.next;
        }
        //删除最后一个节点
        p.next = null;
    }
	
    public static void main(String[] args) {
//		MyCalendarThree solution = new MyCalendarThree();
//		solution.deleteNode(node);
	}
}
