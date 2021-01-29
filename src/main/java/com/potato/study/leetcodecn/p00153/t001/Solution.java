package com.potato.study.leetcodecn.p00153.t001;

import org.junit.Assert;

import java.util.Stack;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。

 请找出其中最小的元素。

  

 示例 1：

 输入：nums = [3,4,5,1,2]
 输出：1
 示例 2：

 输入：nums = [4,5,6,7,0,1,2]
 输出：0
 示例 3：

 输入：nums = [1]
 输出：1
  

 提示：

 1 <= nums.length <= 5000
 -5000 <= nums[i] <= 5000
 nums 中的所有整数都是 唯一 的
 nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 旋转数组 找到 最小值 没重复
     * 最小的元素一定在旋转的那边
     * 还是之前的思路
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 兼容一个元素的情况 一个元素的时候就返回了 3个数组能保证 mid 与 left和tight 一定不重合
        while (right - left > 2) {
            int mid = (left + right) / 2;
            // 先判断有没有旋转
            if (nums[left] < nums[right]) {
                // 我擦 没有旋转 你这个骗子
                right = mid - 1;
                continue;
            }
            // 走到这 肯定是旋转了 判断 是否已经达到3个元素了 只可能是大于或者小于
            if (nums[left] < nums[mid]) {
                // 左边有序增加，那么最小值在右边 mid 没有可能
                left = mid + 1;
            } else {
                // mid > right
                right = mid;
            }
        }
        // 遍历 找到最小
        int min = nums[left];
        while (left <= right) {
            min = Math.min(min, nums[left]);
            left++;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3,4,5,1,2};
        int min = solution.findMin(arr);
        System.out.println(min);
        Assert.assertEquals(1, min);


        arr = new int[]{4,5,6,7,0,1,2};
        min = solution.findMin(arr);
        System.out.println(min);
        Assert.assertEquals(0, min);


        arr = new int[]{1};
        min = solution.findMin(arr);
        System.out.println(min);
        Assert.assertEquals(1, min);

        arr = new int[]{11,13,15,17};
        min = solution.findMin(arr);
        System.out.println(min);
        Assert.assertEquals(11, min);


        arr = new int[]{4,5,1,2,3};
        min = solution.findMin(arr);
        System.out.println(min);
        Assert.assertEquals(1, min);
    }
}
