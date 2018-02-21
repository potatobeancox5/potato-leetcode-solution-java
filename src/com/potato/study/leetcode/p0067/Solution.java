package com.potato.study.leetcode.p0067;


/**
 * 
 * @author liuzhao11
 * 
 *         67. Add Binary
 *         Given two binary strings, return their sum (also a
 *         binary string).
 * 
 *         For example, a = "11" b = "1" Return "100".
 * 
 *         思路：
 *         给定两个字符串相加 计算二进制数 返回一个二进制数的字符串
 *         1.找到大的那个数 确定数位
 *         2.新申请一个数组char[大的长度+1] 用于存放 计算后的结果
 * 
 * 
 * 
 */
public class Solution {

	public String addBinary(String a, String b) {
		// 处理空串 问题
		if (a == null || "".equals(a.trim())) {
			return b;
		}
		if (b == null || "".equals(b.trim())) {
			return a;
		}
		//使用String reverse方法进行字符串反转
		int aIndex = a.length() - 1;
		int bIndex = b.length() - 1;
		int carry = 0;// 进位符
		StringBuilder result = new StringBuilder(); 
		while(aIndex > -1 || bIndex > -1 || carry == 1) {
			int aNum = aIndex == -1 ? 0 : a.charAt(aIndex--) - '0';
			int bNum = bIndex == -1 ? 0 : b.charAt(bIndex--) - '0';
			int temp = aNum + bNum + carry;
			switch (temp) {
			case 1:
				temp = 1;
				carry = 0;
				break;
			case 2:
				temp = 0;
				carry = 1;
				break;
			case 3:
				temp = 1;
				carry = 1;
				break;
			default:
				System.out.println("运算出错");
				break;
			}
			result.append(temp);
		}
		return result.reverse().toString();
	}

	

	public static void main(String[] args) {
		Solution solution = new Solution();
		String a = "11";
		String b = "1";
		String result = solution.addBinary(a, b);
		System.out.println(result);
		
	}
}
