package com.potato.study.leetcodecn.p00002.t001;

import com.potato.study.leetcode.domain.ListNode;

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
     * 从头开始 往前累加 每次加和 考虑之前进位问题
     * 加和之后 如果大于10 求进位，达到最后一个节点 判断进位，是否需要创建新节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int carry = 0;
        while (null != l1 && null != l2) {
            int val = l1.val + l2.val + carry;
            if (val >= 10) {
                carry = val / 10;
                val %= 10;
            } else {
                carry = 0;
            }
            p.next = new ListNode(val);
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;

        }
        // 判定 l1 或者 l2 任意一个
        while (null != l1) {
            int val = l1.val + carry;

            if (val >= 10) {
                carry = val / 10;
                val %= 10;
            } else {
                carry = 0;
            }
            p.next = new ListNode(val);
            l1 = l1.next;
            p = p.next;
        }
        while (null != l2) {
            int val = l2.val + carry;
            if (val >= 10) {
                carry = val / 10;
                val %= 10;
            } else {
                carry = 0;
            }
            p.next = new ListNode(val);
            l2 = l2.next;
            p = p.next;
        }
        // 判断进位 carry
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return head.next;
    }


}
