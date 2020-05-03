package com.potato.study.leetcode.p0847;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	847. Shortest Path Visiting All Nodes
 *  
 *         An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.

graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.

Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.



Example 1:

Input: [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]
Example 2:

Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]


Note:

1 <= graph.length <= 12
0 <= graph[i].length < graph.length

 *         
 *         思路：
 *           https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/solution/java-yong-wei-cun-chu-zhuang-tai-bfswu-ren-he-qi-y/
 *
 *          使用 int 的12 个位 组成 状态 全是 1 代表完成了遍历
 * 
 */
public class Solution {

    public int shortestPathLength(int[][] graph) {
        int len = graph.length;
        if(graph == null || graph.length == 0){
            return 0;
        }
        // 标记是否访问过,用于避免重复访问
        boolean[][] visited = new boolean[len][1<<len];
        // 用于检查是否访问完所有的节点,每个位代表一个节点的状态,形如1111
        int finishState = (1<<len)-1;
        // 队列里的数组,第一个记录的是标号,第二个是状态
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<len; i++){
            queue.offer(new int[]{i, 1<<i});
        }
        int step = 0;
        while(!queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                int[] node = queue.poll();
                // 如果标记的节点访问状态是结束,那么返回步长
                if(finishState == node[1]){
                    return step;
                }
                for(int next: graph[node[0]]){
                    // 2个节点相或,标记着访问了这条边的2个点
                    int nextState = node[1]|(1<<next);
                    if(visited[next][nextState]){
                        continue;
                    }
                    visited[next][nextState] = true;
                    // 将该节点和边的信息加入bfs对列
                    queue.offer(new int[]{next,nextState});
                }
            }
            step++;
        }
        return step;
    }


	public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] graph = new int[][]{{1,2,3}, {0}, {0}, {0}};
        int len = solution.shortestPathLength(graph);
        System.out.println(len);
        Assert.assertEquals(4, len);

    }
}
