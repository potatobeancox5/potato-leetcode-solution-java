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

    /**
     * 通过leetcode 给的字符串（1->2->4） 生成一个链表
     * 返回 链表头节点
     * @param leetcodeString
     * @return
     */
    public static ListNode buildListByLeetcodeString (String leetcodeString) {
        if (null == leetcodeString || "".equals(leetcodeString)) {
            return null;
        }
        String[] split = leetcodeString.split("->");
        if (split.length <= 0) {
            return null;
        }
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode p = head;
        for (int i = 1; i < split.length; i++) {
            p.next = new ListNode(Integer.parseInt(split[i]));
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListByLeetcodeString("1->1->2->3->4->4");
        System.out.println(head);
    }
}
