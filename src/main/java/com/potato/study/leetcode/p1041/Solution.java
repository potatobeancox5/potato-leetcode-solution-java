package com.potato.study.leetcode.p1041;


/**
 * 
 * @author liuzhao11
 * 
 * 	1041. Robot Bounded In Circle
 *  
 *        On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degress to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.



Example 1:

Input: "GGLLGG"
Output: true
Explanation:
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: "GG"
Output: false
Explanation:
The robot moves north indefinitely.
Example 3:

Input: "GL"
Output: true
Explanation:
The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...


Note:

1 <= instructions.length <= 100
instructions[i] is in {'G', 'L', 'R'}
 *         
 *
 *         题目含义：
 *
 *
 *
 *          https://leetcode-cn.com/problems/robot-bounded-in-circle/solution/si-kao-kao-zhi-xu-yao-yi-lun-xun-huan-ji-ke-de-chu/
 */
public class Solution {

    public boolean isRobotBounded(String instructions) {

        int dir = 0; // 方向: 0上   1右   2下   3左
        int x = 0;   // x轴坐标
        int y = 0;   // y轴坐标
        char ch;
        for(int i = 0; i < instructions.length(); i ++){
            ch = instructions.charAt(i); // 逐个读取字符
            if(ch == 'L'){
                if(dir == 0) {
                    dir = 3;
                } else {
                    dir --;
                }
            }
            if(ch == 'R'){
                if(dir == 3) {
                    dir = 0;
                } else {
                    dir ++;
                }
            }
            if(ch == 'G'){
                switch(dir){
                    case 0: y ++; break;
                    case 1: x ++; break;
                    case 2: y --; break;
                    case 3: x --; break;
                }
            }
        }
        // 情况1: 走完一轮回到原点
        if(x == 0 && y == 0) {
            return true;
        }
        // 情况2: 走完一轮,只要方向改变了(即不是直走了),最后不管走多少轮总会回到起点
        if(dir != 0) {
            return true;
        }

        return false;
    }

}
