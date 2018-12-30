package com.potato.study.leetcode.p0234;

import com.potato.study.leetcode.domain.ListNode;

/**
 * 
 * @author liuzhao11
 * 
 *      234. Palindrome Linked List
 * 
 * Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?




 * 
 * 思路：
 * 找到中间节点 断开  快慢指针
 * 倒置右边的那个东西
 * 比较两个是否相同
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (null == head) {
            return true;
        }

        ListNode middle = findMiddleNode(head);
        // reverse
        ListNode middleHead = reverse(middle);
        // compare
        ListNode p = head;
        ListNode q = middleHead;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    /**
     * 找到中间点
     * odd fast 会保证每次都会走两步 直到走完 返回中间的那个点
     * even fast途中就端了 返回中间的两个点前面的那个点
     * @param head
     * @return
     */
    private ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            if(fast.next == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 倒置单链表
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        ListNode pre = null;
        while (p != null) {
            ListNode s = p.next;
            p.next = pre;
            pre = p;
            p = s;
            if (s == null) {
                break;
            }
            s = s.next;
        }
        return pre;
    }
	
    public static void main(String[] args) {
//		Solution solution = new Solution();
//		
//		int val = solution.lowestCommonAncestor(root, p, q).val;
	}
}
