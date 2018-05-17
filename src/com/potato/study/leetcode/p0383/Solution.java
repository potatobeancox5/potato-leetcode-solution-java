package com.potato.study.leetcode.p0383;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *       383. Ransom Note
 * 
 *      Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 *         
 *         思路：
 *         判断前边的那个字符串中的字符 是否能有后面字符转中的字符表示
 */
public class Solution{
	
	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : magazine.toCharArray()) {
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
        for(char ch : ransomNote.toCharArray()) {
        	if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if(map.get(ch) < 0) {
					return false;
				}
			} else {
				return false;
			}
        }
        return true;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String ransomNote = "aa";
		String magazine = "aab";
		boolean res = solution.canConstruct(ransomNote, magazine);
		System.out.println(res);
	}
}

