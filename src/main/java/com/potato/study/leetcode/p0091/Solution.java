package com.potato.study.leetcode.p0091;

/**
 * 
 * @author liuzhao11
 * 
 *         91. Decode Ways
 *         
 *         
 *         A message containing letters from A-Z is being
 *         encoded to numbers using the following mapping:
 * 
 *         'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing
 *         digits, determine the total number of ways to decode it.
 * 
 *         For example, Given encoded message "12", it could be decoded as "AB"
 *         (1 2) or "L" (12).
 * 
 *         The number of ways decoding "12" is 2.
 * 
 *
 *         思路：(注意： 从后往前遍历 更简单)
 * 		
 * 			dp[i] (从0 到 i 可以解码的种类数)
 * 			如果 i-1 i 大于26
 * 			dp[i] = dp[i-1] + dp[i-2];(第i-1 , i 能组成一个字母)
 * 			after = current + before
 * 
 * 			before = current
 * 			current = after
 * 			如果  i-1 i 小于等于26
 * 			dp[i] = dp[i-1]
 * 			after = current
 * 			before = current
 * 			current = after
 */
public class Solution {

	public int numDecodings(String s) {
		if(null == s || s.length() == 0) {
			return 0;
		}
		int current = 0;
		int before = 1;
		if(s.charAt(0) == '0') {
			return 0;
		}
        for (int i = 0 ; i < s.length() ; i++) {
        	if(i == 0) {
        		current = 1;
        	} else {
				String num = s.substring(i-1, i+1);
        		int numInt = Integer.parseInt(num);
        		if(numInt == 0) { //两位数为0
        			return 0;
        		} else if(numInt > 0 && numInt <= 9) {
        			before = current;
        		} else if (numInt == 10) {
        			int after = before;
        			before = current;
        			current = after;
        		} else if(numInt > 10 && numInt <= 26 && numInt != 20) {
        			// 0 ， 1 能否组成 11 - 26 以的值 有两种选择
        			int after = current + before;
        			before = current;
        			current = after;
        		} else if (numInt == 20) {
        			int after = before;
        			before = current;
        			current = after;
				} else {// 能组成26以上的值
        			if(numInt % 10 == 0) { //30 40 50 
        				return 0;
        			}
        			before = current;
        		}
        	}
        }
        return current;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
//		String s = "123"; 
//		String s = "1224"; 
//		String s = "10"; 
//		String s = "100"; 
//		String s = "110"; 
//		String s = "310"; 
		String s = "12120"; 
		int kindsNum = solution.numDecodings(s);
		System.out.println(kindsNum);
	}
}
