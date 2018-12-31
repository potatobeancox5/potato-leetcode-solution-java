package com.potato.study.leetcode.p0414;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         414. Third Maximum Number
 * 
 *         Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
 * 
 * 
 *         思路：
 *         记录三个最大的数，每次替换那个最小的数，最后返回最小的数
 * 
 */
public class Solution {

    public int thirdMax(int[] nums) {
        if (null == nums) {
            return -1;
        }
        if (nums.length < 3) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] max = new int[3];
        max[0] = nums[0];
        int index = 1;
        while (index < nums.length && nums[index] == max[0]) {
            index++;
        }
        if (index >= nums.length) {
            return max[0];
        }
        max[1] = nums[index++];
        while (index < nums.length &&  (nums[index] == max[0] || nums[index] == max[1])) {
            index++;
        }
        if (index >= nums.length) {
            return max[0] > max[1] ? max[0] : max[1];
        }
        max[2] = nums[index++];
        Arrays.sort(max);
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > max[0] && nums[i] != max[1] && nums[i] != max[2]) {
                max[0] = nums[i];
                Arrays.sort(max);
            }
        }
        return max[0];
    }


	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] arr = {2,2,3,1};
        int thirdMax = solution.thirdMax(arr);
        System.out.println(thirdMax);
    }
}
