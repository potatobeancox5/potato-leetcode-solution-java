package com.potato.study.leetcode.p0013;

import java.util.HashMap;
import java.util.Map;

import javax.swing.UIManager;

/**
 * 
 * @author liuzhao11
 * 
 * 		13. Roman to Integer
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *         思路：
 *         先科普一下罗马数字使用规则
 *         罗马数字采用七个罗马字母作数字、即Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）。
 *         记数的方法：
 *         相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；(连写不能超过3个)
 *		   小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
 *		   小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9；
 *		   1-3 10-30 100-300 这类的数采用连写原则
 *		   4，9   40，90   400，900 这类的数采用减法原则
 *		   5 50 500 这类的数直接有规定
 *		   6，7，8 采用加法原则和连写原则
 *
 *			左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
 * 			但是，左减时不可跨越一个位数。比如，99不可以用IC（100 - 1）表示，而是用XCIX（[100 - 10] + [10 - 1]）表示。（等同于阿拉伯数字每位数字分别表示。）
 * 			左减数字必须为一位，比如8写成VIII，而非IIX。
 *		
 *		从后往前依次读入字母 并翻译成阿拉伯数字， 
 *		 若当前数字 》= 之前数字的时候 与之前的数字相加
 *				否则 使用之前的数字与减去当前的数字，
 *		 
 */
public class Solution {

	/**
	 * 前提是出入字符一定是合法的罗马数字串
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
    
		if(null == s || s.length() == 0) {
			return 0;
		}
		//建立转换map
		Map<Character, Integer> romanBitToIntMap = new HashMap<>();
		romanBitToIntMap.put('I', 1);
		romanBitToIntMap.put('V', 5);
		romanBitToIntMap.put('X', 10);
		romanBitToIntMap.put('L', 50);
		romanBitToIntMap.put('C', 100);
		romanBitToIntMap.put('D', 500);
		romanBitToIntMap.put('M', 1000);
		int totalResult = romanBitToIntMap.get(s.charAt(s.length() - 1));//获取第一个数
		int afterCurrentNum = totalResult;
		if(s.length() == 1) {
			return totalResult;
		}
		for(int i = s.length() - 2 ; i >= 0 ; i--) {
			int currentNum = romanBitToIntMap.get(s.charAt(i));
			if(currentNum < afterCurrentNum) {
				totalResult -= currentNum;
			} else {
				totalResult += currentNum;
			}
			//修改beforeNum
			afterCurrentNum = currentNum;
		}
		return totalResult;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int num = solution.romanToInt("XXIII");
		int num = solution.romanToInt("XIX");
		System.out.println(num);
		
	}

}
