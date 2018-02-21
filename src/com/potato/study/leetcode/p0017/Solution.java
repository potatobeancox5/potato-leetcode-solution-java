package com.potato.study.leetcode.p0017;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author liuzhao11 
 * 
 * 		17. Letter Combinations of a Phone Number 
 * 
 * 		 Given a digit
 *         string, return all possible letter combinations that the number could
 *         represent.
 * 
 *         A mapping of digit to letters (just like on the telephone buttons) is
 *         given below.
 * 
 * 
 * 
 *         Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
 *         "cd", "ce", "cf"]. Note: Although the above answer is in
 *         lexicographical order, your answer could be in any order you want.
 * 
 * 
 * 
 *         思路：	
 *         题意是将手机键盘的按键号码 代表的字母 进行组合 并将组合结果 显示出来
 *         创建一个新的数组
 *         遍历数字，
 *         获取当前数字代表的字符集 ，
 *         利用每个字符将 原来 link从头开始添加字符 并将添加后的结果放在list末尾
 *         
 *         
 * 
 * 
 */
public class Solution {
	
	public List<String> letterCombinations(String digits) {
		LinkedList<String> result = new LinkedList<>();
		if(null == digits || "".equals(digits.trim())) {
			return result;
		}
		String[] origin = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		// 遍历给定数组
		for (int i = 0; i < digits.length(); i++) {
			int index = digits.charAt(i) - '0';
			String prefix = origin[index];
			int length = result.size();
			List<String> temp = new ArrayList<>();
			for(char ch : prefix.toCharArray()) {
				//遍历list 并向其中添加字符 放在队尾
				if(length == 0) {
;					temp.add("" + ch);
					continue;
				}
				for(int j = 0 ; j < length ; j++ ) {
					String ori = result.pop();
					String newStr = ori + ch;
					temp.add(newStr);
					result.add(ori);
				}
			}
			result.clear();
			result.addAll(temp);
		}
		return result;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<String> letterCombinations = solution.letterCombinations("23");
		System.out.println(letterCombinations);
	}

}
