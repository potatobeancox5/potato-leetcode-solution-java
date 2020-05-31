package com.potato.study.leetcode.p1092;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1092. Shortest Common Supersequence
 *  
 *      Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.

(A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)



Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation:
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.


Note:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.
 *         
 *
 *
 *
 *         思路：
 *         https://leetcode-cn.com/problems/shortest-common-supersequence/solution/java-dp-xian-qiu-lcsran-hou-de-dao-zui-duan-gong-g/
 *
 *
 */
public class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = lcs(str1, str2);
        int idx1 = 0;
        int idx2 = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lcs.length(); i ++) {
            while (idx1 < str1.length() && str1.charAt(idx1) != lcs.charAt(i)) {
                sb.append(str1.charAt(idx1 ++));
            }
            while (idx2 < str2.length() && str2.charAt(idx2) != lcs.charAt(i)) {
                sb.append(str2.charAt(idx2 ++));
            }
            sb.append(lcs.charAt(i));
            idx1 ++;
            idx2 ++;
        }
        return sb.toString() + str1.substring(idx1) + str2.substring(idx2);
    }

    public String lcs(String str1, String str2) {
        String[][] dp = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], "");
        }
        for (int i = 0; i < str1.length(); i ++) {
            for (int j = 0; j < str2.length(); j ++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + str1.charAt(i);
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j].length() > dp[i][j + 1].length() ? dp[i + 1][j] : dp[i][j + 1];
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

}
