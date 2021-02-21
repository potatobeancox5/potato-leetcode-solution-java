package com.potato.study.leetcodecn.p00044.t001;

import org.junit.Assert;

/**
 * 44. 通配符匹配
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

 '?' 可以匹配任何单个字符。
 '*' 可以匹配任意字符串（包括空字符串）。
 两个字符串完全匹配才算匹配成功。

 说明:

 s 可能为空，且只包含从 a-z 的小写字母。
 p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 示例 1:

 输入:
 s = "aa"
 p = "a"
 输出: false
 解释: "a" 无法匹配 "aa" 整个字符串。
 示例 2:

 输入:
 s = "aa"
 p = "*"
 输出: true
 解释: '*' 可以匹配任意字符串。
 示例 3:

 输入:
 s = "cb"
 p = "?a"
 输出: false
 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 示例 4:

 输入:
 s = "adceb"
 p = "*a*b"
 输出: true
 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 示例 5:

 输入:
 s = "acdcb"
 p = "a*c?b"
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/wildcard-matching
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 明显的dp
     * https://leetcode-cn.com/problems/wildcard-matching/solution/tong-pei-fu-pi-pei-by-leetcode-solution/
     *
     *
     * dp i j 表示 s的前i个字符 是否能被 p的前j个字符表示 （包括 ij）
     * 先计算 dp 0 0 = true 没有字符 与没有 通配符 是可以匹配的
     * 再计算 dp i 0 = false 有自付 没有通配符
     * 最后计算 dp 0 j 此时只有 0 - j 都是 * 时 才会匹配，也就是说 找到 j 中第一个 不是 * 的字符 下标 dp 0 k 之前都是 true
     *
     * 分情况讨论 ij 从1开始
     * 假设 si 是 q
     *  那么 如果 pj 是 q  那么 dp i j = dp i-1 j-1
     *  如果 pj 是字母 不是 q so dp i j = false
     *  如果 pj 是 ? dp i j = dp i-1 j-1
     *  如果 pj 是 *
     *      不匹配 空字符 dp ij = dp i j-1
     *      匹配 （不适用这个匹配符号） dp ij = dp i j-1
     *
     *
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        // dp i j 表示 s的前i个字符 是否能被 p的前j个字符表示 （包括 ij） dp 0 0 留出来 标识空串的匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 先计算 dp 0 0 = true 没有字符 与没有 通配符 是可以匹配的
        dp[0][0] = true;
        // 最后计算 dp 0 j 此时只有 0 - j 都是 * 时 才会匹配，也就是说 找到 j 中第一个 不是 * 的字符 下标 k dp 0 k(包含) 之前都是 true
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = true;
            } else {
                break;
            }
        }
        // 开始遍历数组
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    //  dp[i][j-1]—— 没有使用j这个位置 相当于多匹配    dp[i-1][j] 使用 * 匹配了 空
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aa";
        String q = "a";
        boolean match = solution.isMatch(s, q);
        System.out.println(match);
        Assert.assertEquals(false, match);


        s = "aa";
        q = "*";
        match = solution.isMatch(s, q);
        System.out.println(match);
        Assert.assertEquals(true, match);

        s = "cb";
        q = "*a";
        match = solution.isMatch(s, q);
        System.out.println(match);
        Assert.assertEquals(false, match);
    }
}
