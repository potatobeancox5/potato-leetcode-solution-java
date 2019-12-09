package com.potato.study.leetcode.p0600;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         600. Non-negative Integers without Consecutive Ones
 * 
 *         Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.

Example 1:
Input: 5
Output: 5
Explanation:
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
Note: 1 <= n <= 109
 * 
 *         思路：
 *
 *         600. Non-negative Integers without Consecutive Ones

zero i  i位置为0的个数
one j   j位置为1的可能个数

zero i = zero i-1 + one i-1
one i = zero i-1

最后给出小于n的情况

两个连续1 break

两个连续0 删除/onei continue

只有高位i为0的时候 i-1 不为1 i-1 才只能为0


https://blog.csdn.net/excellentlizhensbfhw/article/details/81915177
 *
 */
public class Solution {

    public int findIntegers(int num) {
        // 1. 找到 n位数字
        String s = Integer.toBinaryString(num);
        StringBuilder builder = new StringBuilder(s).reverse();
        int len = builder.length();
        // zero i  i位置为0的个数 one j   j位置为1的可能个数 高位在后边
        int[] one = new int[len];
        int[] zero = new int[len];

        one[0] = 1;
        zero[0] = 1;

        for (int i = 1; i < len; i++) {
            zero[i] = zero[i-1] + one[i-1];
            one[i] = zero[i-1];
        }
        // len 位数一共有多少种可能
        int totalRes = zero[len-1] + one[len-1];
        // 从高位开始 计算 当前 多出来的那部分数字 最高位保留
        for (int i = len-2; i>=0 ; i--) {
            if (builder.charAt(i+1) == '0' && builder.charAt(i) == '0') {
                totalRes -= one[i];
            } else if (builder.charAt(i) == '1' && builder.charAt(i+1) == '1') {
                break;
            }
        }
        return totalRes;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int num = 5;
        int res = solution.findIntegers(num);
        System.out.println(res);
        Assert.assertEquals(5, res);
    }
}
