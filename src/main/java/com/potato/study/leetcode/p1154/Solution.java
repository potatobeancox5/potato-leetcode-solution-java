package com.potato.study.leetcode.p1154;


/**
 * 
 * @author liuzhao11
 * 
 * 	1154. Day of the Year
 *  
 *
 * Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.



Example 1:

Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.
Example 2:

Input: date = "2019-02-10"
Output: 41
Example 3:

Input: date = "2003-03-01"
Output: 60
Example 4:

Input: date = "2004-03-01"
Output: 61


Constraints:

date.length == 10
date[4] == date[7] == '-', and all other date[i]'s are digits
date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.
 *         
 *
 *      题目含义：
 *
 *          https://leetcode-cn.com/problems/day-of-the-year/solution/yue-shi-jian-dan-de-ti-yue-yao-xi-xin-by-jxustcmh/
 *
 */
public class Solution {

    public int dayOfYear(String date) {
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] split = date.split("-");

        int day = Integer.parseInt(split[2]);

        int month = Integer.parseInt(split[1]);

        if (isLeapYear(split[0]) && month > 2) {
            day += 1;
        }
        for (int i = 0; i < month - 1; i++) {
            day += arr[i];
        }
        return day;

    }
    private boolean isLeapYear(String stringYear) {
        int year = Integer.parseInt(stringYear);
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }
}
