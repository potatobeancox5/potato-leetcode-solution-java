package com.potato.study.leetcode.p0002;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11 
 * 		2.Add Two Numbers
 *
 *
 *         You are given two non-empty linked lists representing two
 *         non-negative integers. The digits are stored in reverse order and
 *         each of their nodes contain a single digit. Add the two numbers and
 *         return it as a linked list.
 * 
 *         You may assume the two numbers do not contain any leading zero,
 *         except the number 0 itself.
 * 
 *         思路： 
			一遍遍历两个列表
			两个列表当前都有节点时，
				相加当前节点值和进位值    %10，并设置是否进位
			只有一个列表有节点时，
				计算存在数字的节点和进位问题%10，设置进位值， 
				并将得到的节点连接在第一个列表中
			两个节点都为null 时 返回结果
 */	
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		//处理第一个节点
		if (null == l1) {
			return l2;
		}
		int carry = 0;
		l1 .val += l2.val;
		if(l1.val >= 10) {
			l1.val %= 10;
			carry = 1;
		}
		ListNode p1 = l1;
		ListNode p2 = l2;
		while(null != p1.next || null != p2.next || carry > 0) {
			if(null != p1.next && null != p2.next) {
				int digit = p1.next.val + p2.next.val + carry;
				if(digit >= 10) {
					carry = 1;
					digit %= 10;
				} else {
					carry = 0;
				}
				p1.next.val = digit;
				//移动
				p1 = p1.next;
				p2 = p2.next;
			} else if (null == p1.next && null == p2.next) { // only carry =1 
				p1.next = new ListNode(carry);
				p1 = p1.next;
				break;
			} else if (p1.next == null) {
				p1.next = p2.next;
				p2.next = null;//注意此处需要对p2节点进行断开处理
				int digit = p1.next.val + carry;
				if(digit >= 10) {
					digit %= 10;
					carry = 1;
				} else {
					carry = 0;
				}
				p1.next.val = digit;
				p1 = p1.next;
			} else { //only p2.next node is null
				int digit = p1.next.val + carry;
				if(digit >= 10) {
					digit %= 10;
					carry = 1;
				} else {
					carry = 0;
				}
				p1.next.val = digit;
				p1 = p1.next;
			}
		}
		return l1;
	}

	
	
	
	public static void main(String[] args) {
		//(2 -> 4 -> 3) + (5 -> 6 -> 4)
//		int[] arr1 = {2,4,3};
//		int[] arr2 = {5,6,4};
		int[] arr1 = {0};
		int[] arr2 = {2,7,8};
		Solution solution = new Solution();
		ListNode l1 = ListNodeUtil.intArrayToListNode(arr1);
		ListNode l2 = ListNodeUtil.intArrayToListNode(arr2);
		ListNode result = solution.addTwoNumbers(l1, l2);
		ListNodeUtil.printListNode(result);
	}
}
