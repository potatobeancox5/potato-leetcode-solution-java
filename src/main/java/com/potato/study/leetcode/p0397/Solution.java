package com.potato.study.leetcode.p0397;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *       397. Integer Replacement
 * 
 *     Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1
 *         
 *         思路：
 *
 *         easy  每遇到奇数时，分别判断n-1还是n+1的尾部零更多，越多的当然步骤越少。

            特殊case：当n==Integer 最大值时，当n==3时
https://blog.csdn.net/yeqiuzs/article/details/52506492
 *
 *         
 */
public class Solution {

    public int integerReplacement(int n) {
        if (n <= 1) {
            return 0;
        }
        // 特殊情况 3 因为3 + 1 与3 -1 改变了1数位中存在的1的个数
        if (n == 3) {
            return 2;
        }
        // 转换 n 成 long形式 防止过多
        long real = n;
        int count = 0;
        while (real != 1) {
            if (real % 2 == 0) {
                count++;
                real = real >> 1;
            } else {
                if (real == 3) {
                    real = 2;
                } else if (countZeroBit(real - 1) > countZeroBit(real + 1)) {
                // 每遇到奇数时，分别判断n-1还是n+1的尾部零更多，越多的当然步骤越少。
                    real = real - 1;
                } else {
                    real = real + 1;
                }
                count++;
            }
        }
        return count;
    }

    /**
     * 判断real 末尾有多少个0
     * @param real
     * @return
     */
    private int countZeroBit(long real) {
        int count = 0;
        while (real > 0 && (real & 1) == 0) {
            count++;
            real = real >> 1;
        }
        return count;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        int n = 8;
        int res = solution.integerReplacement(n);
        System.out.println(res);
        Assert.assertEquals(3, res);

        n = 7;
        res = solution.integerReplacement(n);
        System.out.println(res);
        Assert.assertEquals(4, res);


        n = 65535;
        res = solution.integerReplacement(n);
        System.out.println(res);
        Assert.assertEquals(17, res);

        n = 1234;
        res = solution.integerReplacement(n);
        System.out.println(res);
        Assert.assertEquals(14, res);
    }
}

