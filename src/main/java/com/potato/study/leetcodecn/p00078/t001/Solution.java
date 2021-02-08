package com.potato.study.leetcodecn.p00078.t001;


import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

  

 示例 1：

 输入：nums = [1,2,3]
 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 示例 2：

 输入：nums = [0]
 输出：[[],[0]]
  

 提示：

 1 <= nums.length <= 10
 -10 <= nums[i] <= 10
 nums 中的所有元素 互不相同

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/subsets
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用 result 暂存目前生成的结果，每次遍历 nums，想 resul 中 添加 result + 当前元素的结果
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 加入空集
        result.add(new ArrayList<>());
        for (int num : nums) {
            int len = result.size();
            for (int i = 0; i < len; i++) {
                List<Integer> tmp = new ArrayList<>(result.get(i));
                tmp.add(num);
                result.add(tmp);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);

        nums = new int[]{0};
        subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}
