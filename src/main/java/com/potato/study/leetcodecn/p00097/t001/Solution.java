package com.potato.study.leetcodecn.p00097.t001;


import org.junit.Assert;

/**
 * 97. 交错字符串
 *
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。

 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：

 s = s1 + s2 + ... + sn
 t = t1 + t2 + ... + tm
 |n - m| <= 1
 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 提示：a + b 意味着字符串 a 和 b 连接。

  

 示例 1：


 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 输出：true
 示例 2：

 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 输出：false
 示例 3：

 输入：s1 = "", s2 = "", s3 = ""
 输出：true
  

 提示：

 0 <= s1.length, s2.length <= 100
 0 <= s3.length <= 200
 s1、s2、和 s3 都由小写英文字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/interleaving-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     *
     * 肯定是动态规划 只不过想复杂了
     * dp ij 代表 i-1 j-1 位置是否可以交替组成 s3
     * dp 0 0 true
     *
     * 转移方程
     *
     * 对于 i j 位置
     *      如果 i-1 位置 字母与 i+j-1 字母相同  dp i j = dp i-1 j (最后一个字母是 i的)
     *      or j-1 位置 字母 与 i+j-1 字母相同  dp i j = dp i j-1  (最后一个字母是 j的)
     *
     * for i 1 - s1.len
     *  for j 1 - s2.len
     *      if (如果 i-1 位置 字母与 i+j-1 字母相同) {
     *              dp i j = dp i-1 j
     *      }
     *      if (j-1 位置 字母 与 i+j-1 字母相同) {
     *          dp i j = dp i j-1
     *      }
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length() ; j++) {
                int k = i + j - 1;
                if (i > 0 && s1.charAt(i-1) == s3.charAt(k)) {
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }
                if (j > 0 && s2.charAt(j-1) == s3.charAt(k)) {
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean interleave = solution.isInterleave(s1, s2, s3);
        System.out.println(interleave);
        Assert.assertEquals(true, interleave);

        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        interleave = solution.isInterleave(s1, s2, s3);
        System.out.println(interleave);
        Assert.assertEquals(false, interleave);

        s1 = "";
        s2 = "";
        s3 = "";
        interleave = solution.isInterleave(s1, s2, s3);
        System.out.println(interleave);
        Assert.assertEquals(true, interleave);

        s1 = "ab";
        s2 = "bc";
        s3 = "babc";
        interleave = solution.isInterleave(s1, s2, s3);
        System.out.println(interleave);
        Assert.assertEquals(true, interleave);

    }
}
