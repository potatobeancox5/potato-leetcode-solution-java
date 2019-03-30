package com.potato.study.leetcode.p0300;


/**
 * 
 * @author Administrator
 *
 *         300. Longest Increasing Subsequence
 *         
 *          
 *         Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 *         
 *         
 *         
 *         题目含义：
 *          最长的子序列 子序列是原来传的一些片段的组合
 *          动态规划
 *          dp[i] 代表 包含i的 递增子序列的长度
 *          dp[i] = max (dp[j 从 0-j] + 1) 且 ch i > ch j
 *          dp[0] = 1
 *
 *         思路：
 *          https://www.cnblogs.com/yrbbest/p/5047816.html
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
