package com.potato.study.leetcode.p1335;



import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1335. Minimum Difficulty of a Job Schedule
 *  
 *
You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the i-th job, you have to finish all the jobs j where 0 <= j < i).

You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done in that day.

Given an array of integers jobDifficulty and an integer d. The difficulty of the i-th job is jobDifficulty[i].

Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.



Example 1:


Input: jobDifficulty = [6,5,4,3,2,1], d = 2
Output: 7
Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
Second day you can finish the last job, total difficulty = 1.
The difficulty of the schedule = 6 + 1 = 7
Example 2:

Input: jobDifficulty = [9,9,9], d = 4
Output: -1
Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
Example 3:

Input: jobDifficulty = [1,1,1], d = 3
Output: 3
Explanation: The schedule is one job per day. total difficulty will be 3.
Example 4:

Input: jobDifficulty = [7,1,7,1,7,1], d = 3
Output: 15
Example 5:

Input: jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
Output: 843


Constraints:

1 <= jobDifficulty.length <= 300
0 <= jobDifficulty[i] <= 1000
1 <= d <= 10
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/remove-sub-folders-from-the-filesystem/solution/javaxian-pai-xu-ran-hou-cha-kan-shi-fou-shi-gong-g/
 *
 *
 *
 *      //dp[i][j] 表示第i天，完成第j个任务，其中i<=j
 */
public class Solution {

    public int minDifficulty(int[] jobDifficulty, int d) {
        // 边界
        if (null == jobDifficulty || jobDifficulty.length == 0 || d == 0) {
            return -1;
        }
        if(jobDifficulty.length < d) {
            return -1;
        }

        int max = 0;
        // //第一天完成0-i项工作，难度等于0-i中最大的难度
        int[][] dp = new int[d][jobDifficulty.length];
        // day 1
        for (int i = 0; i < jobDifficulty.length; i++) {
            // 找到 第 0 天能够完成的最大难度
            max = Math.max(max, jobDifficulty[i]);
            dp[0][i] = max;
        }
        // day 2 - n
        for (int i = 1; i < d; i++) {
            //从第i项工作开始（每天至少完成一项，第i天至少已经完成前i项）
            for(int j = i; j < jobDifficulty.length; j++) {
                max = 0;
                int minSum = Integer.MAX_VALUE;
                //当天完成工作项是[k,j]，当天工作量 = 前k-1项工作量 + 当天最大难度
                for(int k = j; k >= i; k--) {
                    max = Math.max(max, jobDifficulty[k]); //当天最大难度
                    minSum = Math.min(minSum, dp[i-1][k-1] + max);
                }
                dp[i][j] = minSum;
            }
        }

        return dp[d-1][jobDifficulty.length-1];
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int[] jobDifficulty = new int[] {6,5,4,3,2,1};
        int d = 2;
        int res = solution.minDifficulty(jobDifficulty, d);
        System.out.println(res);
        Assert.assertEquals(7, res);

        jobDifficulty = new int[] {9,9,9};
        d = 4;
        res = solution.minDifficulty(jobDifficulty, d);
        System.out.println(res);
        Assert.assertEquals(-1, res);
    }
}
