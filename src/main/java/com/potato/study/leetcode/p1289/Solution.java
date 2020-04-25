package com.potato.study.leetcode.p1289;


import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	1289. Minimum Falling Path Sum II
 *  
 *
Given a square grid of integers arr, a falling path with non-zero shifts is a choice of exactly one element from each row of arr, such that no two elements chosen in adjacent rows are in the same column.

Return the minimum sum of a falling path with non-zero shifts.



Example 1:

Input: arr = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
Explanation:
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.


Constraints:

1 <= arr.length == arr[i].length <= 200
-99 <= arr[i][j] <= 99
 *         
 *         思路：
 *           找到 min 阶梯
 *           https://leetcode-cn.com/problems/minimum-falling-path-sum-ii/solution/java-yuan-shu-zu-dp-jie-fa-by-ling-ji-zhi-chu/
 *
 *           arr[i][j] = findMin(arr[i+1], j) + arr[i][j];
 *
 *           从顶部 往下走 dp ij 代表 走到当前位置的最小代价
 *
 */
public class Solution {


    public int minFallingPathSum(int[][] arr) {
        // 如果当前 有 0 行
        if (null == arr || arr.length == 0) {
            return 0;
        }
        // 自底 向顶 index = 0  做dp 计算
        for (int i = arr.length - 2; i >= 0 ; i--) {
            for (int j = 0; j < arr[0].length; j++) {
                // 下面那行 最小值 + 当前值 arr = dp 到达当前ij位置的 最小花费
                arr[i][j] = findMinValue(arr[i+1], j) + arr[i][j];
            }
        }
        // 求 顶部最小值
        return findMinValue(arr[0], -1);
    }


    /**
     * 找到一行中 最小的元素 出去 第 exceptIndex 个元素
     * @param line
     * @param exceptIndex
     * @return
     */
    private int findMinValue(int[] line, int exceptIndex) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < line.length; i++) {
            if (exceptIndex == i) {
                continue;
            }
            min = Math.min(min, line[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int res = solution.minFallingPathSum(arr);
        System.out.println(res);
        Assert.assertEquals(13, res);
    }

}
