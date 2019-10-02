package com.potato.study.leetcode.p0407;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 *    407. Trapping Rain Water II
 * 
 *      Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.



Note:

Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.



Example:

Given the following 3x6 height map:
[
[1,4,3,1,3,2],
[3,2,1,3,2,4],
[2,3,3,2,3,1]
]

Return 4.


The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.





After the rain, water is trapped between the blocks. The total volume of water trapped is 4.

	思路 ：
https://www.cnblogs.com/grandyang/p/5928987.html
  采用 bfs 遍历整个图 规则是 建立一个queue 初始将四周全部加入到queue中 优先队列， 值是海拔
 从海拔1开始 从队列中 获取相等的值，然后一次遍历周围的点，并将周围没有遍历的点 记录遍历状态 visit
 如果出现 没遍历的点 海拔小于给定海拔 说明可以计算当前存水量


 */
public class Solution {


    /**
     * 存储点坐标和高度
     */
    class PointHeight {
        public int height;
        public int x;
        public int y;

        public PointHeight(int height, int x, int y) {
            this.height = height;
            this.x = x;
            this.y = y;
        }
    }

    private int[][] directions = {{-1, 0},{1, 0},{0, -1},{0, 1}};

    public int trapRainWater(int[][] heightMap) {

        if (null == heightMap || heightMap.length == 0) {
            return 0;
        }

        // 存储状态
        boolean[][] visit = new boolean[heightMap.length][heightMap[0].length];
        // 初始将走遍节点加入优先队列 并标记为visit
        PriorityQueue<PointHeight> priorityQueue = new PriorityQueue(new Comparator<PointHeight>() {
            @Override
            public int compare(PointHeight o1, PointHeight o2) {
                return o1.height - o2.height;
            }
        });
        initHeightPriorityQueue(heightMap, priorityQueue, visit);
        // 依次升高海拔，选出当前的高度点进行遍历，当当前点邻接的没有遍历过的点加入队列，
        int currentHeight = 1;
        int result = 0;
        while (!priorityQueue.isEmpty()) {
            while ( !priorityQueue.isEmpty() && priorityQueue.peek().height <= currentHeight) {
                PointHeight pointHeight = priorityQueue.poll();
                int x = pointHeight.x;
                int y = pointHeight.y;
                // 四个方向
                for (int[] direction : directions) {
                    int curX = x + direction[0];
                    int curY = y + direction[1];
                    // 坐标合法
                    if (0 <= curX && curX < heightMap.length && 0 <= curY && curY < heightMap[0].length
                            && !visit[curX][curY]) {
                        // 节点没有被访问过 则加入queue
                        priorityQueue.add(new PointHeight(heightMap[curX][curY], curX, curY));
                        visit[curX][curY] = true;
                        // 如果加入队列点高度小于当前海拔，可以计算当前高度总和
                        if (heightMap[curX][curY] < currentHeight) {
                            result += (currentHeight - heightMap[curX][curY]);
                        }
                    }
                }
            }
            currentHeight++;
        }
        return result;
    }

    private void initHeightPriorityQueue(int[][] heightMap, PriorityQueue<PointHeight> priorityQueue, boolean[][] visit) {
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j < heightMap[0].length; j++) {
                if (i == 0 || j == 0 || i == heightMap.length - 1 || j == heightMap[0].length - 1) {
                    priorityQueue.add(new PointHeight(heightMap[i][j], i, j));
                    visit[i][j] = true;
                }
            }
        }
    }
	
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix = {{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
		int sss = solution.trapRainWater(matrix);
		System.out.println(sss);
	}
}
