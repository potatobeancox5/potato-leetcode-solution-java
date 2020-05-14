package com.potato.study.leetcode.p0853;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author liuzhao11
 * 
 * 	853. Car Fleet
 *  
 *         N cars are going to the same destination along a one lane road.  The destination is target miles away.

Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.

A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.

The distance between these two cars is ignored - they are assumed to have the same position.

A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.


How many car fleets will arrive at the destination?



Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 and 8 become a fleet, meeting each other at 12.
The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
The cars starting at 5 and 3 become a fleet, meeting each other at 6.
Note that no other cars meet these fleets before the destination, so the answer is 3.

Note:

0 <= N <= 10 ^ 4
0 < target <= 10 ^ 6
0 < speed[i] <= 10 ^ 6
0 <= position[i] < target
All initial positions are different.
 *         
 *
 *         题目含义：
 *
 *         思路：
 *
 *          https://leetcode-cn.com/problems/car-fleet/solution/che-dui-by-leetcode
853
按照start
 *
 *
 *
 */
public class Solution {

    class Car {
        public int position;
        public double time;

        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }


    public int carFleet(int target, int[] position, int[] speed) {
        // 0 构造 car【】 数据结构
        int num = position.length;
        Car[] cars = new Car[num];
        for (int i = 0; i < num; i++) {
            cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
        }
        // 1 按照起始位置排序
        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car a, Car b) {
                return Integer.compare(a.position, b.position);
            }
        });
        // 2 从 n-1 向前比较  如果后面那个时间比前边长 那就是追不上了 否则时间 就是 n-1
        int count = 0;
        int t = num - 1;
        while (t > 0) {
            if (cars[t].time < cars[t-1].time) {
                count++; //if cars[t] arrives sooner, it can't be caught
            } else {
                cars[t-1] = cars[t]; //else, cars[t-1] arrives at same time as cars[t]
            }
            t--;
        }
        if (t == 0) {
            count++;
        }
        return count;
    }


	public static void main(String[] args) {
		Solution solution = new Solution();


        int target = 12;
        int[] position = new int[]{10,8,0,5,3};
        int[] speed = new int[]{2,4,1,1,3};
        int result = solution.carFleet(target, position, speed);
        System.out.println(result);
        Assert.assertEquals(3, result);
    }
}
