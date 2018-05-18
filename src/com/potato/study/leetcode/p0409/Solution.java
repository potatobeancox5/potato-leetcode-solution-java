package com.potato.study.leetcode.p0409;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *    409. Longest Palindrome
 * 
 *      Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

	思路 ：统计字符转中字母的出现次数 然后 回文长度就等于 
		没有出现奇数次字母 的所有字母数
		出现了奇数次字母的字母数的 - 1的和 再加上1
 */
public class Solution {
	
	public int longestPalindrome(String s) {
		if(null == s || s.length() ==0) {
			return 0;
		}
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++) {
        	char key = s.charAt(i);
        	if(map.containsKey(key)) {
        		map.put(key, map.get(key) + 1);
        	} else {
        		map.put(key, 1);
        	}
        }
        //遍历map 记录次数
        boolean hasOdd = false;
        int len = 0;
        for (char ch : map.keySet()) {
			int count = map.get(ch);
			if(count / 2 * 2 == count) { // 偶数次
				len += count;
			} else {
				len += (count - 1);
				hasOdd = true;
			}
		}
        return hasOdd ? len + 1 : len;
    }
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "abccccdd";
		int len = solution.longestPalindrome(s);
		System.out.println(len);
	}
}
