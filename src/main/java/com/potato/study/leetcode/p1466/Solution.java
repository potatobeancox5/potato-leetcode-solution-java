package com.potato.study.leetcode.p1466;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 
 * @author liuzhao11
 * 
 * 	1466. Reorder Routes to Make All Paths Lead to the City Zero
 *  
 *
There are n cities numbered from 0 to n-1 and n-1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [a, b] represents a road from city a to b.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach the city 0 after reorder.



Example 1:



Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:



Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0


Constraints:

2 <= n <= 5 * 10^4
connections.length == n-1
connections[i].length == 2
0 <= connections[i][0], connections[i][1] <= n-1
connections[i][0] != connections[i][1]
 *         
 *
 *
 *
 * 思路：
 * https://leetcode-cn.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/solution/ru-guo-ke-yi-zai-gei-wo-yi-ge-bfsde-ji-hui-by-suri/
 *
 *
 */
public class Solution {


    public int minReorder(int n, int[][] connections) {
        //遍历整个数组,构建一个可达图，这里的可达的定义为联通即可，不在乎方向（但是这里我用负数代表了反方向，方便后续统计）
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] val : connections) {
            HashSet<Integer> set = map.containsKey(val[0]) ? map.get(val[0]) : new HashSet<>();
            set.add(val[1]);
            map.put(val[0], set);
            HashSet<Integer> setReverse = map.containsKey(val[1]) ? map.get(val[1]) : new HashSet<>();
            setReverse.add(val[0] * -1);
            map.put(val[1], setReverse);
        }
        return mybfs(map, n);
    }

    private int mybfs(HashMap<Integer, HashSet<Integer>> map, int n) {
        boolean[] tBool = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        int ans = 0;
        queue.offerLast(0);
        tBool[0] = true;
        while (!queue.isEmpty()) {
            for (Integer i : map.get(queue.pollFirst())) {
                //访问之后禁止再访问
                if (tBool[Math.abs(i)]) {
                    continue;
                }
                //前面说到，我们用负数代表了反方向，这里就用作统计了，如果是正数，就说明方向需要调整，建议仔细品味下
                if (i > 0) {
                    ans++;
                }
                tBool[Math.abs(i)] = true;
                queue.offerLast(Math.abs(i));
            }
        }
        return ans;
    }

}
