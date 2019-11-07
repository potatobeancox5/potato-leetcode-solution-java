package com.potato.study.leetcode.p0483;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         483. Smallest Good Base
 * 
 *        For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.

Now given a string representing n, you should return the smallest good base of n in string format.

Example 1:

Input: "13"
Output: "3"
Explanation: 13 base 3 is 111.


Example 2:

Input: "4681"
Output: "8"
Explanation: 4681 base 8 is 11111.


Example 3:

Input: "1000000000000000000"
Output: "999999999999999999"
Explanation: 1000000000000000000 base 999999999999999999 is 11.


Note:

The range of n is [3, 10^18].
The string representing n is always valid and will not have leading zeros.
 * 
 *         思路：
 *         https://segmentfault.com/a/1190000008366710
 *         483. Smallest Good Base

https://blog.csdn.net/qq_23997101/article/details/73135615

num 表示 给定字符串生存的数字

base = 向下取整 num开k次方

其中 主要确定k

子方法 判定  num 是否 可由base 和k 组成

num== 1+base^1...base^k

主方法
遍历k k max 是log2num 最大值不应超过64 long最大位

每个k 判断能否组成


都不行 返回num-1


https://segmentfault.com/a/1190000008366710?utm_medium=referral&utm_source=tuicool
 *         
 * 
 */
public class Solution {


    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        long kMax = Math.min(64, (long)Math.pow(num, 0.5));

        for (long k = kMax; k > 1; k--) {
            long base = (long) Math.pow(num, 1.0 / k);
            if (isGoodBase(num, base, k)) {
                return String.valueOf(base);
            }
        }
        return String.valueOf(num - 1);
    }

    /**
     * 子方法 判定  num 是否 可由base 和k 组成
     * @return
     */
    private boolean isGoodBase(long num, long base, long k) {
        long tmp = 1;
        for (int i = 0; i <= k; i++) {
            num = num - tmp;
            tmp *= base;
        }
        return num == 0;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		String n = "13";
		String s = solution.smallestGoodBase(n);
		System.out.println(s);
        Assert.assertEquals("3", s);

        n = "4681";
        s = solution.smallestGoodBase(n);
        System.out.println(s);
        Assert.assertEquals("8", s);
	}
}
