package com.potato.study.leetcodecn.p00025.t001;


import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 25. K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

 k 是一个正整数，它的值小于或等于链表的长度。

 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

  

 示例：

 给你这个链表：1->2->3->4->5

 当 k = 2 时，应当返回: 2->1->4->3->5

 当 k = 3 时，应当返回: 3->2->1->4->5

  

 说明：

 你的算法只能使用常数的额外空间。
 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 链表 记录当前数字，
     * 设置一个哨兵，newHead
     * 遍历链表 使用 数字 num记录 当前遍历到多少个节点
     * 记录 这个小段落开始的位置和结束的位置
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 设置哨兵
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        int num = 0;
        ListNode p = newHead.next;
        ListNode nextPartHead;
        ListNode prePartTail = newHead;
        ListNode start = newHead.next;
        while (p != null) {
            num++;
            if (num == k) {
                nextPartHead = p.next;
                // 翻转
                reversePart(start, k, nextPartHead, prePartTail);
                // 设置之前的几点
                prePartTail = start;
                // 下一个开始的位置
                start = start.next;
                num = 0;
                p = start;
            } else {
                p = p.next;
            }
        }
        return newHead.next;
    }


    /**
     * 翻转 start 到 end 这个部分 包括end
     * 如何反转
     * https://www.cnblogs.com/keeya/p/9218352.html
     * @param start
     * @param k
     * @param nextPartHead
     * @param prePartTail
     */
    private void reversePart(ListNode start, int k, ListNode nextPartHead, ListNode prePartTail) {
        ListNode pre = null;
        ListNode p = start;
        while (p != null && k > 0) {
            ListNode nextNode = p.next;
            p.next = pre;
            k--;
            // 转移
            pre = p;
            p = nextNode;
        }
        // pre 指向的是 第一个节点 p 指向的下一个开始的点 start 指向的是末尾
        start.next = nextPartHead;
        prePartTail.next = pre;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNodeUtil.stringToListNode("1->2->3->4->5");
        ListNode listNode = solution.reverseKGroup(head, 2);
        ListNodeUtil.printListNode(listNode);// 2->1->4->3->5

        head = ListNodeUtil.stringToListNode("1->2->3->4->5");
        listNode = solution.reverseKGroup(head, 3);
        ListNodeUtil.printListNode(listNode);// 3->2->1->4->5
    }
}
