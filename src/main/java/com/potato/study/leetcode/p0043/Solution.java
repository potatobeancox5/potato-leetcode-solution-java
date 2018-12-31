package com.potato.study.leetcode.p0043;

/**
 * 
 * @author liuzhao11
 * 
 *      43. Multiply Strings
 *      Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.   没有多余的前置零
You must not use any built-in BigInteger library or convert the inputs to integer directly.

 * 
 * 
 *         思路：乘法规则
 *          15
 *      x   13
 *      --------------------
 *      	15
 *          3
 *          5
 *     +   1
 *     ------------------------
 *         195
 *       开一个int数组 存储中间计算结果 倒叙储存 数组大小被乘数和乘数的大小和  
 *       0 位置为个位 并记录最大位置数 
 *       过程中记录最大位置数 来计算最终结果数位
 *       通过上一步得出的最后结果 申请新数组 
 *       最后从前到后遍历一遍int数组并撤职新申请的数组的字符串
 *
 */
public class Solution {
	
	public String multiply(String num1, String num2) {
		if(null == num1 || null == num2) {
			return null;
		}
		int[] tmp = new int[num1.length() + num2.length()];
		for(int i = num2.length() - 1 ; i >= 0 ; i--) {
			int num2BitInt = num2.charAt(i) - '0';
			for(int j = num1.length() - 1 ; j >= 0 ; j--) {
				int num1BitInt = num1.charAt(j) - '0';
				tmp[num2.length() - 1 - i + num1.length() - 1 - j] += (num2BitInt * num1BitInt);
			}
		}
		// 判断当前结果并申请新字符串
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < tmp.length ; i++) {
			builder.append(tmp[i] % 10);
			if(i != tmp.length - 1) {
				tmp[i+1] += (tmp[i] / 10);
			}
		}
		// tmp 申请的数字长度意味着tmp一定够用 但需要去掉最后几个0 知道第一个不为0的位置
		while(builder.length() > 0 && builder.charAt(builder.length() - 1) == '0') {
			builder.deleteCharAt(builder.length() - 1);
		}
		if(builder.length() == 0) {
			return "0";
		}
		return builder.reverse().toString();
	}
	
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		String result = solution.multiply("0", "0");
		System.out.println(result);
	}
}
