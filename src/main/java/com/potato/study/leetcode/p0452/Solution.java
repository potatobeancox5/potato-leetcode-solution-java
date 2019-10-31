package com.potato.study.leetcode.p0452;


import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author liuzhao11
 * 
 *   452. Minimum Number of Arrows to Burst Balloons
 * 
 *      There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.

Example:

Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

Explanation:
One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
 * 
 *         思路：
 *          https://www.cnblogs.com/lightwindy/p/9552042.html
 *
 *          452. Minimum Number of Arrows to Burst Balloons


https://blog.csdn.net/lby0910/article/details/69945430

贪心法
排序按照start
维护一个重叠区域 start end
计数器 count =0

遍历气球

新气球 左端在内部 右也在内 缩小范围
左边在内 右在外 缩小范围
左在外 计数 ++

最终计算范围 计数
count++
 * 				
 */	
public class Solution {

    public int findMinArrowShots(int[][] points) {
        if (null == points || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
//        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;
        int shotCount = 0;
        // 默认前提 start <= point[0】
        for (int[] point : points) {
            if (point[0] > end) {
                shotCount++;
//                start = point[0];
                end = point[1];
            } else if (point[1] > end) {
//                start = point[0];
            } else if (point[1] <= end) {
//                start = point[0];
                end = point[1];
            }
        }
        shotCount++;
        return shotCount;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        int num = solution.findMinArrowShots(points);
		System.out.println(num);
        Assert.assertEquals("", 2, num);
	}
}
