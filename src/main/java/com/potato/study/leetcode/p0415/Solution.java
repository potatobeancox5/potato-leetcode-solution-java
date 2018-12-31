package com.potato.study.leetcode.p0415;

/**
 * 
 * @author liuzhao11
 * 
 *         415. Add Strings
 * 
 *         Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * 
 *         思路： 两个字符串数字相加 
 *         申请第三个数字 比最大的长度+ 1 设置一个bit记录进位情况
 * 
 */
public class Solution {
	
	public String addStrings(String num1, String num2) {
        if(null == num1 || num1.length() == 0) {
        	return num2;
        }
        if(null == num2 || num2.length() == 0) {
        	return num1;
        }
        
        int len = num1.length() > num2.length() ? num1.length(): num2.length();
        char[] resultArr = new char[len];
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1 ; i >= 0 || j >=0 ;i--,j--) {
        	if(i >= 0 && j >= 0) {
        		int k = i > j ? i : j;
        		int temp = num1.charAt(i) - '0' + num2.charAt(j) - '0'  + carry;
        		if(temp >= 10) {
        			carry = temp / 10;
        			temp = temp - 10; // 不可能超过19
        		} else {
        			carry = 0;
        		}
        		resultArr[k] = (char) ('0' + temp);
        		
        	} else if(i >= 0) {
        		int temp = num1.charAt(i) - '0' + carry;
        		if(temp >= 10) {
        			carry = temp / 10;
        			temp = temp - 10; // 不可能超过19
        		} else {
        			carry = 0;
        		}
        		resultArr[i] = (char) ('0' + temp);
        	} else { // j >= 0
        		int temp = num2.charAt(j) - '0'  + carry;
        		if(temp >= 10) {
        			carry = temp / 10;
        			temp = temp - 10; // 不可能超过19
        		} else {
        			carry = 0;
        		}
        		resultArr[j] = (char) ('0' + temp);
        	}
        }
        //判断最终是否出现了进位
        if(carry > 0) {
        	return 1 + new String(resultArr);
        } else {
        	return new String(resultArr);
        }
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String num1 = "55";
		String num2 = "55";
		String num = solution.addStrings(num1, num2);
		System.out.println(num);
	}
}
