package com.potato.study.leetcode.p0332;

import java.util.*;

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
 *          332. Reconstruct Itinerary
map记录票信息
key 始发站 value->list 终点列表 list 按照字母排序
按照始发遍历map


https://www.jianshu.com/p/35aea2ab3d4a
访问时 remove边 回溯时加回来
1. 转换map key 始发 value 终点list 排序
2. reslist 存放路径 出始 添加 始发点
3. 递归生成路径
4. 返回
5.

生成路径 currentcity reslist curresult 图map
if map 没有currcity return false
for 取出当前path 并删除当前path 从map中
boolean 递归找下一个结点
找到 if 返回的是true return
没找到 加回来之前的那个结点 return false
 *
 * 
 */
public class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        // 1. 使用 map 记录 图 key 始发 value 终点list 排序
        Map<String, List<String>> sortedDestinationMap = buildSortedDestinationMap(tickets);
        // 2. 从给定起点开始 dfs 一直找到最终的路径即可
        List<String> finallyPath = new ArrayList<>();
        findItineraryDfs(finallyPath, "JFK", sortedDestinationMap, new ArrayList<>(), tickets.size());
        // 3. 返回结果
        finallyPath.add(0, "JFK");
        return finallyPath;
    }

    /**
     * 生成 map 结果 存储 始发点到终点结构
     * @param tickets
     * @return
     */
    private Map<String,List<String>> buildSortedDestinationMap(List<List<String>> tickets) {
        if (null == tickets || tickets.size() == 0) {
            return new HashMap<>();
        }
        Map<String,List<String>> res = new HashMap<>();
        for (List<String> fromToCityArr : tickets) {
            List<String> destinationList = res.get(fromToCityArr.get(0));
            if (null == destinationList || destinationList.size() == 0) {
                List<String> destinations = new ArrayList<>();
                destinations.add(fromToCityArr.get(1));
                res.put(fromToCityArr.get(0), destinations);
            } else {
                destinationList.add(fromToCityArr.get(1));
            }
        }
        // 排序
        for (Map.Entry<String, List<String>> entry : res.entrySet()) {
            Collections.sort(entry.getValue());
        }
        return res;
    }

    /**
     *
     * @param finallyPath       最终路线
     * @param from              当前出发城市
     * @param figure            存储的图结构
     * @param currentTempPath   当前已经走过的路线
     */
    private void findItineraryDfs(List<String> finallyPath, String from, Map<String,List<String>> figure, List<String> currentTempPath, int total) {
        // 终结条件 票的点数量等于key数量
        if (currentTempPath.size() == total) {
            finallyPath.addAll(currentTempPath);
        }
        // 　找到 from 的每个目的地 依次往下找他们的目的地
        List<String> currentDestinationList = figure.get(from);
        if (null == currentDestinationList) {
            return;
        }
        for (int i = 0; i < currentDestinationList.size(); i++) {
            // 记录当前票被使用
            String destination = currentDestinationList.remove(i);
            currentTempPath.add(destination);
            findItineraryDfs(finallyPath, destination, figure, currentTempPath, total);
            if (null != finallyPath && finallyPath.size() != 0) {
                return;
            }
            currentTempPath.remove(currentTempPath.size() - 1);
            currentDestinationList.add(destination);
            Collections.sort(currentDestinationList);
        }
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//        String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        List<String> itinerary = solution.findItinerary(null);
        System.out.println(itinerary);
	}
}
