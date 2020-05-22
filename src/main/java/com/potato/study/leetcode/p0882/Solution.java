package com.potato.study.leetcode.p0882;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author liuzhao11
 *
 * 882. Reachable Nodes In Subdivided Graph
 *
 *
 * Starting with an undirected graph (the "original graph") with nodes from 0 to N-1, subdivisions are made to some of the edges.

The graph is given as follows: edges[k] is a list of integer pairs (i, j, n) such that (i, j) is an edge of the original graph,

and n is the total number of new nodes on that edge.

Then, the edge (i, j) is deleted from the original graph, n new nodes (x_1, x_2, ..., x_n) are added to the original graph,

and n+1 new edges (i, x_1), (x_1, x_2), (x_2, x_3), ..., (x_{n-1}, x_n), (x_n, j) are added to the original graph.

Now, you start at node 0 from the original graph, and in each move, you travel along one edge.

Return how many nodes you can reach in at most M moves.



Example 1:

Input: edges = [[0,1,10],[0,2,1],[1,2,2]], M = 6, N = 3
Output: 13
Explanation:
The nodes that are reachable in the final graph after M = 6 moves are indicated below.

Example 2:

Input: edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], M = 10, N = 4
Output: 23


Note:

0 <= edges.length <= 10000
0 <= edges[i][0] < edges[i][1] < N
There does not exist any i != j for which edges[i][0] == edges[j][0] and edges[i][1] == edges[j][1].
The original graph has no parallel edges.
0 <= edges[i][2] <= 10000
0 <= M <= 10^9
1 <= N <= 3000
A reachable node is a node that can be travelled to using at most M moves starting from node 0.
 *
 *
 * 题目含义：
 *
 *
 * 思路：
 *      https://leetcode-cn.com/problems/reachable-nodes-in-subdivided-graph/solution/java-bfs-priorityqueue-by-jake-song/
 *
 *
 *
 */
public class Solution {

    public int reachableNodes(int[][] edges, int mm, int nn) {

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], t -> new HashMap<>()).put(edge[1], edge[2]);
            map.computeIfAbsent(edge[1], t -> new HashMap<>()).put(edge[0], edge[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[]{mm, 0});
        Map<Integer, Integer> seen = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            // step remain
            int step = top[0];
            // current node
            int node = top[1];
            if (!seen.containsKey(node)) {
                seen.put(node, step);
                if (map.containsKey(node)) {
                    for (int next : map.get(node).keySet()) {
                        // distance between current node and next node
                        int distance = map.get(node).get(next);
                        int left = step - distance - 1;
                        if (left >= 0 && map.containsKey(next)) {
                            pq.add(new int[]{left, next});
                        }
                    }
                }
            }
        }
        int res = seen.size();
        for (int[] edge : edges) {
            int a = seen.getOrDefault(edge[0], 0);
            int b = seen.getOrDefault(edge[1], 0);
            res += Math.min(a + b, edge[2]);
        }
        return res;
    }


    public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] edges = new int[][]{{0,1,10},{0,2,1},{1,2,2}};
        int m = 6;
        int n = 3;
        int result = solution.reachableNodes(edges, m, n);
        System.out.println(result);
        Assert.assertEquals(13, result);

    }
}
