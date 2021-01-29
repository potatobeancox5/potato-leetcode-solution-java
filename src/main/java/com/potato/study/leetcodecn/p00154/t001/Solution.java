package com.potato.study.leetcodecn.p00154.t001;

import org.junit.Assert;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 请找出其中最小的元素。

 注意数组中可能存在重复的元素。

 示例 1：

 输入: [1,3,5]
 输出: 1
 示例 2：

 输入: [2,2,2,0,1]
 输出: 0
 说明：

 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 分情况 讨论
     * left < right 没有旋转 返回left
     * left > right 旋转了，继续找mid
     *
     * left == right 难说，left++, 记下min;
     *
     * 返回 min
     *
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            if (nums[left] < nums[right]) {
                // 情况 1 没有旋转 直接返回
                return nums[left];
            } else if (nums[left] > nums[right]) {
                // 情况 2 旋转了 需要往旋转的那侧进行查找
                int mid = left + ((right - left) >>> 1);
                // 做一个剪枝通过 mid-1 mid mid+1 判断是不是找到了转折点
                if (mid!=0 && nums[mid-1] > nums[mid]) {
                    return nums[mid];
                }
                if (mid != nums.length -1 && nums[mid] > nums[mid+1]) {
                    return nums[mid+1];
                }


                if (nums[left] > nums[mid]) {
                    min = Math.min(nums[mid], min);
                    right = mid - 1;
                } else if (nums[left] < nums[mid]){
                    left = mid + 1;
                } else {
                    // 相等怎么办
                    min = Math.min(nums[mid], min);
                    left = mid + 1;
                }
            } else {
                // 情况 3 两端相等 不好说往那边找，往另一侧搜索吧
                min = Math.min(nums[left], min);
                left++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3,4,5,1,2};
        int min = solution.findMin(arr);
        System.out.println(min);
        Assert.assertEquals(1, min);



        arr = new int[]{4,5,1,2,3};
        min = solution.findMin(arr);
        System.out.println(min);
        Assert.assertEquals(1, min);

        arr = new int[]{2,2,2,0,1};
        min = solution.findMin(arr);
        System.out.println(min);
        Assert.assertEquals(0, min);


        arr = new int[]{2,2,2,2,1};
        min = solution.findMin(arr);
        System.out.println(min);
        Assert.assertEquals(1, min);
    }
}
