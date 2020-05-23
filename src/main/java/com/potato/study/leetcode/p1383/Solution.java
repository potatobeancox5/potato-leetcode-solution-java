package com.potato.study.leetcode.p1383;


import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1383. Maximum Performance of a Team
 *  
 *
There are n engineers numbered from 1 to n and two arrays: speed and efficiency, where speed[i] and efficiency[i] represent the speed and efficiency for the i-th engineer respectively. Return the maximum performance of a team composed of at most k engineers, since the answer can be a huge number, return this modulo 10^9 + 7.

The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.



Example 1:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
Output: 60
Explanation:
We have the maximum performance of the team by selecting engineer 2 (with speed=10 and efficiency=4) and engineer 5 (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.
Example 2:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
Output: 68
Explanation:
This is the same example as the first but k = 3. We can select engineer 1, engineer 2 and engineer 5 to get the maximum performance of the team. That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
Example 3:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
Output: 72


Constraints:

1 <= n <= 10^5
speed.length == n
efficiency.length == n
1 <= speed[i] <= 10^5
1 <= efficiency[i] <= 10^8
1 <= k <= n
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/maximum-performance-of-a-team/solution/pai-xu-dui-onlgn-by-henrylee4/
 *
 *         直观的解法是按照效率进行降序排序，每个人作为最低效率时，在其左侧找出至多K - 1个最大速度即可(再加上这个人的速度组成K个)，这一过程可以用堆，时间复杂度O(nlg(k-1))
 *
 *
 */
public class Solution {


    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        //  新数据结构用于之后的排序
        int[][] items = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            items[i][0] = speed[i];
            items[i][1] = efficiency[i];
        }

        // 按照效率 降序
        Arrays.sort(items, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[1] - a[1];
            }
        });
        // 存放速度 当每个人最最小效率时， 在比他效率高的人中 找速度块的几个人
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long res = 0;
        long sum = 0;
        // 遍历 成员
        for(int i = 0 ; i < n ; i++){
            if(queue.size() > k - 1){
                sum -= queue.poll();
            }
            res = Math.max(res, (sum + items[i][0])* items[i][1]);
            queue.add(items[i][0]);
            sum += items[i][0];
        }
        return (int)(res % (int)(1e9 + 7));
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int n = 6;
        int[] speed = new int[]{2,10,3,1,5,8};
        int[] efficiency = new int[]{5,4,3,9,7,2};
        int k = 2;

        int res = solution.maxPerformance(n, speed, efficiency, k);
        System.out.println(res);
        Assert.assertEquals(60, res);
    }
}
