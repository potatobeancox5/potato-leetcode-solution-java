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
     * 感觉使用递归比较简单
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resultList = new ArrayList<>();
        return null;
    }


    /**
     *
     * @param resultList
     * @param currentList       当前结果集合
     * @param k
     * @param n
     * @param currentNum        当前可用数字
     * @param currentUsed       当前用了多少个数字
     */
    private void combinationSum3(List<List<Integer>> resultList, List<List<Integer>> currentList, int k,
                                 int n, int currentNum, int currentUsed) {
        // 当前已经用了 n个数字 直接将 currentList 放入 resultList
        if (k == currentUsed) {
            resultList.addAll(copyList(currentList));
        }
        // 当前还没有到 遍历 currentList 加上 当前 currentNum


        // 对于 currentNum 之后的数字 依次 遍历 得到结果集合 递归生成结果集
        for (int i = currentNum + 1; i < n; i++) {

        }


    }

    /**
     * 生成新的list
     * @param resultList
     * @return
     */
    private List<List<Integer>> copyList (List<List<Integer>> resultList) {
        List<List<Integer>> newList = new ArrayList<>();
        for (int i = 0; i < resultList.size(); i++) {
            List<Integer> list = new ArrayList<>();
            list.addAll(resultList.get(i));
            newList.add(list);
        }
        return newList;
    }
}
