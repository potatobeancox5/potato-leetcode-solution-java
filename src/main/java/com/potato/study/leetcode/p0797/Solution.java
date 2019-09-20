package com.potato.study.leetcode.p0797;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 * 	797. All Paths From Source to Target
 *  
 *         Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.
 *         
 *
 *         题目含义：
 *             给定一个有向无环图，找到从节点0到n-1的所有可能路径并返回
 *             入参是一个数组graph[i] 表示从 i 到 graph[i][0]....graph[i][j] 存在一条路径
 *         思路：
 *              采用dfs进行遍历
 *
 * 
 */
public class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 开始生成结果
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        this.dfs(graph, 0, graph.length - 1, result, path);
        return result;
    }

    /**
     * 深度有点搜索遍历一个图，返回路径
     * @param graph     入参是一个数组graph[i] 表示从 i 到 graph[i][0]....graph[i][j] 存在一条路径
     * @param position  当前所在的位置
     * @param target    目标节点位置
     * @param result    总的结果，最终返回的结果
     * @param path      走到当前位置的路径
     *
     */
    private void dfs(int[][] graph, int position, int target, List<List<Integer>> result,
                     List<Integer> path) {
        // 当前位置已经是最后一个node了
        if (position == target) {
            List<Integer> finalPath = new ArrayList<>(path);
            finalPath.add(position);
            result.add(finalPath);
            return;
        }
        // 当前位置不是最后一个位置，遍历当前可以去的地方，去那里
        for (int nextPosition : graph[position]) {
            path.add(position);
            dfs(graph, nextPosition, target, result, path);
            // 还原节点 下个节点继续dfs
            path.remove(path.size() - 1);
        }

    }
	

	public static void main(String[] args) {
//		MyCalendarThree solution = new MyCalendarThree();
    }
}
