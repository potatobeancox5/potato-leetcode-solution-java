package com.potato.study.leetcode.p1019;


import com.potato.study.leetcode.domain.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	1019. Next Greater Node In Linked List
 *  
 *        We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.

Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.

Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.



Example 1:

Input: [2,1,5]
Output: [5,5,0]
Example 2:

Input: [2,7,4,3,5]
Output: [7,0,5,5,0]
Example 3:

Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]


Note:

1 <= node.val <= 10^9 for each node in the linked list.
The given list has length in the range [0, 10000].
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/next-greater-node-in-linked-list/solution/dan-diao-zhan-on-by-huangyt/
 *
 *         单调栈
 *
 *         https://leetcode-cn.com/problems/next-greater-node-in-linked-list/solution/java-dan-diao-zhan-by-anyfeel/
 *
 *          单调栈的思路
栈中保存链表的节点编号（即下标），还需要一个 data 数组保存下标对应的链表值（避免再次遍历链表）
按单调递减栈的入栈顺序，如果出现当前遍历到的节点比栈顶值大，说明需要将栈中元素出栈，并更新 res 值


    栈内元素 保证比当前 index大

    stack 存 index 如果当前元素值 比栈顶大 说明 当前元素是栈顶元素的第一个最大值 设置即可
 *
 */
public class Solution {

    public int[] nextLargerNodes(ListNode head) {
        // stack 存index 目前还没有获得最大值的index
        Stack<Integer> notGetResultIndexStack = new Stack<>();
        // 存链表 原来的值 因为不知道多长没办法数据
        List<Integer> data = new ArrayList<>();
        // 存结果 index 就是 链表的index
        List<Integer> resultList = new ArrayList<>();

        while (null != head) {
            data.add(head.val);
            // 初始值
            resultList.add(0);
            // 如果当前元素值 比栈顶大 说明 当前元素是栈顶元素的第一个最大值 设置即可
            while (!notGetResultIndexStack.isEmpty() && data.get(notGetResultIndexStack.peek()) < head.val) {
                Integer index = notGetResultIndexStack.pop();
                resultList.set(index, head.val);
            }
            notGetResultIndexStack.push(data.size() - 1);

            head = head.next;
        }

        int[] res = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }
        return res;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 2;
        int[] b = solution.nextLargerNodes(null);
        System.out.println(Arrays.toString(b));

    }
}
