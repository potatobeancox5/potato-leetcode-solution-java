package com.potato.study.leetcode.domain;

/**
 * 链表节点
 * @author liuzhao11
 * 采用充血模型
 *
 */
public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode(" + val + ") -> " + (next == null ? "" : next.toString());
    }
}
