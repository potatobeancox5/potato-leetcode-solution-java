package com.potato.study.leetcode.p0216;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liuzhao11
 * 
 *         216. Combination Sum III
 * 
 * 			Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]


    题目需求：
        https://blog.csdn.net/sinat_32547403/article/details/78493705
        求出 1- 9 中 选取 k个数字 ，和为n的各种情况
    思路：
        其实是dfs 深度优先搜索


 */
public class Solution {


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpResult = new ArrayList<>();
        dfs(result, k, n, tmpResult, 0);
        return result;
    }


    /**
     * dfs 查找和为k 的n 个 数字
     * @param result        最终结果集
     * @param k             寻找数字的个数
     * @param n             目标数字
     * @param tmpResult     本次查找的结果
     */
    private void dfs(List<List<Integer>> result, int k, int n, List<Integer> tmpResult, int lastNum) {
        // 判断是否已经结束了
        if (k == 0 && n == 0) { // 找到可以直接返回了
            List<Integer> currentResult = new ArrayList<>();
            currentResult.addAll(tmpResult);
            result.add(currentResult);
            return;
        } else if (k == 0) { // 找偏了
            return;
        }
        // 遍历 lastNum + 1 - 9 递归查找，每次查找将结果 放到 tmpResult中 没找到直接移除
        for (int i = lastNum + 1; i <= 9; i++) {
            // i -> tmpresult
            tmpResult.add(i);
            dfs(result, k - 1, n - i, tmpResult, i);
            // i out tmpresult
            tmpResult.remove(tmpResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution() ;

//        int k = 3;
//        int n = 7;
        int k = 3;
        int n = 9;

        List<List<Integer>> lists = solution.combinationSum3(k, n);
        System.out.println(lists);

    }



}
