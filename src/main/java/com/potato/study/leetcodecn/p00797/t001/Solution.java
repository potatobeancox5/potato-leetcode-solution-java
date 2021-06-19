package com.potato.study.leetcodecn.p00797.t001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * 797. 所有可能的路径
 *
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）

 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。

  

 示例 1：



 输入：graph = [[1,2],[3],[3],[]]
 输出：[[0,1,3],[0,2,3]]
 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 示例 2：



 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 示例 3：

 输入：graph = [[1],[]]
 输出：[[0,1]]
 示例 4：

 输入：graph = [[1,2,3],[2],[3],[]]
 输出：[[0,1,2,3],[0,2,3],[0,3]]
 示例 5：

 输入：graph = [[1,3],[2],[3],[]]
 输出：[[0,1,2,3],[0,3]]
  

 提示：

 结点的数量会在范围 [2, 15] 内。
 你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 递归
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        List<Integer> path = new ArrayList<>();
        path.add(0);

        getPath(graph, visited, path, result);
        return result;
    }


    private void getPath(int[][] graph, boolean[] visited, List<Integer> path, List<List<Integer>> result) {
        if (null == path || path.size() == 0) {
            return;
        }
        Integer start = path.get(path.size() - 1);
        // 如果 path 最后一个 位置 是 n-1 那么直接将当前path 放入 结果中
        if (start == graph.length - 1) {
            result.add(path);
            return;
        }
        visited[start] = true;
        // 否则 从 graph 中获取到下一个点 进行遍历 判断是否visited 过
        for (int i = 0; i < graph[start].length; i++) {
            int end = graph[start][i];
            if (visited[end]) {
                continue;
            }
            List<Integer> nextPath = new ArrayList<>(path);
            nextPath.add(end);
            getPath(graph, visited, nextPath, result);
        }
        // 如果没有了点就返回吧
        visited[start] = false;
        return;
    }
}
