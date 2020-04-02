package com.potato.study.leetcode.p0813;

/**
 * 
 * @author liuzhao11
 * 
 * 	813. Largest Sum of Averages
 *  
 *        We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of the average of each group. What is the largest score we can achieve?

Note that our partition must use every number in A, and that scores are not necessarily integers.

Example:
Input:
A = [9,1,2,3,9]
K = 3
Output: 20
Explanation:
The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
We could have also partitioned A into [9, 1], [2], [3, 9], for example.
That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.


Note:

1 <= A.length <= 100.
1 <= A[i] <= 10000.
1 <= K <= A.length.
Answers within 10^-6 of the correct answer will be accepted as correct.
 *         
 *         思路：
 *         https://www.jianshu.com/p/2ca23e18da3e
 *         dfs 加dp剪枝
 *         https://leetcode.com/problems/largest-sum-of-averages/discuss/509588/Java-DP
 *
 *          dp(i,k)  表示前 ii 个数字，分为 kk 组的最大平均值之和
 *          找到分割出新一个  组的为止 求最大值
 *          f[i][k] = max(f[i][k], f[j][k - 1] + 1.0 * (sum[i] - sum[j]) / (i - j));
 *
 *
 * 
 */
public class Solution {

    public double largestSumOfAverages(int[] arr, int kk) {
        // sum 计算当前为止的累加和
        double[] sum = new double[arr.length];

        sum[0] = arr[0];
        for (int i = 1; i < sum.length ; i++) {
            sum[i] = sum[i-1] + arr[i];
        }

        // 0 - i 分成k 组最多能多少sum
        double[][] dp = new double[kk][arr.length];


        for (int k = 0; k < kk; k++) {
            for (int i = 0; i < arr.length; i++) {
                if (k == 0) {
                    // 全是一个组
                    dp[k][i] = averageLeft(sum, i);
                } else {
                    // 遍历每一个分割为止
                    for (int j = 1; j <= i; j++) {
                        dp[k][i] = Math.max(dp[k][i], dp[k-1][j-1] + averageBetween(sum, j-1, i));
                    }
                }
            }
        }
        return dp[kk-1][arr.length - 1];
    }


    /**
     * 求 i- j 之间的平均值
     * @param sum
     * @param i
     * @param j
     * @return
     */
    private double averageBetween(double[] sum, int i, int j) {
        return (sum[j] - sum[i]) / (j-i);
    }


    /**
     * 求 i 位置左边的平均值
     * @param sum
     * @param i
     * @return
     */
    private double averageLeft(double[] sum, int i) {
        return sum[i] / (i+1);
    }



	public static void main(String[] args) {
		Solution solution = new Solution();


        int[] arr = new int[]{9,1,2,3,9};
        int k = 3;
        double list = solution.largestSumOfAverages(arr, k);
        System.out.println(list); // 20
    }
}
