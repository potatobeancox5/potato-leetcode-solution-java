package com.potato.study.leetcode.p1192;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	1192. Critical Connections in a Network
 *  
 *
There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.

Return all critical connections in the network in any order.



Example 1:



Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.


Constraints:

1 <= n <= 10^5
n-1 <= connections.length <= 10^5
connections[i][0] != connections[i][1]
There are no repeated connections.
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/critical-connections-in-a-network/solution/1192-cha-zhao-ji-qun-nei-de-guan-jian-lian-jie-jav/
 *
 *
 *

 *
 */
public class Solution {

    private List<Integer>[] edges;
    private int[] dfn;
    private int[] low;
    private boolean[] visited;
    private List<List<Integer>> ans;
    private int t;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.edges = new ArrayList[n];
        this.dfn = new int[n];
        this.low = new int[n];
        this.visited = new boolean[n];
        this.ans = new ArrayList<>();
        this.t = 0;
        for(int i = 0; i < n; i ++) {
            edges[i] = new ArrayList<>();
        }
        for (List<Integer> conn : connections) {
            int n1 = conn.get(0), n2 = conn.get(1);
            edges[n1].add(n2);
            edges[n2].add(n1);
        }
        tarjan(0, -1);
        return ans;
    }

    public void tarjan(int cur, int pre) {
        t ++;
        dfn[cur] = t;
        low[cur] = t;
        visited[cur] = true;
        for (int node : edges[cur]) {
            if (node == pre) {
                continue;
            }
            if (!visited[node]) {
                tarjan(node, cur);
                low[cur] = Math.min(low[cur], low[node]);
                if (low[node] > dfn[cur]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(node);
                    ans.add(list);
                }
            } else {
                low[cur] = Math.min(low[cur], dfn[node]);
            }
        }
    }
}
