package com.potato.study.leetcode.p0065;

/**
 * 
 * @author liuzhao11
 * 
 *         65. Valid Number
 * 
 * 
 *         Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.


 * 
 *         思路：
 * 			判断给定的字符串是否是数字
 * 
 */
public class Solution {
	
	public boolean isNumber(String s) {
        //去掉两端空格
		s = s.trim();
		// 是否存在e
		if(s.contains("e")) {
			// 按照用第一个e分开 前边可以是小数 也可以是整数 后边只能是整数
			int i = 0;
			while(i < s.length()) {
				if(s.charAt(i) == 'e') {
					break;
				}
				i++;
			}
			if(i == s.length()) { // e是最后一个字符
				return false;
			}
			String before = s.substring(0, i); 
			String after = s.substring(i+1);
			//判断是否是整数
			return isInteger(after) && isFloatOrInteger(before);
		} else {
			return isFloatOrInteger(s);
		}
    }

	
	/**
	 * 可以有正负号 但其余的都是数字
	 * @param num
	 * @return
	 */
	private boolean isInteger(String num) {
		if(null == num || num.length() == 0) {
			return false;
		}
		char symbol = num.charAt(0);
		if((symbol == '+' || symbol == '-') && num.length() == 1) {
			return false;
		}
		if(symbol != '+' && symbol != '-' && !(symbol >= '0' && symbol <= '9') ) {
			return false;
		}
		for(int i = 1 ; i < num.length() ; i++) {
			if(num.charAt(i) < '0' || num.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 无符号整数
	 * @param num
	 * @return
	 */
	private boolean isUnsignedInteger(String num) {
		if(null == num || num.length() == 0) {
			return false;
		}
		for(int i = 0 ; i < num.length() ; i++) {
			if(num.charAt(i) < '0' || num.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	
	private boolean isFloatOrInteger(String num) {
		if(num.contains(".")) {
			char symbol = num.charAt(0);
			if(symbol == '+' || symbol == '-') {
				num = num.substring(1);
			}
			if(num.length() == 0) {
				return false;
			}
			int index = 0;
			for (; index < num.length(); index++) {
				if(num.charAt(index) == '.') {
					break;
				}
			}
			if(index == num.length() - 1) {
				String tmp = num.substring(0,num.length() - 1);
				return isUnsignedInteger(tmp);
			}
			if(index == 0) { // .1 return true
				String tmp = num.substring(index + 1);
				return isUnsignedInteger(tmp);
			}
			// 两边都是整数
			String before = num.substring(0, index);
			String after = num.substring(index + 1);
			return isUnsignedInteger(before) && isUnsignedInteger(after);
		} else {
			return isInteger(num);
		}
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = " 1. ";
		boolean result = solution.isNumber(s);
		System.out.println(result);
	}
}
