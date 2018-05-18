package com.potato.study.leetcode.p0400;

/**
 * 
 * @author liuzhao11
 * 
 *        400. Nth Digit
 * 
 *       Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 *         思路： 
			没啥好办法 
			1 - 9 一位数 9 个
			10 - 99 90 个两位数
			100 - 999 900 个三位数
			1000 - 9999 9000 个四位数
			
			首先判断这个数字在几位数中 
				
			然后确定这个数具体落在几个数里边
 * 
 */
public class Solution {
	
	public int findNthDigit(int n) {
        // 判断n 属于几位数中
		long thisBitCount = 9;// 标记 目前最大数位 当前n位数 一共有多少个数字
		long bitCount = 1;//当前几位数
		long k = n;
		while(k > thisBitCount * bitCount) {
			k = k - thisBitCount * bitCount;
			thisBitCount *= 10;
			bitCount += 1;
		}
		// 当前数字是第几个
		long no = k / bitCount;
		long current = no + thisBitCount / 9;
		// 当前位置是current的第几个数字
		long pos = k % bitCount;
		if(pos == 0) {
			String str = Long.toString(current - 1);
			return str.charAt(str.length() - 1) - '0';
		} else {
			return Long.toString(current).charAt((int) (pos - 1)) - '0';
		}
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int n = 3;
//		int n = 1000;
		int n = 11;
//		int n = 2147483647;
		int num = solution.findNthDigit(n);
		System.out.println(num);
	}
}
