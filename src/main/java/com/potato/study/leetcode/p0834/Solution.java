package com.potato.study.leetcode.p0834;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	834. Sum of Distances in Tree
 *  
 *         An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.

The ith edge connects nodes edges[i][0] and edges[i][1] together.

Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.

Example 1:

Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation:
Here is a diagram of the given tree:
0
/ \
1   2
/|\
3 4 5
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
Note: 1 <= N <= 10000


 *         
 *         思路：
 *
https://leetcode-cn.com/problems/sum-of-distances-in-tree/solution/shu-zhong-ju-chi-zhi-he-by-leetcode/
 *
 *
 *
 */
public class Solution {

    // 当前节点的结果
    private int[] res;
    // 子树的数量（包括这个节点）
    private int[] count;
    // 存储 邻接点关系
    private List<Set<Integer>> graph;

    private int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        graph = new ArrayList<>();
        res = new int[n];
        count = new int[n];
        // 包括树的节点
        Arrays.fill(count, 1);
        // 生成 graph
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        // dfs find
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        dfsCount(0, -1);
        dfsDistant(0, -1);
        return res;
    }

    /**
     *
     * @param node  当前节点 标号
     * @param parent 父亲标号
     */
    private void dfsCount(int node, int parent) {
        for (int childIndex : graph.get(node)) {
            if (childIndex != parent) {
                dfsCount(childIndex, node);
                count[node] += count[childIndex];
                res[node] += res[childIndex] + count[childIndex];
            }
        }
    }

    /**
     *
     * @param node  当前节点 标号
     * @param parent 父亲标号
     */
    private void dfsDistant(int node, int parent) {
        for (int childIndex: graph.get(node)) {
            if (childIndex != parent) {
                res[childIndex] = res[node] - count[childIndex] + n - count[childIndex];
                dfsDistant(childIndex, node);
            }
        }
    }


	public static void main(String[] args) {

        Solution solution = new Solution();

//        int n = 6;
//        int[][] edges = new int[][]{[0,1],[0,2],[2,3],[2,4],[2,5]};
//        System.out.println(res); // 8,12,6,10,10,10edges
//        Assert.assertEquals("eeebffff", res);


    }
}
