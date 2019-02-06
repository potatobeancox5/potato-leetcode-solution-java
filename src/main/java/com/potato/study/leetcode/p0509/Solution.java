package com.potato.study.leetcode.p0509;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         509. Fibonacci Number
 * 
 *         The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).



Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.


Note:

0 ≤ N ≤ 30.


 * 
 * 
 *         思路： 求斐波拉切数列

N - 1 he n - 2 的值，不断更新
设置cache map 用于优化速度
 *          
 */
public class Solution {

    private static Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int n) {
        cache.put(0, 0);
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        // 计算 f数列
        int n1 = 1;
        int n2 = 1;
        if (n <= 2) {
            cache.put(n, 1);
            return 1;
        }
        for (int i = 3; i <= n ;i++) {
            int tmp = n1 + n2;
            if (i == n) {
                cache.put(n, tmp);
                return tmp;
            } else { // 替换n1 和n2
                n1 = n2;
                n2 = tmp;
            }
        }
        return 0;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        for (int i = 1; i <= 30; i++) {
            int result = solution.fib(i);
            System.out.println(result);
        }

	}
}
