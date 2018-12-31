package com.potato.study.leetcode.p0434;

/**
 * 
 * @author liuzhao11
 * 
 *   434. Number of Segments in a String
 * 
 *   Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
Seen this question in a real interview before?  YesNo

 * 			
 *     思路：查给定字符串中的单词数 单词是 用space格开的
 *     遍历字符串 遇到字符查看前面是不是空格 是的话 wordcount++ 不是的话 continue 
 *     	遇到空格continue	
 *     
 * 			
 * 	
 */	
public class Solution {
	
	public int countSegments(String s) {
        int wordCount = 0;
        for(int i = 0 ; i < s.length() ; i++) {
        	if(i == 0 && s.charAt(i) != ' ') {
        		wordCount++;
        	} else if (s.charAt(i) == ' ') {
        		continue;
        	} else { // 不等于0  且不为 空格的
        		if(s.charAt(i-1) == ' ') {
        			wordCount++;
        		}
        	}
        }
        return wordCount;
    }
	
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		String s = "Hello, my name is John";
		String s = "     11";
		int count = solution.countSegments(s);
		System.out.println(count);
	}
}
