package com.potato.study.leetcode.p0306;


/**
 * 
 * @author Administrator
 *
 *         306. Additive Number
 *         
 *          
 *         Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:

Input: "112358"
Output: true
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: The additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Follow up:
How would you handle overflow for very large input integers?
 *         
 *         
 *         
 *         题目含义：
 *          1、确定前两个数之后 如何判定一个数字序列是一个Additive Number 递归判定字符串是否由 前两个数组成前缀
 *          然后将第二个数和 和作为新的前缀进行判断
 *          2、如何取前两个数 字符串总长度n 第一个数length i 属于[1, (n -1 )/ 2]
 *          第二个数length 到j截止 长度 j - i 第三个数length n - j 满足条件 n - j >= i 且 n - j >= j - i
 *              判定j 的时候 从  n - j >= i 且 n - j >= j - i 做文章
 *
 *         思路：
 *         https://blog.csdn.net/x_i_y_u_e/article/details/50724390
 *
 *         
 *         
 *         
 *         
 *         
 */
public class Solution {

    public boolean isAdditiveNumber(String num) {
        if (null == num || "".equals(num)) {
            return true;
        }
        int length = num.length();
        for (int i = 1; i <= (length - 1) / 2; i++) {
            for (int j = i + 1; (length - j >= i) && (length - j >= j - i); j++) {
                long num1 = Long.parseLong(num.substring(0, i));
                long num2 = Long.parseLong(num.substring(i, j));
                if (isAdditiveNumberString(num1, num2, num)) {
                    return true;
                }
            }
        }
        return false;
    }



    private boolean isAdditiveNumberString (long num1, long num2, String numStr) {
        long sum = num1 + num2;
        String prefixKey = "" + num1 + num2 + sum;
        if (!numStr.startsWith(prefixKey)) {
            return false;
        }
        // 根据长度判断是否已经比较结束
        if (numStr.length() == prefixKey.length()) {
            return true;
        }
        String num1Str = "" + num1;
        return isAdditiveNumberString(num2, sum, numStr.substring(num1Str.length()));
    }


	public static void main(String[] args) {
		Solution solution = new Solution();
		String num = "221474836472147483649";
//		String num = "123";
        boolean additiveNumber = solution.isAdditiveNumber(num);
        System.out.println(additiveNumber);
    }
}
