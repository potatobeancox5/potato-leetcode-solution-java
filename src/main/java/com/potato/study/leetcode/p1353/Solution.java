package com.potato.study.leetcode.p1353;


import org.junit.Assert;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1353. Maximum Number of Events That Can Be Attended
 *  
 *  Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.

Return the maximum number of events you can attend.



Example 1:


Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
Example 2:

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
Example 3:

Input: events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
Output: 4
Example 4:

Input: events = [[1,100000]]
Output: 1
Example 5:

Input: events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
Output: 7


Constraints:

1 <= events.length <= 10^5
events[i].length == 2
1 <= events[i][0] <= events[i][1] <= 10^5
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended/solution/chun-cui-de-tan-xin-mei-yong-you-xian-dui-lie-dai-/
 *
 *
 *
 */
public class Solution {

    public int maxEvents(int[][] events) {
        //首先排序：开始时间小的在前。这样是方便我们顺序遍历，把开始时间一样的都放进堆
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        //小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //结果、开始时间、events下标、有多少组数据
        int res = 0, last = 1, i = 0, n = events.length;
        while (i < n || !pq.isEmpty()) {
            //将start相同的会议都放进堆里
            while (i < n && events[i][0] == last) {
                pq.offer(events[i++][1]);
            }
            //po p掉当前天数之前的
            while (!pq.isEmpty() && pq.peek() < last) {
                pq.poll();
            }
            //顶上的就是俺们要参加的
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            last++;
        }
        return res;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] events = new int[][]{{1,2},{2,3},{3,4}};

        int res = solution.maxEvents(events);
        System.out.println(res);
        Assert.assertEquals(3, res);


    }
}
