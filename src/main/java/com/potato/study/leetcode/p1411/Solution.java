package com.potato.study.leetcode.p1411;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1411. Number of Ways to Paint N × 3 Grid
 *  
 *
You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colours: Red, Yellow or Green while making sure that no two adjacent cells have the same colour (i.e no two cells that share vertical or horizontal sides have the same colour).

You are given n the number of rows of the grid.

Return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 10^9 + 7.



Example 1:

Input: n = 1
Output: 12
Explanation: There are 12 possible way to paint the grid as shown:

Example 2:

Input: n = 2
Output: 54
Example 3:

Input: n = 3
Output: 246
Example 4:

Input: n = 7
Output: 106494
Example 5:

Input: n = 5000
Output: 30228214


Constraints:

n == grid.length
grid[i].length == 3
1 <= n <= 5000
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/number-of-ways-to-paint-n-x-3-grid/solution/fen-liang-chong-qing-kuang-kao-lu-xia-yi-xing-dong/
 */
public class Solution {


    public int numOfWays(int n) {
        long[][] dp = new long[n][2];
        dp[0][0] = 6;
        dp[0][1] = 6;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i-1][0] * 3 + dp[i-1][1] * 2) % 1000000007;
            dp[i][1] = (dp[i-1][0] * 2 + dp[i-1][1] * 2) % 1000000007;
        }
        return (int) ((dp[n-1][0] + dp[n-1][1])% 1000000007);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 1;
        int res = solution.numOfWays(n);
        System.out.println(res);
        Assert.assertEquals(12, res);

        n = 2;
        res = solution.numOfWays(n);
        System.out.println(res);
        Assert.assertEquals(54, res);

        n = 3;
        res = solution.numOfWays(n);
        System.out.println(res);
        Assert.assertEquals(246, res);

        n = 7;
        res = solution.numOfWays(n);
        System.out.println(res);
        Assert.assertEquals(106494, res);

        n = 5000;
        res = solution.numOfWays(n);
        System.out.println(res);
        Assert.assertEquals(30228214, res);
    }
}
