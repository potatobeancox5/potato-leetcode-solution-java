package com.potato.study.leetcode.p1144;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1144. Decrease Elements To Make Array Zigzag
 *  
 *
 * Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.

An array A is a zigzag array if either:

Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
Return the minimum number of moves to transform the given array nums into a zigzag array.



Example 1:

Input: nums = [1,2,3]
Output: 2
Explanation: We can decrease 2 to 0 or 3 to 1.
Example 2:

Input: nums = [9,6,1,6,2]
Output: 4


Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 1000
 *         
 *      思路：
 *          https://leetcode-cn.com/problems/decrease-elements-to-make-array-zigzag/solution/java-fen-lei-tao-lun-by-gfu/
 *
 */
public class Solution {

    private int len;

    public int movesToMakeZigzag(int[] nums) {
        len = nums.length;
        return Math.min(compute(Arrays.copyOf(nums, len), 0), compute(nums, 1));
    }

    private int compute(int[] arr, int idx) {
        int count = 0;
        for (; idx < len; idx += 2) {
            int cur_num = arr[idx];
            if (idx > 0 && arr[idx - 1] >= cur_num) {
                count += arr[idx - 1] - cur_num + 1;
                arr[idx - 1] = cur_num - 1;
            }
            if (idx + 1 < len && arr[idx + 1] >= cur_num) {
                count += arr[idx + 1] - cur_num + 1;
                arr[idx + 1] = cur_num - 1;
            }
        }
        return count;
    }
}
