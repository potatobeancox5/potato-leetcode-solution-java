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
	
	/**
	 * 将 如1->2->3->3->4->4->5 类型的string 转换成对应列表 head.value = 1
	 * 特例是只有一个数组 如 1
	 * @param str
	 * @return
	 */
	public static ListNode stringToListNode(String str) {
		if(null == str || "".equals(str.trim())) {
			return null;
		}
		// 存在-> ？
		if(str.contains("->")) {
			String[] oriNumArray = str.trim().split("->");
			int[] arr = new int[oriNumArray.length]; 
			for (int i = 0 ; i <arr.length ; i++ ) {
				arr[i] = Integer.parseInt(oriNumArray[i]);
			}
			return intArrayToListNode(arr);
		} else {
			// 不存在->  直接转换成数组 出现异常 正面 不是数字 则返回 null
			try {
				int value = Integer.parseInt(str.trim());
				ListNode head = new ListNode(value);
				return head;
			} catch(NumberFormatException nfe) {
				nfe.printStackTrace();
				return null;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "1->2->3->3->4->4->5";
		ListNode head = ListNodeUtil.stringToListNode(str);
		printListNode(head);
	}
}
