package com.potato.study.leetcode.p0785;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 	785. Is Graph Bipartite?
 *  
 *        Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation:
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation:
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.


Note:

graph will have length in range [1, 100].
graph[i] will contain integers in range [0, graph.length - 1].
graph[i] will not contain i or duplicate values.
The graph is undirected: if any element j is in graph[i], then i will be in graph[j].


 *
 *
 *   解题思路：
 *      判断一个图是否可以被二分
 *
 *
 *
 *      染色法 https://blog.csdn.net/xdhc304/article/details/79779837
 *
 *      dfs 判断 每个节点 对应的点 是否有
 *
 *
 *      color 代表颜色 每次 进行染色 -1 1
 * 
 */
public class Solution {

    public boolean isBipartite(int[][] graph) {
        // 0 转换成邻接数组的形式存储
        int n = graph.length;
        int[][] connection = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                connection[i][j] = 1;
            }
        }
        // 1 从每个点开始判断 是否满足 相异 dfs
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(connection, color, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * dfs 进行颜色设置
     * @param connection
     * @param color
     * @param start
     * @param colorNum
     * @return
     */
    private boolean dfs(int[][] connection, int[] color, int start, int colorNum) {
        // 设置当前颜色
        color[start] = colorNum;
        // 对邻接点设置颜色
        for (int i = 0; i < color.length; i++) {
            if (connection[start][i] == 1) {
                if (color[i] != 0 && colorNum == color[i]) {
                    return false;
                }
                if (color[i] == 0 && !dfs(connection, color, i, colorNum * -1)) {
                    return false;
                }
            }
        }
        return true;
    }



	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] graph = new int[][]{{1,3}, {0,2}, {1,3}, {0,2}};
        boolean res = solution.isBipartite(graph);
        System.out.println(res);
        Assert.assertEquals(true, res);

        graph = new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        res = solution.isBipartite(graph);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
