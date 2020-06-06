package com.potato.study.leetcode.p1202;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1201. Ugly Number III
 *  
 *
Write a program to find the n-th ugly number.

Ugly numbers are positive integers which are divisible by a or b or c.



Example 1:

Input: n = 3, a = 2, b = 3, c = 5
Output: 4
Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
Example 2:

Input: n = 4, a = 2, b = 3, c = 4
Output: 6
Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
Example 3:

Input: n = 5, a = 2, b = 11, c = 13
Output: 10
Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
Example 4:

Input: n = 1000000000, a = 2, b = 217983653, c = 336916467
Output: 1999999984


Constraints:

1 <= n, a, b, c <= 10^9
1 <= a * b * c <= 10^18
It's guaranteed that the result will be in range [1, 2 * 10^9]
 *         
 *         思路：
 *
 *          https://blog.csdn.net/zjbzlc/article/details/101198435
 *

 *
 */
public class Solution {

    public int nthUglyNumber(int n, int a, int b, int c) {
        int count = 0;
        int low = a;
        // 一定在这个之间
        int high = n * a;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long numbers = countNthUglyNumber(mid, a, b, c);
            if (numbers > n) {
                high = mid - 1;
            } else if (numbers < n) {
                low = mid + 1;
            } else {
                // 相等 最后一个数字 命中n
                if (countNthUglyNumber(mid-1, a,b,c) < n) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return count;

    }


    /**
     * 给定 n 和 a,b,c，找到n以内中因数包含a,b,c的个数
     * @param n
     * @param a
     * @param b
     * @param c
     * @return
     */
    public long countNthUglyNumber(int n, int a, int b, int c) {
        long res;
        // 求每个组合的最小公倍数
        long ab = lcm(a,b);
        long ac = lcm(a,c);
        long bc = lcm(b,c);
        long abc = lcm(ab,c);
        // 求 n 中包含各个数的个数
        res = n / a + n / b - n / ab + n / c  - n/ac - n/bc +  n / abc;
        return res;
    }


    /**
     * 求两个数的最小公倍数
     * @param num1
     * @param num2
     * @return
     */
    private long lcm(long num1, long num2) {
        return num1 * num2 / gcd(num1, num2);
    }

    /**
     * 求对打公约数
     * @param num1
     * @param num2
     * @return
     */
    private long gcd (long num1, long num2) {
        // 交换两个数
        if (num1 < num2) {
            long tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        // 辗转相除
        while (num1 % num2 != 0) {
            long tmp = num1 % num2;
            num1 = num2;
            num2 = tmp;
        }
        return num2;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 3;
        int a = 2;
        int b = 3;
        int c = 5;
        int res = solution.nthUglyNumber(n, a, b, c);
        System.out.println(res);
        Assert.assertEquals(4, res);

        n = 4;
        a = 2;
        b = 3;
        c = 4;
        res = solution.nthUglyNumber(n, a, b, c);
        System.out.println(res);
        Assert.assertEquals(6, res);

        n = 5;
        a = 2;
        b = 11;
        c = 13;
        res = solution.nthUglyNumber(n, a, b, c);
        System.out.println(res);
        Assert.assertEquals(10, res);

        n = 1000000000;
        a = 2;
        b = 217983653;
        c = 336916467;
        res = solution.nthUglyNumber(n, a, b, c);
        System.out.println(res);
        Assert.assertEquals(1999999984, res);
    }
}
