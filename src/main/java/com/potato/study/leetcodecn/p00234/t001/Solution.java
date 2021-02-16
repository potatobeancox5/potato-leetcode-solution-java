package com.potato.study.leetcodecn.p00234.t001;

import com.potato.study.leetcode.domain.ListNode;
import org.junit.Assert;

/**
 * 234. 回文链表
 *
 * 请判断一个链表是否为回文链表。

 示例 1:

 输入: 1->2
 输出: false
 示例 2:

 输入: 1->2->2->1
 输出: true
 进阶：
 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 有些难想
     * 遍历 head 计算 链表长度
     * 计算需要比较的链表长度
     * 先移动到比较位置开始，移动的过程中 反转之前的链表
     * 再使用一个指针进行遍历比较
     * 想想就麻烦
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        // 计算一半的位置 奇数 偶数 需要移动多少个节点数 3 的话  2， 4的话 2
        int half = (length % 2 == 0 ? length / 2: length / 2 + 1);
        p = head;
        // 过程中 翻转链表
        ListNode pre = null;
        for (int i = 0; i < half; i++) {
            // 奇数 的最后一次 不需要反转
            if (i == half - 1 && length % 2 == 1) {
                p = p.next;
                continue;
            }
            ListNode q = p.next;
            p.next = pre;
            // 移动 p 和 pre
            pre = p;
            p = q;
        }
        // 另一端的开始
        ListNode halfStart = p;
        // 判断是够是回文
        while (pre != null && halfStart != null) {
            if (pre.val != halfStart.val) {
                return false;
            }
            pre = pre.next;
            halfStart = halfStart.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        boolean palindrome = solution.isPalindrome(head);
        System.out.println(palindrome);
        Assert.assertEquals(false, palindrome);

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        palindrome = solution.isPalindrome(head);
        System.out.println(palindrome);
        Assert.assertEquals(true, palindrome);


        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        palindrome = solution.isPalindrome(head);
        System.out.println(palindrome);
        Assert.assertEquals(false, palindrome);
    }

}
