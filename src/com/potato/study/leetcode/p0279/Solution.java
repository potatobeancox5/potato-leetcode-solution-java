package com.potato.study.leetcode.p0279;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *
279. Perfect Squares
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

        题目含义：输入一个数字 返回最少是几个平方的和组成

* 		思路：
 * 	        dp问题
 * 	        dp[n] 储存 dp[n] 最少由几个平方和组成 n 从1 开始计算 为了防止出现问题
 * 	        dp[i] = min {dp[i - 1* 1] + 1, dp[i - 2 * 2] + 1....dp[i - k* k] + 1} (k * k < i)
 *
 * 	        https://blog.csdn.net/mupengfei6688/article/details/78903254
 *
* 
 */
public class Solution {




        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                List<Integer> dpList = new ArrayList<>();
                for (int k = 1 ; k * k <= i ; k++) {
                    dpList.add(dp[i - k * k]);
                }
                dp[i] = min(dpList) + 1;
            }
            return dp[n];
        }

        /**
         * 输入一组数字，返回最小值
         * @param list
         * @return
         */
        private int min (List<Integer> list) {
            if (null == list || list.size() == 0) {
                // 处理异常
            }
            int min = list.get(0);
            for (int num: list) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        }
	
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int n = 12;
        int result1 = solution.numSquares(n);
        System.out.println("result1:" + result1);
        n = 13;
        int result2 = solution.numSquares(n);
        System.out.println("result1:" + result2);
    }
}
