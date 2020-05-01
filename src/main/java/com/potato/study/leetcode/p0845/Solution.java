package com.potato.study.leetcode.p0845;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	845. Longest Mountain in Array
 *  
 *         Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain.

Return 0 if there is no mountain.

Example 1:

Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: [2,2,2]
Output: 0
Explanation: There is no mountain.
Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000
Follow up:

Can you solve it using only one pass?
Can you solve it in O(1) space?
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/longest-mountain-in-array/solution/shu-zu-zhong-de-zui-chang-shan-mai-by-leetcode/
 *          https://leetcode-cn.com/problems/longest-mountain-in-array/solution/xian-zhao-dao-feng-ding-zai-xiang-zuo-you-cha-zhao/
 *
 *          先找到 峰顶 然后开始向左右两端查找
 *
 * 
 */
public class Solution {

    public int longestMountain(int[] arr) {
        if (null == arr || arr.length < 3) {
            return 0;
        }
        int max = 0;
        // 从每个位置开始找 相邻出现左边小右边大 就是封顶
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i-1] >= arr[i] || arr[i] <= arr[i+1]) {
                continue;
            }
            // 找到top
            int left = i - 1;
            while (left > 0 && arr[left-1] < arr[left]) {
                left--;
            }
            int right = i + 1;
            while (right + 1 < arr.length && arr[right] > arr[right + 1]) {
                right++;
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] arr = new int[]{2,1,4,7,3,2,5};
        int res = solution.longestMountain(arr);
        System.out.println(res);
        Assert.assertEquals(5, res);

        arr = new int[]{2,2,2};
        res = solution.longestMountain(arr);
        System.out.println(res);
        Assert.assertEquals(0, res);
    }
}
