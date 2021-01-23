package com.potato.study.leetcodecn.p00389.t001;

/**
 * 389. 找不同
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。

 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

 请找出在 t 中被添加的字母。

  

 示例 1：

 输入：s = "abcd", t = "abcde"
 输出："e"
 解释：'e' 是那个被添加的字母。
 示例 2：

 输入：s = "", t = "y"
 输出："y"
 示例 3：

 输入：s = "a", t = "aa"
 输出："a"
 示例 4：

 输入：s = "ae", t = "aea"
 输出："a"
  

 提示：

 0 <= s.length <= 1000
 t.length == s.length + 1
 s 和 t 只包含小写字母

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-the-difference
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] count1 = this.countTheWord(s);
        int[] count2 = this.countTheWord(t);
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return (char) ('a' + i);
            }
        }
        return ' ';
    }

    /**
     * 计数
     * @param word
     * @return
     */
    private int[] countTheWord(String word) {
        int[] count = new int[26];
        if (null == word) {
            return count;
        }
        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }
        return count;
    }

}
