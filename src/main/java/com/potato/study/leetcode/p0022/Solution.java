package com.potato.study.leetcode.p0022;


import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 * 
 * 思路 ：
 * 递归思想的一种变更 
 * 每次 纪录 a b n current result(存储总的字符串)
 * 初值条件 当前纪录的字符串长度等于 n * 2 
 * 设 （数量为a    ）数量为b    输入对数n
 * 当  a < n 时 
 * 		若 a > b   下一个输入可能是 （ 也可能是 ）
 * 		若 a == b   下一个只能是 （
 * 当  a == n 时 下一个输入只能是 ")"
 * @author Administrator
 *
 */
public class Solution {
	
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generateParenthesStr(0, 0, n , "", result);
		return result;
    }	
	
	/**
	 * 递归求解 符号匹配字符串 满足current 中字符符号要求之后 将其放入result中
	 * @param a			当前（ 数量
	 * @param b			当前 ）数量
	 * @param n			 符号对数
	 * @param current	 当前积累的字符串
	 * @param result		 保存积累的字符串的结果
	 */
	private void generateParenthesStr(int a, int b , int n , String current ,List<String> result) {
		//初值条件
		if(current.length() == n * 2) {
			result.add(current);
			return;
		}
		if(a < n) {
//		当  a < n 时 
			if(a > b) {
//		 * 		若 a > b   下一个输入可能是 （ 也可能是 ）
				generateParenthesStr(a + 1, b, n, current + "(", result);
				generateParenthesStr(a, b + 1, n, current + ")", result);
			} else {
//		 * 		若 a == b   下一个只能是 （
				generateParenthesStr(a + 1, b, n, current + "(", result);
			}			
		} else {
//		 * 当  a == n 时 下一个输入只能是 ")"
			generateParenthesStr(a, b + 1, n, current + ")", result);
		}
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<String> con = solution.generateParenthesis(3);
		System.out.println(con);
		
	}
}
