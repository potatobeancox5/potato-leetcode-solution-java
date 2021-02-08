package com.potato.study.leetcodecn.p00047.t001;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

  

 示例 1：

 输入：nums = [1,1,2]
 输出：
 [[1,1,2],
 [1,2,1],
 [2,1,1]]
 示例 2：

 输入：nums = [1,2,3]
 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  

 提示：

 1 <= nums.length <= 8
 -10 <= nums[i] <= 10

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutations-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 深度优先搜索 生成结果的时候 需要进行 排重判定 set list 实现重复判定
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<Integer> prev = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        dfs(resultSet, nums, prev, visited);
        List<List<Integer>> result = new ArrayList<>(resultSet);
        return result;

    }

    /**
     * dfs 生成遍历结果
     * @param resultSet 结果set
     * @param nums      当前的数组
     * @param prev      之前的列表
     * @param visited   访问的情况
     */
    private void dfs(Set<List<Integer>> resultSet, int[] nums, List<Integer> prev, boolean[] visited) {
        if (prev.size() == nums.length) {
            resultSet.add(prev);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            List<Integer> temp = new ArrayList<>(prev);
            temp.add(nums[i]);
            visited[i] = true;
            dfs(resultSet, nums, temp, visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,1,2};
        List<List<Integer>> list = solution.permuteUnique(nums);
        System.out.println(list);

        nums = new int[] {1,2,3};
        list = solution.permuteUnique(nums);
        System.out.println(list);
    }
}
