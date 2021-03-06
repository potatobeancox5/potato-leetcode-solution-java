package com.potato.study.leetcodecn.p00147.t001;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 147. 对链表进行插入排序
 *
 * 对链表进行插入排序。


 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

  

 插入排序算法：

 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 重复直到所有输入数据插入完为止。
  

 示例 1：

 输入: 4->2->1->3
 输出: 1->2->3->4
 示例 2：

 输入: -1->5->3->4->0
 输出: -1->0->3->4->5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/insertion-sort-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 对链表进行插入排序
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        // 只有一个元素 不进行排序
        if (null == head || head.next == null) {
            return head;
        }
        // 设置哨兵 初始指向null
        ListNode sentinel = new ListNode(-1);
        ListNode p = head;
        // p 非空 说明 还有元素带排序
        while (p != null) {
            // 如果当前是第一点时不用排序
            if (sentinel.next == null) {
                sentinel.next = p;
                ListNode current = p;
                p = p.next;
                // 断开列表防止出错
                current.next = null;
            } else {
                // 不是第一个节点 需要先进行位置查找再进行插入 从开始位置
                ListNode q = sentinel.next;
                ListNode pre = sentinel;
                while (q != null && p.val > q.val) {
                    pre = pre.next;
                    q = q.next;
                }
                // q 到了末尾或者 插入 到 pre和q之间
                pre.next = p;
                ListNode next = p.next;
                p.next = q;
                // p 往后移动一下
                p = next;
            }
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = ListNodeUtil.stringToListNode("4->2->1->3");
        ListNode head = solution.insertionSortList(root);
        ListNodeUtil.printListNode(head);


        root = ListNodeUtil.stringToListNode("-1->5->3->4->0");
        head = solution.insertionSortList(root);
        ListNodeUtil.printListNode(head);
    }

}
