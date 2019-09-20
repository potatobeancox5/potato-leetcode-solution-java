package com.potato.study.leetcode.p0138;

import com.potato.study.leetcode.domain.RandomListNode;

/**
 * 
 * @author liuzhao11
 * 
 *         138. Copy List with Random Pointer
 *         
 *         A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
  
 *         思路：
 *         	https://blog.csdn.net/derrantcm/article/details/47745459
 *         复制随机链表
 *         1.遍历链表，将每一个节点复制一次插入节点的后面，
 *         2.遍历链表，按照当前链表的指向，将新创建的链表节点的随机指针 进行放置
 *         3.将生成的节点从之前链表中摘出来
 *         
 * 
 */
public class Solution {
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
//		 1.遍历链表，将每一个节点复制一次插入节点的后面，
		RandomListNode copyNode = head;
		while(copyNode != null) {
			RandomListNode newNode = new RandomListNode(copyNode.label);
			newNode.next = copyNode.next;
			copyNode.next = newNode;
			copyNode = newNode.next;
		}
//		 2.遍历链表，按照当前链表的指向，将新创建的链表节点的随机指针 进行放置
		RandomListNode p = head;
		while(p != null) {
			RandomListNode q = p.next;//上一部进行了复制 所以有p一定有q
			if(p.random != null) {				
				q.random = p.random.next;// 随机指针指向的节点 在其后边
			}
			p = q.next;
		}
//		 3.将生成的节点从之前链表中摘出来
		RandomListNode newHead = head.next;
		RandomListNode pp = head;
		RandomListNode qq = newHead;
		while(pp != null ) {
			pp.next = pp.next.next;
			pp = pp.next;
			if(qq.next != null) {
				qq.next = qq.next.next;
				qq = qq.next;
			}
		}
		return newHead;
    }
	
	public static void main(String[] args) {
//		MyCalendarThree solution = new MyCalendarThree();
	}
}
