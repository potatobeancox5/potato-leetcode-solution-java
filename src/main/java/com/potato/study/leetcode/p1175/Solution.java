package com.potato.study.leetcode.p1175;


/**
 * 
 * @author liuzhao11
 * 
 * 	1175. Prime Arrangements
 *  
 *
Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)

(Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)

Since the answer may be large, return the answer modulo 10^9 + 7.



Example 1:

Input: n = 5
Output: 12
Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
Example 2:

Input: n = 100
Output: 682289015


Constraints:

1 <= n <= 100
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/prime-arrangements/solution/javajian-ji-ban-ji-you-hua-by-dreshadow/
 *
 *
 */
public class Solution {

    public int numPrimeArrangements(int n) {
        if (n < 3) {
            return 1;
        }

        int count = 0;
        boolean[] nums = new boolean[n + 1];
        for (int i = 2; i * i < nums.length; i++) {
            if (!nums[i]) {
                for (int j = i * i; j < nums.length; j += i) {
                    if (nums[j]) {
                        continue;
                    }
                    nums[j] = true;
                    count++;
                }
            }
        }
        // 非质数的数量(加1：元素1不包含在内)
        count++;

        // 8以内的质数个数多于非质数
        if (n < 8) {
            count = n - count;
        }

        // 结果
        long res = 1;
        for (int i = 2; i <= count; i++) {
            res = (res * i) % 1000000007;
            // 这里判断会减少一轮遍历
            if (i == n - count) {
                res = (res * res) % 1000000007;
            }
        }
        return (int) res;
    }

}
