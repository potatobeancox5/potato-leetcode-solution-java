package com.potato.study.leetcode.p1414;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1414. Find the Minimum Number of Fibonacci Numbers Whose Sum Is K
 *  
 *
Given the number k, return the minimum number of Fibonacci numbers whose sum is equal to k, whether a Fibonacci number could be used multiple times.

The Fibonacci numbers are defined as:

F1 = 1
F2 = 1
Fn = Fn-1 + Fn-2 , for n > 2.
It is guaranteed that for the given constraints we can always find such fibonacci numbers that sum k.


Example 1:

Input: k = 7
Output: 2
Explanation: The Fibonacci numbers are: 1, 1, 2, 3, 5, 8, 13, ...
For k = 7 we can use 2 + 5 = 7.
Example 2:

Input: k = 10
Output: 2
Explanation: For k = 10 we can use 2 + 8 = 10.
Example 3:

Input: k = 19
Output: 3
Explanation: For k = 19 we can use 1 + 5 + 13 = 19.


Constraints:

1 <= k <= 10^9
 *         
 *         思路：
 *
 *         https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/solution/chao-ji-yi-dong-shi-jian-fu-za-du-o1-by-drama_

计算数列 存储45个 多于会溢出
遍历 当值小于是减去值 计数
返回计数
 *
 */
public class Solution {


    public int findMinFibonacciNumbers(int k) {

        int[] fib = new int[45];
        fib[0] = 1;
        fib[1] = 1;

        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        int target = k;
        int count = 0;
        for (int i = fib.length - 1; i >=0 ; i--) {
            if (target >= fib[i]) {
                target -= fib[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int k = 7;
        int res = solution.findMinFibonacciNumbers(k);
        System.out.println(res);
        Assert.assertEquals(2, res);

        k = 10;
        res = solution.findMinFibonacciNumbers(k);
        System.out.println(res);
        Assert.assertEquals(2, res);

        k = 19;
        res = solution.findMinFibonacciNumbers(k);
        System.out.println(res);
        Assert.assertEquals(3, res);
    }
}
