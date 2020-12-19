package com.potato.study.leetcodecn.p0002.t002;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 2. 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    /**
     * 两个链表均不为空时
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 是否有之前的进位
        boolean needAddOne = false;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(-1);
        ListNode newList = head;
        while (p1 != null && p2 != null) {
            int target = p1.val + p2.val;
            if (needAddOne) {
                target += 1;
            }
            // 处理进位
            if (target >= 10) {
                target %= 10;
                needAddOne = true;
            } else {
                needAddOne = false;
            }
            ListNode node = new ListNode(target);
            newList.next = node;
            newList = newList.next;

            p1 = p1.next;
            p2 = p2.next;
        }
        // 处理未完的情况
        while (p1 != null) {
            int target = p1.val;
            if (needAddOne) {
                target += 1;
            }
            // 处理进位
            if (target >= 10) {
                target %= 10;
                needAddOne = true;
            } else {
                needAddOne = false;
            }
            ListNode node = new ListNode(target);
            newList.next = node;
            newList = newList.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int target = p2.val;
            if (needAddOne) {
                target += 1;
            }
            // 处理进位
            if (target >= 10) {
                target %= 10;
                needAddOne = true;
            } else {
                needAddOne = false;
            }
            ListNode node = new ListNode(target);
            newList.next = node;
            newList = newList.next;
            p2 = p2.next;
        }
        // 处理最后一个进位
        if (needAddOne) {
            newList.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNodeUtil.stringToListNode("2 -> 4 -> 3");
        ListNode l2 = ListNodeUtil.stringToListNode("5 -> 6 -> 4");

        ListNode listNode = solution.addTwoNumbers(l1, l2);
        ListNodeUtil.printListNode(listNode);
    }
}
