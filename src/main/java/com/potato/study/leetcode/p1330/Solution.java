package com.potato.study.leetcode.p1330;



import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1330. Reverse Subarray To Maximize Array Value
 *  
 *
You are given an integer array nums. The value of this array is defined as the sum of |nums[i]-nums[i+1]| for all 0 <= i < nums.length-1.

You are allowed to select any subarray of the given array and reverse it. You can perform this operation only once.

Find maximum possible value of the final array.



Example 1:

Input: nums = [2,3,1,5,4]
Output: 10
Explanation: By reversing the subarray [3,1,5] the array becomes [2,5,1,3,4] whose value is 10.
Example 2:

Input: nums = [2,4,9,24,2,1,10]
Output: 68


Constraints:

1 <= nums.length <= 3*10^4
-10^5 <= nums[i] <= 10^5
 *         
 *
 *
 *      思路：
 *
 *      https://leetcode-cn.com/problems/reverse-subarray-to-maximize-array-value/solution/javajie-fa-by-saliormoon-3/
 *
 *
 *
 */
public class Solution {

    public int maxValueAfterReverse(int[] nums) {
        int ans = 0;
        // 所有加和
        int all = 0;
        int n = nums.length;
        for(int i = 0;i< n-1;i++) {
            all += Math.abs(nums[i]-nums[i+1]);
        }

        int mn = Math.max(nums[0], nums[1]);
        int mx = Math.min(nums[0], nums[1]);
        for(int i = 1;i < n;i++) {
            int t1 = Math.min(nums[i], nums[i-1]);
            int t2 = Math.max(nums[i], nums[i-1]);
            if(mn<t1) {
                ans = Math.max(ans, t1-mn);
            }
            if(mx>t2) {
                ans = Math.max(ans, mx-t2);
            }
            mn = Math.min(mn, t2);
            mx = Math.max(mx, t1);
        }
        ans *= 2;
        for(int i = 1;i < n;i++) {
            ans = Math.max(ans, Math.abs(nums[i]-nums[0]) - Math.abs(nums[i]-nums[i-1]));
            ans = Math.max(ans, Math.abs(nums[n-i-1]-nums[n-1]) - Math.abs(nums[n-i]-nums[n-i-1]));
        }
        return all + ans;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{2,3,1,5,4};
        int res = solution.maxValueAfterReverse(arr);
        System.out.println(res);
        Assert.assertEquals(10, res);

    }
}
