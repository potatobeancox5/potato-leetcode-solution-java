package com.potato.study.leetcodecn.p0206t001;

import com.potato.study.leetcode.domain.ListNode;

/**
 * 206. 反转链表
 *
 * 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 反转链表 注意边界条件判定
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 没有节点 只有一个节点 直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // p在前 q 在后
        ListNode p = head.next;
        ListNode q = head;

        while (p != null) {

            ListNode pNext = p.next;
            p.next = q;
            // 如果本次移动的是首节点 那么 新的 head = p；
            if (q.next == p) {
                q.next = null;
            }
            head = p;

            q = p;
            p = pNext;

        }
        return head;
    }
}
