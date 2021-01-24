package com.potato.study.leetcodecn.p00086.t001;


import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 86. 分隔链表
 *
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

 你应当保留两个分区中每个节点的初始相对位置。

  

 示例：

 输入：head = 1->4->3->2->5->2, x = 3
 输出：1->2->2->4->3->5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/partition-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (null == head) {
            return head;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);

        ListNode small = smallHead;
        ListNode big = bigHead;

        ListNode p = head;
        while (null != p) {
            if (p.val < x) {
                small.next = p;
                small = small.next;
            } else {
                big.next = p;
                big = big.next;
            }
            p = p.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = ListNodeUtil.stringToListNode("1->4->3->2->5->2");
        int x = 3;
        ListNode partition = solution.partition(head, x);
        ListNodeUtil.printListNode(partition);

    }
}
