package com.potato.study.leetcode.p0539;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         539. Minimum Time Difference
 * 
 *         Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
Example 1:
Input: ["23:59","00:00"]
Output: 1
Note:
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.
 * 
 * 
 *         思路： 一个列表时间 之间的最小时间
 *       		先对列表排序 升序
 *       		计算相邻时间间隔 计算最开始到最后的时间间隔
 *          
 */
public class Solution {
	
	public int findMinDifference(List<String> timePoints) {
		//升序
		timePoints.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return minusTime(o1, o2);
			}
		});
		List<String> firstTimePoints = new ArrayList<>();
		firstTimePoints.add(timePoints.get(timePoints.size() - 1));
		firstTimePoints.add(timePoints.get(0));
		int min = minusTime(timePoints.get(0), timePoints.get(timePoints.size() - 1)) + 1440;// 1 day = 1440 minutes
		for(int i = timePoints.size() - 1 ; i > 0 ; i--) {
			int tmp = minusTime(timePoints.get(i), timePoints.get(i - 1));
			if(tmp < min) {
				min = tmp;
			}
		}
		return min;
	}
	
	
	/**
	 * 计算两个时间字符串的差
	 * @param reduced		被减数
	 * @param Subtraction	减数
	 * @return
	 */
	private int minusTime(String reduced, String subtraction) {
		String[] reducedStr = reduced.split(":");
		String[] subtractionStr = subtraction.split(":");
		int result = Integer.parseInt(reducedStr[0]) 
				- Integer.parseInt(subtractionStr[0]);
		result = result * 60 + (Integer.parseInt(reducedStr[1]) 
				- Integer.parseInt(subtractionStr[1]));
		return result;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<String> timePoints = new ArrayList<>();
		timePoints.add("23:59");
		timePoints.add("00:00");
		int minutes = solution.findMinDifference(timePoints);
		System.out.println(minutes);
	}
}
