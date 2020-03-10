package com.potato.study.leetcode.p0798;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	798. Smallest Rotation with Highest Score
 *  
 *         Given an array A,
 *         we may rotate it by a non-negative integer K so that the array becomes A[K], A[K+1], A{K+2], ... A[A.length - 1], A[0], A[1], ..., A[K-1].
 *
 *         Afterward, any entries that are less than or equal to their index are worth 1 point.

For example, if we have [2, 4, 1, 3, 0], and we rotate by K = 2, it becomes [1, 3, 0, 2, 4].
This is worth 3 points because 1 > 0 [no points], 3 > 1 [no points], 0 <= 2 [one point], 2 <= 3 [one point], 4 <= 4 [one point].

Over all possible rotations, return the rotation index K that corresponds to the highest score we could receive.
If there are multiple answers, return the smallest such index K.

Example 1:
Input: [2, 3, 1, 4, 0]
Output: 3
Explanation:
Scores for each K are listed below:
K = 0,  A = [2,3,1,4,0],    score 2
K = 1,  A = [3,1,4,0,2],    score 3
K = 2,  A = [1,4,0,2,3],    score 3
K = 3,  A = [4,0,2,3,1],    score 4
K = 4,  A = [0,2,3,1,4],    score 3
So we should choose K = 3, which has the highest score.



Example 2:
Input: [1, 3, 0, 2, 4]
Output: 0
Explanation:  A will always have 3 points no matter how it shifts.
So we will choose the smallest K, which is 0.
Note:

A will have length at most 20000.
A[i] will be in the range [0, A.length].
 *         
 *
 *         题目含义：
 *          积分规则 如果 value 小于等于index 得一分
 *          按照哪个位置进行旋转能得到最高的分数
 *
 *         思路：
 *          https://leetcode.com/problems/smallest-rotation-with-highest-score/discuss/118725/Easy-and-Concise-5-lines-Solution-C++JavaPython?page=2
 *
 *          所以我们可以在这个刚好开始不得分的地方标记一下，通过-1进行标记
 *
 *
 *          解释
 *          https://www.cnblogs.com/grandyang/p/9272921.html
 *
 * 
 */
public class Solution {

    public int bestRotation(int[] arr) {

        int len = arr.length;
        int[] change = new int[len];
        // 计算 arr[i] 到那个位置 开始不得分的
        for (int i = 0; i < len; i++) {
            change[(i - arr[i] + len + 1)% len]--;
        }
        int maxIndex = 0;
        for (int i = 1; i < len; i++) {
            change[i] += (change[i-1] + 1);
            if (change[maxIndex] < change[i]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
	

	public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2, 3, 1, 4, 0};
        int res = solution.bestRotation(arr);
        System.out.println(res);
        Assert.assertEquals(3, res);

        arr = new int[]{1, 3, 0, 2, 4};
        res = solution.bestRotation(arr);
        System.out.println(res);
        Assert.assertEquals(0, res);
    }
}
