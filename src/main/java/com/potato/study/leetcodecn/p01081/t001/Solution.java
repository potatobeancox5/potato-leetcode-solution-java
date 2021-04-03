package com.potato.study.leetcodecn.p01081.t001;

import org.junit.Assert;

/**
 * 1081. 不同字符的最小子序列
 *
 * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。

 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同

  

 示例 1：

 输入：s = "bcabc"
 输出："abc"
 示例 2：

 输入：s = "cbacdcbc"
 输出："acdb"
  

 提示：

 1 <= s.length <= 1000
 s 由小写英文字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 类似栈的思想
     *
     * stac 使用stringbuilder 模拟
     *
     * 如果栈空 入栈
     *
     * 栈不空
     * 如果当前ch 大于peek 入栈
     * 如果当前小于peek
     * while peek 一下看后续是否还有剩余 有的话 pop
     * 没有的话 停止 当前字母 入栈
     * @param s
     * @return
     */
    public String smallestSubsequence(String s) {

        // 计数
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        boolean[] hasContain = new boolean[26];
        StringBuilder builder = new StringBuilder();
        // 遍历 s 如果当前 字母 ch  大于 peek  说明 可以按照当前顺序构造字符串
        for (char ch : s.toCharArray()) {


            if (builder.length() == 0) {
                builder.append(ch);
                hasContain[ch - 'a'] = true;
            } else {
                // builder 里边有东西
                if (ch > builder.charAt(builder.length() - 1)) {
                    // 前面没有的时候才会添加
                    if (!hasContain[ch - 'a']) {
                        builder.append(ch);
                        hasContain[ch - 'a'] = true;
                    }
                } else if (ch < builder.charAt(builder.length() - 1)) {

                    if (!hasContain[ch - 'a']) {
                        // 如果当前 ch 小于 peek 那么说明前面的字母有可能要被替换掉了
                        while (builder.length() > 0
                                && ch < builder.charAt(builder.length() - 1)
                                && count[builder.charAt(builder.length() - 1) - 'a'] > 0) {
                            hasContain[builder.charAt(builder.length() - 1) - 'a'] = false;
                            builder.deleteCharAt(builder.length() - 1);
                        }
                        builder.append(ch);
                        hasContain[ch - 'a'] = true;
                    }
                }
            }
            count[ch - 'a']--;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String str = "bcabc";
        String s = solution.smallestSubsequence(str);
        System.out.println(s);
        Assert.assertEquals("abc", s);

        str = "cbacdcbc";
        s = solution.smallestSubsequence(str);
        System.out.println(s);
        Assert.assertEquals("acdb", s);


        str = "cbaacabcaaccaacababa";
        s = solution.smallestSubsequence(str);
        System.out.println(s);
        Assert.assertEquals("abc", s);

    }
}
