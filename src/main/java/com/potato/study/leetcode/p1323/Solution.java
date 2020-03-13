package com.potato.study.leetcode.p1323;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1323. Maximum 69 Number
 *  
 *
Given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).



Example 1:

Input: num = 9669
Output: 9969
Explanation:
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.
Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.
Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.


Constraints:

1 <= num <= 10^4
num's digits are 6 or 9.
 *         
 *         思路：
 *          第一个6 换成9
 *
 *
 *
 *

 *
 */
public class Solution {

    public int maximum69Number (int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int left = 0;

        while (left < nums.length && nums[left] == '9') {
            left++;
        }

        if (left < nums.length) {
            nums[left] = '9';
        }

        int res = Integer.parseInt(new String(nums));
        return res;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 9669;
        int number = solution.maximum69Number(num);
        System.out.println(number);
        Assert.assertEquals(9969, number);

        num = 9996;
        number = solution.maximum69Number(num);
        System.out.println(number);
        Assert.assertEquals(9999, number);

        num = 9999;
        number = solution.maximum69Number(num);
        System.out.println(number);
        Assert.assertEquals(9999, number);
    }
}
