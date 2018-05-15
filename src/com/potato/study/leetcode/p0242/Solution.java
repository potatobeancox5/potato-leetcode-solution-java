package com.potato.study.leetcode.p0242;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *      242. Valid Anagram
 * 
 *Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?* 
 * 思路：两个单词包含的字母相同
 */
public class Solution {
	
	/**
	 * 假设s t 都不为null
	 * 和 “”
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
        	return false;
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
        for(int i = 0 ; i < t.length() ; i++) {
        	char key = t.charAt(i);
			if(map.containsKey(key)) {
				if(map.get(key) < 1) {
					return false;
				}
				map.put(key, map.get(key) -1);
			} else {
				return false;
			}
        }
        return true;
    }
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
//    	String s = "anagram";
//    	String t = "nagaram";
    	String s = "rat";
    	String t = "car";
    	boolean isAna = solution.isAnagram(s, t);
    	System.out.println(isAna);
	}
}
