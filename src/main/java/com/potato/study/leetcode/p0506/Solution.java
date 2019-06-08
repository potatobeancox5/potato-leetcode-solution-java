package com.potato.study.leetcode.p0506;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *        506. Relative Ranks
 * 
 *        Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.


 * 
 *         题目含义：
 *
 *         思路：
 *          堆排序，记录当前值和index
 *
 *          
 */
public class Solution {


    public String[] findRelativeRanks(int[] nums) {

        PriorityQueue<int[]> numsPriorityQueue = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        for (int i = 0; i < nums.length; i++) {
            numsPriorityQueue.add(new int[]{nums[i], i});
        }

        String[] res = new String[nums.length];
        // 第一名
        if (!numsPriorityQueue.isEmpty()) {
            res[numsPriorityQueue.poll()[1]] = "Gold Medal";
        }
        // 第二名
        if (!numsPriorityQueue.isEmpty()) {
            res[numsPriorityQueue.poll()[1]] = "Silver Medal";
        }
        // 第三名
        if (!numsPriorityQueue.isEmpty()) {
            res[numsPriorityQueue.poll()[1]] = "Bronze Medal";
        }
        int rank = 4;
        while (!numsPriorityQueue.isEmpty()) {
            res[numsPriorityQueue.poll()[1]] = "" + rank++;
        }
        return res;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {5, 4, 3, 2, 1};

        String[] res = solution.findRelativeRanks(nums);
        System.out.println(Arrays.toString(res));

    }
}
