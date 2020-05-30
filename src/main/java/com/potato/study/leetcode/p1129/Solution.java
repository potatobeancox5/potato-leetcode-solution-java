package com.potato.study.leetcode.p1129;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1129. Shortest Path with Alternating Colors
 *  
 *
 * Consider a directed graph, with nodes labelled 0, 1, ..., n-1.  In this graph, each edge is either red or blue, and there could be self-edges or parallel edges.

Each [i, j] in red_edges denotes a red directed edge from node i to node j.  Similarly, each [i, j] in blue_edges denotes a blue directed edge from node i to node j.

Return an array answer of length n, where each answer[X] is the length of the shortest path from node 0 to node X such that the edge colors alternate along the path (or -1 if such a path doesn't exist).



Example 1:

Input: n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
Output: [0,1,-1]
Example 2:

Input: n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
Output: [0,1,-1]
Example 3:

Input: n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
Output: [0,-1,-1]
Example 4:

Input: n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
Output: [0,1,2]
Example 5:

Input: n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
Output: [0,1,1]


Constraints:

1 <= n <= 100
red_edges.length <= 400
blue_edges.length <= 400
red_edges[i].length == blue_edges[i].length == 2
0 <= red_edges[i][j], blue_edges[i][j] < n*
 *
 *
 *      思路：
 *          https://leetcode-cn.com/problems/shortest-path-with-alternating-colors/solution/1129-yan-se-jiao-ti-de-zui-duan-lu-jing-by-wangziy/
 *
 *
 *
 *
 */
public class Solution {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> redEdge = new HashMap<>();

        Map<Integer, List<Integer>> blueEdge = new HashMap<>();
        // 图 初始化  避免在逻辑中做过多的null判断
        for (int i = 0; i < n; i++) {
            redEdge.computeIfAbsent(i, ArrayList::new);
            blueEdge.computeIfAbsent(i, ArrayList::new);
        }
        // 初始化红图
        for (int[] e : redEdges) {
            int start = e[0];
            int end = e[1];
            redEdge.get(start).add(end);
        }
        // 初始化化蓝图
        for (int[] e : blueEdges) {
            int start = e[0];
            int end = e[1];
            blueEdge.get(start).add(end);
        }
        // 重点 两个数组交替计算，并且需要理解 red {1,2} blue{1,2} 是红蓝两条边
        // 红-蓝开
        int[] redDis = new int[n];
        // 蓝-红开
        int[] blueDis = new int[n];

        Arrays.fill(redDis, -1);
        Arrays.fill(blueDis, -1);
        Queue<Integer> redQueue = new ArrayDeque<>();
        Queue<Integer> blueQueue = new ArrayDeque<>();

        redQueue.add(0);

        blueQueue.add(0);
        redDis[0] = 0;


        blueDis[0] = 0;
        int row = 0;

        while (!redQueue.isEmpty() || !blueQueue.isEmpty()) {

            Queue<Integer> newRed = new ArrayDeque<>();
            Queue<Integer> newBlue = new ArrayDeque<>();
            // 打野蓝开
            int redSize = redQueue.size();
            for (int i = 0; i < redSize; i++) {
                int v = redQueue.poll();
                // red
                List<Integer> edgeLis = blueEdge.get(v);
                for (Integer e : edgeLis) {
                    // 下一层  并更新蓝色边对应的顶点已经访问，
                    if (blueDis[e] == -1) {
                        blueDis[e] = row + 1;
                        newBlue.add(e);
                    }
                }

            }

            // 打野红开
            int blueSize = blueQueue.size();
            for (int i = 0; i < blueSize; i++) {
                int v = blueQueue.poll();

                List<Integer> edgeLis = redEdge.get(v);
                for (Integer e : edgeLis) {
                    // 下一层  并更新红色边对应的顶点已经访问，
                    if (redDis[e] == -1) {
                        redDis[e] = row + 1;
                        newRed.add(e);
                    }
                }

            }
            blueQueue = newBlue;
            redQueue = newRed;
            row++;
        }
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        for (int i = 0; i < n; i++) {
            if (redDis[i] >= 0 && blueDis[i] >= 0) {
                answer[i] = Math.min(redDis[i], blueDis[i]);
            } else if (redDis[i] >= 0) {
                answer[i] = redDis[i];
            } else {
                answer[i] = blueDis[i];
            }
        }
        return answer;
    }


	
	public static void main(String[] args) {
    }
}
