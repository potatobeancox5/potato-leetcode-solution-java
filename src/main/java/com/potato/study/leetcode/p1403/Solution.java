package com.potato.study.leetcode.p1403;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1403. Minimum Subsequence in Non-Increasing Order
 *  
 *
Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence.

If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array.

Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.



Example 1:

Input: nums = [4,3,10,9,8]
Output: [10,9]
Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of their elements is strictly greater than the sum of elements not included, however, the subsequence [10,9] has the maximum total sum of its elements.
Example 2:

Input: nums = [4,4,7,6,7]
Output: [7,7,6]
Explanation: The subsequence [7,7] has the sum of its elements equal to 14 which is not strictly greater than the sum of elements not included (14 = 4 + 4 + 6). Therefore, the subsequence [7,6,7] is the minimal satisfying the conditions. Note the subsequence has to returned in non-decreasing order.
Example 3:

Input: nums = [6]
Output: [6]


Constraints:

1 <= nums.length <= 500
1 <= nums[i] <= 100
 *         
 *         思路：
 *
 *          https://www.cnblogs.com/qinduanyinghua/p/12677849.html
 *
 *
 *
 *
 */
public class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        // 1. 排序
        Arrays.sort(nums);
        // 2. 求和
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 3. 遍历数组 当list >= sum/2 时返回
        List<Integer> list = new ArrayList<>();
        long cur = 0;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            cur += nums[i];
            list.add(nums[i]);
            if (cur > (sum - cur)) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{4,3,10,9,8};
        List<Integer> list = solution.minSubsequence(nums);
        System.out.println(list); // [10,9]

        nums = new int[]{4,4,7,6,7};
        list = solution.minSubsequence(nums);
        System.out.println(list); // [7,7,6]

        nums = new int[]{6};
        list = solution.minSubsequence(nums);
        System.out.println(list); // [6]
    }
}
