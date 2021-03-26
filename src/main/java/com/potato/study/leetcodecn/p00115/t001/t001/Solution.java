package com.potato.study.leetcodecn.p00115.t001.t001;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 115. 不同的子序列

 *
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。

 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

 题目数据保证答案符合 32 位带符号整数范围。

  

 示例 1：

 输入：s = "rabbbit", t = "rabbit"
 输出：3
 解释：
 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 (上箭头符号 ^ 表示选取的字母)
 rabbbit
 ^^^^ ^^
 rabbbit
 ^^ ^^^^
 rabbbit
 ^^^ ^^^
 示例 2：

 输入：s = "babgbag", t = "bag"
 输出：5
 解释：
 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 (上箭头符号 ^ 表示选取的字母)
 babgbag
 ^^ ^
 babgbag
 ^^    ^
 babgbag
 ^    ^^
 babgbag
 ^  ^^
 babgbag
 ^^^
  

 提示：

 0 <= s.length, t.length <= 1000
 s 和 t 由英文字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/distinct-subsequences
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * dpij 代表 i-1 和j-1 位置匹配上 可能性

     dp00 =1 dp 0k =0
     dp k0 =1
     fori 1-len forj 相同
     如果i-1 j-1 相同
     dpij 等于 sum dpi-1 j-1 到dp i-k j-1
     fori
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        // dp ij 代表 i-1 和j-1 位置匹配上 可能性 种类数
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 都没有字符串 只有一种可能
        dp[0][0] = 1;
        // dp k0 =1
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }
        // 遍历 s的每个位置和 t的每个位置 如果相同的话 计算 可能存在的数量
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i-1) != t.charAt(j-1)) {
                    continue;
                }
                // 相同的话往前找呢
                for (int k = 1; k <= i; k++) {
                    dp[i][j] += dp[i-k][j-1];
                    if (j == 1) {
                        break;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 1; i < s.length() + 1; i++) {
            sum += dp[i][t.length()];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "rabbbit";
        String t = "rabbit";
        int i = solution.numDistinct(s, t);
        System.out.println(i);
        Assert.assertEquals(3, i);

        s = "babgbag";
        t = "bag";
        i = solution.numDistinct(s, t);
        System.out.println(i);
        Assert.assertEquals(5, i);
    }
}
