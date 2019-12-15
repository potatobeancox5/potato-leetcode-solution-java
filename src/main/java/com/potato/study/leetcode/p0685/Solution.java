package com.potato.study.leetcode.p0685;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         685. Redundant Connection II
 * 
 *         In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
1
/ \
v   v
2-->3
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
^    |
|    v
4 <- 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 *
 *         思路：
 *
 *         https://leetcode.com/problems/redundant-connection-ii/discuss/450408/My-Union-Find-solution-written-in-Java-with-clear-explanation-time-beats-97
 *
 *          3中情况
 *          1. 每个点都只有一个父亲节点 但有一个圈
 *          2. 有节点 有两个父亲节点
 *          3. 有一个节点有两个父亲节点，其中一个在圈里
 *
 *
 *
 */
public class Solution {


    public int[] findRedundantDirectedConnection(int[][] edges) {

        // 0. 初始化 并查集数据结构
        int n = edges.length;
        int[] unionSet = new int[n+1];
        for (int i = 0; i < unionSet.length; i++) {
            unionSet[i] = i;
        }
        // 删除的那个边
        int[] result = new int[2];
        int child = 0;
        int[] parents = new int[2];
        // 1. 遍历边
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            // 找到两个点的公共祖先
            int parentOfFrom = this.findParent(unionSet, from);
            int parentOfTo = this.findParent(unionSet, to);
            if (parentOfFrom == parentOfTo && child == 0) {
                result = edge;
            } else if (parentOfTo != to) {
                child = to;
                parents[0] = unionSet[to];
                parents[1] = from;
            } else {
                unionSet[to] = from;
            }
        }
        // 2. 最终确认要删除哪个边
        if (child != 0) {
            int root1 = this.findParent(unionSet, parents[0]);
            int root2 = this.findParent(unionSet, parents[1]);
            if (root1 == root2 || root2 == 0) {
                result = new int[]{parents[1], child};
            } else {
                result = new int[]{parents[0], child};
            }
        }

        return result;
    }


    /**
     * 找到 target 的祖先
     * @param unionSet
     * @param target
     * @return
     */
    private int findParent(int[] unionSet, int target) {
        int i = target;
        while (unionSet[i] != i) {
            i = unionSet[i];
            // 找到了最开始的点 返回0
            if (target == i) {
                return 0;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] edges = {{1,2}, {1,3}, {2,3}};
        int[] points = solution.findRedundantDirectedConnection(edges);
        System.out.println(Arrays.toString(points));


        int[][] edges1 = {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
        int[] points1 = solution.findRedundantDirectedConnection(edges1);
        System.out.println(Arrays.toString(points1));
    }

}
