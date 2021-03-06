package com.potato.study.leetcodecn.p00143.t001;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 143. 重排链表
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 示例 1:

 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 示例 2:

 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reorder-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 对列表重新排列
     * @param head
     */
    public void reorderList(ListNode head) {
        // 简化
        if (null == head || head.next == null || head.next.next == null) {
            return;
        }
        // 快慢指针找到中间的点 fast  先移动 然后移动slow 如果 fast 移动过程中 出现了null 说明 已经结束了 slow 的next 就是中间开始的点
        ListNode sentinel = new ListNode(-11);
        sentinel.next = head;
        ListNode fast = sentinel;
        ListNode slow = sentinel;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        // 拿到slow next 之后 对 slow.next revert
        ListNode middleHead = slow.next;
        // 断链接
        slow.next = null;

        ListNode pre = null;
        ListNode p = middleHead;
        while (p != null) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        middleHead = pre;
        // 然后从将两个链表 head 和 slow 组装
        ListNode pp = head;
        ListNode qq = middleHead;
        ListNode kk = sentinel;
        while (pp != null) {
            ListNode ppNext = pp.next;
            kk.next = pp;
            kk = kk.next;
            // 处理odd 节点引发的pp 比qq 多一个节点的问题
            if (qq == null) {
                break;
            }
            ListNode qqNext = qq.next;
            kk.next = qq;
            kk = kk.next;

            pp = ppNext;
            qq = qqNext;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNodeUtil.stringToListNode("1->2->3->4");
        solution.reorderList(head);
        ListNodeUtil.printListNode(head);


        head = ListNodeUtil.stringToListNode("1->2->3->4->5");
        solution.reorderList(head);
        ListNodeUtil.printListNode(head);
    }
}
