package com.potato.study.leetcode.p0160;

import com.potato.study.leetcode.domain.ListNode;

/**
 * 
 * @author liuzhao11
 * 
 *      160. Intersection of Two Linked Lists
 *         
 *          
 *   Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
Special thanks to 
@stellari for adding this problem and creating all test cases.

 *         思路：
 *         题意 找到两个链表的连接点 
 *         前提 可能不存在连接点
 *         不能改变原来链表的结构
 *         链中无环
 *         最多遍历两边 数组 
 *          计算headA 长度 headB长度 较长的那个先走  n - m 步 pa pb
 *          while pa ！= null &&  pb！= null
 *          	判断是否相等 
 *          		是 返回 thisnode
 *          		不是 两边同时走到next
 * 			返回 null
 * 
 * 			参考找链表中环起点的方法
 * https://blog.csdn.net/derrantcm/article/details/47855991
 */
public class Solution {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != null) {
        	lenA++;
        	pa = pa.next;
        }
        while(pb != null) {
        	lenB++;
        	pb = pb.next;
        }
        pa = headA;
        pb = headB;
        if(lenA > lenB) {
        	int count = 0;
        	int step = lenA - lenB;
        	while(count < step) {
        		pa = pa.next;
        		count++;
        	}
        } else if (lenA < lenB) {
        	int count = 0;
        	int step = lenB - lenA;
        	while(count < step) {
        		pb = pb.next;
        		count++;
        	}
        } 
        // 开始寻找相遇点
        while(null != pa && null != pb) {
        	if(pa == pb) {
        		return pa;
        	} else {
        		pa = pa.next;
        		pb = pb.next;
        	}
        }
        return null;
    }	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode headA = null;
		ListNode headB = null;
		ListNode node = solution.getIntersectionNode(headA, headB);
		System.out.println(node.val);
	}
}
