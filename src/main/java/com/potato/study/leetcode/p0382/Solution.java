package com.potato.study.leetcode.p0382;

import com.potato.study.leetcode.domain.ListNode;

import java.util.Random;

/**
 * 
 * @author liuzhao11
 * 
 *       382. Linked List Random Node
 * 
 *      Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
 *         
 *         思路：
 *         https://blog.csdn.net/criminalcode/article/details/69948509
 *
 *         保证第i个数 被随机到到概率是 1/i 即可
 *
 *
 *
 */
public class Solution {

    private ListNode head;
    private Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode p = head;
        int count = 0;
        int res = -1;
        while (p != null) {
            int key = random.nextInt(++count);
            if (key == count - 1) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }


	
	public static void main(String[] args) {
	}
}
