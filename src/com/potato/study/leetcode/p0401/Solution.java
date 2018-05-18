package com.potato.study.leetcode.p0401;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *   401. Binary Watch
 * 
 *      A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".*  

       
       思路： 
			https://blog.csdn.net/styshoo/article/details/52908424
			最多有10盏灯可以亮
			动态规划解题
			dp[n][k] 表示 n 盏灯中 k 个亮的数字集合 那么
			dp[n][k] = dp[n-1][k] + dp[n-1][k-1](顺便把第k盏灯点亮加入其中)
			
			压缩状态量
			dp k = dp k + dp(k-1) (结果加上第k 代表的数) 其中每个dp是 一个list 里边放着代表灯量的数量
			
			https://blog.csdn.net/justdoit_potato/article/details/77262225
			数字格式化 输出
 * 
 */
public class Solution {
	
	
	/**
	 * 使用轮训吧
	 * @param num
	 * @return
	 */
	public List<String> readBinaryWatch(int num) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < 12 ; i++) {
			for(int j = 0 ; j < 60 ; j++) {
				int tmp = i * 64 + j;
				if(Integer.bitCount(tmp) == num) {
					list.add(tmp);
				}
			}
		}
		List<String> times = new ArrayList<>();
		for (Integer time : list) {
			int hour = time >>> 6; 
			int nimue = time & 0b111111;
			String h = "" + hour;
			String min = String.format("%02d", nimue);
			times.add(h + ":" + min);
		}
		return times;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int num = 2;
		List<String> list = solution.readBinaryWatch(num);
		System.out.println(list);
	}
}
