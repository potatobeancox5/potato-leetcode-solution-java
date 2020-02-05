package com.potato.study.leetcode.p0765;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	765. Couples Holding Hands
 *  
 *         N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).

The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.

Example 1:

Input: row = [0, 2, 1, 3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
Example 2:

Input: row = [3, 2, 0, 1]
Output: 0
Explanation: All couples are already seated side by side.
Note:

len(row) is even and in the range of [4, 60].
row is guaranteed to be a permutation of 0...len(row)-1.

 *   题目大意：
 *
 *      最小交换多少次 使得 每个情侣都是相邻的
 *
 *
 *   解题思路：
 *
 *      https://blog.csdn.net/qq_43592709/article/details/90400194
 *
 *      使用一个map 记录 id - > 实际的index
 *
 * 
 */
public class Solution {

    public int minSwapsCouples(int[] row) {

        // 1 使用一个map 记录 id - > 实际的index
        Map<Integer, Integer> id2PositionMap = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            id2PositionMap.put(row[i], i);
        }
        // 2 遍历 row 每个位置找到其 配对的id 每次移动2个位置
        int step = 0;
        for (int i = 0; i < row.length; i += 2) {
            int pair1 = row[i];
            int pair2 = (pair1 % 2 == 0 ? pair1 + 1: pair1 - 1);
            // 3 如果当前位置 + 1 不是配对的id 通过map 对位置进行交换 并对计数器进行操作
            if (row[i + 1] != pair2) {
                // 交换
                int j = id2PositionMap.get(pair2);
                id2PositionMap.put(pair2, i+1);
                id2PositionMap.put(row[i+1], j);

                int tmp = row[i+1];
                row[i+1] = row[j];
                row[j] = tmp;
                step++;
            }
        }
        return step;
    }

	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] row = {0, 2, 1, 3};
        int num = solution.minSwapsCouples(row);
        System.out.println(num);
        Assert.assertEquals(1, num);

        int[] row1 = {3, 2, 0, 1};
        num = solution.minSwapsCouples(row1);
        System.out.println(num);
        Assert.assertEquals(0, num);

        int[] row2 = {0,2,4,6,7,1,3,5};
        num = solution.minSwapsCouples(row2);
        System.out.println(num);
        Assert.assertEquals(3, num);
    }
}
