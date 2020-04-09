package com.potato.study.leetcode.p0826;

import org.junit.Assert;

import java.util.TreeMap;

/**
 * 
 * @author liuzhao11
 * 
 * 	826. Most Profit Assigning Work
 *  
 *         We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job.

Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with difficulty at most worker[i].

Every worker can be assigned at most one job, but one job can be completed multiple times.

For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.  If a worker cannot complete any job, his profit is $0.

What is the most profit we can make?

Example 1:

Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
Output: 100
Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.
Notes:

1 <= difficulty.length = profit.length <= 10000
1 <= worker.length <= 10000
difficulty[i], profit[i], worker[i]  are in range [1, 10^5]
 *         
 *         思路：
 *          给定一些工作 和对应难度 工人只能做对应难度的工作 问 最多能赚多少钱
 *
 *          https://www.cnblogs.com/shawshawwan/p/10275911.html
 *
 *
 *          如果TreeMap里面保存的是每个difficulty[i] 对应的最大的profit，则就可以直接找floorKey对应的value就是对应的要找的value;
那么只需要再遍历一次TreeMap，将最大的到目前key位置最大的value放进去就行了


 * 
 */
public class Solution {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        // 找到每个难度对应的最大利润
        TreeMap<Integer, Integer> maxProfitMap = new TreeMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            int maxProfit = Math.max(maxProfitMap.getOrDefault(difficulty[i], 0), profit[i]);
            maxProfitMap.put(difficulty[i], maxProfit);
        }
        // 找到每个难度 对应的 小于这个难度的最大利润 key 默认升序
        int max = 0;
        for (int diff : maxProfitMap.keySet()) {
            max = Math.max(max, maxProfitMap.get(diff));
            maxProfitMap.put(diff, max);
        }
        // 遍历 woeker map floorKey  累加
        int maxMoney = 0;
        for (int i = 0; i < worker.length; i++) {
            Integer pro = maxProfitMap.floorKey(worker[i]);
            if (null != pro) {
                maxMoney += maxProfitMap.get(pro);
            }
        }
        return maxMoney;
    }



	public static void main(String[] args) {
		Solution solution = new Solution();

        int[] difficulty = new int[]{2,4,6,8,10};
        int[] profit = new int[]{10,20,30,40,50};
        int[] worker = new int[]{4,5,6,7};
        int res = solution.maxProfitAssignment(difficulty, profit, worker);
        System.out.println(res);
        Assert.assertEquals(100, res);


    }
}
