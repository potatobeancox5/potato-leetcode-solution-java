package com.potato.study.leetcodecn.p00092.t001;


import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 92. 反转链表 II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

 说明:
 1 ≤ m ≤ n ≤ 链表长度。

 示例:

 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 输出: 1->4->3->2->5->NULL

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 head p 当前指向点
     * 小于 m 或者 大于 n 时，直接 p 往后移动
     * 如果 p 是第 m 个点 记录下 p的pre 位置 revertStrat = p的pre位置 并开始反转 并记录本次反转的尾巴 end
     * 如果 p 是第 n 个点 记录下 p的next 位置 revertEnd = p的pre位置 并且记下 这个段 反转的头部 start
     *  pre = null
     *  next = p.next
     *  p.next = pre
     *  pre = p;
     *  p = p 的下一个点
     *
     *
     *
     * 链接上述 revertStrat start end revertEnd
     *
     *
     * 返回哨兵 next
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // m和n 相同 就不用翻转了
        if (m == n) {
            return head;
        }
        // 哨兵
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode p = head;
        // p 之前的点
        ListNode nodePre = sentinel;
        int current = 1;
        // m-1 节点
        ListNode revertStart = null;
        // n + 1 节点
        ListNode revertEnd = null;
        // 反转段的第一个节点 n
        ListNode start = null;
        // 反转段的最后一个节点 m
        ListNode end = null;
        while (p != null) {
            // 小于 m 或者 大于 n 时，直接 p 往后移动
            if (current < m || current > n) {
                nodePre = p;
                p = p.next;
                current++;
                continue;
            }
            if (current == m) {
                // 如果 p 是第 m 个点 记录下 p的pre 位置 revertStrat = p的pre位置 并开始反转 并记录本次反转的尾巴 end
                revertStart = nodePre;
                end = p;
                nodePre = null;
            } else if (current == n) {
                // 如果 p 是第 n 个点 记录下 p的next 位置 revertEnd = p的next位置 并且记下 这个段 反转的头部 start
                revertEnd = p.next;
                start = p;
            }
            // 反转操作
            ListNode tempNext = p.next;
            p.next = nodePre;
            // 移动
            nodePre = p;
            p = tempNext;
            current++;
        }
        // 链接中间翻转的部分
        revertStart.next = start;
        end.next = revertEnd;
        return sentinel.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNodeUtil.stringToListNode("1->2->3->4->5");
        ListNode listNode = solution.reverseBetween(head, 2, 4);
        // 1->4->3->2->5->NULL
        ListNodeUtil.printListNode(listNode);

        head = ListNodeUtil.stringToListNode("1->2->3->4->5");
        listNode = solution.reverseBetween(head, 1, 1);
        // 1->2->3->4->5
        ListNodeUtil.printListNode(listNode);

        head = ListNodeUtil.stringToListNode("1");
        listNode = solution.reverseBetween(head, 1, 1);
        // 1
        ListNodeUtil.printListNode(listNode);
    }
}
