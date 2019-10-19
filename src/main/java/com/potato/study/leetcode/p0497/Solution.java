package com.potato.study.leetcode.p0497;

import java.util.Random;

/**
 * 
 * @author liuzhao11
 * 
 *         497. Random Point in Non-overlapping Rectangles
 * 
 *         Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.

Note:

An integer point is a point that has integer coordinates.
A point on the perimeter of a rectangle is included in the space covered by the rectangles.
ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
length and width of each rectangle does not exceed 2000.
1 <= rects.length <= 100
pick return a point as an array of integer coordinates [p_x, p_y]
pick is called at most 10000 times.
Example 1:

Input:
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
Output:
[null,[4,1],[4,1],[3,3]]
Example 2:

Input:
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
Output:
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array of rectangles rects. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.


 *
 *
 *         题目含义：
 *
 *         思路：
 *         https://www.jianshu.com/p/732f3eb04f65
 *         注意 按照点来处理
 * 
 */
public class Solution {

    private int[][] rects;
    private Random random;
    // 保存的是到目前为止的面积和
    private int[] area;

    public Solution(int[][] rects) {
        // 存储 坐标
        this.rects = rects;
        this.random = new Random();
        // 计算面积和并 存储
        this.area = new int[rects.length];
        area[0] = getArea(rects[0]);
        for (int i = 1; i < area.length; i++) {
            area[i] = getArea(rects[i]) + area[i-1];
        }
    }

    public int[] pick() {
        // 1. 遍历并选择面积和 random
        int randomArea = random.nextInt(area[area.length - 1]);
        // 2. 判断随机出来的数字是哪个面积和中的 rect
        int randomAreaIndex = this.getAreaIndex(randomArea);
        // 3. 根据随机结果对纵横坐标进行计算
        int area = randomAreaIndex > 0 ? randomArea - this.area[randomAreaIndex-1] : randomArea;
        int pointEachRow = rects[randomAreaIndex][2] - rects[randomAreaIndex][0] + 1;
        int x = rects[randomAreaIndex][0] + area % pointEachRow;
        int y = rects[randomAreaIndex][1] + area / pointEachRow;
        return new int[]{x, y};

    }

    /**
     * 出入一个矩形的四个坐标计算这个矩形的中包含多少和点
     * @param rect
     * @return
     */
    private int getArea(int[] rect) {
        return (rect[3] - rect[1] + 1) * (rect[2] - rect[0] + 1);
    }

    /**
     * 给出一个当前的面积，计算它属于哪个面积中
     * @param thisArea  返回属于面积的index
     * @return
     */
    private int getAreaIndex(int thisArea) {
        int left = 0;
        int right = area.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (area[mid] <= thisArea) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
    }
}
