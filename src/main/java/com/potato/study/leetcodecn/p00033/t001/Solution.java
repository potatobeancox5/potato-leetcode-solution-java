package com.potato.study.leetcodecn.p00033.t001;

import org.junit.Assert;

/**
 * 33. 搜索旋转排序数组
 *
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。

 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

  

 示例 1：

 输入：nums = [4,5,6,7,0,1,2], target = 0
 输出：4
 示例 2：

 输入：nums = [4,5,6,7,0,1,2], target = 3
 输出：-1
 示例 3：

 输入：nums = [1], target = 0
 输出：-1
  

 提示：

 1 <= nums.length <= 5000
 -10^4 <= nums[i] <= 10^4
 nums 中的每个值都 独一无二
 nums 肯定会在某个点上旋转
 -10^4 <= target <= 10^4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 旋转数组 找到指定值
     * 数组没有重复情况
     * 找不到返回 -1
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 数组len 小于3 不用那么麻烦了 便利 这里就不实现了
        if (null == nums) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
//        right =len-1
//        while left 小于等于 right
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = nums[mid];
            // 找到了 直接返回index
            if (target == val) {
                return mid;
            }
            if (target == nums[left]) {
                return left;
            }
            if (target == nums[right]) {
                return right;
            }
            // 没找到的话，根据局部单调性判断应该往那边继续找
            if (nums[left] < val) {
                // 左边单调增  还需要判断小的程度 是不是比left小
                if (nums[left] <= target && target <= val) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边单调增
                if (val <= target && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        int index = solution.search(nums, target);
        System.out.println(index);
        Assert.assertEquals(4, index);


        nums = new int[]{3,1};
        target = 1;
        index = solution.search(nums, target);
        System.out.println(index);
        Assert.assertEquals(1, index);

    }
}
