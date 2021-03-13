package com.potato.study.leetcodecn.p00318.t001;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 318. 最大单词长度乘积
 *
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。

 示例 1:

 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 输出: 16
 解释: 这两个单词为 "abcw", "xtfn"。
 示例 2:

 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 输出: 4
 解释: 这两个单词为 "ab", "cd"。
 示例 3:

 输入: ["a","aa","aaa","aaaa"]
 输出: 0
 解释: 不存在这样的两个单词。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 找到不包含 两个相同字符word的最大乘积
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        // 1 按照长短排序
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        // 2 从后往前 遍历 双循环 找到没有相同字母的交集
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // 如果没有交叉
                if (!hasSame(words[i], words[j])) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }

    /**
     *
     * @param word1
     * @param word2
     * @return
     */
    private boolean hasSame(String word1, String word2) {
        int[] count = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            if (count[word2.charAt(i) - 'a'] > 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[] {
                "abcw","baz","foo","bar","xtfn","abcdef"
        };
        int i = solution.maxProduct(words);
        System.out.println(i);
        Assert.assertEquals(16, i);
    }
}
