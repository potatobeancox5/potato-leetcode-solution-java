package com.potato.study.leetcode.p0372;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *       372. Super Pow
 * 
 *      Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example 1:

Input: a = 2, b = [3]
Output: 8
Example 2:

Input: a = 2, b = [1,0]
Output: 1024
 *         
 *         思路：
 *         https://www.cnblogs.com/grandyang/p/5651982.html
 *
 *          公式
 *         ab % k = (a%k)(b%k)%k
 */
public class Solution {

    public int superPow(int a, int[] b) {

        long res = 1;
        for (int i = 0; i < b.length; i++) {
            res = pow(res, 10) * pow(a, b[i]) % 1337;
        }
        return (int)res;
    }

    /**
     *
     * @param a 底数
     * @param b 指数
     * @return
     */
    private long pow (long a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a % 1337;
        }
        return pow(a, b /2) * pow(a, b - b /2) % 1337;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int a = 2;
		int[] b = {3};
		int num = solution.superPow(a, b);
		System.out.println(num);
        Assert.assertEquals(8, num);

        a = 2;
        int[] b1 = {1,0};
        num = solution.superPow(a, b1);
        System.out.println(num);
        Assert.assertEquals(1024, num);
	}
}
