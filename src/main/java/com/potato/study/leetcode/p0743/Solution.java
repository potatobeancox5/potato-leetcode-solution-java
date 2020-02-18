package com.potato.study.leetcode.p0743;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	743. Network Delay Time
 *  
 *         There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node,
and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.



Example 1:



Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2


Note:

N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 *
 * 思路：
 *  给出一个 图 求从图中某一个点出发 达到其他点最小长度
 *
 *  minPath 记录 到达这个点最小的值 默认是 -1 不可达
 *
 *  bfs 从起始点开始 依次将邻接点 加入其中 每加入一个点修改 minPath min {minPath[i], minPath[邻接source] + 边长}
 *
 *  转化 times 转化成map
 *
 *
 *  https://www.jianshu.com/p/0a1abade476f
 *
 *
 *
 *
 *
 */
public class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        // 0. times 转化成map key 源头节点 value list time 最终的值 是总计需要的时间
        Map<Integer, Map<Integer, Integer>> graphMap = new HashMap<>();
        // from 1 - n add to graphMap to avoid npe
        for (int i = 1; i <= n; i++) {
            graphMap.put(i, new HashMap<>());
        }


        for (int[] time : times) {
            Map<Integer, Integer> edges = graphMap.getOrDefault(time[0], new HashMap<>());
            edges.put(time[1], time[2]);
            graphMap.put(time[0], edges);
        }
        // 1 从k 节点开始 依次找到边 并加入queue 每次修改 minPath 数组 按照时间进行比较
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        Map<Integer, Integer> timeMap = new HashMap<>();
        timeMap.put(k, 0);
        priorityQueue.addAll(graphMap.get(k).entrySet());
        int maxTime = 0;
        // 2 遍历 minPath 如果出现 -1 直接返回 -1 否则 找到最大节点
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Integer, Integer> nodeEdge = priorityQueue.poll();
            int toNode = nodeEdge.getKey();
            int time = nodeEdge.getValue();
            // 因为按照距离排序了 再次发现的点一定比之前发现的点时间长
            if (timeMap.containsKey(toNode)) {
                continue;
            }
            timeMap.put(toNode, time);
            maxTime = Math.max(maxTime, time);
            // 修改之后的临界点
            for (Map.Entry<Integer, Integer> next : graphMap.get(toNode).entrySet()) {
                // 增加时间
                next.setValue(next.getValue() + time);
                priorityQueue.add(next);
            }
        }

        if (timeMap.size() != n) {
            return -1;
        }
        return maxTime;
    }
	

	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        int num = solution.networkDelayTime(times, n, k);
		System.out.println(num);
        Assert.assertEquals(2, num);

        times = new int[][]{{1,2,1}};
        n = 2;
        k = 2;
        num = solution.networkDelayTime(times, n, k);
        System.out.println(num);
        Assert.assertEquals(-1, num);

        times = new int[][]{{1,2,1}, {2,1,3}};
        n = 2;
        k = 2;
        num = solution.networkDelayTime(times, n, k);
        System.out.println(num);
        Assert.assertEquals(3, num);
//

    }
}
