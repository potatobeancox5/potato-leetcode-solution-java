package com.potato.study.leetcode.p0948;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	948. Bag of Tokens
 *  
 *       You have an initial power P, an initial score of 0 points, and a bag of tokens.

Each token can be used at most once, has a value token[i], and has potentially two ways to use it.

If we have at least token[i] power, we may play the token face up, losing token[i] power, and gaining 1 point.
If we have at least 1 point, we may play the token face down, gaining token[i] power, and losing 1 point.
Return the largest number of points we can have after playing any number of tokens.



Example 1:

Input: tokens = [100], P = 50
Output: 0
Example 2:

Input: tokens = [100,200], P = 150
Output: 1
Example 3:

Input: tokens = [100,200,300,400], P = 200
Output: 2


Note:

tokens.length <= 1000
0 <= tokens[i] < 10000
0 <= P < 10000
 *         
 *         题目含义：
 *          初始能量 p
 *              如果你至少有 token[i] 点能量，可以将令牌置为正面朝上，失去 token[i] 点能量，并得到 1 分。
                如果我们至少有 1 分，可以将令牌置为反面朝上，获得 token[i] 点能量，并失去 1 分。

 *
 *
 *         思路：
 *          https://leetcode-cn.com/problems/bag-of-tokens/solution/ling-pai-fang-zhi-by-leetcode/
 *          策略 如果有能量 就让令牌朝上，否则找到能量最多的令牌 翻转
 *
 *
 * 
 */
public class Solution {

    public int bagOfTokensScore(int[] tokens, int p) {
        // 排序 升序
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        // 分数
        int points = 0;
        int ans = 0;
        // 如果当前的能量 还足够翻转牌子 就继续 ，如果或者当前还有分数去翻转
        while (left <= right && (p >= tokens[left] || points > 0)) {
            // 小的地方开始 正面朝上
            while (left <= right && p >= tokens[left]) {
                p -= tokens[left++];
                points++;
            }
            ans = Math.max(ans, points);
            // 大的位置 获取能量
            if (left <= right && points > 0) {
                p += tokens[right--];
                points--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();


        int[] tokens = {100};
        int p = 50;
        int result = solution.bagOfTokensScore(tokens, p);
        System.out.println(result);
        Assert.assertEquals(0, result);
    }
}
