package com.potato.study.leetcode.p0486;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         486. Predict the Winner
 * 
 *        Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2.
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
Hence, player 1 will never be the winner and you need to return False.
Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
Note:
1 <= length of the array <= 20.
Any scores in the given array are non-negative integers and will not exceed 10,000,000.
If the scores of both players are equal, then player 1 is still the winner.
 * 
 *         思路：
 *
 * https://www.cnblogs.com/liujinhong/p/6477367.html
 *            dp ij 代码 拿的那个人从 ij 中能获胜多少钱 最多 dp ii = nums
 *            
 *            dp ij = max {num i  i+1, j   ,  num j - dp i, j-1}
 *         
 *
 */
public class Solution {

    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        // 1. dp ii = nums
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        // 2. dp生成的顺序决定 for遍历的方向
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }


	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {1, 5, 2};
		boolean res = solution.PredictTheWinner(nums);
        System.out.println(res);
        Assert.assertEquals(false, res);


        int[] nums1 = {1, 5, 233, 7};
        res = solution.PredictTheWinner(nums1);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
