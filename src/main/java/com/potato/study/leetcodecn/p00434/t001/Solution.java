package com.potato.study.leetcodecn.p00434.t001;

/**
 * 434. 字符串中的单词数
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。

 请注意，你可以假定字符串里不包括任何不可打印的字符。

 示例:

 输入: "Hello, my name is John"
 输出: 5
 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int count = 0;
        String[] split = s.split(" ");
        for (String word : split) {
            if (!"".equals(word)) {
                count++;
            }
        }
        return count;
    }
}
