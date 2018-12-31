package com.potato.study.leetcode.p0009;

/**
 * 
 * @author liuzhao11
 * 
 *  	9. Palindrome Number
 * 
 *         Determine whether an integer is a palindrome. Do this without extra
 *         space. Could negative integers be palindromes? (ie, -1)
 * 
 *         If you are thinking of converting the integer to string, note the
 *         restriction of using extra space.
 * 
 *         You could also try reversing an integer. However, if you have solved
 *         the problem "Reverse Integer", you know that the reversed integer
 *         might overflow. How would you handle such case?
 * 
 *         There is a more generic way of solving this problem.
 * 
 * 
 *         思路：
 *         不可以使用额外空间
 *         考虑负数情况（负数都不是）
 *         最后一位为0的正数 不是对称数
 *         定义一个新数字 newNum = 0;，而num = x
 *         循环取出数字最后一位t，t = num % 10；(当新数字 >= 原数字为止)
 *         	t = num % 10
 *         	newNum = newNum * 10 + t;
 *         	num = num ／ 10;
 *		返回结果：
 *			return num == newNum || num == newNum / 10;
 *         	
 *      
 */
public class Solution {

	public boolean isPalindrome(int x) {
		//处理负数情况
		if(x < 0) {
			return false;
		}
		if (x == 0) { //  处理一位数情况
			return true;
		} 
		if( x % 10 == 0) {
			//最后一位为0的大于0的数一定不是对称数
			//因为下面判断无法判断200 这种情况
			return false;
		}
		int num = x;
		int newNum = 0;

		while(num > newNum) {
			int t = num % 10;
			newNum = newNum * 10 + t;
			num /= 10;
		}
        return num == newNum || num == newNum / 10;
    }
	
	public static void main(String[] args) {
//		int x = 1;
//		int x = -1;
//		int x = 1221;
//		int x = 121;
//		int x = 100;
//		int x = -121;
		int x = 121;
		Solution solution = new Solution();
		boolean result = solution.isPalindrome(x);
		System.out.println(result);
	}

}
