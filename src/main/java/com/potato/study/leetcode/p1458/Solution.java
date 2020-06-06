package com.potato.study.leetcode.p1458;


/**
 * 
 * @author liuzhao11
 * 
 * 	1458. Max Dot Product of Two Subsequences
 *  
 *
Given two arrays nums1 and nums2.

Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.

A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).



Example 1:

Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
Output: 18
Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
Their dot product is (2*3 + (-2)*(-6)) = 18.
Example 2:

Input: nums1 = [3,-2], nums2 = [2,-6,7]
Output: 21
Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
Their dot product is (3*7) = 21.
Example 3:

Input: nums1 = [-1,-1], nums2 = [1,1]
Output: -1
Explanation: Take subsequence [-1] from nums1 and subsequence [1] from nums2.
Their dot product is -1.


Constraints:

1 <= nums1.length, nums2.length <= 500
-1000 <= nums1[i], nums2[i] <= 1000
 *         
 *
 *
 *
 * 思路：
 *      https://leetcode-cn.com/problems/max-dot-product-of-two-subsequences/solution/javadai-ma-jiang-yi-xia-wo-shi-zen-yao-kao-lu-dui-/
 *
 *
 */
public class Solution {


    private int f[][];
    private int a1[];
    private int a2[];
    private int maxPoint;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        f = new int[nums1.length][nums2.length];
        for (int i = 0 ; i < nums1.length ; i++) {
            f[i] = new int[nums2.length];
        }
        a1 = nums1;
        a2 = nums2;
        maxPoint = nums1[0] * nums2[0];
        f[0][0] = nums1[0] * nums2[0];

        for (int i = 0 ; i < nums1.length ; i++) {
            for (int j = 0 ; j < nums2.length ; j++) {
                int curNum = a1[i] * a2[j];
                f[i][j] = curNum;
                if (((i - 1) >= 0) && ((j - 1) >= 0)) {
                    curNum = f[i - 1][j - 1] + a1[i] * a2[j];
                    if (f[i][j] < curNum) {
                        f[i][j] = curNum;
                    }
                }

                if (i >= 1) {
                    if (f[i][j] < f[i - 1][j]) {
                        f[i][j] = f[i - 1][j];
                    }
                }

                if (j >= 1) {
                    if (f[i][j] < f[i][j - 1]) {
                        f[i][j] = f[i][j - 1];
                    }
                }

                if (maxPoint < f[i][j]) {
                    maxPoint = f[i][j];
                }
            }
        }
        return maxPoint;
    }

}
