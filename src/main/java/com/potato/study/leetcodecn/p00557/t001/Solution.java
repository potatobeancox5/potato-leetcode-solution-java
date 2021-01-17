package com.potato.study.leetcodecn.p00557.t001;


import org.junit.Assert;

/**
 * 557. 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

  

 示例：

 输入："Let's take LeetCode contest"
 输出："s'teL ekat edoCteeL tsetnoc"
  

 提示：

 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 先分割 然后倒转 最后拼接
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        String[] split = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String word : split) {
            StringBuilder sb = new StringBuilder(word);
            StringBuilder reverse = sb.reverse();
            builder.append(reverse);
            builder.append(" ");
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.reverseWords("Let's take LeetCode contest");
        System.out.println(s);
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", s);
    }

}
