package com.potato.study.leetcodecn.p00039.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的数字可以无限制重复被选取。

 说明：

 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。 
 示例 1：

 输入：candidates = [2,3,6,7], target = 7,
 所求解集为：
 [
 [7],
 [2,2,3]
 ]
 示例 2：

 输入：candidates = [2,3,5], target = 8,
 所求解集为：
 [
   [2,2,2,2],
   [2,3,3],
   [3,5]
 ]
  

 提示：

 1 <= candidates.length <= 30
 1 <= candidates[i] <= 200
 candidate 中的每个元素都是独一无二的。
 1 <= target <= 500

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/combination-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * dp 0 - target
     * dp i 表示，组成 i这个数字有多少中组合数目
     * dp i = dp [i- candidates【j】] + ... dp [i- candidates【0】]
     *
     * 从 candidates 0 开始 遍历
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] dp = new ArrayList[target + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];
            // dp 从 0 开始到 最接近的target 且小于 target的值
            for (int j = candidate; j <= target; j++) {
                List<List<Integer>> list = dp[j - candidate];
                if (list == null) {
                    continue;
                }
                if (null == dp[j]) {
                    dp[j] = new ArrayList<>();
                }
                List<List<Integer>> eachResult = dp[j];
                for (List<Integer> eachRes : list) {
                    List<Integer> lll = new ArrayList<>(eachRes);
                    lll.add(candidate);
                    // 放入结果集
                    eachResult.add(lll);
                }

            }
        }
        if (dp[target] == null) {
            return new ArrayList<>();
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> list = solution.combinationSum(candidates, target);
        System.out.println(list);

        candidates = new int[]{2,3,5};
        target = 8;
        list = solution.combinationSum(candidates, target);
        System.out.println(list);

        candidates = new int[]{2};
        target = 1;
        list = solution.combinationSum(candidates, target);
        System.out.println(list);
    }
}
