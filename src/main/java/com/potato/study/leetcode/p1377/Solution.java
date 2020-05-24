package com.potato.study.leetcode.p1377;


import java.util.HashMap;

/**
 * 
 * @author liuzhao11
 * 
 * 	1377. Frog Position After T Seconds
 *  
 *
Given an undirected tree consisting of n vertices numbered from 1 to n. A frog starts jumping from the vertex 1. In one second, the frog jumps from its current vertex to another unvisited vertex if they are directly connected. The frog can not jump back to a visited vertex. In case the frog can jump to several vertices it jumps randomly to one of them with the same probability, otherwise, when the frog can not jump to any unvisited vertex it jumps forever on the same vertex.

The edges of the undirected tree are given in the array edges, where edges[i] = [fromi, toi] means that exists an edge connecting directly the vertices fromi and toi.

Return the probability that after t seconds the frog is on the vertex target.



Example 1:



Input: n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
Output: 0.16666666666666666
Explanation: The figure above shows the given graph. The frog starts at vertex 1, jumping with 1/3 probability to the vertex 2 after second 1 and then jumping with 1/2 probability to vertex 4 after second 2. Thus the probability for the frog is on the vertex 4 after 2 seconds is 1/3 * 1/2 = 1/6 = 0.16666666666666666.
Example 2:



Input: n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
Output: 0.3333333333333333
Explanation: The figure above shows the given graph. The frog starts at vertex 1, jumping with 1/3 = 0.3333333333333333 probability to the vertex 7 after second 1.
Example 3:

Input: n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 20, target = 6
Output: 0.16666666666666666


Constraints:

1 <= n <= 100
edges.length == n-1
edges[i].length == 2
1 <= edges[i][0], edges[i][1] <= n
1 <= t <= 50
1 <= target <= n
Answers within 10^-5 of the actual value will be accepted as correct.
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/frog-position-after-t-seconds/solution/jie-zhu-hashmapbu-yong-di-gui-he-hui-su-by-jie/
 *
 *
 *
 */
public class Solution {



    public double frogPosition(int n, int[][] edges, int t, int target) {
        for(int i = 0; i < n - 1; ++i){
            if(edges[i][0] > edges[i][1]){
                int tmp = edges[i][0];
                edges[i][0] = edges[i][1];
                edges[i][1] = tmp;
            }
        }
        int[] e = new int[n+1];//记录有几个子孙
        for(int i = 0; i < n - 1; ++i){
            int tmp = edges[i][0];
            e[tmp]++;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n - 1; ++i){
            map.put(edges[i][1], edges[i][0]);
        }//记录父亲
        int numt = 0;
        int cur = target;
        double res = 1;
        boolean sign = false;
        if(e[cur] != 0) {
            sign = true; //记录是否target还有子孙
        }
        while (cur != 1 && map.get(cur) != null) {
            cur = map.get(cur);
            ++numt;
            res *= e[cur];
        }
        if(cur != 1 || numt > t) {
            return 0.0;
        }
        if(sign && numt < t) {
            return 0.0;
        }
        return 1 / res;
    }


	public static void main(String[] args) {

    }
}
