package com.potato.study.leetcode.p0876;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * @author liuzhao11
 * <p>
 * 876. Middle of the Linked List
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.



Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 *
 * 题目含义：
 *
 * 思路：
 * 快慢指针

 *
 */
public class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode slow = null;
        ListNode fast = null;
        ListNode startNode = new ListNode(-1);
        startNode.next = head;
        slow = startNode;
        fast = startNode;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) { // 偶数节点
                return slow;
            }
            fast = fast.next;
            if (null == fast) { // 奇数 节点
                return slow;
            }
        }
        return null;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] arr = {1,2,3,4,5};
		int[] arr = {1,2,3,4,5,6};
		ListNode head = ListNodeUtil.intArrayToListNode(arr);
        ListNode mid = solution.middleNode(head);
        System.out.println(mid.val);
    }
}
