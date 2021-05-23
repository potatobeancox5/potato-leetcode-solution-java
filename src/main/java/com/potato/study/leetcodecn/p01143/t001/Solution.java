package com.potato.study.leetcodecn.p01143.t001;


import org.junit.Assert;

/**
 * 1143. 最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。

 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

 若这两个字符串没有公共子序列，则返回 0。

  

 示例 1:

 输入：text1 = "abcde", text2 = "ace"
 输出：3
 解释：最长公共子序列是 "ace"，它的长度为 3。
 示例 2:

 输入：text1 = "abc", text2 = "abc"
 输出：3
 解释：最长公共子序列是 "abc"，它的长度为 3。
 示例 3:

 输入：text1 = "abc", text2 = "def"
 输出：0
 解释：两个字符串没有公共子序列，返回 0。
  

 提示:

 1 <= text1.length <= 1000
 1 <= text2.length <= 1000
 输入的字符串只含有小写英文字符。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 最长公共子序列
     * dp i+1 j+1  前i j 个 字符串中 最长的公共子序列
     *
     * dp ij = dp i-1 j-1 + 1 如果 i-1 和 j-1 是一样的
     *
     * dp 00 = 0
     * dp 0i = 0
     * dp 0j = 0
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        dp[0][0] = 0;
        int max = 0;
        for (int j = 1; j < text2.length() + 1; j++) {
            for (int i = 1; i < text1.length() + 1; i++) {
                // 按照地推公式计算
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] =  1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text1 = "abcde";
        String text2 = "ace";
        int len = solution.longestCommonSubsequence(text1, text2);
        System.out.println(len);
        Assert.assertEquals(3, len);


        text1 = "abc";
        text2 = "abc";
        len = solution.longestCommonSubsequence(text1, text2);
        System.out.println(len);
        Assert.assertEquals(3, len);


        text1 = "bl";
        text2 = "yby";
        len = solution.longestCommonSubsequence(text1, text2);
        System.out.println(len);
        Assert.assertEquals(1, len);

        text1 = "hofubmnylkra";
        text2 = "pqhgxgdofcvmr";
        len = solution.longestCommonSubsequence(text1, text2);
        System.out.println(len);
        Assert.assertEquals(5, len);
    }
}
