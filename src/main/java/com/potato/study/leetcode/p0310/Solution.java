package com.potato.study.leetcode.p0310;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 *         310. Minimum Height Trees
 *          
 *        For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1 :

Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

0
|
1
/ \
2   3

Output: [1]
Example 2 :

Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

0  1  2
\ | /
3
|
4
|
5

Output: [3, 4]
Note:

According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *         
 *         
 *         
 *         题目含义：
 *         310. Minimum Height Trees
每个结点https://blog.csdn.net/jmspan/article/details/51205302

思路dfs 找本节点的最远结点
先找 0号节点的最远结点k
在找 k 的最远结点m
找到 k m 的中点 返回

全局 maxDistance
全局 farthestNode

dfs2FindMaxDistanceNode
参数
currentIndex ，currendistance当前节点距离起始点距离 ，visit【】，
previous【】 key 是当前index 值是key的前驱
list【】graph 临接表存储图 key 是起始点 list存临接点

if currendistance 》maxdistance
更改 最大信息
if visit 【currentindex】
return
修改visit 当前index
\\组装调用信息
取出list【currentindex】fore
对每个点递归调用 dfs方法


https://blog.csdn.net/jmspan/article/details/51205302
 *
 *
 *         
 *         
 *         
 *         
 *         
 */
public class Solution {

    private int maxDistance = 0;
    private int farthestNode = 0;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        思路dfs 找本节点的最远结点
        boolean[] visit = new boolean[n];
        int[] previousNode = new int[n];

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 组装graph
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

//        先找 0号节点的最远结点k
        visit[0] = true;
        dfs2FindMaxDistanceNode(0, 0, visit, previousNode, graph);
        int k = farthestNode;
//        在找 k 的最远结点m

        int[] previousNode2 = new int[n];
        visit = new boolean[n];

        farthestNode = k;
        maxDistance = 0;
        visit[k] = true;
        dfs2FindMaxDistanceNode(k, 0, visit, previousNode2, graph);
//        找到 k m 的中点 返回
        int m = farthestNode;

        int node = m;
        for(int i = 0; i < maxDistance / 2; i++) {
            node = previousNode2[node];
        }
        List<Integer> list = new ArrayList<>();
        if (maxDistance % 2 == 0) {
            list.add(node);
        } else {
            list.add(node);
            list.add(previousNode2[node]);
        }
        return list;
    }

    /**
     *
     * @param currentIndex
     * @param currentDistance   当前节点距离起始点距离
     * @param visit
     * @param previousNode      当前index 值是key的前驱
     * @param graph             临接表存储图 key 是起始点 list存临接点
     */
    private void dfs2FindMaxDistanceNode(int currentIndex, int currentDistance, boolean[] visit,
                                         int[] previousNode, List<Integer>[] graph) {
        // 更改 最大信息
        if (currentDistance > maxDistance) {
            maxDistance = currentDistance;
            farthestNode = currentIndex;
        }
//        System.out.println(currentIndex + "," + currentDistance + "," + + maxDistance + "," + farthestNode);
        // 修改visit 当前index 组装调用信息
//        取出list【currentindex】fore
        for (int nextIndex : graph[currentIndex]) {
//        对每个点递归调用 dfs方法
            if (visit[nextIndex]) {
                continue;
            }
            visit[nextIndex] = true;
            previousNode[nextIndex] = currentIndex;
            dfs2FindMaxDistanceNode(nextIndex, currentDistance + 1, visit, previousNode, graph);
        }
    }




	public static void main(String[] args) {
		Solution solution = new Solution();

//        int n = 4;
//		int[][] edges = {{1, 0}, {1, 2}, {1, 3}};

        int n = 6;
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};

		List<Integer> nodes = solution.findMinHeightTrees(n, edges);
        System.out.println(nodes);
    }
}
