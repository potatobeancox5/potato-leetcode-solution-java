package com.potato.study.leetcode.p1081;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 * 	1081. Smallest Subsequence of Distinct Characters
 *  
 *       Return the lexicographically smallest subsequence of text that contains all the distinct characters of text exactly once.

Example 1:

Input: "cdadabcc"
Output: "adbc"
Example 2:

Input: "abcd"
Output: "abcd"
Example 3:

Input: "ecbacba"
Output: "eacb"
Example 4:

Input: "leetcode"
Output: "letcod"


Constraints:

1 <= text.length <= 1000
text consists of lowercase English letters.
Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/
 *         
 *
 *
 *
 *         思路：
 *
 *https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/solution/cu-su-yi-dong-shu-zu-zhan-hashmap-pei-he-qiu-jie-5/
 */
public class Solution {

    public String smallestSubsequence(String text) {
        if (text == null || text.length() == 1) {
            return text;
        }
        int len = text.length();
        int[] recordCharCount = new int[26]; // 用来保存字母出现的次数

        Stack<Character> res = new Stack<>();
        for (int i = 0; i < len; i++){
            recordCharCount[text.charAt(i) - 'a'] += 1;
        }

        Map<Character, Integer> hasMap = new HashMap<>(); // 用来记录栈中是否存在当前遍历的字符
        for (int i = 0; i < len; i++){
            recordCharCount[text.charAt(i) - 'a'] -= 1;
            if (hasMap.containsKey(text.charAt(i))) {
                continue;
            }
            while (!res.isEmpty()){
                char curPeekChar = res.peek();
                if (curPeekChar > text.charAt(i) && recordCharCount[curPeekChar - 'a'] > 0){
                    res.pop();
                    hasMap.remove(curPeekChar);
                }else{
                    break;
                }
            }
            res.push(text.charAt(i));
            hasMap.put(text.charAt(i), 1);
        }

        StringBuffer result = new StringBuffer();
        while (!res.isEmpty()){
            result.append(res.pop());
        }

        return result.reverse().toString();
    }


}
