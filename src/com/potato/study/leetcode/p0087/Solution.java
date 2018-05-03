package com.potato.study.leetcode.p0087;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *        87. Scramble String
 *         
 *          
 *       Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

Example 1:

Input: s1 = "great", s2 = "rgeat"
Output: true
Example 2:

Input: s1 = "abcde", s2 = "caebd"
Output: false
 * 
 *         思路：如果两个两个字符串互为乱序关系 那么他们从某个位置切开 两端字符均为乱序关系 
 *         		那么 最基础的情况 如果 两字字母  只要字母一样 就可以是 Scramble String
 *         		一个字母 一样的情况下  Scramble 
 *         		于是 进行递归 
 *         
 */
public class Solution {

	public boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		if(s1.length() == 1) {
			return s1.equals(s2);
		}
		if(s1.length() == 2) {
			return s1.equals(s2) || (s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0));
		}
		if(!containSame(s1,s2)) {
			return false;
		}
		for(int i = 1; i < s1.length() ;i++) { //从那个位置切割字符串
			boolean result = (isScramble(s1.substring(0, i), s2.substring(0, i)) 
					&& isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length())))
					|| (isScramble(s1.substring(0, i), s2.substring(s2.length() - i , s2.length()))
					&& isScramble(s1.substring(i, s1.length()), s2.substring(0, s2.length() - i)));
			if (result) {
				return true;
			}
		}
        return false;
    }
	
	private boolean containSame(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s1.toCharArray()) {
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch,1);
			}
		}
		for (char ch : s2.toCharArray()) {
			if(map.containsKey(ch)) {
				int count = map.get(ch);
				if(count <= 0) {
					return false;
				}
				map.put(ch, count - 1);
			} else {
				return false;
			}
		}
		return true;
	}
	
	

	public static void main(String[] args) {
		Solution solution = new Solution();
//		String s1 = "great";
//		String s2 = "rgeat";
		String s1 = "abcdefghijklmnopq";
		String s2 = "efghijklmnopqcadb";
		boolean result = solution.isScramble(s1, s2);
		System.out.println(result);
	}
}
