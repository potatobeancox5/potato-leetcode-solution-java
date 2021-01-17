package com.potato.study.leetcodecn.p01309.t001;


import org.junit.Assert;

/**
 * 1309. 解码字母到整数映射
 *
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：

 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 返回映射之后形成的新字符串。

 题目数据保证映射始终唯一。

  

 示例 1：

 输入：s = "10#11#12"
 输出："jkab"
 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 示例 2：

 输入：s = "1326#"
 输出："acz"
 示例 3：

 输入：s = "25#"
 输出："y"
 示例 4：

 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 输出："abcdefghijklmnopqrstuvwxyz"
  

 提示：

 1 <= s.length <= 1000
 s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 s 是映射始终存在的有效字符串。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 从后往前 如果是 # 往前找两个数字 翻译，否则 直接翻译
     * @param s
     * @return
     */
    public String freqAlphabets(String s) {
        int index = s.length() - 1;
        StringBuilder builder = new StringBuilder();

        char[] charArr = new char[] {
                'a','b','c','d',
                'e','f','g','h',
                'i','j','k','l',
                'm','n','o','p',
                'q','r','s','t',
                'u','v','w','x',
                'y','z'
        };
        while (index >= 0) {
            char ch = s.charAt(index);
            if ('#' == ch) {
                char c = s.charAt(index - 2);
                char cc = s.charAt(index - 1);
                int ii = (c - '0') * 10 + (cc - '0') - 1;
                builder.append(charArr[ii]);
                index-=3;
            } else {
                // 数字 直接转义
                int ii = ch - '0' - 1;
                builder.append(charArr[ii]);
                index--;
            }
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "10#11#12";
        String res = solution.freqAlphabets(s);
        System.out.println(res);
        Assert.assertEquals("jkab", res);
    }
}
