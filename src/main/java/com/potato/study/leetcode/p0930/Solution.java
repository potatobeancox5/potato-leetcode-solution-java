package com.potato.study.leetcode.p0930;

/**
 * 
 * @author liuzhao11
 * 
 * 	930. Binary Subarrays With Sum
In an array A of 0s and 1s, how many non-empty subarrays have sum S?



Example 1:

Input: A = [1,0,1,0,1], S = 2
Output: 4
Explanation:
The 4 subarrays are bolded below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]


Note:

A.length <= 30000
0 <= S <= A.length
A[i] is either 0 or 1.
 *         
 *         题目含义：
 *
 *         思路：
 *
 *          https://leetcode-cn.com/problems/binary-subarrays-with-sum/solution/he-xiang-tong-de-er-yuan-zi-shu-zu-by-leetcode/
 *
 *
 * 
 */
public class Solution {


    public int numSubarraysWithSum(int[] arr, int sum) {
        int su = 0;
        for (int x: arr) {
            su += x;
        }

        // indexes[i] = location of i-th one (1 indexed)
        int[] indexes = new int[su + 2];
        int t = 0;
        indexes[t++] = -1;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 1) {
                indexes[t++] = i;
            }
        }
        indexes[t] = arr.length;
        int ans = 0;
        if (sum == 0) {
            for (int i = 0; i < indexes.length - 1; ++i) {
                // w: number of zeros between consecutive ones
                int w = indexes[i+1] - indexes[i] - 1;
                ans += w * (w + 1) / 2;
            }
            return ans;
        }

        for (int i = 1; i < indexes.length - sum; ++i) {
            int j = i + sum - 1;
            int left = indexes[i] - indexes[i-1];
            int right = indexes[j+1] - indexes[j];
            ans += left * right;
        }

        return ans;
    }
}
