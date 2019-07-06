package com.potato.study.leetcode.p0482;

/**
 * 
 * @author liuzhao11
 * 
 *         482. License Key Formatting
 * 
 *        You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.

Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.

Given a non-empty string S and a number K, format the string according to the rules described above.

Example 1:
Input: S = "5F3Z-2e-9-w", K = 4

Output: "5F3Z-2E9W"

Explanation: The string S has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
Example 2:
Input: S = "2-5g-3-J", K = 2

Output: "2-5G-3J"

Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
Note:
The length of string S will not exceed 12,000, and K is a positive integer.
String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
String S is non-empty.
 * 
 *         思路：  查找数组中 最长的连续的1的个数
 *         
 * 
 */
public class Solution {


	/**
	 * 给定一个字符串代表license，按照keyNum 数量 重新编排这个license key
	 * 不够组成keyNum个字符的按照第一个先处理 余数个
	 * @param str
	 * @param keyNum
	 * @return
	 */
	public String licenseKeyFormatting(String str, int keyNum) {


		String newStr = str.replace("-", "").toUpperCase();

		if ("".equals(newStr)) {
			return "";
		}

		int len = newStr.length();
		// 计算第一组数量
		int firstPartLen = len % keyNum;
		StringBuilder sb = new StringBuilder();
		// 设置第一组
		if (firstPartLen != 0) {
			sb.append(newStr.substring(0, firstPartLen)).append('-');
		}
		// 设置之后的数字
		int currentCount = 0;
		for (int i = firstPartLen ; i < newStr.length(); i++) {
			sb.append(newStr.charAt(i));
			currentCount++;
			if (currentCount == keyNum) {
				sb.append('-');
				currentCount = 0;
			}
		}

		// 判断是否需要删除最后一个'-'
		if (sb.charAt(sb.length() - 1) == '-') {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

//		String str = "5F3Z-2e-9-w";
//		int keyNum = 4;

//		String str = "2-5g-3-J";
//		int keyNum = 2;

		String str = "2-4A0r7-4k";
		int keyNum = 4;

		String s = solution.licenseKeyFormatting(str, keyNum);
		System.out.println(s);
	}
}
