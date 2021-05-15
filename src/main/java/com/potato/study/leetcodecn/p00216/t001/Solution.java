package com.potato.study.leetcodecn.p00216.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

 说明：

 所有数字都是正整数。
 解集不能包含重复的组合。 
 示例 1:

 输入: k = 3, n = 7
 输出: [[1,2,4]]
 示例 2:

 输入: k = 3, n = 9
 输出: [[1,2,6], [1,3,5], [2,3,4]]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/combination-sum-iii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用 9个二进制位 作为数字 遍历 数字 num 小于 2^9
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        int max = (1 << 9);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            if (isSumSame(n, i)) {
                List<Integer> list = getResultFromMask(i);
                if (list.size() == k) {
                    result.add(list);
                }
            }
        }
        return result;
    }

    /**
     *
     * @param sum
     * @param mask
     * @return
     */
    private boolean isSumSame(int sum, int mask) {
        int thisSum = 0;
        for (int i = 1; i <= 9; i++) {
            if (1 == (mask & 1)) {
                thisSum += i;
            }
            mask >>>= 1;
        }
        return thisSum == sum;
    }


    /**
     * 取 mask 最末 9个位置 作为
     * @param mask
     * @return
     */
    private List<Integer> getResultFromMask(int mask) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (1 == (mask & 1)) {
                list.add(i);
            }
            mask >>>= 1;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 3, n = 7;
        List<List<Integer>> lists = solution.combinationSum3(k, n);
        System.out.println(lists);

        k = 3;
        n = 9;
        lists = solution.combinationSum3(k, n);
        System.out.println(lists);
    }



}
