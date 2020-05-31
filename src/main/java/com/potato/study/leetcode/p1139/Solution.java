package com.potato.study.leetcode.p1139;


/**
 * 
 * @author liuzhao11
 * 
 * 	1139. Largest 1-Bordered Square
 *  
 *
 * Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that has all 1s on its border, or 0 if such a subgrid doesn't exist in the grid.



Example 1:

Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
Output: 9
Example 2:

Input: grid = [[1,1,0,0]]
Output: 1


Constraints:

1 <= grid.length <= 100
1 <= grid[0].length <= 100
grid[i][j] is 0 or 1
 *         
 *      思路：
 *
 *
 *      https://leetcode-cn.com/problems/largest-1-bordered-square/solution/dpzui-jian-dan-de-dai-ma-by-ri-mu-tu-yuan-12/
 */
public class Solution {

    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length, m = 0, res = 0;
        if(n == 0) {
            return 0;
        }
        m = grid[0].length;
        int[][][] dp = new int[n + 1][m + 1][2];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int d = 0;
                if(grid[i - 1][j - 1] == 1){    //因为dp数组下标从1开始
                    //更新dp[i][j]的2个状态
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                    //以当前的1为右下角要构成正方形,其边长最长只可能是左边最长连续的1与上面最长连续的1的个数取最小值
                    d = Math.min(dp[i][j - 1][0], dp[i - 1][j][1]); //d表示不包括当前1的最长长度
                    while(d > 0){
                        //判断第i行的第j-d列的上面1的个数,和第i-d行的第j列的左边的1的个数是否都大于d(大于d,不能等,因为d比实际边长小1)
                        if(dp[i][j - d][1]  > d &&  dp[i - d][j][0] > d) {
                            break; //判断边长为d能否构成正方形,若能break
                        }
                        d--;    //若不能就取次小的边长
                    }
                    res = Math.max(res, d + 1);
                }
            }
        }
        return res * res;
    }
}
