package com.potato.study.leetcode.p1185;


/**
 * 
 * @author liuzhao11
 * 
 * 	1185. Day of the Week
 *  
 *
Given a date, return the corresponding day of the week for that date.

The input is given as three integers representing the day, month and year respectively.

Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.



Example 1:

Input: day = 31, month = 8, year = 2019
Output: "Saturday"
Example 2:

Input: day = 18, month = 7, year = 1999
Output: "Sunday"
Example 3:

Input: day = 15, month = 8, year = 1993
Output: "Sunday"


Constraints:

The given dates are valid dates between the years 1971 and 2100.
 *         
 *         思路：
 *
 *         https://www.cnblogs.com/xiaochuan94/p/11588720.html
 *
 *
 *

 *
 */
public class Solution {

    public String dayOfTheWeek(int day, int month, int year) {
        // 计算 当前日期具体 1970 。1.1 有多少天
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month-1, day);

        int i = calendar.get(java.util.Calendar.DAY_OF_WEEK) - 1;
        if (i < 0) {
            i = 0;
        }
        String[] week = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"};
        return week[i];
    }
	
	public static void main(String[] args) {

    }
}
