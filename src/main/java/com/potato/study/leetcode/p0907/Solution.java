package com.potato.study.leetcode.p0907;

import org.junit.Assert;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	907. Sum of Subarray Minimums
 *  
 *      Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

Since the answer may be large, return the answer modulo 10^9 + 7.



Example 1:

Input: [3,1,2,4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.


Note:

1 <= A.length <= 30000
1 <= A[i] <= 30000

 *         
 *         题目含义：
 *         https://leetcode-cn.com/problems/sum-of-subarray-minimums/solution/zi-shu-zu-de-zui-xiao-zhi-zhi-he-by-leetcode/
 *
 *         思路：
 *
 *          单调栈
 *
 *
 */
public class Solution {

    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int len = arr.length;

        Stack<Integer> stack = new Stack();
        int[] prev = new int[len];
        for (int i = 0; i < len; ++i) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack = new Stack();
        int[] next = new int[len];
        for (int k = len-1; k >= 0; --k) {
            while (!stack.isEmpty() && arr[k] < arr[stack.peek()]) {
                stack.pop();
            }
            next[k] = stack.isEmpty() ? len : stack.peek();
            stack.push(k);
        }

        // Use prev/next array to count answer
        long ans = 0;
        for (int i = 0; i < len; ++i) {
            ans += (i - prev[i]) * (next[i] - i) % mod * arr[i] % mod;
            ans %= mod;
        }
        return (int) ans;

    }




    public static void main(String[] args) {
		Solution solution = new Solution();
        int[] arr = {3,1,2,4};
        int result = solution.sumSubarrayMins(arr);
        System.out.println(result);
        Assert.assertEquals(17, result);
    }
}
