package com.potato.study.leetcode.p1017;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1017. Convert to Base -2
 *  
 *         Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).

The returned string must have no leading zeroes, unless the string is "0".



Example 1:

Input: 2
Output: "110"
Explantion: (-2) ^ 2 + (-2) ^ 1 = 2
Example 2:

Input: 3
Output: "111"
Explantion: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
Example 3:

Input: 4
Output: "100"
Explantion: (-2) ^ 2 = 4


Note:

0 <= N <= 10^9
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/convert-to-base-2/solution/gen-ju-qi-ou-xing-pan-duan-by-samll_hanhan/
 *
 *
 *
 */
public class Solution {

    public String baseNeg2(int n) {
        if (0 == n) {
            return "0";
        }
        String result = "";
        while (n != 0) {
            if (n % 2 == 0) {
                result = "0" + result;
                n = n / (-2);
            } else {
                result = "1" + result;
                n = (n - 1) / (-2);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 2;
        String b = solution.baseNeg2(n);
        System.out.println(b);
        Assert.assertEquals("110", b);

        n = 3;
        b = solution.baseNeg2(n);
        System.out.println(b);
        Assert.assertEquals("111", b);

        n = 4;
        b = solution.baseNeg2(n);
        System.out.println(b);
        Assert.assertEquals("100", b);
    }
}
