package com.potato.study.leetcode.p1277;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1277. Count Square Submatrices with All Ones
 *  
 *
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.



Example 1:

Input: matrix =
[
[0,1,1,1],
[1,1,1,1],
[0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix =
[
[1,0,1],
[1,1,0],
[1,1,0]
]
Output: 7
Explanation:
There are 6 squares of side 1.
There is 1 square of side 2.
Total number of squares = 6 + 1 = 7.


Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
 *         
 *         思路：
 *          找到内部 方块 1 的个数
 *
 *          https://blog.csdn.net/LLL_foever/article/details/103617360
 *
 *
 *          动态规划
 *          dp ij 代表 以 matrix为右下角的 1矩阵边长数量 dp ij = min {dp i-1, j dp i, j-1, dp i-1, j-1} + 1
 *
 *
 *
 *

 *
 */
public class Solution {

    public int countSquares(int[][] matrix) {

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        int count = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i-1][j-1] == 0) {
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                // 计算个数
                for (int k = 1; k <= dp[i][j]; k++) {
                    count++;
                }
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] matrix = new int[][]{{0,1,1,1}, {1,1,1,1}, {0,1,1,1}};
        int res = solution.countSquares(matrix);
        System.out.println(res);
        Assert.assertEquals(15, res);


        matrix = new int[][]{{1,0,1}, {1,1,0}, {1,1,0}};
        res = solution.countSquares(matrix);
        System.out.println(res);
        Assert.assertEquals(7, res);

    }
}
