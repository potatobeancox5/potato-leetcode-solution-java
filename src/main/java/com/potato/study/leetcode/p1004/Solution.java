package com.potato.study.leetcode.p1004;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1004. Max Consecutive Ones III
 *  
 *         Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s.



Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation:
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation:
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.


Note:

1 <= A.length <= 20000
0 <= K <= A.length
A[i] is 0 or 1
 *         
 *         思路：
 *          0 1 组成的数组 可以变更k 个位置 求 最长连续 1 是多少
 *          https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/hua-dong-chuang-kou-10ms534mb-by-hadymic/
 *
 *          滑动窗口
 *          left right 左右边界
 *
 */
public class Solution {

    public int longestOnes(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < arr.length) {

            if (arr[right]== 0) {
                if (k > 0) {
                    k--;
                } else {
                    // k = 0  移动 left
                    while (arr[left] == 1) {
                        left++;
                    }
                    left++;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int num = solution.longestOnes(arr, k);
        System.out.println(num);
        Assert.assertEquals(6, num);
    }
}
