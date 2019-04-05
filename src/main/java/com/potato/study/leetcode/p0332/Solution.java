package com.potato.study.leetcode.p0332;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         332. Reconstruct Itinerary
 * 
 *         Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
But it is larger in lexical order.
 * 
 *         思路： dfs
 *          代码提示：
 *          https://blog.csdn.net/jmspan/article/details/51279044
 *          一笔画问题 欧拉七桥问题
 *          本质是有向图边的遍历
 *          https://www.cnblogs.com/zmyvszk/p/5657056.html
 *
 * 
 */
public class Solution {

    public List<String> findItinerary(String[][] tickets) {

        List<String> res = new ArrayList<>();

        // 深度优先搜索
//        dfs(res, );
        return null;
    }

    private void dfs(List<String> res, String from) {
        // 终结条件
        if (true) {

        }
        // 　找到 from 的每个目的地

    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        String[][] tickets = {};

        List<String> itinerary = solution.findItinerary(tickets);
        System.out.println(itinerary);
	}
}
