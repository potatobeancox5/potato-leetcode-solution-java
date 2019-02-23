package com.potato.study.leetcode.p0946;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	946. Validate Stack Sequences
 *  
 *       Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.



Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.


Note:

0 <= pushed.length == popped.length <= 1000
0 <= pushed[i], popped[i] < 1000
pushed is a permutation of popped.
pushed and popped have distinct values.
 *         
 *         题目含义：
 *
 *
 *         思路：
 *          申请一个栈
 *          出栈的时候peek一下 是否和pop数组给的值一致，
 *              是的话 pop掉 移动pop数组 ，
 *              不是的话push 数组的值，如果此时不能push了说明不匹配
 *
 *
 * 
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (null == pushed && null == popped) {
            return true;
        } else if (null == pushed) {
            return false;
        } else if (null == popped) {
            return false;
        }

        if (pushed.length != popped.length) {
            return false;
        }

        if (0 == pushed.length) {
            return true;
        }


        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        // 先push 一个值
        stack.push(pushed[i++]);
        while (j < popped.length) {
            if (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                if (i < pushed.length) {
                    stack.push(pushed[i++]);
                } else {
                    return false;
                }

            }
        }
        return true;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] pushed = {1,2,3,4,5};
//		int[] popped = {4,5,3,2,1};

//        int[] pushed = {1,2,3,4,5};
//		int[] popped = {4,3,5,1,2};

        int[] pushed = {};
        int[] popped = {};
        boolean result = solution.validateStackSequences(pushed, popped);
        System.out.println(result);
    }
}
