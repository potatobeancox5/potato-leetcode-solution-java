package com.potato.study.leetcodecn.p01791.t001;

import com.google.common.collect.Lists;
import com.potato.study.leetcode.util.LeetcodeInputUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1791. 找出星型图的中心节点
 *
 * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。

 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。

  

 示例 1：


 输入：edges = [[1,2],[2,3],[4,2]]
 输出：2
 解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
 示例 2：

 输入：edges = [[1,2],[5,1],[1,3],[1,4]]
 输出：1
  

 提示：

 3 <= n <= 105
 edges.length == n - 1
 edges[i].length == 2
 1 <= ui, vi <= n
 ui != vi
 题目数据给出的 edges 表示一个有效的星型图

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-center-of-star-graph
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 edges 直接用map 邻接的点的个数吧
     * 然后 遍历 map 找 邻接点 数量是 n-1的
     * @param edges
     * @return
     */
    public int findCenter(int[][] edges) {
        if (null == edges || edges.length == 0) {
            throw new RuntimeException("输入有误");
        }
        // 遍历 edges 直接用map 邻接的点的个数吧
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int nodeIndex1 = edges[i][0];
            int nodeIndex2 = edges[i][1];
            Integer count1 = countMap.getOrDefault(nodeIndex1, 0);
            Integer count2 = countMap.getOrDefault(nodeIndex2, 0);

            count1++;
            count2++;

            countMap.put(nodeIndex1, count1);
            countMap.put(nodeIndex2, count2);
        }
        // 然后 遍历 map 找 邻接点 数量是 n-1的
        int targetCount = edges.length;
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            if (entry.getValue() == targetCount) {
                return entry.getKey();
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = LeetcodeInputUtils.inputString2IntArrayTwoDimensional("[[1,2],[2,3],[4,2]]");
        int index = solution.findCenter(edges);
        System.out.println(index);
        Assert.assertEquals(2, index);


        edges = LeetcodeInputUtils.inputString2IntArrayTwoDimensional("[[1,2],[5,1],[1,3],[1,4]]");
        index = solution.findCenter(edges);
        System.out.println(index);
        Assert.assertEquals(1, index);
    }
}
