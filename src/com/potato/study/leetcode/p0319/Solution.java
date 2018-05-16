package com.potato.study.leetcode.p0319;


/**
 * 
 * @author Administrator
 *
 *         319. Bulb Switcher
 *         
 *          
 *         There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.
 *         
 *         
 *         
 *         思路： 
 *         n = a * b 除非 ab 相等  否则就有会有两个轮次点击开关1 这样开关最后的状态就是闭合的
 *         因此 题目转换成求 小于n 的平方数
 *         https://blog.csdn.net/zhangxiao93/article/details/50370170
 *         
 *         
 *         
 *         
 *         
 */
public class Solution {
	
	
	public int bulbSwitch(int n) {
		if(n == 0) {
			return 0;
		}
        int param = 1;
        while(param * param <= n) {
        	param++;
        }
        return param - 1;
    }
	
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 15;
		int result = solution.bulbSwitch(n);
		System.out.println(result);
	}
}
