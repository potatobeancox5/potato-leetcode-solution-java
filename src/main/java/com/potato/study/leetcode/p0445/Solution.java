package com.potato.study.leetcode.p0445;

import com.potato.study.leetcode.domain.ListNode;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *   445. Add Two Numbers II
 * 
 *    You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

 *
 *     思路：
 *
 *
 *     
 * 			
 * 	
 */	
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 直接使用栈 缓存数字 然后重建链表
        ListNode res = null;
        if (l1 == null && l2 == null) {
            return res;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode p = l1;
        while (p!=null) {
            stack1.push(p.val);
            p = p.next;
        }

        p = l2;
        while (p!=null) {
            stack2.push(p.val);
            p = p.next;
        }
        boolean needPlusOne = false;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int val;
            if (!stack1.isEmpty() && !stack2.isEmpty()) {
                val = stack1.pop() + stack2.pop();
            } else if (!stack1.isEmpty()) {
                val = stack1.pop();
            } else {
                //!stack2.isEmpty()
                val = stack2.pop();
            }

            if (needPlusOne) {
                val += 1;
            }

            if (val >= 10) {
                val -= 10;
                needPlusOne = true;
            } else {
                needPlusOne = false;
            }

            // build res
            if (null == res) {
                res = new ListNode(val);
            } else {
                ListNode node = new ListNode(val);
                node.next = res;
                res = node;
            }
        }

        if (needPlusOne) {
            ListNode node = new ListNode(1);
            node.next = res;
            res = node;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode len = solution.addTwoNumbers(l1, l2);
        System.out.println(len);
    }
}
