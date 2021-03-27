package com.potato.study.leetcodecn.p00445.t001;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

import java.util.Stack;

/**
 * 445. 两数相加 II
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

  

 进阶：

 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

  

 示例：

 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 8 -> 0 -> 7

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 两个栈记录
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 是否有进位
        boolean isCarry = false;
        // 1. 将 l1 l2 用栈进行处理
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        // 2. 分别 pop 计算 当前数字 利用头插入法，生成最终结果
        ListNode head = new ListNode(-1);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Integer num1 = stack1.pop();
            Integer num2 = stack2.pop();
            int tmp = num1 + num2;
            if (isCarry) {
                tmp++;
            }
            // 处理进位问题
            if (tmp >= 10) {
                tmp %= 10;
                isCarry = true;
            } else {
                isCarry = false;
            }
            // 插入
            ListNode newNode = new ListNode(tmp);
            newNode.next = head.next;
            head.next = newNode;
        }
        // 3. 如果那个链表没有访问完 继续头插法生成结果
        while (!stack1.isEmpty()) {
            Integer num1 = stack1.pop();
            int tmp = num1;
            if (isCarry) {
                tmp++;
            }
            // 处理进位问题
            if (tmp >= 10) {
                tmp %= 10;
                isCarry = true;
            } else {
                isCarry = false;
            }
            // 插入
            ListNode newNode = new ListNode(tmp);
            newNode.next = head.next;
            head.next = newNode;
        }

        while (!stack2.isEmpty()) {
            Integer num2 = stack2.pop();
            int tmp = num2;
            if (isCarry) {
                tmp++;
            }
            // 处理进位问题
            if (tmp >= 10) {
                tmp %= 10;
                isCarry = true;
            } else {
                isCarry = false;
            }
            // 插入
            ListNode newNode = new ListNode(tmp);
            newNode.next = head.next;
            head.next = newNode;
        }
        // 4. 处理最终进位
        if (isCarry) {
            ListNode newNode = new ListNode(1);
            newNode.next = head.next;
            head.next = newNode;
        }
        return head.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNodeUtil.stringToListNode("7 -> 2 -> 4 -> 3");
        ListNode l2 = ListNodeUtil.stringToListNode("5 -> 6 -> 4");
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        ListNodeUtil.printListNode(listNode);
    }
}
