package com.potato.study.leetcode.p1000;


/**
 * 
 * @author liuzhao11
 * 
 * 	1000. Minimum Cost to Merge Stones
 *  
 *         There are N piles of stones arranged in a row.  The i-th pile has stones[i] stones.

A move consists of merging exactly K consecutive piles into one pile, and the cost of this move is equal to the total number of stones in these K piles.

Find the minimum cost to merge all piles of stones into one pile.  If it is impossible, return -1.



Example 1:

Input: stones = [3,2,4,1], K = 2
Output: 20
Explanation:
We start with [3, 2, 4, 1].
We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
We merge [4, 1] for a cost of 5, and we are left with [5, 5].
We merge [5, 5] for a cost of 10, and we are left with [10].
The total cost was 20, and this is the minimum possible.
Example 2:

Input: stones = [3,2,4,1], K = 3
Output: -1
Explanation: After any merge operation, there are 2 piles left, and we can't merge anymore.  So the task is impossible.
Example 3:

Input: stones = [3,5,1,2,6], K = 3
Output: 25
Explanation:
We start with [3, 5, 1, 2, 6].
We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
We merge [3, 8, 6] for a cost of 17, and we are left with [17].
The total cost was 25, and this is the minimum possible.


Note:

1 <= stones.length <= 30
2 <= K <= 30
1 <= stones[i] <= 100
 *         
 *
 *
 * https://leetcode-cn.com/problems/minimum-cost-to-merge-stones/solution/java-dong-tai-gui-hua-by-mmmmmmosky-2/
 */
public class Solution {

    private static final int INF = 0x3f3f3f3f;
    private int K;
    private int[] preSum;
    private int[][][] dp;

    public int mergeStones(int[] stones, int kk) {
        if (stones.length == 1) {
            return 0;
        } else if (stones.length < kk) {
            return -1;
        }

        int n = stones.length;
        this.K = kk;
        preSum = new int[n];
        preSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + stones[i];
        }
        dp = new int[n][n][kk + 1];

        int res = memoSearch(0, n - 1, 1);
        return res < INF ? res : -1;
    }

    private int sum(int i, int j) {
        return i == 0 ? preSum[j] : preSum[j] - preSum[i - 1];
    }

    private int memoSearch(int i, int j, int k) {
        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }
        if (j - i + 1 == k) {
            return 0;
        } else if (j - i + 1 < k) {
            return INF;
        }
        if (k == 1) {
            dp[i][j][k] = memoSearch(i, j, K) + sum(i, j);
            return dp[i][j][k];
        }

        dp[i][j][k] = INF;
        for (int jj = i; jj < j; jj++) {
            dp[i][j][k] = Math.min(dp[i][j][k], memoSearch(i, jj, 1) + memoSearch(jj + 1, j, k - 1));
        }

        return dp[i][j][k];
    }
}
