package com.potato.study.leetcodecn.p00081.t001;


/**
 * 81. 搜索旋转排序数组 II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

 示例 1:

 输入: nums = [2,5,6,0,0,1,2], target = 0
 输出: true
 示例 2:

 输入: nums = [2,5,6,0,0,1,2], target = 3
 输出: false
 进阶:

 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 还是二分法查找
     * 重要的是 进行下一步区间选择是 首先判断单调性，如果无法判断单调性（中间值等于两侧中任意一侧的值，直接 left + 1 遍历）
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target || nums[left] == target || nums[right] == target) {
                return true;
            }
            // 没有命中 说明一定在区间内 找到两侧的递增区间
            if (nums[left] == nums[mid]) {
                // 不好说是怎么样
                left++;
            } else if (nums[left] < nums[mid]) {
                // 左边一定单调增
                if (nums[left] < target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边一定单调增
                if (nums[mid] < target && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
