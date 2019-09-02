package com.potato.study.leetcode.p0540;

/**
 * 
 * @author liuzhao11
 * 
 *         540. Single Element in a Sorted Array
 * 
 *         Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10
Note: Your solution should run in O(log n) time and O(1) space.


 * 
 *         思路： 异或 同则为0
 *       
 *          
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int num = 0;
        for (int current : nums) {
            num ^= current;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,3,7,7,10,11,11};
        int res = solution.singleNonDuplicate(nums);
        System.out.println(res);
    }
}
