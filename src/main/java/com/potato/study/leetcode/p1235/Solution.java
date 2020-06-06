package com.potato.study.leetcode.p1235;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1235. Maximum Profit in Job Scheduling
 *  
 *      We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime , endTime and profit arrays, you need to output the maximum profit you can take such that there are no 2 jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.



Example 1:



Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job.
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:




Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job.
Profit obtained 150 = 20 + 70 + 60.
Example 3:



Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6


Constraints:

1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
1 <= startTime[i] < endTime[i] <= 10^9
1 <= profit[i] <= 10^4
 *         
 *
 *
 *         思路：
 *          https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling/solution/java-you-xian-ji-dui-lie-by-miaomiao-2/
 *
 */
public class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i=0; i<n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        //startTime asc
        Arrays.sort(jobs, (a, b)->a[0]-b[0]);
        //  0- endTime asc;   1- profit dec;
        PriorityQueue<int[]> endQueue = new PriorityQueue<>((a, b)->{
            if(a[1] == b[1]) {
                return a[0]-b[0];
            }
            return b[1]-a[1];
        });

        for(int i=0; i<n; i++) {
            int[] cur = jobs[i];
            Queue<int[]> tmp = new LinkedList<>();
            //将不能叠加的区间先取出
            while(!endQueue.isEmpty() && endQueue.peek()[0] > cur[0]) {
                tmp.add(endQueue.poll());
            }
            //没有可以叠加的前序区间
            if(endQueue.isEmpty()) {
                tmp.add(new int[]{cur[1], cur[2]});
            } else {
                //前序区间叠加，endQueue.peek() 已经是profit最大，且endTime最小的了，剩下的都可以丢弃
                tmp.add(new int[]{cur[1], cur[2]+endQueue.peek()[1]});
                tmp.add(endQueue.peek());
                endQueue.clear();
            }
            while(!tmp.isEmpty()) {
                //  System.out.println(tmp.peek()[0]+","+tmp.peek()[1]);
                endQueue.add(tmp.poll());
            }
            //   System.out.println("-----");
        }
        return endQueue.peek()[1];
    }
}
