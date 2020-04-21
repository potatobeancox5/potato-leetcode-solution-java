package com.potato.study.leetcode.p1420;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1420. Build Array Where You Can Find The Maximum Exactly K Comparisons
 *  
 *
Given three integers n, m and k. Consider the following algorithm to find the maximum element of an array of positive integers:


You should build the array arr which has the following properties:

arr has exactly n integers.
1 <= arr[i] <= m where (0 <= i < n).
After applying the mentioned algorithm to arr, the value search_cost is equal to k.
Return the number of ways to build the array arr under the mentioned conditions. As the answer may grow large, the answer must be computed modulo 10^9 + 7.



Example 1:

Input: n = 2, m = 3, k = 1
Output: 6
Explanation: The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
Example 2:

Input: n = 5, m = 2, k = 3
Output: 0
Explanation: There are no possible arrays that satisify the mentioned conditions.
Example 3:

Input: n = 9, m = 1, k = 1
Output: 1
Explanation: The only possible array is [1, 1, 1, 1, 1, 1, 1, 1, 1]
Example 4:

Input: n = 50, m = 100, k = 25
Output: 34549172
Explanation: Don't forget to compute the answer modulo 1000000007
Example 5:

Input: n = 37, m = 17, k = 7
Output: 418930126


Constraints:

1 <= n <= 50
1 <= m <= 100
0 <= k <= n
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/solution/dong-tai-gui-hua-java-by-lishaoxiao/
 *
 *          dp[i][kk][mm]表示 i位置的值至少是mm且可以递增kk次时的方法数。
 *
 *
 *
 */
public class Solution {


    public int numOfArrays(int n, int m, int k) {
        // 没有第k个数字
        if (k > m) {
            return 0;
        }
        // dp
        long [][][] dp = new long[n + 2][k + 2][m + 2];

        for (int i = m; i >= 1 ; i--) {
            dp[n-1][0][i] += dp[n-1][0][i+1] + 1;
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= k; j++) {
                for (int l = m; l >= 1; l--) {
                    dp[i][j][l] =  dp[i][j][l+1] +
                            ( j>=1 ? dp[i+1][j-1][l+1] : 0) + l * (dp[i+1][j][l] + 1000000007 - dp[i+1][j][l+1]);
                    dp[i][j][l] %=1000000007;
                }
            }
        }

        return   (int)dp[0][k-1][1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 2;
        int m = 3;
        int k = 1;
        int res = solution.numOfArrays(n, m, k);
        System.out.println(res);
        Assert.assertEquals(6, res);

        n = 5;
        m = 2;
        k = 3;
        res = solution.numOfArrays(n, m, k);
        System.out.println(res);
        Assert.assertEquals(0, res);


        n = 9;
        m = 1;
        k = 1;
        res = solution.numOfArrays(n, m, k);
        System.out.println(res);
        Assert.assertEquals(1, res);
    }
}
