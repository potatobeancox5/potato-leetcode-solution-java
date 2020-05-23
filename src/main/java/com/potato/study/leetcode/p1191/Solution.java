package com.potato.study.leetcode.p1191;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1191. K-Concatenation Maximum Sum
 *  
 *
Given an integer array arr and an integer k, modify the array by repeating it k times.

For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].

Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.

As the answer can be very large, return the answer modulo 10^9 + 7.



Example 1:

Input: arr = [1,2], k = 3
Output: 9
Example 2:

Input: arr = [1,-2,1], k = 5
Output: 2
Example 3:

Input: arr = [-1,-2], k = 7
Output: 0


Constraints:

1 <= arr.length <= 10^5
1 <= k <= 10^5
-10^4 <= arr[i] <= 10^4
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/k-concatenation-maximum-sum/solution/java-kadanesuan-fa-yu-jie-ti-si-lu-by-zdxiq125/
 *
 *
 *
 *

 *
 */
public class Solution {

    public int kConcatenationMaxSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        long maxOfEnd = arr[0] > 0 ? arr[0] : 0L;
        long maxSoFar = maxOfEnd, sum = arr[0];
        for (int i = 1; i < Math.min(k, 2) * arr.length; i++) {
            maxOfEnd = Math.max(maxOfEnd + arr[i % arr.length], arr[i % arr.length]);
            maxSoFar = Math.max(maxOfEnd, maxSoFar);
            if (i < arr.length) {
                sum += arr[i];
            }
        }
        while (sum > 0 && --k >= 2){
            maxSoFar = (maxSoFar + sum) % 1000000007;
        }
        return (int) maxSoFar;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{1,2};
        int k = 3;
        int res = solution.kConcatenationMaxSum(arr, k);
        System.out.println(res);
        Assert.assertEquals(9, res);
    }
}
