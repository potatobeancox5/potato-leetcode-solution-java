package com.potato.study.leetcode.p0263;

/**
 * 
 * @author liuzhao11
 * 
 * 263. Ugly Number
 Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example 1:

Input: 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2
Example 3:

Input: 14
Output: false 
Explanation: 14 is not ugly since it includes another prime factor 7.
Note:

1 is typically treated as an ugly number.
Input is within the 32-bit signed integer range: [−231,  231 − 1].

* 		思路： 判断一个数是否是 因数只有2 3 5  
* 			递归做吧
* 
 */
public class Solution {
	
	public boolean isUgly(int num) {
		if(num == 1) {
			return true;
		}
		if(num == 0) {
			return false;
		}
        if(num / 2 * 2 != num && num / 3 * 3 != num 
        		&& num / 5 * 5 != num) { // 不能被2 3 5 整除
        	return false;
        } else if(num / 2 * 2 == num) {
        	return isUgly(num / 2);
        } else if(num / 3 * 3 == num) {
        	return isUgly(num / 3);
        } else { // num / 5 * 5 == num
        	return isUgly(num / 5);
        }
    }
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int num = 0;
    	boolean result = solution.isUgly(num);
    	System.out.println(result);
	}
}
