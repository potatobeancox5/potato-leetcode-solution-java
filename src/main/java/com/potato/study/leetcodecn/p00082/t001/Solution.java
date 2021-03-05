package com.potato.study.leetcodecn.p00082.t001;


import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

 示例 1:

 输入: 1->2->3->3->4->4->5
 输出: 1->2->5
 示例 2:

 输入: 1->1->1->2->3
 输出: 2->3

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 一个 pre 一个 p 一个prepre
     如果pre 不等于p 时 pre p 往前滑动
     如果pre 等于p 一直往后滑动p 直到p为null 或者p 为不是pre 的时候
     prepre 与p 连接

     哨兵上 prepre =null pre 等于哨兵 p 等于首节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 声明哨兵
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        sentinel.next = head;
        ListNode p = head;
        ListNode pre = sentinel;
        ListNode prepre = null;
        // 如果
        while (p != null) {
            // 如果pre 不等于p 时 pre p 往前滑动
            if (pre.val != p.val) {
                prepre = pre;
                pre = p;
                p = p.next;
                continue;
            }
            // 如果pre 等于p 一直往后滑动p 直到p为null 或者p 为不是pre 的时候
            while (p != null && p.val == pre.val) {
                p = p.next;
            }
            // prepre 与p 连接   因为 pre 到 p之前的结点都是相同的 p指向新开始 prepre 是之前的结点
            if (null == prepre) {
                // 直接删
                pre = sentinel.next = p;
            } else {
                // 删除 确定 之后要比较的点
                prepre.next = p;
                pre = p;
                if (p == null) {
                    break;
                }
                p = p.next;
            }
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode listNode = solution.deleteDuplicates(head);
        ListNodeUtil.printListNode(listNode);
    }
}
