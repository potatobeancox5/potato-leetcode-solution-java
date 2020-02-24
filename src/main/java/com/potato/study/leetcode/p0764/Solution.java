package com.potato.study.leetcode.p0764;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	764. Largest Plus Sign
 *  
 *         In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1,
 *         except those cells in the given list mines which are 0.
 *         What is the largest axis-aligned plus sign of 1s contained in the grid? Return the order of the plus sign.
 *         If there is none, return 0.

An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with 4 arms of length k-1 going up, down, left, and right, and made of 1s.
This is demonstrated in the diagrams below.
Note that there could be 0s or 1s beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1s.

Examples of Axis-Aligned Plus Signs of Order k:

Order 1:
000
010
000

Order 2:
00000
00100
01110
00100
00000

Order 3:
0000000
0001000
0001000
0111110
0001000
0001000
0000000
Example 1:

Input: N = 5, mines = [[4, 2]]
Output: 2
Explanation:
11111
11111
11111
11111
11011
In the above grid, the largest plus sign can only be order 2.  One of them is marked in bold.
Example 2:

Input: N = 2, mines = []
Output: 1
Explanation:
There is no plus sign of order 2, but there is of order 1.
Example 3:

Input: N = 1, mines = [[0, 0]]
Output: 0
Explanation:
There is no plus sign, so return 0.
Note:

N will be an integer in the range [1, 500].
mines will have length at most 5000.
mines[i] will be length 2 and consist of integers in the range [0, N-1].
(Additionally, programs submitted in C, C++, or C# will be judged with a slightly smaller time limit.)


 *   题目大意：
 *
 *   判断 是否能够构造上述几个 图形
 *
 *
 *   解题思路：
 *
 *   https://www.cnblogs.com/ruruozhenhao/p/10555667.html
 *
 *   dp
 *
 *   1. dp[i][j] 代表该点最小的 十字长度  初始值 都是n
 *   2. 归置 0 点
 *   3. 对 ij 分别从两端进行遍历 求出
 *   4. 遍历数组 求最大值
 *
 * 
 */
public class Solution {

    public int orderOfLargestPlusSign(int n, int[][] mines) {

        // 1. dp[i][j] 代表该点最小的 十字长度  初始值 都是n
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        // 2. 归置 0 点
        for (int[] mine : mines) {
            dp[mine[0]][mine[1]] = 0;
        }
        // 3. 对 ij 分别从两端进行遍历 求出
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = 0;
            int up = 0;
            int down = 0;
            for (int j = 0, k = n -1 ; j < n && k >= 0; j++, k--) {
                left = (dp[i][j] == 0) ? 0 : left + 1;
                dp[i][j] = Math.min(dp[i][j], left);

                right = (dp[i][k] == 0) ? 0 : right + 1;
                dp[i][k] = Math.min(dp[i][k], right);

                up = (dp[j][i] == 0) ? 0 : up + 1;
                dp[j][i] = Math.min(dp[j][i], up);

                down = (dp[k][i] == 0) ? 0 : down + 1;
                dp[k][i] = Math.min(dp[k][i], down);
            }
        }
        // 4. 遍历数组 求最大值
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 5;
        int[][] mines = {{4, 2}};

        int num = solution.orderOfLargestPlusSign(n, mines);
        System.out.println(num);
        Assert.assertEquals(2, num);

        n = 2;
        mines = new int[][]{};
        num = solution.orderOfLargestPlusSign(n, mines);
        System.out.println(num);
        Assert.assertEquals(1, num);

        n = 1;
        mines = new int[][]{{0, 0}};
        num = solution.orderOfLargestPlusSign(n, mines);
        System.out.println(num);
        Assert.assertEquals(0, num);
    }
}
