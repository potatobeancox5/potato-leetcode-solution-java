package com.potato.study.leetcode.p0405;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *         405. Convert a Number to Hexadecimal
 * 
 *      Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.
Example 1:

Input:
26

Output:
"1a"
Example 2:

Input:
-1

Output:
"ffffffff"

	思路 ：将一个整数 转换成16进制的字符串
	弄一个栈 每次对16取余  余数进栈 然后将原来的数 / 16
 */
public class Solution {
	
	public String toHex(int num) {
		if(num == 0) {
			return "0";
		}
        int tmp = num;
        char[] hex = new char[]{'0','1','2','3','4','5','6','7','8','9'
        		,'a','b','c','d','e','f'};
        Stack<Integer> stack = new Stack<>();
        while(tmp != 0) {
        	int remainder = tmp & 15;
        	stack.push(remainder);
        	tmp = tmp >>> 4; // 无符号右移位
        }
        //生成最后的字符串
        StringBuilder sBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
        	int n = stack.pop();
        	sBuilder.append(hex[n]);
        }
        return sBuilder.toString();
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int num = -1;
//		int num = 26;
		String hex = solution.toHex(num);
		System.out.println(hex);
	}
}
