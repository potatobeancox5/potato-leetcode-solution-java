package com.potato.study.leetcode.p0720;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	720. Longest Word in Dictionary
 *  
 *        Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
 *         
 *         思路：
 *             https://blog.csdn.net/xiakexiaohu/article/details/78512354
 *
 *             720. Longest Word in Dictionary
            better
            题目隐含 每次增加一个字母进行构建
            字典排序sort set 存放
            遍历数组
            if len ==1 写入set 或者 当前s 的前缀在set中
            set .add
            比较当前是否长度最大 最大 插入
 *
 * 
 */
public class Solution {

    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> prefixSet = new HashSet<>();
        int maxLen = 0;
        String longestWord = "";
        for (String word : words) {
            if (word.length() == 1 || prefixSet.contains(word.substring(0, word.length() - 1))) {
                if (maxLen < word.length()) {
                    maxLen = word.length();
                    longestWord = word;
                }
                prefixSet.add(word);
            }
        }
        return longestWord;
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();
//        String[] words = {"w","wo","wor","worl", "world"};
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String s = solution.longestWord(words);
        System.out.println(s);
    }
}
