package com.potato.study.leetcode.p0201;

/**
 * 
 * @author liuzhao11
 * 
 *         201. Bitwise AND of Numbers Range
 * 
 *         Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
 * 
 *         思路：找到mn 的共有前缀 p  p就是 [m,n]之间的数相互与得到的值
 *         移位
 * 
 */
public class Solution {

    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0) {
            return 0;
        }
        if(m == n) {
            return n;
        }
        int k = (1 << 31);
        while((k & m) == (k & n)) {
            k = k >> 1;
        }
        k = k << 1;
        return  k & m;
    }
	

    
    public static void main(String[] args) {
        Solution solution = new Solution();
		int m = 0;
		int n = 1;
        int result = solution.rangeBitwiseAnd(m, n);
        System.out.println(result);
    }
}
