package com.potato.study.leetcode.p0815;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	815. Bus Routes
 *  
 *         We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.

We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.

Example:
Input:
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation:
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.


Constraints:

1 <= routes.length <= 500.
1 <= routes[i].length <= 10^5.
0 <= routes[i][j] < 10 ^ 6.
 *         
 *         思路：
 *
 * 815. Bus Routes

https://www.jianshu.com/p/519f6b93e15c

    将每个bus 作为 站点 根据是否有交叉 判定 bus 是否可以换乘
https://www.jianshu.com/p/519f6b93e15c
 */
public class Solution {

    /**
     *
     * @param routes i bus i 停靠的站点
     * @param s
     * @param t
     * @return
     */
    public int numBusesToDestination(int[][] routes, int s, int t) {

        // 简单判断起点是不是终点
        if (s == t) {
            return 0;
        }
        int n = routes.length;
        // routes 转换成一个map 存储 key 是 车id value 是set 车停靠的站点
        Map<Integer, Set<Integer>> routeMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int key = i;
            Set<Integer> set = new HashSet<>();
            for (int stop : routes[i]) {
                set.add(stop);
            }
            routeMap.put(key, set);
        }
        // graph key 车id balue list 可以换成的车
        Map<Integer, List<Integer>> busGraph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = i + 1; j < routes.length; j++) {
                Set<Integer> set1 = routeMap.get(i);
                Set<Integer> set2 = routeMap.get(j);
                if (hasIntersection(set1, set2)) {
                    List<Integer> list1 = busGraph.getOrDefault(i, new ArrayList<>());
                    List<Integer> list2 = busGraph.getOrDefault(j, new ArrayList<>());
                    list1.add(j);
                    list2.add(i);
                    busGraph.put(i, list1);
                    busGraph.put(j, list2);
                }
            }
        }
        // queue 初始将起始位置的车都add 进去 计数器 bfs
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hasTokenBus = new HashSet<>();
        int times = 1;
        // 将开始可以乘坐的车add 入queue
        for (int i = 0; i < routes.length; i++) {
            Set<Integer> set = routeMap.get(i);
            if (set.contains(s)) {
                queue.add(i);
                hasTokenBus.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer bus = queue.poll();
                if (routeMap.get(bus).contains(t)) {
                    return times;
                }
                // 加入可以换乘的车

                if (!busGraph.containsKey(bus)) {
                    continue;
                }

                for (int nextBus : busGraph.get(bus)) {
                    if (!hasTokenBus.contains(nextBus)) {
                        hasTokenBus.add(nextBus);
                        queue.add(nextBus);
                    }
                }
            }
            times++;
        }
        return -1;
    }


    /**
     * 判断两个set 是否有交集
     * @param set1
     * @param set2
     * @return
     */
    private boolean hasIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.isEmpty() || set2.isEmpty()) {
            return false;
        }
        for (int num : set1) {
            if (set2.contains(num)) {
                return true;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();
        int[][] routes = new int[][]{{1, 2, 7}, {3, 6, 7}};
        int s = 1;
        int t = 6;
        int res = solution.numBusesToDestination(routes, s, t);
        System.out.println(res);
        Assert.assertEquals(2, res);


        routes = new int[][]{{1}, {15,16,18}, {10}, {3,4,12,14}};
        s = 3;
        t = 15;
        res = solution.numBusesToDestination(routes, s, t);
        System.out.println(res);
        Assert.assertEquals(-1, res);

    }
}
