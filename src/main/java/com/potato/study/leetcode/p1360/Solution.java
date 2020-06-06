package com.potato.study.leetcode.p1360;


/**
 * 
 * @author liuzhao11
 * 
 * 	1360. Number of Days Between Two Dates
 *  
 *
Write a program to count the number of days between two dates.

The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.



Example 1:

Input: date1 = "2019-06-29", date2 = "2019-06-30"
Output: 1
Example 2:

Input: date1 = "2020-01-15", date2 = "2019-12-31"
Output: 15


Constraints:

The given dates are valid dates between the years 1971 and 2100.
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/number-of-days-between-two-dates/solution/cyu-yan-0ms-14xing-jian-ji-dai-ma-jie-zhu-zellergo/
 *
 *
 *
 */
public class Solution {

    public int toDay(String dateStr) {
        String[] temp = dateStr.split("-");
        int year = Integer.valueOf(temp[0]);
        int month = Integer.valueOf(temp[1]);
        int day = Integer.valueOf(temp[2]);

        if (month <= 2) {
            year--;
            month += 10;
        } else {
            month -= 2;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + 30 * month + (3 * month - 1) / 5 + day /*- 584418*/;
    }
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(toDay(date1) - toDay(date2));
    }
}
