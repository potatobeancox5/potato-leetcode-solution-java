package com.potato.study.leetcode.p0504;

/**
 * 
 * @author liuzhao11
 * 
 *        504. Base 7
 * 
 *         Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].

 * 
 *         题目含义：
 *          转换成7进制
 *         思路：
 *          https://blog.csdn.net/spring_translate/article/details/81024184
 *          记录每次的余数
 *
 *          
 */
public class Solution {


    public String convertToBase7(int num) {
        boolean isNegtive = false;
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        // 处理负数
        if (num < 0) {
            isNegtive = true;
            num = (-1 * num);
        }
        while (num > 0){
            sb.append(num % 7);
            num /= 7;
        }
        if (isNegtive) {
            return "-" + sb.reverse().toString();
        }
        return sb.reverse().toString();
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        int num = -7;
        String s = solution.convertToBase7(num);
        System.out.println(s);

    }
}
