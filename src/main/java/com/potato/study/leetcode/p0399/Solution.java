package com.potato.study.leetcode.p0399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *       399. Evaluate Division
 * 
 *     Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].


The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 *         
 *         思路：
 *         https://segmentfault.com/a/1190000019073059?utm_medium=referral&utm_source=tuicool
 *
 *         被除数和除数 看成 图的顶点 a / b = 2 ， 2 代表 从a-b 边的权重
 *         如此只要对图进行dfs 遍历 并 记录 当前权重的乘积 即可
 *
 *         1. 将给定 表达式按照图的方式存在Map<String, List<String>> 中 Map<String, List<Double>> 存放这个边的权重
 *
 *         2. 遍历 queries dfs找到 从 a - b 的权重乘积 使用set记录 已经遍历过的节点 res 透传每次判断这个节点之前已经计算了多少个节点
 *
 *         https://segmentfault.com/a/1190000019073059?utm_medium=referral&utm_source=tuicool
 *
 *
 *
 *
 *         
 */
public class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {
        // 1. 将给定 表达式按照图的方式存在Map<String, List<String>> 中 Map<String, List<Double>> 存放这个边的权重
        Map<String, List<String>> pointMap = new HashMap<>();
        Map<String, List<Double>> edgeMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            // 被除数
            String dividend = equation.get(0);
            // 除数
            String divisor = equation.get(1);
            // 值
            double value = values[i];
            // 不存在先初始化
            if (!pointMap.containsKey(dividend)) {
                pointMap.put(dividend, new ArrayList<>());
                edgeMap.put(dividend, new ArrayList<>());
            }
            if (!pointMap.containsKey(divisor)) {
                pointMap.put(divisor, new ArrayList<>());
                edgeMap.put(divisor, new ArrayList<>());
            }
            // 将点插入map中
            pointMap.get(dividend).add(divisor);
            edgeMap.get(dividend).add(value);

            // 反向插入
            pointMap.get(divisor).add(dividend);
            edgeMap.get(divisor).add(1.0 / value);


        }
        // 2. 遍历 queries dfs找到 从 a - b 的权重乘积 使用set记录 已经遍历过的节点 res 透传每次判断这个节点之前已经计算了多少个节点
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            Set<String> visited = new HashSet<>();
            result[i] = dfsGetTheCalcEquation(pointMap, edgeMap, start, end, visited, 1.0);
        }
        return result;
    }


    /**
     *
     * @param pointMap  点map
     * @param edgeMap   边map
     * @param start     开始节点
     * @param end       结束节点
     * @param visited   已经遍历过的set
     * @param
     * @return
     */
    private double dfsGetTheCalcEquation(Map<String, List<String>> pointMap, Map<String, List<Double>> edgeMap,
                                         String start, String end, Set<String> visited, double currentRes) {
        // dfs找到 从 a - b 的权重乘积 使用set记录 已经遍历过的节点 res 透传每次判断这个节点之前已经计算了多少个节点
        if (!pointMap.containsKey(start)) {
            return -1.0;
        }
        // 访问过了 这条路不通
        if (visited.contains(start)) {
            return -1.0;
        }
        // 找到了 自身的节点 直接返回1.0
        if (start.equals(end)) {
            return currentRes;
        }
        List<String> destinationPointList = pointMap.get(start);
        List<Double> edgeList = edgeMap.get(start);
        for (int i = 0; i < destinationPointList.size(); i++) {
            String desPoint = destinationPointList.get(i);
            Double value = edgeList.get(i);
            visited.add(start);
            double tmpValue = dfsGetTheCalcEquation(pointMap, edgeMap, desPoint, end, visited, currentRes * value);
            if (tmpValue != -1.0) {
                return tmpValue;
            }
            visited.remove(start);
        }
        return -1.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> equations = new ArrayList<>();
        String[] aa = {"a","b"};
        String[] bb = {"b","c"};
        equations.add(Arrays.asList(aa));
        equations.add(Arrays.asList(bb));


        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();

        String[] cc = {"a","c"};
        String[] dd = {"b","a"};
        String[] ee = {"a","e"};
        String[] ff = {"a","a"};
        String[] hh = {"x","x"};
        queries.add(Arrays.asList(cc));
        queries.add(Arrays.asList(dd));
        queries.add(Arrays.asList(ee));
        queries.add(Arrays.asList(ff));
        queries.add(Arrays.asList(hh));

        double[] doubles = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(doubles));

    }
}

