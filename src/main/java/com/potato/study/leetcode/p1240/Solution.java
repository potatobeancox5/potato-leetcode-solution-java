package com.potato.study.leetcode.p1240;


/**
 * 
 * @author liuzhao11
 * 
 * 	1240. Tiling a Rectangle with the Fewest Squares
 *  
 *      Given a rectangle of size n x m, find the minimum number of integer-sided squares that tile the rectangle.



Example 1:



Input: n = 2, m = 3
Output: 3
Explanation: 3 squares are necessary to cover the rectangle.
2 (squares of 1x1)
1 (square of 2x2)
Example 2:



Input: n = 5, m = 8
Output: 5
Example 3:



Input: n = 11, m = 13
Output: 6


Constraints:

1 <= n <= 13
1 <= m <= 13
 *         
 *
 *
 *         思路：
 *
 *
 *
 *https://leetcode-cn.com/problems/tiling-a-rectangle-with-the-fewest-squares/solution/dong-tai-gui-hua-by-shu_ykc/
 *
 */
public class Solution {

    public int tilingRectangle(int n, int m) {
        int[][] dp=new int[15][15];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                dp[i][j]=i==j?1:i*j;
                for(int p=1;p<i;p++) {
                    dp[i][j]=Math.min(dp[i][j], dp[p][j]+dp[i-p][j]);
                }
                for(int p=1;p<j;p++) {
                    dp[i][j]=Math.min(dp[i][j], dp[i][p]+dp[i][j-p]);
                }
                for(int x=2;x<i;x++) {
                    for(int y=2;y<j;y++) {
                        dp[i][j]=Math.min(dp[i][j], dp[x-1][y]+dp[x][j-y]+dp[i-x+1][y-1]+dp[i-x][j-y+1]+1);
                    }
                }
            }
        }
        return dp[n][m];
    }
}
