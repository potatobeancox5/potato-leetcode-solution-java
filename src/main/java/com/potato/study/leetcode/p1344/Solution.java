package com.potato.study.leetcode.p1344;



/**
 * 
 * @author liuzhao11
 * 
 * 	1344. Angle Between Hands of a Clock
 *  
 *
Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.



Example 1:



Input: hour = 12, minutes = 30
Output: 165
Example 2:



Input: hour = 3, minutes = 30
Output: 75
Example 3:



Input: hour = 3, minutes = 15
Output: 7.5
Example 4:

Input: hour = 4, minutes = 50
Output: 155
Example 5:

Input: hour = 12, minutes = 0
Output: 0
 *         
 *         思路：
 *         https://zxi.mytechroad.com/blog/math/leetcode-1344-angle-between-hands-of-a-clock/
 *
 *
 *
 *
 *

 *
 */
public class Solution {

    public double angleClock(int hour, int minutes) {
        // 算出分针角度 算出 时针角度
        double minutesAngle = 1.0 * minutes * 360 / 60;
        double hourAngle =  (hour + minutes / 60.0) * 360 / 12;
        // 算出夹脚
        double angle = Math.min(Math.abs(minutesAngle - hourAngle), 360 -  Math.abs(minutesAngle - hourAngle));
        return angle;
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        int hour = 12;
        int minutes = 30;
        double angle = solution.angleClock(hour, minutes);
        System.out.println(angle);

    }
}
