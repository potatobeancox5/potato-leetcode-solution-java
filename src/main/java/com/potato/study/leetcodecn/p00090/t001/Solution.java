package com.potato.study.leetcodecn.p00090.t001;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 90. 子集 II
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: [1,2,2]
 输出:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/subsets-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用 Set List 存储结果
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        // 增加空集
        result.add(new ArrayList<>());
        for (int num : nums) {
            int len = result.size();
            List<List<Integer>> tmp = new ArrayList<>(result);
            for (int i = 0; i < len; i++) {
                List<Integer> eachElement = new ArrayList<>(tmp.get(i));
                eachElement.add(num);
                result.add(eachElement);
            }
        }
        return new ArrayList<>(result);
    }
}
