package com.potato.study.leetcodecn.p00021.t001;


import com.potato.study.leetcode.domain.ListNode;

/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

  

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 新列表哨兵吧
     * 入参原本有序
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 哨兵
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        // 都不为null 时
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                tail.next = p;
                p = p.next;
            } else {
                tail.next = q;
                q = q.next;
            }
            // 移动尾指针
            tail = tail.next;
            tail.next = null;
        }
        // 其中一个为null 时 拼接
        if (q != null) {
            tail.next = q;
        } else if (p != null) {
            tail.next = p;
        }
        return head.next;
    }
}
