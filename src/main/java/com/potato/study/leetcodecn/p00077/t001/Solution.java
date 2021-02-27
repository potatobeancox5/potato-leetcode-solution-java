package com.potato.study.leetcodecn.p00077.t001;


import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

 示例:

 输入: n = 4, k = 2
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/combinations
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        // 初始化 结果集合
        List<List<Integer>> result = new ArrayList<>();
        // 选择不同的起点 开始dfs
        for (int i = 1; i <= n; i++) {
            dfs(n, k, i, new ArrayList<>(), result);
        }
        return result;
    }

    /**
     *
     * @param n
     * @param k
     * @param current           当前遍历到的数组 后续只能从 （ current  n 里边选
     * @param currentResult
     * @param result
     */
    private void dfs(int n, int k, int current, List<Integer> currentResult, List<List<Integer>> result) {
        // 否则 当前 数字作为结果接的一部分
        List<Integer> eachResult = new ArrayList<>(currentResult);
        eachResult.add(current);
        if (eachResult.size() == k) {
            result.add(new ArrayList<>(eachResult));
            return;
        }
        // 遍历 后续的元素
        for (int i = current + 1; i <= n; i++) {
            dfs(n, k, i, eachResult, result);
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = solution.combine(n, k);
        System.out.println(combine);
    }
}
