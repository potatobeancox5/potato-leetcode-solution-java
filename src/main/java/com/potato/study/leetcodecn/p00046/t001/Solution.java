package com.potato.study.leetcodecn.p00046.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutations
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * 深度优先搜索
     * 用到visited 数组
     * 用到prev 数组
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<Integer> prev = new ArrayList<>();
        dfs(result, visited, nums, prev);
        return result;
    }

    /**
     * 深度优先搜索 获取 结果
     * @param result
     * @param visited
     * @param nums
     * @param prev
     */
    private void dfs(List<List<Integer>> result, boolean[] visited, int[] nums, List<Integer> prev) {
        // 达到最终条件
        if (prev.size() == nums.length) {
            result.add(prev);
            return;
        }
        // 遍历 nums 找到没有 visit 过的 递归生成 结果
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // 就这个节点了 先进行访问
            int value = nums[i];
            List<Integer> temp = new ArrayList<>(prev);
            temp.add(value);
            visited[i] = true;
            dfs(result, visited, nums, temp);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,2,3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[] {2,3,1,1,4};
//        int jump = solution.jump(nums);
//        System.out.println(jump);
//        Assert.assertEquals(2, jump);
//
//
////        int[] nums = new int[] {2,3,1,1,4};
////        int jump = solution.jump(nums);
////        System.out.println(jump);
////        Assert.assertEquals(2, jump);
//    }
}
