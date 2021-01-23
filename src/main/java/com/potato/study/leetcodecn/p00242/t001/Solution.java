package com.potato.study.leetcodecn.p00242.t001;

/**
 * 242. 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。

 进阶:
 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-anagram
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
    public boolean isAnagram(String s, String t) {
        int[] count1 = this.getWordChCount(s);
        int[] count2 = this.getWordChCount(t);
        return charCountArrayEquals(count1, count2);
    }

    /**
     * 判断 字母 数组 coun1 == count2
     * @param count1
     * @param count2
     * @return
     */
    private boolean charCountArrayEquals(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算每个 单词 每个字母出现的个数
     * 只支持小写字母
     * @param word
     * @return
     */
    private int[] getWordChCount(String word) {
        int[] count = new int[26];
        if (null == word || word.length() == 0) {
            return count;
        }
        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }
        return count;
    }


}
