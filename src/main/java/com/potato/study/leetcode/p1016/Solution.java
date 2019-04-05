package com.potato.study.leetcode.p1016;


/**
 * 
 * @author liuzhao11
 * 
 * 	1016. Binary String With Substrings Representing 1 To N
 *  
 *         Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N, return true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.



Example 1:

Input: S = "0110", N = 3
Output: true
Example 2:

Input: S = "0110", N = 4
Output: false


Note:

1 <= S.length <= 1000
1 <= N <= 10^9
 *         
 *         思路：
 *
 *

 *
 */
public class Solution {

    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n ; i++) {
            int tmp = i;
            StringBuilder sb = new StringBuilder();
            while (tmp > 0) {
                sb.append(tmp & 1);
                tmp = (tmp >>> 1);
            }
            if (!s.contains(sb.reverse().toString())) {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String s = "0110";
        int n = 4;
        boolean b = solution.queryString(s, n);
        System.out.println(b);
    }
}
