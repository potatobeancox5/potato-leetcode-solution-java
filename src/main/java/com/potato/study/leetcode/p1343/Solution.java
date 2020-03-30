package com.potato.study.leetcode.p1343;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 *  
 *
Given an array of integers arr and two integers k and threshold.

Return the number of sub-arrays of size k and average greater than or equal to threshold.



Example 1:

Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
Example 2:

Input: arr = [1,1,1,1,1], k = 1, threshold = 0
Output: 5
Example 3:

Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
Output: 6
Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
Example 4:

Input: arr = [7,7,7,7,7,7,7], k = 7, threshold = 7
Output: 1
Example 5:

Input: arr = [4,4,4,4], k = 4, threshold = 1
Output: 1


Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^4
1 <= k <= arr.length
0 <= threshold <= 10^4
 *         
 *         思路：
 *
 *          https://blog.csdn.net/Wang100gui/article/details/105026966
 *
 *          一遍遍历 维护一个 k大小的当前窗口 实时比较 窗口内大小和 k * threshold 的值
 *
 *
 *

 *
 */
public class Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int limit = k * threshold;
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }

        int count = 0;
        for (int i = k-1; i < arr.length; i++) {
            sum += arr[i];
            if (sum >= limit) {
                count++;
            }
            sum -= arr[i - (k-1)];
        }
        return count;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,2,2,2,5,5,5,8};
        int k = 3;
        int threshold = 4;
        int steps = solution.numOfSubarrays(arr, k, threshold);
        System.out.println(steps);
        Assert.assertEquals(3, steps);

        arr = new int[]{1,1,1,1,1};
        k = 1;
        threshold = 0;
        steps = solution.numOfSubarrays(arr, k, threshold);
        System.out.println(steps);
        Assert.assertEquals(5, steps);


        arr = new int[]{11,13,17,23,29,31,7,5,2,3};
        k = 3;
        threshold = 5;
        steps = solution.numOfSubarrays(arr, k, threshold);
        System.out.println(steps);
        Assert.assertEquals(6, steps);


        arr = new int[]{7,7,7,7,7,7,7};
        k = 7;
        threshold = 7;
        steps = solution.numOfSubarrays(arr, k, threshold);
        System.out.println(steps);
        Assert.assertEquals(1, steps);

        arr = new int[]{4,4,4,4};
        k = 4;
        threshold = 1;
        steps = solution.numOfSubarrays(arr, k, threshold);
        System.out.println(steps);
        Assert.assertEquals(1, steps);
    }
}
