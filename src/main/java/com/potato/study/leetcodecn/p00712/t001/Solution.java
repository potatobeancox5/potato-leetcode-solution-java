package com.potato.study.leetcodecn.p00712.t001;

import org.junit.Assert;

/**
 * 712. 两个字符串的最小ASCII删除和
 *
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 *
 * 示例 1:
 *
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * 示例 2:
 *
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 * 注意:
 *
 * 0 < s1.length, s2.length <= 1000。
 * 所有字符串中的字符ASCII值在[97, 122]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * dp 从后往前 结果是dp 00
     * dp ij 从ij开始到结尾 相等需要删除的最小asc 码val
     * 相等 dpij 等于dpi+1j+1
     *
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        // dp ij 从00 ij 位置 相等的最小删除和 ij 位置是索引
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // 生成 处理 最开始 dp 00 s1 和 s2都没有字母的情况
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);;
        }

        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }
        // 状态转移
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                // 相等的状态
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                // 不相等的状态
                dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "sea";
        String s2 = "eat";
        int i = solution.minimumDeleteSum(s1, s2);
        System.out.println(i);
        Assert.assertEquals(231, i);

        s1 = "delete";
        s2 = "leet";
        i = solution.minimumDeleteSum(s1, s2);
        System.out.println(i);
        Assert.assertEquals(403, i);
    }
}
