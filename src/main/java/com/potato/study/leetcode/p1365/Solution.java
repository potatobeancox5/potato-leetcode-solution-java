package com.potato.study.leetcode.p1365;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1365. How Many Numbers Are Smaller Than the Current Number
 *  
 *
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.



Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]


Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100
 *         
 *         思路：
 *
 *         给定一个数组，找到每个位置比该位置小的数字个数 0 <= nums[i] <= 100 直接计数 然后加吧
 *
 *
 *

 *
 */
public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        // count
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = 0; j < nums[i]; j++) {
                tmp += count[j];
            }
            res[i] = tmp;
        }
        return res;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{8,1,2,2,3};
        int[] steps = solution.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(steps));// 4,0,1,1,3

        nums = new int[]{6,5,4,8};
        steps = solution.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(steps));// 2,1,0,3

        nums = new int[]{7,7,7,7};
        steps = solution.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(steps));// 0,0,0,0
    }
}
