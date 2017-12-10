package com.potato.study.leetcode.util;

import com.potato.study.leetcode.domain.ListNode;

/**
 * ListNode工具类
 * @author liuzhao11
 *
 */
public class ListNodeUtil {
	private ListNodeUtil() {
		
	}
	/**
	 * 顺序 控制台 打印ListNode 型链表
	 * @param head
	 */
	public static void printListNode(ListNode head) {
		StringBuilder sBuilder = new StringBuilder("[");
		ListNode p = head;
		while(null != p) {
			sBuilder.append(p.val).append(",");
			p = p.next;
		}
		if (sBuilder.length() > 1) {
			sBuilder.deleteCharAt(sBuilder.length() - 1);
		}
		sBuilder.append("]");
		System.out.println(sBuilder.toString());
	}
	/**
	 * 将int型数组 顺序转换成ListNode 型列表
	 * @param arr
	 * @return	ListNode型列表
	 */
	public static ListNode intArrayToListNode(int[] arr) {
		if (null == arr || arr.length == 0) {
			return null;
		}
		ListNode head = new ListNode(55);
		ListNode p = head;
		for (int value : arr) {
			p.next = new ListNode(value);
			p = p.next;
		}
		return head.next;
	}
}
