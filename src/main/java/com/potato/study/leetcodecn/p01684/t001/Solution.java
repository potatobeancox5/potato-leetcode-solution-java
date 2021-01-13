package com.potato.study.leetcodecn.p01684.t001;

import java.util.HashSet;
import java.util.Set;

/**
 * 1684. 统计一致字符串的数目
 *
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。

 请你返回 words 数组中 一致字符串 的数目。

  

 示例 1：

 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 输出：2
 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 示例 2：

 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 输出：7
 解释：所有字符串都是一致的。
 示例 3：

 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 输出：4
 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
  

 提示：

 1 <= words.length <= 104
 1 <= allowed.length <= 26
 1 <= words[i].length <= 10
 allowed 中的字符 互不相同 。
 words[i] 和 allowed 只包含小写英文字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/count-the-number-of-consistent-strings
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * set contain
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStrings(String allowed, String[] words) {
        if (null == allowed || null == words) {
            return 0;

        }
        Set<Character> allowedSet = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }
        int count = 0;
        for (String word : words) {
            // every word
            boolean isValid = true;
            for (char ch : word.toCharArray()) {
                if (!allowedSet.contains(ch)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                count++;
            }
        }
        return count;
    }


}
