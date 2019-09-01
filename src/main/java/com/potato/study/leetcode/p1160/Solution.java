package com.potato.study.leetcode.p1160;


import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	1160. Find Words That Can Be Formed by Characters
 *  
 *
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.



Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation:
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation:
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.


Note:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.
 *         
 *         思路：
 *         计算这个chars 可以表示的单词的长度和
 *         https://www.acwing.com/solution/LeetCode/content/3968/
 *
 *
 *
 *
 */
public class Solution {

    public int countCharacters(String[] words, String chars) {
        // 统计 chars 的字母集合
        Map<Character, Integer> chCountMap = new HashMap();
        for (char ch : chars.toCharArray()) {
            Integer count = chCountMap.get(ch);
            if (count == null) {
                chCountMap.put(ch, 1);
            } else {
                chCountMap.put(ch, count + 1);
            }
        }
        int resLen = 0;
        for (int i = 0; i < words.length; i++) {
            // 判断这个单词是否可以由给的字符串拼出来
            boolean canForm = true;
            Map<Character, Integer> currentMap = new HashMap<>(chCountMap);
            for (char ch : words[i].toCharArray()) {
                Integer count = currentMap.get(ch);
                if (null == count) {
                    canForm = false;
                    break;
                } else if (count == 1) {
                    currentMap.remove(ch);
                } else if (count > 1) {
                    currentMap.put(ch, count - 1);
                }
            }
            if (canForm) {
                resLen += words[i].length();
            }
        }
        return resLen;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
//        String[] words = {"hello","world","leetcode"};
//        String chars = "welldonehoneyr";
        int count = solution.countCharacters(words, chars);
        System.out.println(count);
    }
}
