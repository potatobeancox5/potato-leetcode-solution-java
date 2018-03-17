package com.potato.study.leetcode.util;

import java.util.ArrayList;
import java.util.List;

import com.potato.study.leetcode.domain.Interval;

/**
 * 间隔 工具类
 * @author Administrator
 *
 */
public class IntervalUtil {
	private IntervalUtil() {
		
	}
	
	public static List<Interval> str2IntervalList(String str) {
		List<Interval> list = new ArrayList<>();
		if(!str.contains("],[")) { // 只有一个间隔对象
			String subStr = str.substring(1, str.length() - 1);
			String[] split = subStr.split(",");
			Interval interval = new Interval(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
			list.add(interval);
		} else {
			String subStr = str.substring(1, str.length() - 1);
			String[] split = subStr.split("\\],\\[");
			for (String string : split) {
				String[] numStr = string.split(",");
				Interval interval = new Interval(Integer.parseInt(numStr[0]), Integer.parseInt(numStr[1]));
				list.add(interval);
			}
		}
		return list;
	}
}
