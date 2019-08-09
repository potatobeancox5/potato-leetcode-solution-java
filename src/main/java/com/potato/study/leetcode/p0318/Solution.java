package com.potato.study.leetcode.p0318;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 *         318. Maximum Product of Word Lengths
 *         
 *          
 *         Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:

Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
 *         
 *         
 *         
 *         思路：
 *         318. Maximum Product of Word Lengths
将每个字符串 转换成26bit 二进制数

一次比较 取出最长的 &为0的乘积


https://blog.csdn.net/gao1440156051/article/details/51912990
 *
 *
 *         
 *         
 *         
 *         
 *         
 */
public class Solution {


    class WordObject {
        public String word;
        public long code;

        public WordObject(String word, long code) {
            this.word = word;
            this.code = code;
        }
    }

    public int maxProduct(String[] words) {
        if (null == words || words.length == 0) {
            return 0;
        }
        List<WordObject> wordObjectList = new ArrayList<>();
        for (String word : words) {
            wordObjectList.add(new WordObject(word, generateWordHash(word)));
        }
        int maxProduct = 0;
        // 遍历list 找到乘机最大的值
        for (int i = 0; i < wordObjectList.size(); i++) {
            for (int j = i + 1; j < wordObjectList.size(); j++) {
                if ( (wordObjectList.get(i).code & wordObjectList.get(j).code) == 0
                        && maxProduct < wordObjectList.get(i).word.length() * wordObjectList.get(j).word.length()) {
                    maxProduct = wordObjectList.get(i).word.length() * wordObjectList.get(j).word.length();
                }
            }
        }
        return maxProduct;
    }

    /**
     * 利用二进制字符串形式进行转换
     * @return
     */
    private long generateWordHash(String word) {
        if (null == word || "".equals(word)) {
            return 0;
        }
        long hashCode = 0;
        for (char ch : word.toCharArray()) {
            hashCode |= 1 << (ch - 'a');
        }
        return hashCode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"}; // bac
//        String[] words = {"a","ab","abc","d","cd","bcd","abcd"}; // bac
        String[] words = {"a","aa","aaa","aaaa"}; // bac
        int maxProduct = solution.maxProduct(words);
        System.out.println(maxProduct);
    }
}
