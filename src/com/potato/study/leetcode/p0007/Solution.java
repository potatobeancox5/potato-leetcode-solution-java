package com.potato.study.leetcode.p0007;

/**
 * 
 * @author liuzhao11
 * 
 *         7. Reverse Integer
 * 
 *         Given a 32-bit signed integer, reverse digits of an integer.
 * 
 *         Example 1:
 * 
 *         Input: 123 Output: 321 Example 2:
 * 
 *         Input: -123 Output: -321 Example 3:
 * 
 *         Input: 120 Output: 21 Note: Assume we are dealing with an environment
 *         which could only hold integers within the 32-bit signed integer
 *         range. For the purpose of this problem, assume that your function
 *         returns 0 when the reversed integer overflows.
 * 
 * 
 * 
 *         思路：逆转数字 只能用int
 *         	当前数位计数器bitNum = 0;当前数字current = 0； boolean isNegative = false(整数) true(负数)
 *         依次将给定数 % 10 并 / 10  (temp == 0 时跳出循环)
 *         		若 bitNum< 9 current = current * 10 + 余数      bitNum++
 *         		若bitNum== 9 判断最高位>2 
 *         				>2 溢出
 *         				<2 current = current * 10 + 余数      bitNum++
 *         				== 2
 *         				result = int 最大 减去 2 * 10e9 再减去    current % 1 * 10e8 * 10 + 余数
 *         				若!isNegative result < 0 溢出
 *         				若isNegative   result < -1 溢出
 *         		若bitNum > 9  temp > 0 溢出
 */
public class Solution {
	
	private static final int TEN_MILLION = 100000000;
	private static final int HUNDRED_MILLION = 1000000000;
	
	public int reverse(int x) {
		int bitNum = 0;
		int current = 0;
		int temp = x;
		boolean isNegative = temp < 0;
		if(isNegative) {
			temp *= -1;
		}
		
		while(temp > 0) {
			int remind = temp % 10;
			temp /= 10;
			if(bitNum < 9) {
				current = current * 10 + remind;
				bitNum++;
			} else if (bitNum > 9) {
				if(temp > 0) {
					return 0;
				}
			} else {//处理第九位
				int highBit = (int) (current / TEN_MILLION);
				if(highBit > 2) {
					return 0;
				} else if (highBit < 2) {
					current = current * 10 + remind;
					bitNum++;
				} else {//highBit == 2
//					result = int 最大 减去 2 * 10e9 再减去 (current % 1 * 10e8) * 10 + 余数
					int judge = Integer.MAX_VALUE - 2 * HUNDRED_MILLION;
					judge = judge - current % TEN_MILLION * 10 - remind;
//					若!isNegative result < 0 溢出
					if(!isNegative && judge < 0) {
						return 0;
					}
//					若isNegative   result < -1 溢出
					if (isNegative && judge < -1) {
						return 0;
					}
					//确定不溢出
					current = current * 10 + remind;
					bitNum++;
				}
			}
		}
		return isNegative? current * -1 : current;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int x = 2147483647;
		int x = -2147483611;
		int reverse = solution.reverse(x);
		System.out.println(reverse);

	}

}
