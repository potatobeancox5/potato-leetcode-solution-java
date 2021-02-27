package com.potato.study.leetcodecn.p00091.t001;


import org.junit.Assert;

/**
 * 91. 解码方法
 *
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。

 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。

 题目数据保证答案肯定是一个 32 位 的整数。

  

 示例 1：

 输入：s = "12"
 输出：2
 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 示例 2：

 输入：s = "226"
 输出：3
 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 示例 3：

 输入：s = "0"
 输出：0
 解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 示例 4：

 输入：s = "06"
 输出：0
 解释："06" 不能映射到 "F" ，因为字符串开头的 0 无法指向一个有效的字符。 
  

 提示：

 1 <= s.length <= 100
 s 只包含数字，并且可能包含前导零。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/decode-ways
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * dp i 说明 第i 个字符之前的数组可以组成的单词的个数
     * 也别的 dp 0 = 0
     * dp i = dp i - 1 + dp i-2 （如果 i-2,i） 是在 26以内的话
     * 从 0 开始 一直到 s.len  求dp
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        // 0 开头直接返回调
        if (null == s || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        // dp i 达到第i个位置 记录数
        int[] dp = new int[s.length() + 1];
        // dp 0 1
        dp[0] = 1;
        for (int i = 1; i < s.length() + 1; i++) {
            if (i < 2) {
                if (s.charAt(i-1) == '0') {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i-1];
                }
            } else {
                // i 至少为 2 dpi dpi-1+dpi-2
                if (s.charAt(i-1) == '0') {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i-1];
                }
                String substring = s.substring(i - 2, i);
                int num = Integer.parseInt(substring);
                if (10 <= num && num <= 26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "12";
        int i = solution.numDecodings(s);
        System.out.println(i);
        Assert.assertEquals(2, i);


        s = "226";
        i = solution.numDecodings(s);
        System.out.println(i);
        Assert.assertEquals(3, i);


        s = "0";
        i = solution.numDecodings(s);
        System.out.println(i);
        Assert.assertEquals(0, i);

        s = "06";
        i = solution.numDecodings(s);
        System.out.println(i);
        Assert.assertEquals(0, i);


        s = "10";
        i = solution.numDecodings(s);
        System.out.println(i);
        Assert.assertEquals(1, i);
    }
}
