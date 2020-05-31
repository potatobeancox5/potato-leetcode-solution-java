package com.potato.study.leetcode.p1010;


/**
 * 
 * @author liuzhao11
 * 
 * 	1010. Pairs of Songs With Total Durations Divisible by 60
 *  
 *         n a list of songs, the i-th song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.



Example 1:

Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.


Note:

1 <= time.length <= 60000
1 <= time[i] <= 500
 *         
 *         思路：
 *
 *         https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/solution/java-2ms-ji-bai-10000-by-keen0126/
 *
 *
 */
public class Solution {

    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] seconds = new int[60];
        for(int t : time) {
            seconds[t % 60] += 1;
        }
        count += combination(seconds[30], 2);
        count += combination(seconds[0], 2);
        int i = 1, j = 59;
        while(i < j) {
            count += seconds[i++] * seconds[j--];
        }
        return count;
    }

    // 求组合数
    private int combination(int n, int k) {
        long result = 1;
        for(int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return (int)result;
    }
}
