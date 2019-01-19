package com.potato.study.leetcode.p0709;

/**
 * 
 * @author liuzhao11
 * 
 * 	709. To Lower Case
 *  
 *         Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.



Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
 *         
 *         思路：
 *
 *         
 *         动态方程
 *
 * 
 */
public class Solution {

    public String toLowerCase(String str) {
        if (null == str || "".equals(str.trim())) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char)(ch + 32));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String word = "LOVELY";
        String s = solution.toLowerCase(word);
//        System.out.println((int)'a');
//        System.out.println((int)'A');
        System.out.println(s);
    }
}
