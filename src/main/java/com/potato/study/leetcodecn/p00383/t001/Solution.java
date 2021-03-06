package com.potato.study.leetcodecn.p00383.t001;

/**
 * 383. 赎金信
 *
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。

 (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)

  

 注意：

 你可以假设两个字符串均只含有小写字母。

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/ransom-note
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (null == ransomNote) {
            return true;
        }
        if (null == magazine) {
            return false;
        }
        int[] ransomArr = getCharacterCount(ransomNote);
        int[] magazineArr = getCharacterCount(magazine);
        for (int i = 0; i < 26; i++) {
            if (ransomArr[i] > magazineArr[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param word
     * @return
     */
    private int[] getCharacterCount(String word) {
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }
        return count;
    }
}
