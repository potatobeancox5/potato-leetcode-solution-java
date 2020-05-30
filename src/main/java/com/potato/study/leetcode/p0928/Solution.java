package com.potato.study.leetcode.p0928;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	928. Minimize Malware Spread II
 *  
 *       (This problem is the same as Minimize Malware Spread, with the differences bolded.)

In a network of nodes, each node i is directly connected to another node j if and only if graph[i][j] = 1.

Some nodes initial are initially infected by malware.  Whenever two nodes are directly connected and at least one of those two nodes is infected by malware, both nodes will be infected by malware.  This spread of malware will continue until no more nodes can be infected in this manner.

Suppose M(initial) is the final number of nodes infected with malware in the entire network, after the spread of malware stops.

We will remove one node from the initial list, completely removing it and any connections from this node to any other node.  Return the node that if removed, would minimize M(initial).  If multiple nodes could be removed to minimize M(initial), return such a node with the smallest index.



Example 1:

Input: graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
Output: 0
Example 2:

Input: graph = [[1,1,0],[1,1,1],[0,1,1]], initial = [0,1]
Output: 1
Example 3:

Input: graph = [[1,1,0,0],[1,1,1,0],[0,1,1,1],[0,0,1,1]], initial = [0,1]
Output: 1


Note:

1 < graph.length = graph[0].length <= 300
0 <= graph[i][j] == graph[j][i] <= 1
graph[i][i] = 1
1 <= initial.length < graph.length
0 <= initial[i] < graph.length
 *         
 *         题目含义：
 *
 *
 *         思路：
 *          https://leetcode-cn.com/problems/minimize-malware-spread-ii/solution/jin-liang-jian-shao-e-yi-ruan-jian-de-chuan-bo-ii-/
 *
 * 
 */
public class Solution {


    public int minMalwareSpread(int[][] graph, int[] initial) {
        int length = graph.length;
        int[] clean = new int[length];
        Arrays.fill(clean, 1);
        for (int x: initial) {
            clean[x] = 0;
        }

        // For each node u in initial, dfs to find
        // 'seen': all nodes not in initial that it can reach.
        List<Integer>[] infectedBy = new ArrayList[length];
        for (int i = 0; i < length; ++i) {
            infectedBy[i] = new ArrayList();
        }

        for (int u: initial) {
            Set<Integer> seen = new HashSet<>();
            dfs(graph, clean, u, seen);
            for (int v: seen) {
                infectedBy[v].add(u);
            }
        }

        // For each node u in initial, for every v not in initial
        // that is uniquely infected by u, add 1 to the contribution for u.
        int[] contribution = new int[length];
        for (int v = 0; v < length; ++v) {
            if (infectedBy[v].size() == 1) {
                contribution[infectedBy[v].get(0)]++;
            }
        }

        // Take the best answer.
        Arrays.sort(initial);
        int ans = initial[0], ansSize = -1;
        for (int u: initial) {
            int score = contribution[u];
            if (score > ansSize || score == ansSize && u < ans) {
                ans = u;
                ansSize = score;
            }
        }
        return ans;
    }

    public void dfs(int[][] graph, int[] clean, int u, Set<Integer> seen) {
        for (int v = 0; v < graph.length; ++v) {
            if (graph[u][v] == 1 && clean[v] == 1 && !seen.contains(v)) {
                seen.add(v);
                dfs(graph, clean, v, seen);
            }
        }
    }

}
