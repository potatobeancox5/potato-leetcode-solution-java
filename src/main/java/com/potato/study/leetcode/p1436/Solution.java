package com.potato.study.leetcode.p1436;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	1436. Destination City
 *  
 *
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.



Example 1:

Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo"
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
Example 2:

Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are:
"D" -> "B" -> "C" -> "A".
"B" -> "C" -> "A".
"C" -> "A".
"A".
Clearly the destination city is "A".
Example 3:

Input: paths = [["A","Z"]]
Output: "Z"


Constraints:

1 <= paths.length <= 100
paths[i].length == 2
1 <= cityAi.length, cityBi.length <= 10
cityAi != cityBi
All strings consist of lowercase and uppercase English letters and the space character.
 *         
 *
 *
 *
 * 思路：
 *   找到那个没有只能到达不能出发的城市
 *
 *   https://leetcode-cn.com/problems/destination-city/solution/5400java-ha-xi-biao-gao-qi-lai-by-ustcyyw/
 *
 *
 *
 *
 */
public class Solution {


    public String destCity(List<List<String>> paths) {
        // 构造 map 出发 到达
        Map<String, String> pathMap = new HashMap<>();
        for (List<String> p : paths) {
            pathMap.put(p.get(0), p.get(1));
        }
        //  从第一个点开始走，如果发现 达到不能是不在keys 里 那就是这个了
        String start = paths.get(0).get(0);
        while (true) {
            if (!pathMap.containsKey(start)) {
                return start;
            }
            start = pathMap.get(start);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        List<List<String>> paths = new ArrayList<>();
//        List<Boolean> res = solution.destCity(candies, extraCandies);
//        System.out.println(res); // true,true,true,false,true

    }
}
