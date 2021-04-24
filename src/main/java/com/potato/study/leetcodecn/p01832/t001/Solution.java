package com.potato.study.leetcodecn.p01832.t001;

import java.util.Arrays;

/**
 * 1832. 判断句子是否为全字母句
 *
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。

 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。

 如果是，返回 true ；否则，返回 false 。

  

 示例 1：

 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 输出：true
 解释：sentence 包含英语字母表中每个字母至少一次。
 示例 2：

 输入：sentence = "leetcode"
 输出：false
  

 提示：

 1 <= sentence.length <= 1000
 sentence 由小写英语字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 计数
     * 遍历计数矩阵 26 任意为 0 返回false 否则 true
     * @param sentence
     * @return
     */
    public boolean checkIfPangram(String sentence) {
        int[] count = new int[26];
        for (char ch : sentence.toCharArray()) {
            count[ch - 'a']++;
        }
        // 遍历计数矩阵 26 任意为 0 返回false 否则 true
        for (int c : count) {
            if (c == 0) {
                return false;
            }
        }
        return true;
    }


}
