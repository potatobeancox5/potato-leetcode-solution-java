package com.potato.study.leetcodecn.p0083.t001;


import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

 示例 1:

 输入: 1->1->2
 输出: 1->2
 示例 2:

 输入: 1->1->2->3->3
 输出: 1->2->3

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        // 之前出现过的节点
        if (null == head) {
            return head;
        }
        Set<Integer> hasCame = new HashSet<>();
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p = head;
        head = pre;
        while (p != null) {
            if (!hasCame.contains(p.val)) {
                hasCame.add(p.val);
                p = p.next;
                pre = pre.next;
            } else {
                // 存在
                pre.next = p.next;
                p.next = null;
                p = pre.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode = ListNodeUtil.stringToListNode("1->1->2");
        ListNode node = solution.deleteDuplicates(listNode);
        ListNodeUtil.printListNode(node);


        listNode = ListNodeUtil.stringToListNode("1->1->2->3->3");
        node = solution.deleteDuplicates(listNode);
        ListNodeUtil.printListNode(node);
    }
}
