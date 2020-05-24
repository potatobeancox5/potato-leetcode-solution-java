package com.potato.study.leetcode.p1354;


import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1354. Construct Target Array With Multiple Sums
 *  
 *  Given an array of integers target. From a starting array, A consisting of all 1's, you may perform the following procedure :

let x be the sum of all elements currently in your array.
choose index i, such that 0 <= i < target.size and set the value of A at index i to x.
You may repeat this procedure as many times as needed.
Return True if it is possible to construct the target array from A otherwise return False.



Example 1:

Input: target = [9,3,5]
Output: true
Explanation: Start with [1, 1, 1]
[1, 1, 1], sum = 3 choose index 1
[1, 3, 1], sum = 5 choose index 2
[1, 3, 5], sum = 9 choose index 0
[9, 3, 5] Done
Example 2:

Input: target = [1,1,1,2]
Output: false
Explanation: Impossible to create target array from [1,1,1,1].
Example 3:

Input: target = [8,5]
Output: true


Constraints:

N == target.length
1 <= target.length <= 5 * 10^4
1 <= target[i] <= 10^9
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/construct-target-array-with-multiple-sums/solution/java-shuang-100ni-tui-fa-you-xian-dui-lie-shi-xian/
 *
 *          结果 反推起因
 *
 */
public class Solution {

    // 优先队列 为了 快速拿到 当前数组中 最大的数字
    private PriorityQueue<Long> q;
    private long sum = 0;

    public boolean isPossible(int[] target) {
        if (target.length == 1 && target[0] == 1) {
            return true;
        }
        if (target.length == 1) {
            return false;
        }
        initialize(target);
        while (!q.isEmpty()) {
            // 找到之前的一轮的数字
            long previousSum = q.poll();
            long othersSum = sum - previousSum;
            long previousVal;
            long base = (!q.isEmpty() ? q.peek() : 1);
            do {
                previousVal = previousSum - othersSum;
                previousSum = previousVal;
            } while (previousVal > base);

            if (!q.isEmpty()) {
                if (previousVal == base || previousVal < 1) {
                    return false;
                }
                sum = previousVal + othersSum;
                if (previousVal == 1) {
                    continue;
                }
                q.offer(previousVal);
            } else {
                return previousVal == base;
            }
        }
        return true;
    }

    private void initialize(int[] target) {
        q = new PriorityQueue<>(target.length, Comparator.reverseOrder());
        for (long value : target) {
            sum += value;
            if (value > 1) {
                q.offer(value);
            }
        }
    }


	public static void main(String[] args) {
        Solution solution = new Solution();

        int[] target = new int[]{9,3,5};

        boolean res = solution.isPossible(target);
        System.out.println(res);
        Assert.assertEquals(true, res);


    }
}
