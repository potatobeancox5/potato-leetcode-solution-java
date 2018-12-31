package com.potato.study.leetcode.p0402;

import java.util.Stack;

/**
 * 
 * @author liuzhao11
 * 
 *   402. Remove K Digits
 * 
 *      Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.


 *   题目含义：
 *   给定一个数字字符串 numStr 和k 要求 去掉k个数字之后 这个数最小
 *   思路：
 *   https://www.cnblogs.com/reboot329/p/5883739.html
 *   1.什么时候去掉数字能保证去掉后的数字最小
 *   去掉从前往后数递增的最后一个数字
 *   使用栈，如果当前数字比之前peek小的话，删除之前的数，知道数列变成递增的，
 *   如果所有数字都进栈，然后发现k > 0 继续pop 知道k == 0
 *
 *
 */
public class Solution {


    public String removeKdigits(String num, int k) {
        if (null == num || "".equals(num)) {
            return num;
        }
        if (num.length() <= k) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length() ; i++) {
            if (i == 0) {
                stack.push(num.charAt(i));
                continue;
            }
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                k--;
                stack.pop();
            }
            stack.push(num.charAt(i));
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        // 去掉前导0
        while (sb.length() > 0 && sb.charAt(sb.length() -1) == '0') {
            sb.deleteCharAt(sb.length() -1);
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		String num = "1432219";
		int k = 3;
//        String num = "10200";
//		int k = 1;
        String result = solution.removeKdigits(num, k);
        System.out.println(result);
    }
}
