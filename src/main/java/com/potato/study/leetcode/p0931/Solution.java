package com.potato.study.leetcode.p0931;

/**
 * 
 * @author liuzhao11
 * 
 * 	931. Minimum Falling Path Sum
Medium

319

34

Favorite

Share
Given a square array of integers A, we want the minimum sum of a falling path through A.

A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.



Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation:
The possible falling paths are:
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.



Note:

1 <= A.length == A[0].length <= 100
-100 <= A[i][j] <= 100
 *         
 *         题目含义：
 *
 *         思路：
 *          dp[i][j] 代表 底部到达 i j 最小的路径长度
 *          dp[i][j] = min {dp[i + 1][j - 1], dp[i + 1][j], dp[i + 1][j + 1]}
 *
 *          从底部往上去生成
 *
 *
 *
 *
 * 
 */
public class Solution {


    public int minFallingPathSum(int[][] a) {
        int[][] dp = new int[a.length][a[0].length];
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < a[i].length; j++) {
                if (i == a.length - 1) {
                    dp[i][j] = a[i][j];
                } else {
                    dp[i][j] = a[i][j];
                    if (j == 0) {
                        dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                    } else if (j == a[i].length - 1) {
                        dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                    } else {
                        dp[i][j] += Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i + 1][j - 1]));
                    }
                }
            }
        }
        // 找到最小值
        int min = dp[0][0];
        for (int i = 1; i < a[0].length; i++) {
            if (min > dp[0][i]) {
                min = dp[0][i];
            }
        }
        return min;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		int num = solution.minFallingPathSum(a);
        System.out.println(num);
    }
}
