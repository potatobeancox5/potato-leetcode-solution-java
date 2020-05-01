package com.potato.study.leetcode.p0837;

/**
 * 
 * @author liuzhao11
 * 
 * 	837. New 21 Game
 *  
 *         Alice plays the following game, loosely based on the card game "21".

Alice starts with 0 points, and draws numbers while she has less than K points.  During each draw, she gains an integer number of points randomly from the range [1, W], where W is an integer.  Each draw is independent and the outcomes have equal probabilities.

Alice stops drawing numbers when she gets K or more points.  What is the probability that she has N or less points?

Example 1:

Input: N = 10, K = 1, W = 10
Output: 1.00000
Explanation:  Alice gets a single card, then stops.
Example 2:

Input: N = 6, K = 1, W = 10
Output: 0.60000
Explanation:  Alice gets a single card, then stops.
In 6 out of W = 10 possibilities, she is at or below N = 6 points.
Example 3:

Input: N = 21, K = 17, W = 10
Output: 0.73278
Note:

0 <= K <= N <= 10000
1 <= W <= 10000
Answers will be accepted as correct if they are within 10^-5 of the correct answer.
The judging time limit has been reduced for this question.
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/new-21-game/solution/xin-21dian-by-leetcode/
 * 
 */
public class Solution {

    public double new21Game(int n, int k, int w) {
        // dp i 为到达 i 值的可能性
        double[] dp = new double[n + w + 1];
        // 求 前k - n
        for (int i = k; i <= n; i++) {
            dp[i] = 1.0;
        }

        double s = Math.min(w, n - k + 1);
        // S = dp[k+1] + dp[k+2] + ... + dp[k+W]
        for (int i = k - 1; i >= 0 ; i--) {
            dp[i] = s / w;
            s += dp[i] - dp[i + w];
        }
        return dp[0];
    }


	public static void main(String[] args) {
//		Solution solution = new Solution();
//        int[] rec1 = new int[]{0,0,2,2};
//        int[] rec2 = new int[]{1,1,3,3};
//        boolean result = solution.isRectangleOverlap(rec1,rec2);
//        System.out.println(result);
//        Assert.assertEquals(true, result);
//
//
//        rec1 = new int[]{0,0,1,1};
//        rec2 = new int[]{1,0,2,1};
//        result = solution.isRectangleOverlap(rec1,rec2);
//        System.out.println(result);
//        Assert.assertEquals(false, result);
    }
}
