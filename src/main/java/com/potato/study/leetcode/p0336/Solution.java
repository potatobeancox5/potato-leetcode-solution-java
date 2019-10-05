package com.potato.study.leetcode.p0336;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         336. Palindrome Pairs
 * 
 *        Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]
 * 
 *         思路：
 *          给定一组单词，每个单词都是不重复的 找到其中的任意的两个单词，使得两个单词拼接后都是一个回文序列
 *
 *          https://www.jianshu.com/p/be2921f4a7cc
 *
 *          1. 构建一个map key 单词 value 位置
 *
 *
 *
 *
 * 
 */
public class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = this.wordIndexMap(words);
        // 遍历单词
        for (int i = 0; i < words.length; i++) {
            // 如果单词 word 在map总存在 直接返回 当前i 和 map 中获取的单词index
            if (map.containsKey(words[i]) && map.get(words[i]) != i) {
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(map.get(words[i]));
                res.add(pair);
            }
            // 如果当前 word 从 0 - i 是回文 而i + 1 - len 在map中存在 说明可以租场
            for (int j = 0; j < words[i].length(); j++) {
                if (this.isPalindromeWord(0, j, words[i]) && map.containsKey(words[i].substring(j + 1, words[i].length()))) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(map.get((words[i].substring(j + 1, words[i].length()))));
                    pair.add(i);
                    res.add(pair);
                }
            }
            // 如果当前 word 从 i - len -1  是回文 而i + 1 - len 在map中存在 说明可以租场
            for (int j = words[i].length() - 1; j >= 0; j--) {
                if (this.isPalindromeWord(j, words[i].length() - 1, words[i]) && map.containsKey(words[i].substring(0, j))) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(map.get(words[i].substring(0, j)));
                    res.add(pair);
                }
            }
        }
        return res;
    }


    /**
     * 生成一个map  key 单词的revise value 位置
     * @param words
     * @return
     */
    private Map<String, Integer> wordIndexMap (String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            map.put(sb.reverse().toString(), i);
        }
        return map;
    }


    /**
     * 判断一个单词 从start 到 end 是否是回文字符串
     * @param start
     * @param end
     * @param word
     * @return
     */
    private boolean isPalindromeWord (int start, int end, String word) {
        while (start <= end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
	
	public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> lists = solution.palindromePairs(words);
        System.out.println(lists);


        String[] words1 = {"bat","tab","cat"};
        lists = solution.palindromePairs(words1);
        System.out.println(lists);
    }
}
