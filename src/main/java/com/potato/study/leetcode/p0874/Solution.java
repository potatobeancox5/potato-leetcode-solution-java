package com.potato.study.leetcode.p0874;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzhao11
 * <p>
 *
 *
 * 874. Walking Robot Simulation
 *
 *
 * A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:

-2: turn left 90 degrees
-1: turn right 90 degrees
1 <= x <= 9: move forward x units
Some of the grid squares are obstacles.

The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])

If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)

Return the square of the maximum Euclidean distance that the robot will be from the origin.



Example 1:

Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: robot will go to (3, 4)
Example 2:

Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)


Note:

0 <= commands.length <= 10000
0 <= obstacles.length <= 10000
-30000 <= obstacle[i][0] <= 30000
-30000 <= obstacle[i][1] <= 30000
The answer is guaranteed to be less than 2 ^ 31.
 *      https://leetcode-cn.com/problems/walking-robot-simulation/solution/mo-ni-xing-zou-ji-qi-ren-by-intgrp/
 *
 *      按照题意判断方向然后行走，其中方向有{北，东，南，西}，初始化北方
 *
 *      (dir+3)%4。
 *
 *
 * 题目含义：
 *
 *
 * 思路：
 *
 *
 */
public class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        // 四个方向 -2: turn left 90 degrees -1: turn right 90 degrees 北，东，南，西 如果 -2 那么 index + 3 % 4 ++
        int[][] direction = new int[][]{{ 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }};
        // set 存障碍 遇到 障碍 停止都 否则 走起来
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        int directionIndex = 0;
        int maxDistant = 0;

        int x = 0;
        int y = 0;


        for (int command : commands) {
            if (command == -1) {
                directionIndex = (directionIndex + 1) % 4;
            } else if (command == -2) {
                directionIndex = (directionIndex + 3) % 4;
            } else {
                // 走起
                for (int i = 0; i < command; i++) {
                    int nextX = x + direction[directionIndex][0];
                    int nextY = y + direction[directionIndex][1];
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;
                    } else {
                        x = nextX;
                        y = nextY;
                        maxDistant = Math.max(maxDistant, x * x + y * y);
                    }
                }
            }
        }

        return maxDistant;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] commands = new int[]{4,-1,3};
        int[][] obstacles = new int[][]{};
        int sim = solution.robotSim(commands, obstacles);
        System.out.println(sim);
        Assert.assertEquals(25, sim);


        commands = new int[]{4,-1,4,-2,4};
        obstacles = new int[][]{{2,4}};
        sim = solution.robotSim(commands, obstacles);
        System.out.println(sim);
        Assert.assertEquals(65, sim);

    }

}
