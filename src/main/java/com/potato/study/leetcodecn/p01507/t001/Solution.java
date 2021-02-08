package com.potato.study.leetcodecn.p01507.t001;

import java.util.HashMap;
import java.util.Map;

/**
 * 1507. 转变日期格式
 *
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：

 Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
 Year 的范围在 ​[1900, 2100] 之间。
 请你将字符串转变为 YYYY-MM-DD 的格式，其中：

 YYYY 表示 4 位的年份。
 MM 表示 2 位的月份。
 DD 表示 2 位的天数。
  

 示例 1：

 输入：date = "20th Oct 2052"
 输出："2052-10-20"
 示例 2：

 输入：date = "6th Jun 1933"
 输出："1933-06-06"
 示例 3：

 输入：date = "26th May 1960"
 输出："1960-05-26"
  

 提示：

 给定日期保证是合法的，所以不需要处理异常输入。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reformat-date
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 转换日期根式
     * {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}
     * @param date
     * @return
     */
    public String reformatDate(String date) {
        String[] split = date.split(" ");
        int year = Integer.parseInt(split[2]);
        Map<String, Integer> monthMap = new HashMap<>();
        monthMap.put("Jan", 1);
        monthMap.put("Feb", 2);
        monthMap.put("Mar", 3);
        monthMap.put("Apr", 4);
        monthMap.put("May", 5);
        monthMap.put("Jun", 6);
        monthMap.put("Jul", 7);
        monthMap.put("Aug", 8);
        monthMap.put("Sep", 9);
        monthMap.put("Oct", 10);
        monthMap.put("Nov", 11);
        monthMap.put("Dec", 12);
        int month = monthMap.get(split[1]);
        int day = Integer.parseInt(split[0].substring(0, split[0].length() - 2));
        StringBuilder builder = new StringBuilder();
        if (year < 1000) {
            builder.append(0);
        }
        if (year < 100) {
            builder.append(0);
        }
        if (year < 10) {
            builder.append(0);
        }
        builder.append(year).append("-");
        if (month < 10) {
            builder.append(0);
        }
        builder.append(month).append("-");
        if (day < 10) {
            builder.append(0);
        }
        builder.append(day);
        return builder.toString();
    }
}
