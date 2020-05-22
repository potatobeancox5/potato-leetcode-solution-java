package com.potato.study.leetcode.p0878;

import org.junit.Assert;

/**
 * @author liuzhao11
 *
 *
 *
 * 878. Nth Magical Number
 *
 *
 * A positive integer is magical if it is divisible by either A or B.

Return the N-th magical number.  Since the answer may be very large, return it modulo 10^9 + 7.



Example 1:

Input: N = 1, A = 2, B = 3
Output: 2
Example 2:

Input: N = 4, A = 2, B = 3
Output: 6
Example 3:

Input: N = 5, A = 2, B = 4
Output: 10
Example 4:

Input: N = 3, A = 6, B = 4
Output: 8


Note:

1 <= N <= 10^9
2 <= A <= 40000
2 <= B <= 40000
 *
 * 思路：
 *      https://leetcode-cn.com/problems/nth-magical-number/solution/di-n-ge-shen-qi-shu-zi-by-leetcode/
 *
 *
 */
public class Solution {

    public int nthMagicalNumber(int n, int a, int b) {
        int mod = 1_000_000_007;
        // 最小公倍数
        int ll = a / gcd(a, b) * b;
        // 开始位置和 终结位置
        long left = 0;
        long right = (long) 1e15;
        while (left < right) {
            long middle = left + (right - left) / 2;
            // If there are not enough magic numbers below mi...
            if (middle / a + middle / b - middle / ll < n)
                left = middle + 1;
            else
                right = middle;
        }

        return (int) (left % mod);
    }


    /**
     * 求最大公约数
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x, int y) {
        if (x == 0) {
            return y;
        }
        return gcd(y % x, x);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 1;
        int a = 2;
        int b = 3;
        int head = solution.nthMagicalNumber(n, a, b);
        System.out.println(head);
        Assert.assertEquals(2, head);
    }
}
