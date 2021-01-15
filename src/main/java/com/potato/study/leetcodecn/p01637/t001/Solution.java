package com.potato.study.leetcodecn.p01637.t001;

import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1637. 两点之间不包含任何点的最宽垂直面积
 *
 * 给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直面积 的宽度。

 垂直面积 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直面积 为宽度最大的一个垂直面积。

 请注意，垂直区域 边上 的点 不在 区域内。

  

 示例 1：

 ​
 输入：points = [[8,7],[9,9],[7,4],[9,7]]
 输出：1
 解释：红色区域和蓝色区域都是最优区域。
 示例 2：

 输入：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 输出：3
  

 提示：

 n == points.length
 2 <= n <= 105
 points[i].length == 2
 0 <= xi, yi <= 109

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/widest-vertical-area-between-two-points-containing-no-points
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 我咋觉得是找到 两个最大相邻的点呢
     * @param points
     * @return
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        if (null == points) {
            return 0;
        }
        // 使用 堆缓存数据
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        // 少先队 入队
        for (int i = 0; i < points.length; i++) {
            priorityQueue.add(points[i]);
        }

        int max = 0;
        if (priorityQueue.isEmpty()) {
            return max;
        }
        int[] pre = priorityQueue.poll();
        int[] next = null;
        while (!priorityQueue.isEmpty()){
            next = priorityQueue.poll();
            max = Math.max(max, pre[0] - next[0]);
            pre = next;
        }

        if (next == null) {
            return max;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = new int[][] {
                {8,7},{9,9},{7,4},{9,7}
        };
        int max = solution.maxWidthOfVerticalArea(points);
        System.out.println(max);
        Assert.assertEquals(1, max);


        points = new int[][] {
                {3,1},{9,0},{1,0},{1,4},{5,3},{8,8}
        };
        max = solution.maxWidthOfVerticalArea(points);
        System.out.println(max);
        Assert.assertEquals(3, max);
    }
}
