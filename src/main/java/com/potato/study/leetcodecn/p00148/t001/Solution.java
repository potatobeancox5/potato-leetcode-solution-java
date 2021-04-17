package com.potato.study.leetcodecn.p00148.t001;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 148. 排序链表
 *
 * 你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

 进阶：

 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
  

 示例 1：


 输入：head = [4,2,1,3]
 输出：[1,2,3,4]
 示例 2：


 输入：head = [-1,5,3,4,0]
 输出：[-1,0,3,4,5]
 示例 3：

 输入：head = []
 输出：[]
  

 提示：

 链表中节点的数目在范围 [0, 5 * 104] 内
 -105 <= Node.val <= 105

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sort-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 递归 求 每个 排序的长度
     * 归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        // 找到 中间点 进行分割 （不断链表那种）
        return sortList(head, null);
    }


    /**
     * 对 head 到 tail 之间进行排序
     * @param head
     * @param tail
     * @return
     */
    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        // 只有一个节点的时候 自然有序
        if (head.next == null || head.next == tail) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode fast = newHead;
        ListNode slow = newHead;
        // 找到中间点 进行排序 记得断开链表
        while (fast != null && fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast == null || fast == tail) {
                break;
            }
            fast = fast.next;
        }
        sortList(head, slow);
        sortList(slow, null);
        return mergeSortedListNode(head, slow);
    }


    /**
     * 归并排序 两个 head 的list
     * @param head1
     * @param head2
     * @return
     */
    private ListNode mergeSortedListNode (ListNode head1, ListNode head2) {
        ListNode head = new ListNode(-1);
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode p = head;
        // 处理两个链表情况
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        // 处理 单链表情况
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head.next;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = ListNodeUtil.stringToListNode("4->2->1->3");
        ListNode head = solution.sortList(root);
        // [1,2,3,4]
        ListNodeUtil.printListNode(head);


        root = ListNodeUtil.stringToListNode("-1->5->3->4->0");
        head = solution.sortList(root);
        // [-1,0,3,4,5]
        ListNodeUtil.printListNode(head);



    }

}
