package com.potato.study.leetcode.p0725;

import com.potato.study.leetcode.domain.ListNode;

/**
 * 
 * @author liuzhao11
 * 
 * 	725. Split Linked List in Parts
 *  
 *         Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

Return a List of ListNode's representing the linked list parts that are formed.

Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
Example 1:
Input:
root = [1, 2, 3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The input and each element of the output are ListNodes, not arrays.
For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but it's string representation as a ListNode is [].
Example 2:
Input:
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
Note:

The length of root will be in the range [0, 1000].
Each value of a node in the input will be an integer in the range [0, 999].
k will be an integer in the range [1, 50].
 *         
 *         思路：
 *
 *
 * 
 */
public class Solution {

    public ListNode[] splitListToParts(ListNode root, int k) {

        // 1. 遍历 root 统计长度
        int count = 0;
        ListNode p = root;
        while (p != null) {
            count++;
            p = p.next;
        }

        // 2. 向上取整数 计算每个节点的个数
        int nodeCount = (int) Math.floor(1.0 * count / k);
        int leftover = count - nodeCount * k;
        // 3. 遍历 root 构造 返回数组
        ListNode[] resultArray = new ListNode[k];
        p = root;
        int currentCount = 0;
        int index = 0;
        while (p != null) {
            // 当前是 0 节点
            if (currentCount == 0) {
                resultArray[index++] = p;
            }
            currentCount++;
            ListNode pre = p;
            p = p.next;
            if (leftover > 0) {
                if (currentCount == nodeCount + 1) {
                    currentCount = 0;
                    leftover--;
                    // 断开节点
                    pre.next = null;
                }
            } else {
                if (currentCount == nodeCount) {
                    currentCount = 0;
                    // 断开节点
                    pre.next = null;
                }
            }
        }
        return resultArray;
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        int k = 10;
        ListNode[] s = solution.splitListToParts(root, k);
        System.out.println(s[1]);
    }
}
