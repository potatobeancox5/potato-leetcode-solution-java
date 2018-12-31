package com.potato.study.leetcode.p0069;


/**
 * 
 * @author liuzhao11
 * 
 * 69. Sqrt(x)
 *        Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.


Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.

 * 
 *         思路：求根式
 *         int tmp = 0;
 *         for i = 0 ； ； i++
 *         		int nextTmp = (i + 1) * (i + 1);
	 *         if(tmp <= x && x < next) {
	 *         		return i;
	 *         } else {
	 *         	tmp = nexttmp;
	 *         }
 *         
 *        
 * 
 * 
 * 
 */
public class Solution {

	public int mySqrt(int x) {
        if(x < 0) {
        	return 0;
        }
        long tmp = 0;
        for(int i = 0 ;; i++) {
        	long nextTmp = (i + 1L)*(i + 1);
        	if(tmp <= x && x < nextTmp) {
        		return i;
        	} else {
        		nextTmp = tmp;
        	}
        }
    }

	

	public static void main(String[] args) {
		Solution solution = new Solution();
		int result = solution.mySqrt(99);
		System.out.println(result);
		
	}
}
