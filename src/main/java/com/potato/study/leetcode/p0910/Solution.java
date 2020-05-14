package com.potato.study.leetcode.p0910;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	910. Smallest Range II
 *  
 *      Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, and add x to A[i] (only once).

After this process, we have some array B.

Return the smallest possible difference between the maximum value of B and the minimum value of B.



Example 1:

Input: A = [1], K = 0
Output: 0
Explanation: B = [1]
Example 2:

Input: A = [0,10], K = 2
Output: 6
Explanation: B = [2,8]
Example 3:

Input: A = [1,3,6], K = 3
Output: 3
Explanation: B = [4,6,3]


Note:

1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000

 *         
 *         题目含义：
 *
 *         思路：
 *         https://leetcode-cn.com/problems/smallest-range-ii/solution/zui-xiao-chai-zhi-ii-by-leetcode/
 *
 *
 *
 *
 */
public class Solution {

    public int smallestRangeII(int[] arr, int k) {
        int num = arr.length;
        Arrays.sort(arr);
        int ans = arr[num-1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            int a = arr[i];
            int b = arr[i+1];
            int high = Math.max(arr[num - 1] - k, a + k);
            int low = Math.min(arr[0] + k, b - k);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
