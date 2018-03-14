package com.potato.study.leetcode.p0050;

/**
 * 
 * @author liuzhao11
 * 
 * 50. Pow(x, n)
 * 
 * Implement pow(x, n).


Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
 *          
 *          思路：递归调用思路 遇到n为偶数时 调用  pow(x * x, n / 2)
 *           遇到奇数时调用x  * pow(x, n -1)
 *           
 * 
 * 
 * 
 */
public class Solution {
	
	public double myPow(double x, int n) {
		if(x == 1) {
			return 1.0;
		}
		if(x == -1) {
			if(n % 2 == 0) {
				return 1;
			} else {
				return -1;
			}
		}
		if(n <= Integer.MIN_VALUE) {
			return 0.0;
		}
		boolean reciprocal = false;
		if(n < 0) {
			reciprocal = true;
			n = -n;
		}
		if(n == 1) {
			return reciprocal?1.0 / x : x;
		} 
		if(Math.abs(x - 0) < 10e-12) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		if(n % 2 == 0) {
			return reciprocal? 1.0 / myPow(x * x, n / 2) : myPow(x * x, n / 2);
		} else {
			return reciprocal? 1.0 / (x  * myPow(x, n -1)) :x  * myPow(x, n -1);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		double x = -2;
		int n = 3;
		double result = solution.myPow(x, n);
		System.out.println(result);
	}
}
