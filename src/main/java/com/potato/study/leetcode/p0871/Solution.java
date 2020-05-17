package com.potato.study.leetcode.p0871;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author liuzhao11
 *
 * 871. Minimum Number of Refueling Stops
 *
 *
 * A car travels from a starting position to a destination which is target miles east of the starting position.

Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of the starting position, and has station[i][1] liters of gas.

The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.

When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return -1.

Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches the destination with 0 fuel left, it is still considered to have arrived.



Example 1:

Input: target = 1, startFuel = 1, stations = []
Output: 0
Explanation: We can reach the target without refueling.
Example 2:

Input: target = 100, startFuel = 1, stations = [[10,100]]
Output: -1
Explanation: We can't reach the target (or even the first gas station).
Example 3:

Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Explanation:
We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.


Note:

1 <= target, startFuel, stations[i][1] <= 10^9
0 <= stations.length <= 500
0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
 *
 *
 * 题目含义：
 *
 * 思路：
 *  https://leetcode-cn.com/problems/minimum-number-of-refueling-stops/solution/zui-di-jia-you-ci-shu-by-leetcode/
 *

 *
 */
public class Solution {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        // 定义 pq（优先队列）为一个保存了驶过加油站油量的最大堆，定义当前油量为 tank。
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        // location 之前一个车站的位置
        int prevLocation = 0;
        // 当前有多少油量
        int tank = startFuel;

        // 对于每一个 stattion
        for (int[] station : stations) {
            int location = station[0];
            int capacity = station[1];
            // 当前剩余 gas
            tank -= (location - prevLocation);
            // 如果跑到这个站已经没油了 那么需要在之前加一次最多的 gas
            while (tank < 0 && !priorityQueue.isEmpty()) {
                tank += priorityQueue.poll();
                count++;
            }
            // 之前也没法加油 那么接结束了
            if (tank < 0) {
                return -1;
            }
            // 这个站的 gas可以加
            priorityQueue.add(capacity);
            prevLocation = location;

        }

        // last dance
        tank -= target - prevLocation;
        while (!priorityQueue.isEmpty() && tank < 0) {
            tank += priorityQueue.poll();
            count++;
        }
        if (tank < 0) {
            return -1;
        }


        return count;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();




    }
}
