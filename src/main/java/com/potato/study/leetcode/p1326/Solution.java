package com.potato.study.leetcode.p1326;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1326. Minimum Number of Taps to Open to Water a Garden
 *  
 *
There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).

There are n + 1 taps located at points [0, 1, ..., n] in the garden.

Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.

Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.



Example 1:


Input: n = 5, ranges = [3,4,1,1,0,0]
Output: 1
Explanation: The tap at point 0 can cover the interval [-3,3]
The tap at point 1 can cover the interval [-3,5]
The tap at point 2 can cover the interval [1,3]
The tap at point 3 can cover the interval [2,4]
The tap at point 4 can cover the interval [4,4]
The tap at point 5 can cover the interval [5,5]
Opening Only the second tap will water the whole garden [0,5]
Example 2:

Input: n = 3, ranges = [0,0,0,0]
Output: -1
Explanation: Even if you activate all the four taps you cannot water the whole garden.
Example 3:

Input: n = 7, ranges = [1,2,1,0,2,1,0,1]
Output: 3
Example 4:

Input: n = 8, ranges = [4,0,0,0,0,0,0,0,4]
Output: 2
Example 5:

Input: n = 8, ranges = [4,0,0,0,4,0,0,0,4]
Output: 1


Constraints:

1 <= n <= 10^4
ranges.length == n + 1
0 <= ranges[i] <= 100
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/solution/guan-gai-hua-yuan-de-zui-shao-shui-long-tou-shu-mu/
 *
 *
 *
 */
public class Solution {

    class Interval {
        int start;
        int end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public int minTaps(int n, int[] ranges) {

        List<Interval> intervals = new ArrayList<>();
        int pos = 0;
        // 得到所有灌溉区间。
        for (int range: ranges){
            intervals.add(new Interval(pos - range, pos + range));
            pos += 1;
        }

        int size = intervals.size();
        // n + 1个点一共有 n 个区间。 dp矩阵表示前i个区间所需最小的taps
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++){
            dp[i + 1] = Integer.MAX_VALUE;
            // 枚举所有覆盖它的区间。
            for (int j =0; j < size; j++){
                if (intervals.get(j).end < i + 1 || intervals.get(j).start > i){
                    continue;
                }
                // 满足：intervals.get(j).start <= i &&  intervals.get(j).end >= i + 1
                int start = intervals.get(j).start >= 0 ? intervals.get(j).start : 0;

                if (dp[start] != Integer.MAX_VALUE){
                    dp[i + 1] = Math.min(dp[i + 1], dp[start] + 1);
                }

            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

}
