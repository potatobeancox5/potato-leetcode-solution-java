package com.potato.study.leetcode.p0502;

import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *        502. IPO
 * 
 *         Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output your final maximized capital.

Example 1:
Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].

Output: 4

Explanation: Since your initial capital is 0, you can only start the project indexed 0.
After finishing it you will obtain profit 1 and your capital becomes 1.
With capital 1, you can either start the project indexed 1 or the project indexed 2.
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
Note:
You may assume all numbers in the input are non-negative integers.
The length of Profits array and Capital array will not exceed 50,000.
The answer is guaranteed to fit in a 32-bit signed integer.
 * 
 *         题目含义：
 *
 *         思路：
 *          https://blog.csdn.net/gqk289/article/details/55803485
 *          两个priorityQueue，一个capital升序排列，一个profit降序排列，用这两个找到满足当前W的最大profit
 *
 *
 *          首先 升序排列 capital -> profit 对
 *
 *          for k 次选择
 *              每次都按照当前的w选择合适放到profit中，知道capital中没有合适的元素
 *              从profit中选择最多的元素 加到w上
 *
 *           最终返回w值
 *          
 */
public class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> capital2profit = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> profit2capital = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        // init cap PriorityQueue
        for (int i = 0; i < profits.length; i++) {
            capital2profit.add(new int[]{capital[i], profits[i]});
        }
        for (int i = 0; i < k; i++) {
            // 将可以做的项目放到 profit2capital中
            while(!capital2profit.isEmpty() && capital2profit.peek()[0] <= w) {
                profit2capital.add(capital2profit.poll());
            }
            // 每次选择利润最高的进行执行
            if (!profit2capital.isEmpty()) {
                w += profit2capital.poll()[1];
            }
        }
        return w;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int k = 2;
        int w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        int maximizedCapital = solution.findMaximizedCapital(k, w, profits, capital);
        System.out.println("maximizedCapital:" + maximizedCapital);
    }
}
