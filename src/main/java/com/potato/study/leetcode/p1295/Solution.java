package com.potato.study.leetcode.p1295;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1295. Find Numbers with Even Number of Digits
 *  
 *
Given an array nums of integers, return how many of them contain an even number of digits.


Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of digits.
Example 2:

Input: nums = [555,901,482,1771]
Output: 1
Explanation:
Only 1771 contains an even number of digits.


Constraints:

1 <= nums.length <= 500
1 <= nums[i] <= 10^5
 *         
 *         思路：
 *
 *
 *

 *
 */
public class Solution {

    public int findNumbers(int[] nums) {
        int evenCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (String.valueOf(nums[i]).length() % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] nums = new int[]{12,345,2,6,7896};
        int res = solution.findNumbers(nums);
        System.out.println(res);
        Assert.assertEquals(2, res);

        nums = new int[]{555,901,482,1771};
        res = solution.findNumbers(nums);
        System.out.println(res);
        Assert.assertEquals(1, res);
    }
}
