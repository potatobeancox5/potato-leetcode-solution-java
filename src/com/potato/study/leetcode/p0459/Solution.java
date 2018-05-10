package com.potato.study.leetcode.p0459;

/**
 * 
 * @author liuzhao11
 * 
 *        459. Repeated Substring Pattern
 * 
 *       Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * 
 * 
 *         思路： 
 *         // 通过长度计算 然后首先判断是否能够 重复 
 * 			
 * 				
 */	
public class Solution {
	
	public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = len / 2 ; i > 0 ; i--) {
        	if (len % i == 0) {
				// 构造新的·字符串 与之前字符串比较
        		int partNum = len / i;
        		String partStr = s.substring(0, i);
        		boolean canRepeated = true;
        		for(int j = 0 ; j < partNum ; j++) {
        			if(!partStr.equals(s.substring(j * i, (j + 1)* i))) {
        				canRepeated = false;
        				break;
        			}
        		}
        		if(canRepeated) {
        			return true;
        		}
			}
        }
        return false;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "abab";
//		String s = "aba";
//		String s = "abcabcabcabc";
		boolean result = solution.repeatedSubstringPattern(s);
		System.out.println(result);
	}
}
