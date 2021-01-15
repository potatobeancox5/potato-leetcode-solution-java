package com.potato.study.leetcodecn.p01662.t001;

/**
 * 1662. 检查两个字符串数组是否相等
 *
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。

 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。

  

 示例 1：

 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 输出：true
 解释：
 word1 表示的字符串为 "ab" + "c" -> "abc"
 word2 表示的字符串为 "a" + "bc" -> "abc"
 两个字符串相同，返回 true
 示例 2：

 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 输出：false
 示例 3：

 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 输出：true
  

 提示：

 1 <= word1.length, word2.length <= 103
 1 <= word1[i].length, word2[i].length <= 103
 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 word1[i] 和 word2[i] 由小写字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 直接拼接 eq
     * @param word1
     * @param word2
     * @return
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();

        if (null != word1) {
            for (String w1 : word1) {
                builder1.append(w1);
            }
        }
        if (null != word2) {
            for (String w2 : word2) {
                builder2.append(w2);
            }
        }

        return builder1.toString().equals(builder2.toString());
    }
}
