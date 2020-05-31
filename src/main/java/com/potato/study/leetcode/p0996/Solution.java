package com.potato.study.leetcode.p0996;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	  996. Number of Squareful Arrays
 *  
 *        Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

Return the number of permutations of A that are squareful.  Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].



Example 1:

Input: [1,17,8]
Output: 2
Explanation:
[1,8,17] and [17,8,1] are the valid permutations.
Example 2:

Input: [2,2,2]
Output: 1


Note:

1 <= A.length <= 12
0 <= A[i] <= 1e9
 *         
 *         思路：
 *  https://leetcode-cn.com/problems/number-of-squareful-arrays/solution/zheng-fang-xing-shu-zu-de-shu-mu-by-leetcode/
 */
public class Solution {


    private Map<Integer, Integer> count;
    private Map<Integer, List<Integer>> graph;


    public int numSquarefulPerms(int[] arr) {
        int length = arr.length;
        count = new HashMap<>();
        graph = new HashMap<>();

        // count.get(v) : 数组 A 中值为 v 的节点数量
        for (int x: arr) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // graph.get(v) : 在 A 中的值 w 满足 v + w 是完全平方数
        //                (ie., "vw" is an edge)
        for (int x: count.keySet()) {
            graph.put(x, new ArrayList<>());
        }

        for (int x: count.keySet()) {
            for (int y: count.keySet()) {
                int r = (int) (Math.sqrt(x + y) + 0.5);
                if (r * r == x + y) {
                    graph.get(x).add(y);
                }
            }
        }

        // 增加从 x 开始的可行路径数量
        int ans = 0;
        for (int x: count.keySet()) {
            ans += dfs(x, length - 1);
        }
        return ans;
    }

    private int dfs(int x, int todo) {
        count.put(x, count.get(x) - 1);
        int ans = 1;
        if (todo != 0) {
            ans = 0;
            for (int y: graph.get(x)) if (count.get(y) != 0) {
                ans += dfs(y, todo - 1);
            }
        }
        count.put(x, count.get(x) + 1);
        return ans;
    }

}
