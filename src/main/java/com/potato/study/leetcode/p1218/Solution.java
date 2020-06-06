package com.potato.study.leetcode.p1218;


import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	1218. Longest Arithmetic Subsequence of Given Difference
 *  
 *
 * Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.



Example 1:

Input: arr = [1,2,3,4], difference = 1
Output: 4
Explanation: The longest arithmetic subsequence is [1,2,3,4].
Example 2:

Input: arr = [1,3,5,7], difference = 1
Output: 1
Explanation: The longest arithmetic subsequence is any single element.
Example 3:

Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
Output: 4
Explanation: The longest arithmetic subsequence is [7,5,3,1].


Constraints:

1 <= arr.length <= 10^5
-10^4 <= arr[i], difference <= 10^4
 *         
 *         思路：
 *
 *  https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/solution/jian-dan-de-dp-by-97wgl/
 *
 *
 */
public class Solution {

    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: arr) {
            int temp = map.getOrDefault(i - difference, 0) + 1;
            map.put(i, temp);
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}
