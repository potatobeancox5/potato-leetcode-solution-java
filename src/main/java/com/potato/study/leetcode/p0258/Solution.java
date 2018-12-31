package com.potato.study.leetcode.p0258;

/**
 * 
 * @author liuzhao11
 * 
 *      258. Add Digits
 * 
 *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?

* 
* 
* 思路：https://blog.csdn.net/jmspan/article/details/51103086
* 1 - 1
* 2 - 2
* ...
* 9 - 9
* 10 - 1
* ...
* 19 - 10 - 1
* 找到规律 n % 9 为 0 时 返回9
* 
 */
public class Solution {
	
	public int addDigits(int num) {
		if(num == 0) {
			return 0;
		}
        int tmp = num % 9;
        return tmp == 0 ? 9 : tmp;
    }
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int num = 38;
    	int digit = solution.addDigits(num);
    	System.out.println(digit);
	}
}
