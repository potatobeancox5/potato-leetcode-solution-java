package com.potato.study.leetcodecn.p00234.t001;

import com.potato.study.leetcode.domain.ListNode;

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
        // 计算一半的位置 奇数 偶数 需要移动多少个节点数
        int half = (length % 2 == 0 ? length / 2: length / 2 + 1);
        p = head;
        // 过程中 翻转链表
        for (int i = 0; i < half; i++) {
            p = p.next;
        }
        ListNode halfStart = p;


        return false;
    }

}
