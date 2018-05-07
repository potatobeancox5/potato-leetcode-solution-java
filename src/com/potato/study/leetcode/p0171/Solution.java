package com.potato.study.leetcode.p0171;

/**
 * 
 * @author liuzhao11
 * 
 *    171. Excel Sheet Column Number
 *         
 *          
 *   Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701

 *         思路： 
 *         将 字符转转换成代表的数字  也就是26进制  
 *         字符串全变成大写字母 然后 依次
 *        
 */
public class Solution {
	
	public int titleToNumber(String s) {
		if (null == s || s.length() == 0) {
			return 0;
		}
		s = s.toUpperCase();
		int columnNum = 0;
		for(int i = 0 ; i < s.length() ; i++) {
			columnNum = columnNum * 26 + ( s.charAt(i)- 'A' + 1);
		}
		return columnNum;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "ZY";
		int num = solution.titleToNumber(s);
		System.out.println(num);
	}
}
