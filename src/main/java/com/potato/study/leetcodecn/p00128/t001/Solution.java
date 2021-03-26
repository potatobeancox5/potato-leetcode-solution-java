package com.potato.study.leetcodecn.p00128.t001;

import com.potato.study.leetcode.domain.TreeNode;
import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

  

 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？

  

 示例 1：

 输入：nums = [100,4,200,1,3,2]
 输出：4
 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 示例 2：

 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 输出：9
  

 提示：

 0 <= nums.length <= 104
 -109 <= nums[i] <= 109

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 先用 set 记录下来所有的数字
     * 2. 遍历 nums 对于每个数字 n
     *  if n-1 不再 set 中 说明是第一个出现的数字，往后一致 ++ 遍历 到set中不存在
     *  else 存在 不是把头的数字 直接continue了
     *  遍历过程记录最大值
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int maxLen = 0;
        // 遍历 nums 对于每个数字 n
        for (int n : nums) {
            if (!set.contains(n-1)) {
                int count = 0;
                while (set.contains(n)) {
                    n++;
                    count++;
                }
                maxLen = Math.max(maxLen, count);
            } else {
                // 存在 不是把头的数字 直接continue了
                continue;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {100,4,200,1,3,2};
        int res = solution.longestConsecutive(nums);
        System.out.println(res);
        Assert.assertEquals(4, res);


        nums = new int[] {0,3,7,2,5,8,4,6,0,1};
        res = solution.longestConsecutive(nums);
        System.out.println(res);
        Assert.assertEquals(9, res);
    }


}
