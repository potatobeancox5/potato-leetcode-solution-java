package com.potato.study.leetcode.p0629;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         629. K Inverse Pairs Array
 * 
 *         Given two integers n and k, find how many different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs.

We define an inverse pair as following: For ith and jth element in the array, if i < j and a[i] > a[j] then it's an inverse pair; Otherwise, it's not.

Since the answer may be very large, the answer should be modulo 109 + 7.

Example 1:

Input: n = 3, k = 0
Output: 1
Explanation:
Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pair.


Example 2:

Input: n = 3, k = 1
Output: 2
Explanation:
The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.


Note:

The integer n is in the range [1, 1000] and k is in the range [0, 1000].
 *
 * 	思路：
 *
 * 	629. K Inverse Pairs Array


https://blog.csdn.net/magicbean2/article/details/79006767

https://blog.csdn.net/Sdtin/article/details/74906094
求n个数字中 逆序数为k的个数
 *
 */
public class Solution {

    public int kInversePairs(int n, int k) {

        if (k > n*(n-1)/2 || k < 0) {
            return 0;
        }

        if (k == 0 || k == n*(n-1)/2) {
            return 1;
        }

        // dp i j 代表 从 1-i 组成数字 逆序数位j的种类数
        long[][] dp = new long[n+1][k+1];
        // dp i j 可以从 j  + 1放在不同的位置得到结果
        // 1,2
        dp[2][0] = 1;
        // 2,1
        dp[2][1] = 1;
        int mod = 1000000007;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, i * (i -1) / 2); j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                if (j >= i) {
                    dp[i][j] -= dp[i-1][j-i];
                }
                dp[i][j] = (dp[i][j] + mod ) % mod;
            }
        }
        return (int)dp[n][k];
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int n = 3;
        int k = 0;
		int kInversePairs = solution.kInversePairs(n, k);
		System.out.println(kInversePairs);
        Assert.assertEquals(1, kInversePairs);

        n = 3;
        k = 1;
        kInversePairs = solution.kInversePairs(n, k);
        System.out.println(kInversePairs);
        Assert.assertEquals(2, kInversePairs);
	}
}
