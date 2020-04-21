package com.potato.study.leetcode.p1140;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1140. Stone Game II
 *  
 *
 * Alex and Lee continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones.

Alex and Lee take turns, with Alex starting first.  Initially, M = 1.

On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).

The game continues until all the stones have been taken.

Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.



Example 1:

Input: piles = [2,7,9,4,4]
Output: 10
Explanation:  If Alex takes one pile at the beginning, Lee takes two piles, then Alex takes 2 piles again. Alex can get 2 + 4 + 4 = 10 piles in total. If Alex takes two piles at the beginning, then Lee can take all three piles left. In this case, Alex get 2 + 7 = 9 piles in total. So we return 10 since it's larger.


Constraints:

1 <= piles.length <= 100
1 <= piles[i] <= 10 ^ 4
 *         
 *      思路：
 *
 *          https://blog.csdn.net/qq_17550379/article/details/97757641
 *
 *          https://www.cnblogs.com/Dylan-Java-NYC/p/11434194.html
 *
 *
 *
 */
public class Solution {

    // 遍历到的数字
    private int[] suffixSum;
    // 存储结果
    private int[][] dp;

    public int stoneGameII(int[] piles) {
        // 没有旗子情况
        if (null == piles || piles.length == 0) {
            return 0;
        }
        int n = piles.length;
        suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        dp = new int[n][n];
        return findMaxStones(piles, 0, 1);
    }


    /**
     * 对于一定堆数的石子和某一M值，找出最多可以拿到的石子数。
     * @param piles
     * @param i     可以拿的 index
     * @param m
     * @return
     */
    private int findMaxStones(int[] piles, int i, int m) {
        // 如果最后一堆 石子已经被拿完了
        if(i == piles.length)
            return 0;
        //  当前拿的数量比剩余的还打
        if(i + 2 * m >= piles.length){
            return suffixSum[i];
        }
        // 已经有了答案
        if(dp[i][m] != 0) {
            return dp[i][m];
        }
        int minStones = Integer.MAX_VALUE;
        // 每种情况 都找下 对手能拿多少
        for (int j = 1; j <= 2 * m; j++){
            //找出对手可以获得的最小石子数
            minStones = Math.min(minStones, findMaxStones(piles, i + j, Math.max(j, m)));
        }
        dp[i][m] = suffixSum[i] - minStones;
        return dp[i][m];
    }


	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] piles = new int[]{2,7,9,4,4};
        int count = solution.stoneGameII(piles);
        System.out.println(count);
        Assert.assertEquals(10, count);
    }
}
