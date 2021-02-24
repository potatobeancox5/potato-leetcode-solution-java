package com.potato.study.leetcodecn.p00645.t001;


import java.util.HashSet;
import java.util.Set;

/**
 * 645. 错误的集合
 *
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。

 给定一个数组 nums 代表了集合 S 发生错误后的结果。

 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

  

 示例 1：

 输入：nums = [1,2,2,4]
 输出：[2,3]
 示例 2：

 输入：nums = [1,1]
 输出：[1,2]
  

 提示：

 2 <= nums.length <= 104
 1 <= nums[i] <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/set-mismatch
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历一遍 求
     *
     * 整体 a
     * 重复数 b
     * 丢失数 c
     * a + b = sum1
     * a + c = sum2
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        // 求累加和，同时记录set 出现过的数字，能找到重复的数字
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        int repeat = 0;
        for (int num : nums) {
            sum += num;
            if (set.contains(num)) {
                repeat = num;
            }
            set.add(num);
        }
        // 减去剩余数字
        sum -= repeat;
        // (n + 1) * n / 2 就能求出少了那个数字
        int n = nums.length;
        int lack = (n + 1) * n / 2 - sum;
        return new int[]{repeat, lack};
    }

    public static void main(String[] args) {
    }

}
