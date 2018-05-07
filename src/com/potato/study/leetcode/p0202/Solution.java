package com.potato.study.leetcode.p0202;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *         202. Happy Number
 * 
 *         Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 * 
 *         思路：  
 *         按照公式一致算 如果 出现了环形 那么结束战斗 每次计算的过程中使用map 
 *         记录已经出现的值  若该值已经出现过 那么 存在环 返回false
 * 
 */
public class Solution {
	
    public boolean isHappy(int n) {
    	Set<Long> set = new HashSet<>();
        long result = 0;
        while(true) {        	
        	while(n > 0) {
        		int remainder = n % 10;
        		result += (remainder * remainder);
        		n = n / 10;
        	}
        	if(set.contains(result)) {
        		return false;
        	}
        	if(result == 1) {
        		return true;
        	}
        	set.add(result);
        	n = (int) result;
        	result = 0;
        }
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 19;
		boolean result = solution.isHappy(n);
		System.out.println(result);
	}
}
