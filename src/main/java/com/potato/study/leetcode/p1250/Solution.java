package com.potato.study.leetcode.p1250;


/**
 * 
 * @author liuzhao11
 * 
 * 	1250. Check If It Is a Good Array
 *  
 *
Given an array nums of positive integers. Your task is to select some subset of nums, multiply each element by an integer and add all these numbers. The array is said to be good if you can obtain a sum of 1 from the array by any possible subset and multiplicand.

Return True if the array is good otherwise return False.



Example 1:

Input: nums = [12,5,7,23]
Output: true
Explanation: Pick numbers 5 and 7.
5*3 + 7*(-2) = 1
Example 2:

Input: nums = [29,6,10]
Output: true
Explanation: Pick numbers 29, 6 and 10.
29*1 + 6*(-3) + 10*(-1) = 1
Example 3:

Input: nums = [3,6]
Output: false


Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/check-if-it-is-a-good-array/solution/gen-ju-pei-shu-ding-li-qiu-jie-by-utopiahiker/
 *
 *

 *
 */
public class Solution {

    public boolean isGoodArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            res = gcd(res, nums[i]);
        }
        return res == 1;
    }
    private int gcd(int a, int b){
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
