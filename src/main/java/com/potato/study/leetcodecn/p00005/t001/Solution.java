package com.potato.study.leetcodecn.p00005.t001;

/**
 * 5. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * dp 问题
     * maxStr 记录 中间产生的长度的回文串
     * dp ij 代表 ij 之间的字符串是否是回文
     * if s.i == s.j dp ij = dp i+1,j-1
     * else dp ij false
     * 初始化 ij相同为 true ij ij 相差1 直接进行比较
     *
     * 如何遍历呢
     * 控制子串长度 从 1开始 到 s.len  ps计算坐标 -1
     * 其实节点 从 0 - s.len - 1
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return "";
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        // init
        String maxStr = "";

        for (int ll = 1; ll <= s.length(); ll++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + ll - 1;
                if (j >= s.length()) {
                    continue;
                }
                if (i == j || (i+1 == j && s.charAt(i) == s.charAt(j))) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    // 不相等 直接 false
                    dp[i][j] = false;
                }
                // 比较获取最大
                if (dp[i][j] && ll > maxStr.length()) {
                    maxStr = s.substring(i, j+1);
                }
            }
        }
        return maxStr;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "babad";
        String res = solution.longestPalindrome(s);
        System.out.println(res);

        s = "cbbd";
        res = solution.longestPalindrome(s);
        System.out.println(res);
    }

}
