package com.potato.study.leetcode.p0684;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         684. Redundant Connection
 * 
 *         In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N),
with one additional edge added.
The added edge has two different vertices chosen from 1 to N,
and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges.
Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes.
If there are multiple answers, return the answer that occurs last in the given 2D-array.
The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
1
/ \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
|   |
4 - 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

Update (2017-09-26):
We have overhauled the problem description + test cases and specified clearly the graph is an undirected graph. For the directed graph follow up please see Redundant Connection II). We apologize for any inconvenience caused.
 *
 *         思路：
 *
 *          https://www.cnblogs.com/lightwindy/p/9750317.html
 *
 *
 *
 */
public class Solution {


    public int[] findRedundantConnection(int[][] edges) {
        // 0. parent [] 数组 存储 当前节点i最终的root  parent i初始为i 否则
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = getRootIndex(parent, edge[0]);
            int root2 = getRootIndex(parent, edge[1]);
            if (root1 == root2) {
                // 2. 相同的话 它就是多余的
                return edge;
            } else {
                // 1. 对于每个边 获取 顶点的父节点 如果不相同，那么 设置parent roo1 = roo2
                parent[root1] = root2;
            }
        }
        return new int[2];
    }


    /**
     * 找到 target 节点 最终的父节点
     * @param parent
     * @param target
     * @return
     */
    private int getRootIndex(int[] parent, int target) {
        while (parent[target] != target) {
            target = parent[target];
        }
        return target;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] edges = {{1,2}, {1,3}, {2,3}};
        int[] points = solution.findRedundantConnection(edges);
        System.out.println(Arrays.toString(points)); // 2, 3

        int[][] edges1 = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int[] points1 = solution.findRedundantConnection(edges1);
        System.out.println(Arrays.toString(points1)); // 1,4
    }

}
