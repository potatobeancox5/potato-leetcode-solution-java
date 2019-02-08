package com.potato.study.leetcode.p0174;

/**
 * 
 * @author liuzhao11
 * 
 *    174. Dungeon Game
 *         
 *          
 *   The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.



Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)


Note:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.



 *
 *         题目需求：
 *         公主被围困了，骑士取营救 计算骑士需要有至少多少体力才能营救
 *
 *         思路：
 *         https://blog.csdn.net/qq508618087/article/details/51392072
 *         dp
 *         状态转移方程 dp 表示在走当前ij节点之前 最小有多少个血 才能活到下个位置
 *         dp[i][j] = min (dp[i + 1][j]  , dp[i][j +1]) - dungeon[i][j] 这样最终dp[0][0] 就是最终位置
 *         dp[i][j] = max （dp[i][j]， 1）
 *         压缩状态量
 *         dp[j] = min (dp[j]  , dp[j +1]) - dungeon[i][j]
 *
 *         dp[j] = max （dp[j]， 1）
 *
 *         
 *        
 */
public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {

        int[] dp = new int[dungeon[0].length];

        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[0].length - 1; j >= 0 ; j--) {
                if (i == dungeon.length - 1) {
                    if (j == dungeon[0].length - 1) {
                        dp[j] = 1 - dungeon[i][j];
                        dp[j] = Math.max(1, dp[j]);
                    } else {
                        dp[j] = dp[j + 1] - dungeon[i][j];
                        dp[j] = Math.max(dp[j], 1);
                    }
                } else if (j == dungeon[0].length - 1) {
                    dp[j] = dp[j] - dungeon[i][j];
                    dp[j] = Math.max(dp[j], 1);
                } else {
                    dp[j] = Math.min(dp[j], dp[j + 1]) - dungeon[i][j];
                    dp[j] = Math.max(dp[j], 1);
                }
            }
        }
        return dp[0];
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

//        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[][] dungeon = {{100}};
		int life = solution.calculateMinimumHP(dungeon);
        System.out.println(life);
    }
}
