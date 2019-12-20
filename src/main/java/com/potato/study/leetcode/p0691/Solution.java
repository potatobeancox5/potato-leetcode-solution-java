package com.potato.study.leetcode.p0691;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	691. Stickers to Spell Word
 *  
 *        We are given N different types of stickers. Each sticker has a lowercase English word on it.

You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.

You can use each sticker more than once if you want, and you have infinite quantities of each sticker.

What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.

Example 1:

Input:

["with", "example", "science"], "thehat"
Output:

3
Explanation:

We can use 2 "with" stickers, and 1 "example" sticker.
After cutting and rearrange the letters of those stickers, we can form the target "thehat".
Also, this is the minimum number of stickers necessary to form the target string.
Example 2:

Input:

["notice", "possible"], "basicbasic"
Output:

-1
Explanation:

We can't form the target "basicbasic" from cutting letters from the given stickers.
Note:

stickers has length in the range [1, 50].
stickers consists of lowercase English words (without apostrophes).
target has length in the range [1, 15], and consists of lowercase English letters.
In all test cases, all words were chosen randomly from the 1000 most common US English words, and the target was chosen as a concatenation of two random words.
The time limit may be more challenging than usual. It is expected that a 50 sticker test case can be solved within 35ms on average.
 *
 *
 *
 *         题目解释：
 *
 *         思路：
 *
 *         https://blog.csdn.net/thesnowboy_2/article/details/78180542
 *
 *         动态规划
 *         计算 tagret len 使用一个int的每个2进制位 代表 该位置的字母 是不是已经被标签搞定
 *         dp size = 1 << target.len
 *
 *         1. dp init to int max
 *         2.
 *          for i 0 - size-1
 *              计算dp
 *              for e sticker
 *                  如果其中每个字母在target中有 且这个位置不是1 时
 *                      计算 dp 当前值 并 修改 当前比较的值
 *
 *         
 *
 *
 * 
 */
public class Solution {

    public int minStickers(String[] stickers, String target) {

        // 0.  dp size = 1 << target.len 这种情况的最小取值
        int targetLen = target.length();
        int dpLen = 1 << targetLen;
        int[] dp = new int[dpLen];
        // 1. dp init to int max
        for (int i = 1; i < dpLen; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // 2. 遍历 生成最小值
        for (int i = 0; i < dpLen; i++) {
            // 当前就没有合适的答案 不可能有其他的
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            // stickers 遍历
            for (String sticker : stickers) {
                int tmp = i;
                // sticker 字母与 target 的每个字母对比
                for (int j = 0; j < sticker.length(); j++) {
                    for (int k = 0; k < target.length(); k++) {
                        if (sticker.charAt(j) == target.charAt(k)
                                && (( tmp >> k) & 1) == 0) {
                            tmp = tmp | (1 << k);
                            break;
                        }
                    }
                }
                dp[tmp] = Math.min(dp[tmp], dp[i] + 1);
            }
        }


        if (Integer.MAX_VALUE == dp[dpLen - 1]) {
            return -1;
        }
        return dp[dpLen - 1];
    }


	
	public static void main(String[] args) {
		Solution solution = new Solution();

        String[] stickers = {"with", "example", "science"};
        String target = "thehat";

        int minStickers = solution.minStickers(stickers, target);
        System.out.println(minStickers);
        Assert.assertEquals(3, minStickers);
    }
}
