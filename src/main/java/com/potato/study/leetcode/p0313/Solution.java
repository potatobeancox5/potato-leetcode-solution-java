package com.potato.study.leetcode.p0313;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 *         313. Super Ugly Number
 *         
 *          
 *         Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.

Example:

Input: n = 12, primes = [2,7,13,19]
Output: 32
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
super ugly numbers given primes = [2,7,13,19] of size 4.
Note:

1 is a super ugly number for any given primes.
The given numbers in primes are in ascending order.
0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

 *         
 *         
 *
 *
 *         题目含义：
 *         给定一个Ugly 数组，求有这个数组内的数作为因数的第几个数字
 *         思路：
 *         https://blog.csdn.net/u012528000/article/details/78545076
 *         1. 开一个数组 记录当前结果res res[0] = 1
 *         2. 开一个数组 multiIndex[] 记录当前 primes 应该乘的index 数 从0开始
 *         3. 执行n 次循环 每次求 primes[j] * res[multiIndex[j]] 记录最小的j 和 outcome 放到对应的res[i] 中
 *
 *          注意：处理相等的情况
 *
 *
 *         
 *         
 *         
 *         
 *         
 */
public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int[] multiIndex = new int[primes.length];
        for (int i = 0; res.size() < n; i++) {
            // 每次求 primes[j] * res[multiIndex[j]] 记录最小的j 和 outcome 放到对应的res[i] 中
            int minIndex = 0;
            int min = primes[0] * res.get(multiIndex[0]);
            for (int j = 1; j < primes.length; j++) {
                int cur = primes[j] * res.get(multiIndex[j]);
                if (cur < min) {
                    min = cur;
                    minIndex = j;
                }
            }
            //最小值放入res 然后对应multiIndex[minIndex] ++
            if (min != res.get(res.size() - 1)) {
                // 处理相等的情况
                res.add(min);
            }
            multiIndex[minIndex]++;
        }
        System.out.println(res);
        return res.get(n - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 12;
        int[] nums = {2,7,13,19};
        int value = solution.nthSuperUglyNumber(n, nums);
        System.out.println("value : " + value);
    }
}
