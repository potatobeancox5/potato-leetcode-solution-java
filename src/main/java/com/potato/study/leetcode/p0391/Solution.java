package com.potato.study.leetcode.p0391;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *       391. Perfect Rectangle
 * 
 *     Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).


Example 1:

rectangles = [
[1,1,3,3],
[3,1,4,2],
[3,2,4,4],
[1,3,2,4],
[2,3,3,4]
]

Return true. All 5 rectangles together form an exact cover of a rectangular region.




Example 2:

rectangles = [
[1,1,2,3],
[1,3,2,4],
[3,1,4,2],
[3,2,4,4]
]

Return false. Because there is a gap between the two rectangular regions.




Example 3:

rectangles = [
[1,1,3,3],
[3,1,4,2],
[1,3,2,4],
[3,2,4,4]
]

Return false. Because there is a gap in the top center.




Example 4:

rectangles = [
[1,1,3,3],
[3,1,4,2],
[1,3,2,4],
[2,2,4,4]
]

Return false. Because two of the rectangles overlap with each other.
 *         
 *         思路：
 *         https://segmentfault.com/a/1190000018445582
 *
 *         1. 找到最左上和最右下的节点
 *         2. 计算1面积 与 小矩形面积和是否一致
 *         3. 计算是否 1中的点 出现了1次 且 只有他们是出现一次的点
 *
 *
 *         
 */
public class Solution {

    public boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        // 每个小图形的面积
        int sumAreaOfPart = 0;
        // 1. 找到 左上定点和右下节点 计算出面积 coordinate
        Set<String> coordinateSet = new HashSet<>();
        for (int[] rectangle : rectangles) {
            x1 = Math.min(rectangle[0], x1);
            y1 = Math.min(rectangle[1], y1);
            x2 = Math.max(rectangle[2], x2);
            y2 = Math.max(rectangle[3], y2);
            // 每个小图形的面积
            sumAreaOfPart += (Math.abs(rectangle[2] - rectangle[0]) * Math.abs(rectangle[3] - rectangle[1]));
            // 遍历每个点，将其放入一个set中 set中保存 出现奇数次的点
            String leftUp = rectangle[0] + "," + rectangle[1];
            String rightUp = rectangle[0] + "," + rectangle[3];
            String leftDown = rectangle[2] + "," + rectangle[1];
            String rightDown = rectangle[2] + "," + rectangle[3];
            if (coordinateSet.contains(leftUp)) {
                coordinateSet.remove(leftUp);
            } else {
                coordinateSet.add(leftUp);
            }
            if (coordinateSet.contains(rightUp)) {
                coordinateSet.remove(rightUp);
            } else {
                coordinateSet.add(rightUp);
            }
            if (coordinateSet.contains(leftDown)) {
                coordinateSet.remove(leftDown);
            } else {
                coordinateSet.add(leftDown);
            }
            if (coordinateSet.contains(rightDown)) {
                coordinateSet.remove(rightDown);
            } else {
                coordinateSet.add(rightDown);
            }

        }
        // 2. 计算面积和小矩形的和如果相等的话 说明 满足第一个验证条件
        if (coordinateSet.size() == 4
                && coordinateSet.contains(x1 + "," + y1)
                && coordinateSet.contains(x1 + "," + y2)
                && coordinateSet.contains(x2 + "," + y1)
                && coordinateSet.contains(x2 + "," + y2)) {

        } else {
            return false;
        }
        // 3. 遍历每个点，将其放入一个set中 set中保存 出现奇数次的点，
        // 如果最终set有4个点 且 能跟 1产生的四个节点对上返回true 否则返回false
        if (sumAreaOfPart == (Math.abs(x1 - x2) * Math.abs(y1 - y2))) {
            return true;
        }
        return false;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] rectangles = {};
        boolean res = solution.isRectangleCover(rectangles);
		System.out.println(res);
        Assert.assertEquals(false, res);
    }
}

