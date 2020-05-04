package com.potato.study.leetcode.p1437;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1437. Check If All 1's Are at Least Length K Places Away
 *  
 *
Given an array nums of 0s and 1s and an integer k, return True if all 1's are at least k places away from each other, otherwise return False.



Example 1:



Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other.
Example 2:



Input: nums = [1,0,0,1,0,1], k = 2
Output: false
Explanation: The second 1 and third 1 are only one apart from each other.
Example 3:

Input: nums = [1,1,1,1,1], k = 0
Output: true
Example 4:

Input: nums = [0,1,0,1], k = 1
Output: true


Constraints:

1 <= nums.length <= 10^5
0 <= k <= nums.length
nums[i] is 0 or 1
 *         
 *
 *
 *
 * 思路：
 *      https://leetcode-cn.com/problems/check-if-all-1s-are-at-least-length-k-places-away/solution/5401java-zhi-jie-shuang-zhi-zhen-1ms-hen-jian-dan-/
 *
 *      两个指针 先找next 每次找到 next 与pre 做减法与 k比较 如果小于 =k 返回false
 *
 *
 *
 */
public class Solution {


    public boolean kLengthApart(int[] nums, int k) {
        int pre = - 100000;
        for (int next = 0; next < nums.length; next++) {
            if (nums[next] == 1) {
                if (next - pre <= k) {
                    return false;
                }
                pre = next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,0,0,0,1,0,0,1};
        int k = 2;
        boolean res = solution.kLengthApart(nums, k);
        System.out.println(res);
        Assert.assertEquals(true, res);


        nums = new int[]{1,0,0,1,0,1};
        k = 2;
        res = solution.kLengthApart(nums, k);
        System.out.println(res);
        Assert.assertEquals(false, res);

        nums = new int[]{1,0,0,1,0,1};
        k = 2;
        res = solution.kLengthApart(nums, k);
        System.out.println(res);
        Assert.assertEquals(false, res);

    }
}
