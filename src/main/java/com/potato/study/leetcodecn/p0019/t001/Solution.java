package com.potato.study.leetcodecn.p0019.t001;


import com.potato.study.leetcode.domain.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 进阶：

 你能尝试使用一趟扫描实现吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 先往前移动n，然后开始移动指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        for (int i = 1; i < n; i++) {
            front = front.next;
        }
        // 哨兵简化
        ListNode target = new ListNode(-1);
        target.next = head;
        while (front.next != null) {
            front = front.next;
            target = target.next;
        }
        // 如果删除的是头节点咋整
        if (target.next == head) {
            head = target.next.next;
        }
        // 开始删除
        target.next = target.next.next;
        return head;
    }
}
