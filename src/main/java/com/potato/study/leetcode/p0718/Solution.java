package com.potato.study.leetcode.p0718;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	    718. Maximum Length of Repeated Subarray
 *  
 *         Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation:
The repeated subarray with maximum length is [3, 2, 1].


Note:

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100

 *         
 *         思路:
 *
 *         注意观察，dp 值不为0的地方，
 *         都是当 A[i] == B[j] 的地方，
 *         而且还要加上左上方的 dp 值，
 *         即 dp[i-1][j-1]，
 *         所以当前的 dp[i][j] 就等于 dp[i-1][j-1] + 1，而一旦 A[i] != B[j] 时，
 *         直接赋值为0，不用多想，因为子数组是要连续的，一旦不匹配了，就不能再增加长度了。
 *         每次算出一个 dp 值，都要用来更新结果 res，这样就能得到最长相同子数组的长度了，参见代码如下：
 *
 *          dp ij 代表 最大的长度
 *              if i-1 j-1 相等 dp ij = 1 + dp i-1 j-1
 *              else  不相等 dp ij = 0
 *              求 max
 *
 *              https://www.cnblogs.com/grandyang/p/7801533.html 解法 三
 * 
 */
public class Solution {

    public int findLength(int[] a, int[] b) {
        int maxLen = 0;
        int[][] dp = new int[a.length + 1][b.length + 1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i-1] == b[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 0;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] a = {1,2,3,2,1};
        int[] b = {3,2,1,4,7};
        int res = solution.findLength(a, b);
        System.out.println(res);
        Assert.assertEquals(3, res);
    }
}
