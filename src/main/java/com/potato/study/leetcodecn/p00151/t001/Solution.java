package com.potato.study.leetcodecn.p00151.t001;

import org.junit.Assert;

/**
 * 151. 翻转字符串里的单词
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。

 说明：

 无空格字符构成一个 单词 。
 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
  

 示例 1：

 输入："the sky is blue"
 输出："blue is sky the"
 示例 2：

 输入："  hello world!  "
 输出："world! hello"
 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 示例 3：

 输入："a good   example"
 输出："example good a"
 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 示例 4：

 输入：s = "  Bob    Loves  Alice   "
 输出："Alice Loves Bob"
 示例 5：

 输入：s = "Alice does not even like bob"
 输出："bob like even not does Alice"
  

 提示：

 1 <= s.length <= 104
 s 包含英文大小写字母、数字和空格 ' '
 s 中 至少存在一个 单词
  

 进阶：

 请尝试使用 O(1) 额外空间复杂度的原地解法。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    /**
     * 1. 整体反转 字符串
     * 2. 遍历字符串 记录每个part的开始结束节点 然后进行revert
     *
     * 额外的两个单词之前不能有额外的空格
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        // 0 去掉多余的空格
        String[] split = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() != 0) {
                builder.append(split[i]);
                builder.append(" ");
            }
        }
        if (builder.length() > 1) {
            builder.deleteCharAt(builder.length() - 1);
        }
        s = builder.toString();
        // 1. 整体反转 字符串
        char[] words = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            char ch = words[i];
            words[i] = words[s.length() - i - 1];
            words[s.length() - i - 1] = ch;
        }
        // 2. 遍历字符串 记录每个part的开始结束节点 然后进行revert
        int startIndex = 0;
        for (int i = 0; i < words.length; i++) {
            char ch = words[i];
            if (ch == ' ') {
                // 往前反转
                for (int j = 0; j < (i - startIndex)/ 2; j++) {
                    char temp = words[j + startIndex];
                    words[startIndex + j] = words[i - j - 1];
                    words[i - j - 1] = temp;
                }
                startIndex = i + 1;
            } else {
                // 字母直接continue
                continue;
            }
        }
        // 最后一段反转
        if (startIndex < s.length()) {
            for (int i = 0; i < (s.length() - startIndex)/ 2; i++) {
                char ch = words[startIndex + i];
                words[startIndex + i] = words[s.length() - i - 1];
                words[s.length() - i - 1] = ch;
            }
        }
        return new String(words).trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "the sky is blue";
        String str = solution.reverseWords(s);
        System.out.println(str);
        Assert.assertEquals("blue is sky the", str);

        s = "  hello world!  ";
        str = solution.reverseWords(s);
        System.out.println(str);
        Assert.assertEquals("world! hello", str);

        s = "a good   example";
        str = solution.reverseWords(s);
        System.out.println(str);
        Assert.assertEquals("example good a", str);
    }
}
