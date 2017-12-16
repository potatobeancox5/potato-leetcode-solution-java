package com.potato.study.leetcode.p0008;

/**
 * 
 * @author liuzhao11 
 * 
 * 	8. String to Integer (atoi) Implement atoi to convert a
 *         string to an integer.
 * 
 *         Hint: Carefully consider all possible input cases. If you want a
 *         challenge, please do not see below and ask yourself what are the
 *         possible input cases.
 * 
 *         Notes: It is intended for this problem to be specified vaguely (ie,
 *         no given input specs). You are responsible to gather all the input
 *         requirements up front.
 * 
 *         Update (2015-02-10): The signature of the C++ function had been
 *         updated. If you still see your function signature accepts a const
 *         char * argument, please click the reload button to reset your code
 *         definition.
 * 
 *         Requirements for atoi: The function first discards as many whitespace
 *         characters as necessary until the first non-whitespace character is
 *         found. Then, starting from this character, takes an optional initial
 *         plus or minus sign followed by as many numerical digits as possible,
 *         and interprets them as a numerical value.
 * 
 *         The string can contain additional characters after those that form
 *         the integral number, which are ignored and have no effect on the
 *         behavior of this function.
 * 
 *         If the first sequence of non-whitespace characters in str is not a
 *         valid integral number, or if no such sequence exists because either
 *         str is empty or it contains only whitespace characters, no conversion
 *         is performed.
 * 
 *         If no valid conversion could be performed, a zero value is returned.
 *         If the correct value is out of the range of representable values,
 *         INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * 
 * 
 * 
 *         思路：
 *         1.去除输入字符传前面的空格（直接trim）
 *         2.转换的数字后边可以有任意字符 （转换数字遇到第一个不是数字的字符为止）
 *         3.第一个数字之前或者符号之前若果存在字符 不进行转换
 *         4.不进行转换时 返回0 超出int 范围 返回 Integer.max	Integer.min
 *         (由于情绪不号 使用了long型进行存储 对于只要求使用int型的不适用)
 */
public class Solution {
	
	public int myAtoi(String str) {
		if(null == str) {
			return 0;
		}
        str = str.trim();
        if(str.length() == 0) {
        		return 0;
        }
        //第一个字符不是数字或者+ - 号 直接返回
        if (!isValidCharactor(str.charAt(0))) {
			return 0;
		} else { // 结果正常
			//判断是否是符号位，是的话纪录符号
			boolean isNegative = false;
			long currentValue = 0;
			int index = 0;
			if(str.charAt(index) == '-') {
				isNegative = true;
				index++;
			} else if (str.charAt(index) == '+') {
				index++;
			}
			//增加一个数字计算器 防止正数数位超大的情况 返回负数
			int bitNum = 0;
			//遍历字符串，
			while(index < str.length()) {
				if(isNumber(str.charAt(index))) {
					//如果是数字的话,转换成数字并储存在current 中 current = current * 10 + 当前数字
					currentValue = currentValue * 10 + (str.charAt(index) - '0');
					index++;
					bitNum++;
				} else {
					//如果不是数字的话，跳出当前循环
					break;
				}
				//处理数位
				if(bitNum >= 11) {//int 最大10位
					break;
				}
			}
			//给结果加上符号位
			if(isNegative) {
				currentValue = -1 * currentValue;
			}
			//处理越界情况
			if(currentValue > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			} else if (currentValue < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			} else {
				return (int) currentValue;
			}
		}
    }
	
	private boolean isValidCharactor(char ch) {
		if(ch == '+' || ch == '-') {
			return true;
		} else if (isNumber (ch)) {
			return true;
		}
		return false;
	}
	
	private boolean isNumber (char ch) {
		if (ch - '0' >= 0 && ch - '0' <=9) {
			return true;
		}
		return false;
	}
	
	

	public static void main(String[] args) {
//		String string = "-123";
		String string = "-999999999999999999";
//		String string = "";
		Solution solution = new Solution();
		int num = solution.myAtoi(string);
		System.out.println(num);
	}

}
