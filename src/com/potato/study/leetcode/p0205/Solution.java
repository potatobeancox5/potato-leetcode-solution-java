package com.potato.study.leetcode.p0205;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *         205. Isomorphic Strings
 * 
 *         Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
 * 
 *         思路：  判断两个字符串是否是同构的
 *         两个map key 是字母 value 是出现的位置index的字符串 如 1,2,3,18, 每个字母 取出value进行比较 
 *         不同 证明不是同构 相同继续
 *         
 *         另一个思路 建立两个map
 *         https://www.cnblogs.com/ganganloveu/p/4466962.html 比较对应关系 
 *         对应关系保持一对一的性质
 * 
 */
public class Solution {
	
	public boolean isIsomorphic(String s, String t) {
		if(null == s && null == t) {
			return true;
		}
		if(null == s || null == t) {
			return false;
		}
		if(s.length() != t.length()) {
			return false;
		}
        Map<Character, String> mapS = new HashMap<>();
        Map<Character, String> mapT = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++) {
        	char sChar = s.charAt(i);
        	char tChar = t.charAt(i);
        	if(mapS.containsKey(sChar) && mapT.containsKey(tChar)) {
        		String sVal = mapS.get(sChar);
        		String tVal = mapT.get(tChar);
        		if(sVal.equals(tVal)) {
        			mapS.put(sChar, sVal + i + ",");
            		mapT.put(tChar, tVal + i + ",");
        		} else {
        			return false;
        		}
        	} else if(!mapS.containsKey(sChar) && !mapT.containsKey(tChar)) {
        		mapS.put(sChar, i + ",");
        		mapT.put(tChar, i + ",");
        	} else { // 一个有一个没有
        		return false;
        	}
        }
        return true;
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "egg";
		String t = "add";
		boolean result = solution.isIsomorphic(s, t);
		System.out.println(result);
	}
}
