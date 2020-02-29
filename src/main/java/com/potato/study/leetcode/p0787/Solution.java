package com.potato.study.leetcode.p0787;

import org.junit.Assert;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author liuzhao11
 * 
 * 	787. Cheapest Flights Within K Stops
 *  
 *        There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
Note:

The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.


 *
 *
 *   解题思路：
 *
 *   https://www.cnblogs.com/lightwindy/p/9613690.html
 *
 *   迪杰斯特拉
 *
 * 
 */
public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // 0 使用map 存出发到目的地票价 map 开始 map 重点 票价
        Map<Integer, Map<Integer, Integer>> priceMap = new HashMap<>();
        for (int[] flight : flights) {
            Map<Integer, Integer> map = priceMap.getOrDefault(flight[0], new HashMap<>());
            map.put(flight[1], flight[2]);
            priceMap.put(flight[0], map);
        }
        // 1 优先队列 存 总价 当前城市 可以往前走的步数 然后入队第一个数据 0 src k+1 按照总价格排序
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        priorityQueue.add(new int[]{0, src, k+1});
        // 2 依次出队 到达最终点 返回总价 否则 stop > 0 时 遍历邻接点 将临界点分别入队
        while (!priorityQueue.isEmpty()) {
            int[] cost = priorityQueue.poll();
            int totalCost = cost[0];
            int city = cost[1];
            int stop = cost[2];
            if (city == dst) {
                return totalCost;
            }
            if (stop > 0) {
                Map<Integer, Integer> priMap = priceMap.get(city);

                if (null == priMap || priMap.size() == 0) {
                    continue;
                }

                for (int desCity : priMap.keySet()) {
                    priorityQueue.add(new int[]{totalCost + priMap.get(desCity), desCity, stop - 1});
                }
            }
        }
        return -1;
    }



	
	public static void main(String[] args) {
		Solution solution = new Solution();

        int n = 3;
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 1;

        int cost = solution.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cost);
        Assert.assertEquals(200, cost);

        n = 3;
        flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        src = 0;
        dst = 2;
        k = 0;

        cost = solution.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cost);
        Assert.assertEquals(500, cost);

        n = 5;
        flights = new int[][]{{4,1,1},{1,2,3},{0,3,2}, {0,4,10}, {3,1,1}, {1,4,3}};
        src = 2;
        dst = 1;
        k = 1;

        cost = solution.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cost);
        Assert.assertEquals(-1, cost);
    }
}
