package com.potato.study.leetcode.p0070;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         70. Climbing Stairs
 * 
 *         You are climbing a stair case. It takes n steps to reach to the top.
 * 
 *         Each time you can either climb 1 or 2 steps. In how many distinct
 *         ways can you climb to the top?
 * 
 *         Note: Given n will be a positive integer.
 * 
 * 
 *         Example 1:
 * 
 *         Input: 2 Output: 2 Explanation: There are two ways to climb to the
 *         top.
 * 
 *         1. 1 step + 1 step 2. 2 steps Example 2:
 * 
 *         Input: 3 Output: 3 Explanation: There are three ways to climb to the
 *         top.
 * 
 *         1. 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 * 
 *         思路：
 * 			使用动态规划 并压缩状态量
 * 			fn[i] 表示 i个台阶有多少种爬楼梯的方法 
 * 			fn[i] = fn[i-1] + fn[i-2] i节楼梯方法数等于 i-1方法数（最后一次爬一节） +  i-2方法数（最后一次爬二节）
 * 
 * 			fn[0] = 1
 * 			fn[1] = 1
 * 			fn[2] = 2
 * 
 * 
 */
public class Solution {

	public int climbStairs(int n) {
		int first = 1;
		int second = 1;
        for(int i = 2 ; i <= n ; i++) {
        	int current = first + second;
        	first = second;
        	second = current;
        }
        return second;
    }
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int kinds = solution.climbStairs(3);
		System.out.println(kinds);
		
	}
}
