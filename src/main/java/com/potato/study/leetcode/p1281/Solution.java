package com.potato.study.leetcode.p1281;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1281. Subtract the Product and Sum of Digits of an Integer
 *  
 *
Given an integer number n, return the difference between the product of its digits and the sum of its digits.


Example 1:

Input: n = 234
Output: 15
Explanation:
Product of digits = 2 * 3 * 4 = 24
Sum of digits = 2 + 3 + 4 = 9
Result = 24 - 9 = 15
Example 2:

Input: n = 4421
Output: 21
Explanation:
Product of digits = 4 * 4 * 2 * 1 = 32
Sum of digits = 4 + 4 + 2 + 1 = 11
Result = 32 - 11 = 21


Constraints:

1 <= n <= 10^5
 *         
 *         思路：
 *          计算差值 product - sum
 *
 *

 *
 */
public class Solution {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int i = n % 10;
            sum += i;
            product *= i;
            n /= 10;
        }
        return product - sum;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 234;
        int res = solution.subtractProductAndSum(n);
        System.out.println(res);
        Assert.assertEquals(15, res);

        n = 4421;
        res = solution.subtractProductAndSum(n);
        System.out.println(res);
        Assert.assertEquals(21, res);
    }
}
