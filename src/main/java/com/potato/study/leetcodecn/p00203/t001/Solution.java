package com.potato.study.leetcodecn.p00203.t001;

import com.potato.study.leetcode.domain.ListNode;

/**
 * 203. 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。

 示例:

 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 *
 */
public class Solution {

    /**
     * 哨兵 简化
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (null == head) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode p = head;
        // 开始删除
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
                p = pre.next;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }
        return newHead.next;
    }
}
