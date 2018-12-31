package com.potato.study.leetcode.p0125;

/**
 * 
 * @author liuzhao11
 * 
 *         125. Valid Palindrome
 *         
 *    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false  
 *         
 *         思路：
 *        	左右 两个指针left = 0  right = len - 1
 *        	while left 《 right
 *        		找左边的第一个是字母的位置
 *        		找右边第一个是字母的位置
 *        		比较左边和右边 
 *        			相等 在比较下一个位置
 *        			不相等 返回 false   
 *         
 *         
 * 
 */
public class Solution {
	
	public boolean isPalindrome(String s) {
        if(null == s || s.length() == 0) {
        	return true;
        }
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
        	while(left < right && !isLetterOrNum(s.charAt(left))) {
        		left++;
        	}
        	while(left < right && !isLetterOrNum(s.charAt(right))) {
        		right--;
        	}
        	if(left < right && s.charAt(left) != s.charAt(right)) {
        		return false;
        	} else {
        		left++;
        		right--;
        	}
        }
        return true;
    }
	
	private boolean isLetterOrNum(char ch) {
		return (ch - 'a' >= 0 && ch - 'a' < 26) 
				|| (ch - 'A' >= 0 && ch - 'A' < 26) 
				|| (ch - '0' >= 0 && ch - '0' <= 9);
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		String s = "A man, a plan, a canal: Panama";
		String s = "9;8'4P?X:1Q8`dOfJuJXD6FF,8;`Y4! YBy'Wb:ll;;`;\\\"JI0c2uvD':!LAk:s\\\"!'0.!2B55.T1VI?00Du?1,l``RFsc?Y?9vD5 K'3'1b!N8hn:'l. R:9:o`m1r.M2mrJ?`Wjv1`G6i6G`1vjW`?Jrm2M.r1m`o:::R .l':nh8N!b1'3'K 5Dv9?Y?csFR``l,1?uD00?IV1T.55B2!.0'!\\\"s:kAL!:'Dvu2c0IJ\\\";`;;ll9bW'yBY !4Y`;8,FF6DXJuJfOd`8Q1:X?P4'8;9";
		boolean result = solution.isPalindrome(s);
		System.out.println(result);
	}
}
