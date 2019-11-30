package com.potato.study.leetcode.p0554;


import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *        554. Brick Wall
 * 
 *         There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.



Example:

Input: [[1,2,2,1],
[3,1,2],
[1,3,2],
[2,4],
[3,1,2],
[1,3,1,1]]

Output: 2

Explanation:



Note:

The width sum of bricks in different rows are the same and won't exceed INT_MAX.
The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.

 * 
 * 
 *         思路：
 *
 *         554. Brick Wall

给一个 list list 其中的数字代表砖块的宽度  画一条线 ，求穿过砖块最少的线穿过的砖块数量



[[1,3,5,6],
[3,4,6],
[1,4,6],
[2,6],
[3,4,6],
[1,4,5,6]]

1
n -3

2
n - 4
3

n-3
4
n - 4

计算sum的时候直接 加出来Map 个数 求个数最多的那个

https://blog.csdn.net/tstsugeg/article/details/69951556
 *
 *
 *
 */
public class Solution {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        int max = 0;
        for (List<Integer> bricks : wall) {
            int sum = 0;
            for (int i = 0; i < bricks.size() - 1; i++) {
                sum += bricks.get(i);
                Integer count = sumCountMap.get(sum);
                if (null == count) {
                    sumCountMap.put(sum, 1);
                    max = Math.max(max, 1);
                } else {
                    sumCountMap.put(sum, count + 1);
                    max = Math.max(max, count + 1);
                }
            }
        }
        return wall.size() - max;
    }


	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

        List<List<Integer>> wall= null;

        int result = solution.leastBricks(wall);
        System.out.println(result);
        Assert.assertEquals(2, result);

    }
}
