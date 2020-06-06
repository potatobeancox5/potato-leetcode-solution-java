package com.potato.study.leetcode.p1334;



import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author liuzhao11
 * 
 * 	1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 *  
 *
here are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.



Example 1:



Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
Output: 3
Explanation: The figure above describes the graph.
The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2]
City 1 -> [City 0, City 2, City 3]
City 2 -> [City 0, City 1, City 3]
City 3 -> [City 1, City 2]
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
Example 2:



Input: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
Output: 0
Explanation: The figure above describes the graph.
The neighboring cities at a distanceThreshold = 2 for each city are:
City 0 -> [City 1]
City 1 -> [City 0, City 4]
City 2 -> [City 3, City 4]
City 3 -> [City 2, City 4]
City 4 -> [City 1, City 2, City 3]
The city 0 has 1 neighboring city at a distanceThreshold = 2.


Constraints:

2 <= n <= 100
1 <= edges.length <= n * (n - 1) / 2
edges[i].length == 3
0 <= fromi < toi < n
1 <= weighti, distanceThreshold <= 10^4
All pairs (fromi, toi) are distinct.
 *         
 *         思路：
 *
 *
 *         https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/solution/spfa-ji-suan-dan-yuan-zui-duan-lu-jing-java-by-jer/
 *
 */
public class Solution {

    int[][] map;
    int[] dist;
    boolean[] set;
    Queue<Integer> queue;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        map = new int[n][n];
        for (int[] e : edges) {
            map[e[0]][e[1]] = map[e[1]][e[0]] = e[2];
        }
        int min = n + 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int temp = bfs(i, distanceThreshold, n);
            if (temp <= min) {
                min = temp;
                res = i;
            }
        }
        return res;
    }


    //s = start
    private int bfs(int s, int distanceThreshold, int n) {
        queue = new LinkedList<>();
        dist = new int[n];
        set = new boolean[n];
        Arrays.fill(dist, -1);
        Arrays.fill(set, false);

        dist[s] = 0;
        set[s] = true;
        queue.offer(s);

        //SPFA
        while (!queue.isEmpty()) {
            Integer v1= queue.poll();
            for (int v2 = 0; v2 < map[v1].length; v2++) {
                if (map[v1][v2] != 0) {
                    int w = map[v1][v2];
                    if (dist[v2] == -1 || dist[v2] > dist[v1] + w) {
                        dist[v2] = dist[v1] + w;
                        if (!set[v2]) {
                            set[v2] = true;
                            queue.offer(v2);
                        }
                    }
                }
            }
            set[v1] = false;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == -1) {
                continue;
            }
            if (dist[i] <= distanceThreshold) {
                res++;
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]+" ");
        }

        return res;
    }
}
