package com.potato.study.leetcode.p0343;

/**
 * 
 * @author liuzhao11
 * 
 *         343. Integer Break
 * 
 *         Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * 
 *         思路：
 *        分析一下 
 *        1 - 1
 *        2 - 1 * 1 = 1
 *        3 - 1 * 2 = 2
 *        4 - 2 * 2 = 4
 *        5 - 2 * 3 = 6
 *        6 - 2 * 2 * 2  3 * 3 = 9
 *        7 - 2 * 2 * 3 = 12
 *        8 - 2 + 6  3 + 5 4 + 4 = 18
 *        9 - 3 * 3 * 3 = 27 
 *        10 - 3 * 3 * 2 * 2 
 *        11 - 3 * 3 * 3 * 2 = 54
 *        
 *        不能一概而论
 *        结论 分成最多的2 剩下的一个变成3
 *        尽量多的6  剩下的尽量多的2 大于7（不包括）的时候       
 * 			https://www.cnblogs.com/zywscq/p/5415303.html
 * 
 * 			三的倍数 都变成3
 * 			% 3 余 1 取一个4 然后都是三
 * 			% 3 余 2   尽量取3
 * 			特例 2 = 1 
 */
public class Solution {
	
	public int integerBreak(int n) {
		if(n < 2) {
			return 0;
		} else if(n == 2) {
        	return 1;
        } else if(n ==3 ){
        	return 2;
        } else if(n / 3 * 3 == n) { //整除
        	return (int) Math.pow(3, n/3);
        } else if (n % 3 == 1) { // 余数1
        	return (int) Math.pow(3, n/3 - 1) * 4;
        } else { // 余数2
        	return (int) Math.pow(3, n/3) * 2;
        }
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 11;
		int num = solution.integerBreak(n);
		System.out.println(num);
	}
}
