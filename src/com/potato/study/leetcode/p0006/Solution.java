package com.potato.study.leetcode.p0006;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.potato.study.leetcode.domain.ListNode;
import com.potato.study.leetcode.util.ArrayUtil;
import com.potato.study.leetcode.util.ListNodeUtil;

/**
 * 
 * @author liuzhao11
 * 
 * 
 * 
 *         6. ZigZag Conversion
 * 
 *         The string "PAYPALISHIRING" is written in a zigzag pattern on a given
 *         number of rows like this: (you may want to display this pattern in a
 *         fixed font for better legibility)
 * 
 *         P A H N A P L S I I G Y I R And then read line by line:
 *         "PAHNAPLSIIGYIR" Write the code that will take a string and make this
 *         conversion given a number of rows:
 * 
 *         string convert(string text, int nRows); convert("PAYPALISHIRING", 3)
 *         should return "PAHNAPLSIIGYIR" 
 *         
 *         思路：算数题，行数为n
 *         首行： （index）0 ， 2（n - 1） ， 4（n - 1）， 6（n - 1） ， 8（n - 1）。。。
 *         中间行：i
 *         	i ， 2（n-1）-i , 2(n-1) + i,4（n-1）-i , 4(n-1) + i
 *         尾行：（index）(n - 1) ， 3（n - 1） ， 5（n - 1）， 7（n - 1） ， 9（n - 1）。。。
 * 
 */
public class Solution {

	public String convert(String s, int numRows) {
		if(numRows == 1 || null == s || s.length() <=1) {
			return s;
		}
		StringBuilder result = new StringBuilder();
		int magicNum = 2 * (numRows - 1);
		for(int i = 0 ; i < numRows ; i++) {
			if(i == 0) {//首行
				int index = 0;
				while(index < s.length()) {
					result.append(s.charAt(index));
					index += magicNum;
				}
			} else if( i == numRows - 1) {//尾行
				int index = numRows - 1;
				while(index < s.length()) {
					result.append(s.charAt(index));
					index += magicNum;
				}
			} else {//中间行
				int index = i;
				while(index < s.length()) {
					result.append(s.charAt(index));
					index = index + magicNum - 2 * i;
					if(index >= s.length()) {
						break;
					}
					result.append(s.charAt(index));
					index += (2 * i);
				}
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "A";
		int numRows = 1;
		String result = solution.convert(s, numRows);
		System.out.println(result);

	}

}
