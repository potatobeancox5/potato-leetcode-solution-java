package com.potato.study.leetcodecn.p0061.t001;


import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 61. 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: 1->2->3->4->5->NULL, k = 2
 输出: 4->5->1->2->3->NULL
 解释:
 向右旋转 1 步: 5->1->2->3->4->NULL
 向右旋转 2 步: 4->5->1->2->3->NULL
 示例 2:

 输入: 0->1->2->NULL, k = 4
 输出: 2->0->1->NULL
 解释:
 向右旋转 1 步: 2->0->1->NULL
 向右旋转 2 步: 1->2->0->NULL
 向右旋转 3 步: 0->1->2->NULL
 向右旋转 4 步: 2->0->1->NULL

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/rotate-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 先遍历一遍 计算长度len，然后 对len - k%len
     * 遍历 列表 计数找到 第 len - k%len 然后进行拼接
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || null == head) {
            return head;
        }
        int length = 0;
        ListNode p = head;
        // 用来拼接
        ListNode tail = p;
        while (p != null) {
            length++;
            tail = p;
            p = p.next;
        }
        if (k % length == 0) {
            return head;
        }
        int firstLen = length - k % length;
        p = head;
        while (p != null && firstLen > 1) {
            firstLen--;
            p = p.next;
        }
        ListNode firstNode = p.next;
        tail.next = head;
        p.next = null;
        head = firstNode;
        return head;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode listNode = ListNodeUtil.stringToListNode("1->2->3->4->5");
        int k = 2;
        ListNode res = solution.rotateRight(listNode, k);
        ListNodeUtil.printListNode(res);

        listNode = ListNodeUtil.stringToListNode("0->1->2");
        k = 4;
        res = solution.rotateRight(listNode, k);
        ListNodeUtil.printListNode(res);

        listNode = ListNodeUtil.stringToListNode("1");
        k = 0;
        res = solution.rotateRight(listNode, k);
        ListNodeUtil.printListNode(res);

        listNode = ListNodeUtil.stringToListNode("");
        k = 0;
        res = solution.rotateRight(listNode, k);
        ListNodeUtil.printListNode(res);
    }
}
