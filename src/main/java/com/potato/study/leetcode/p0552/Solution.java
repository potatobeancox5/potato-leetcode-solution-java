package com.potato.study.leetcode.p0552;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *        552. Student Attendance Record II
 * 
 *         Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.

A student attendance record is a string that only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

Example 1:
Input: n = 2
Output: 8
Explanation:
There are 8 records with length 2 will be regarded as rewardable:
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" won't be regarded as rewardable owing to more than one absent times.
Note: The value of n won't exceed 100,000.

 * 
 * 
 *         思路：
 *         552. Student Attendance Record II

数学题
总共可能数
3^n 减去2次 a种类数 减去连续3次late 且至多1次absent数目

3^n-
n个位置选2个a 其他位置全排列
n-2种late3连续 其他n-3位置 两种可能有一个a 或者没有 分别计算两种情况

https://www.jianshu.com/p/f1d253005412
 *
 *       定义了三个DP数组P(Present), L(Late), A(Absent).
其中P[i]表示数组[0,i]范围内以P结尾的所有排列方式，L[i]表示数组[0,i]范围内以L结尾的所有排列方式，A[i]表示数组[0,i]范围内以A结尾的所有排列方式
 *       结果就是 P[n-1] + L[n-1] + A[n-1]
 *
 *       https://www.jianshu.com/p/f1d253005412
 */
public class Solution {

    public int checkRecord(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 3;
        }

        long[] a = new long[n];
        long[] l = new long[n];
        long[] p = new long[n];

        // p结尾 只有pl
        long[] onlyP = new long[n];
        // l结尾 只有pl
        long[] onlyL = new long[n];

        // 设置 0，1 因为要从2开始
        a[0] = 1;
        a[1] = 2;
        l[0] = 1;
        l[1] = 3;
        p[0] = 1;
        p[1] = 3;

        onlyL[0] = 1;
        onlyL[1] = 2;


        onlyP[0] = 1;
        onlyP[1] = 2;

        for (int i = 2; i < n; i++) {
            // i-1 位置是p的 + i-2 位置是p的（i-1固定是l）
            onlyL[i] = (onlyP[i-1] + onlyP[i-2]) % 1000000007;
            onlyP[i] = (onlyP[i-1] + onlyL[i-1]) % 1000000007;

            p[i] = (p[i-1] + a[i-1] + l[i-1]) % 1000000007;
            // i - 1 是 a / i-1 是p或者 i-1 是l i-2 是a/p
            l[i] = (a[i - 1] + p[i - 1] + a[i - 2] + p[i - 2]) % 1000000007;
            // onlyP[i];
            a[i] = (onlyP[i-1] + onlyL[i-1]) % 1000000007;
        }
        return (int)((a[n-1] + l[n-1] + p[n-1]) % 1000000007);
    }


	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		int n = 2;

        int result = solution.checkRecord(n);
        System.out.println(result);
        Assert.assertEquals(8, result);


        n = 100;

        result = solution.checkRecord(n);
        System.out.println(result);
        Assert.assertEquals(985598218, result);


        n = 99996;

        result = solution.checkRecord(n);
        System.out.println(result);
        Assert.assertEquals(555387871, result);

    }
}
