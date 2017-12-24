package com.potato.study.leetcode.p0012;

import javax.swing.UIManager;

/**
 * 
 * @author liuzhao11
 * 
 *         12. Given an integer, convert it to a roman numeral.
 * 
 *         Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 
 * 
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
 */
public class Solution {

	/**
	 * 本题只限制0 - 3999 所以简化操作
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		String[] bit = {"","I","II","III","IV","V","VI","VII","VIII","IX"};//个位数字与其代表字符
		String[] tenBit = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};//十位数字与其代表字符
		String[] hundredBit = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};//百位数字代表字符
		String[] thousandBit = {"","M","MM","MMM"};//千位数字代表字符
		
		StringBuilder result = new StringBuilder();
		result.append(thousandBit[num / 1000]);//计算千位
		num %= 1000;
		result.append(hundredBit[num / 100]);//计算百位
		num %= 100;
		result.append(tenBit[num / 10]);//计算十位
		num %= 10;
		result.append(bit[num]);//计算个位
		return result.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int num = 101;
		String result = solution.intToRoman(num);
		System.out.println(result);
	}

}
