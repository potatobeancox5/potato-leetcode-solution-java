package com.potato.study.leetcode.p0290;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 290. Word Pattern
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*
 * 	题目解释：
 *
 * 	思路：
 *
* 
 */
public class Solution {


    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) {
            return true;
        }
        String[] wordParts = str.split(" ");
        if (pattern.length() != wordParts.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>(); // 正向
        Map<String, Character> reverseMap = new HashMap<>(); // 反向

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, wordParts[i]);
            } else if (!map.get(ch).equals(wordParts[i])){ // 比较之前记录的word 和本次的 word 不相等
                return false;
            }
            // 判断反向map
            if (!reverseMap.containsKey(wordParts[i])) {
                reverseMap.put(wordParts[i], ch);
            } else if (reverseMap.get(wordParts[i]).charValue() != ch){ // 比较之前记录的word 和本次的 word 不相等
                return false;
            }
        }
        return true;
    }
	
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	String pattern = "abba";
    	String str = "dog cat cat dog";
//    	String str = "dog cat cat fish";
//    	String str = "dog dog dog dog";


    	boolean result = solution.wordPattern(pattern, str);
        System.out.println(result);
    }
}
