package com.potato.study.leetcode.p0802;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	802. Find Eventual Safe States
 *  
 *         In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

Which nodes are eventually safe?  Return them as an array in sorted order.

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Here is a diagram of the above graph.

Illustration of graph

Note:

graph will have length at most 10000.
The number of edges in the graph will not exceed 32000.
Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
 *         
 *
 *        题目含义：
 *
 *          找到能到达终点的点集合 实质是找到不在环路上的节点集合
 *          从每个店开始dfs 如果与到 0 标识没有访问过 1 标识访问过了 2标识有问题的节点
 *
 *          https://www.cnblogs.com/lightwindy/p/9847572.html
 *
 *
 *        思路：
 *
 *          使用color i标识 i节点 是否已经 访问 是否unsafe
 *
 *          如果 当前节点被访问过 返回是否安全
 *
 *          如果 当前节点 没有访问过
 *
 *
 * 
 */
public class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        // 构造 color 数组
        int nodeCount = graph.length;
        int[] color = new int[nodeCount];
        // 依次遍历 每个节点 如果当前节点是 safe 加入结果
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            if (nodeIsSafeDfs(graph, i, color)) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    /**
     *
     * @param graph 邻接矩阵 i j  i-开始的结点    j-到达的结点
     * @param index 当前遍历到的距离
     * @param color 颜色数组
     * @return
     */
    private boolean nodeIsSafeDfs(int[][] graph, int index, int[] color) {
        // 0 当前位置已经访问过 直接返回是否安全
        if (color[index] != 0) {
            return color[index] == 1;
        }
        // 1 默认是不安全的 遍历每个边，找到 对应 graph【index】 递归调用 nodeIsSafeDfs 如果返回false 直接返回
        color[index] = 2;
        for (int reachIndex : graph[index]) {
            if (!nodeIsSafeDfs(graph, reachIndex, color)) {
                return false;
            }
        }
        // 2 否则继续遍历 遍历结束说明 color 是1 返回true
        color[index] = 1;
        return true;
    }



    public static void main(String[] args) {
    }
}
