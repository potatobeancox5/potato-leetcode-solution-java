package com.potato.study.leetcode.p0166;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *      166. Fraction to Recurring Decimal
 *         
 *          
 *   Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"

 *
 *      题目需求:
 *			打印小数 遇到 循环小数 用括号将循环小数的数字括起来
 *		   使用map 记录循环小数数字重复
 *
 * 		解题思路：
 * 	        https://blog.csdn.net/zdavb/article/details/47836081
            1.使用被除数%除数 记录结果到map （模拟除法演算形式）
            2.mapkey 记录每次计算的余数*10  value 记录出现的位置
            3.一旦出现每次计算的被除数为0 或者map key 出现了重复 那么停止循环
            找到开始重复的数字跟最后一个出现的数字，他们用括号扩起来
            4.整数部分 分开 一次除法计算ok
 *
 *
 */
public class Solution {

	public String fractionToDecimal(int numerator, int denominator) {
	    StringBuilder sb = new StringBuilder();
        Map<Long, Long> remindLocationMap = new HashMap(); // 余数 ， 位置

        // 判断符号位置并归正数
        if (numerator > 0 && denominator < 0) {
            sb.append("-");
        } else if (numerator < 0 && denominator > 0) {
            sb.append("-");
        }

        long pre = numerator; // pre / after
        long after = denominator;
        // 全部归正
        if (numerator < 0) {
            pre *= -1;
        }
        if (denominator < 0) {
            after *= -1;
        }


        // 计算整数值
        String integerPart = Long.toString(pre / after); // 去整了
        sb.append(integerPart);

        // 循环小数标志位 -1 代表map中的小数没有循环小数
        long cycleStartIndex = -1;
        do {
            long remind = pre % after;
            if (remind == 0) {
                break;
            }
            // map中不存在的时候可以继续
            if (remindLocationMap.containsKey(remind)) {
                cycleStartIndex = remindLocationMap.get(remind);
                break;
            } else {
                remindLocationMap.put(remind, (long)remindLocationMap.size());
            }
            remind *= 10;
            pre = remind;
        } while (true);
        // 判断是否有小数 判断是否有循环小数
        if (numerator % denominator == 0) {
            return sb.toString();
        }
        sb.append(".");
        long[] numBit;
        if (cycleStartIndex == -1) {
            numBit = new long[remindLocationMap.size()];
            for (Map.Entry<Long, Long> entry : remindLocationMap.entrySet()) {
                numBit[entry.getValue().intValue()] = entry.getKey() * 10 / after;
            }

        } else { // 有重复的 找到重复的
            numBit = new long[(int) (remindLocationMap.size() - cycleStartIndex)];
            long[] numBitBefore = new long[(int) cycleStartIndex];
            for (Map.Entry<Long, Long> entry : remindLocationMap.entrySet()) {
                if (entry.getValue() >= cycleStartIndex && entry.getValue() < remindLocationMap.size()) {
                    numBit[(int) (entry.getValue() - cycleStartIndex)] = entry.getKey() * 10 / after;
                } else {
                    numBitBefore[entry.getValue().intValue()] = entry.getKey() * 10 / after;
                }
            }
            // 拼装不重复串
            for (int i = 0; i < numBitBefore.length; i++) {
                sb.append(numBitBefore[i]);
            }
            sb.append("(");

        }
        for (int i = 0; i < numBit.length; i++) {
            sb.append(numBit[i]);
        }
        if (cycleStartIndex != -1) {
            sb.append(")");
        }
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int a = 1;
//		int b = 2;

//        int a = 2;
//        int b = 1;

//        int a = 2;
//        int b = 3;

//        int a = 1;
//        int b = 6;

//        int a = -50;
//        int b = 8;

//        int a = -1;
//        int b = -2147483648;

        int a = -2147483648;
        int b = 1;

        String s = solution.fractionToDecimal(a, b);
        System.out.println(s);
    }

}
