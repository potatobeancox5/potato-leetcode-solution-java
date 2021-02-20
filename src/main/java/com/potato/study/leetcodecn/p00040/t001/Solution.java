package com.potato.study.leetcodecn.p00040.t001;

import com.potato.study.leetcode.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 40. 组合总和 II
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用一次。

 说明：

 所有数字（包括目标数）都是正整数。
 解集不能包含重复的组合。 
 示例 1:

 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 所求解集为:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 示例 2:

 输入: candidates = [2,5,2,1,2], target = 5,
 所求解集为:
 [
   [1,2,2],
   [5]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/combination-sum-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 也是 dp 存储 每个点的结果集合
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null && target == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        // dp i 标识 每到 i 有多少中组合
        Set<List<Integer>>[] dp = new Set[target+1];
        dp[0] = new HashSet<>();
        dp[0].add(new ArrayList<>());
        // 遍历 candidates 对每个 candidates dp i = dp i- candidates j + 结果集合
        for (int j = 0; j < candidates.length; j++) {
            // 之前的快照 使用深拷贝
//            Set<List<Integer>>[] newDp = Arrays.copyOf(dp, dp.length);
            Set<List<Integer>>[] newDp = this.deepCopy(dp);
            for (int i = 1; i < target + 1; i++) {
                // if dp i- candidates j 存在 需要 生成dp i
                if (i - candidates[j] < 0) {
                    continue;
                }
                if (null == dp[i - candidates[j]]) {
                    continue;
                }
                // 生成结果集 or 使用当前结果集合
                if (null == newDp[i]) {
                    newDp[i] = new HashSet<>();
                }
                for (List<Integer> eachList : dp[i - candidates[j]]) {
                    List<Integer> eachResult = new ArrayList<>(eachList);
                    eachResult.add(candidates[j]);
                    newDp[i].add(eachResult);
                }
            }
            // 生成的结果转正
            dp = newDp;
        }
        if (dp[target] == null) {
            dp[target] = new HashSet<>();
        }
        List<List<Integer>> result = new ArrayList<>(dp[target]);
        return result;
    }

    /**
     * 深度copy
     * @return
     */
    private Set<List<Integer>>[] deepCopy(Set<List<Integer>>[] dp) {
        Set<List<Integer>>[] newDp = new Set[dp.length];
        for (int i = 0; i < dp.length; i++) {
            if (null == dp[i]) {
                continue;
            }
            newDp[i] = new HashSet<>();
            for (List<Integer> list : dp[i]) {
                newDp[i].add(new ArrayList<>(list));
            }
        }
        return newDp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = ArrayUtil.string2ArrayiInt("[10,1,2,7,6,1,5]");
        int target = 8;
        List<List<Integer>> list;
//        solution.combinationSum2(candidates, target);
//        System.out.println(list);
//
//
//        candidates = ArrayUtil.string2ArrayiInt("[2]");
//        target = 1;
//        list = solution.combinationSum2(candidates, target);
//        System.out.println(list);

        candidates = ArrayUtil.string2ArrayiInt("[1,2,3]");
        target = 6;
        list = solution.combinationSum2(candidates, target);
        System.out.println(list);
    }
}
