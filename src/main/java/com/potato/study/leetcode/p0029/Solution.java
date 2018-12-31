package com.potato.study.leetcode.p0029;


/**
 * 
 * @author liuzhao11
 * 
 * 		29. Divide Two Integers
 * 
 *         Divide two integers without using multiplication, division and mod
 *         operator.
 * 
 *         If it is overflow, return MAX_INT.
 * 
 *         思路：
 *         除法原理 商等于除数的倍数 余数等于 被除数减去除数倍数的差
 *         因此 采用将除数移位的操作 知道 余数小于除数为止
 * 
 * 			边界条件太多
 * 
 */
public class Solution {
	
	/**
	 * 
	 * @param dividend	被除数
	 * @param divisor	除数
	 * @return
	 */
	public int divide(int dividend, int divisor) {
		// 判断是否超过最大值 或者除数==0
		if((dividend == Integer.MIN_VALUE && divisor == -1 ) || divisor == 0) {
			return Integer.MAX_VALUE;
		}
		int symbol = 1;// 符号位
		if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			symbol = -1;
		}
		if(divisor == 1) {
			return dividend;
		}
		if(divisor == -1) {
			return -1 * dividend;
		}
		//去除符号位
		//dividend = dividend > 0 ? dividend : dividend * -1;
		long divisorLong = divisor > 0 ? divisor : divisor * -1L;
		long temp = divisorLong;
		int totalTimes = 0;// 商
		long remainder = dividend > 0 ? dividend : dividend * -1L; // 余数 剩下的数
		
		while(remainder >= divisorLong) { // 只要剩下的数大于除数 就可以继续
			int times = 1;
			while(remainder >=  temp << 1) { // 寻找第一个减去的数
				temp = temp << 1;
				times = times << 1;
			}
			totalTimes += times;
			remainder -= temp;	
			temp = divisorLong;
		}
		return totalTimes * symbol;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int dividend = -1010369383;
		int divisor = -2147483648;
		int result = solution.divide(dividend, divisor);
		System.out.println(result);
	}

	
	
}
