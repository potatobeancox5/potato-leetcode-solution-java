package com.potato.study.leetcode.p0583;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *         583. Delete Operation for Two Strings
 * 
 *         Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Note:
The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.
 * 
 * 
 *         思路：
 *
 *      583. Delete Operation for Two Strings

https://www.cnblogs.com/lightwindy/p/9574188.html

dp ij 表示 word1 前i个字母和word2 前j个字母共同子序列长度

for i  0 len
for j 0 len
if i=0或者j=0
continue
if words1 i  和 word2 j 相等
dp ij 等于 dp i-1 j-1 +1
else
dpij 等于max dpi-1 j   dp i j-1


返回 串长度和 - dp len len
 *       
 *          
 */
public class Solution {

    public int minDistance(String word1, String word2) {

        // dp ij 表示 word1 前i个字母和word2 前j个字母共同子序列长度
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i ==0 || j == 0) {
                    continue;
                }
                // 字母相同 共同字符串++；
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                // dpij 等于max dpi-1 j   dp i j-1
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return word1.length() + word2.length() - dp[word1.length()][word2.length()] * 2;
    }




    public static void main(String[] args) {
		Solution solution = new Solution();

        String word1 = "sea";
        String word2 = "eat";

        int sum = solution.minDistance(word1, word2);
        System.out.println(sum);
        Assert.assertEquals(2, sum);
    }
}
