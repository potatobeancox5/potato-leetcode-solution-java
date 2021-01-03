package com.potato.study.leetcodecn.p00382.t001;

import com.potato.study.leetcode.domain.ListNode;

import java.util.Random;

/**
 * 382. 链表随机节点
 *
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。

 进阶:
 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？

 示例:

 // 初始化一个单链表 [1,2,3].
 ListNode head = new ListNode(1);
 head.next = new ListNode(2);
 head.next.next = new ListNode(3);
 Solution solution = new Solution(head);

 // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 solution.getRandom();

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/linked-list-random-node
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    private ListNode head;
    private Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /** Returns a random node's value. */
    /**
     * 初始化一个蓄水池
     * 其实可以看做 蓄水池 大小是1 的特例
     *
     * @return
     */
    public int getRandom() {
        int[] sample = new int[100];
        ListNode p = head;
        int i = 0;
        while (p != null) {
            if (i < 100) {
                sample[i] = p.val;
            } else {
                int ran = random.nextInt(i + 1);
                if (ran < 100) {
                    sample[ran] = p.val;
                }
            }
            i++;
            p = p.next;
        }
        int target = 0;
        if (i < 100) {
            target = random.nextInt(i);
        } else {
            target = random.nextInt(100);
        }
        return sample[target];
    }
}
