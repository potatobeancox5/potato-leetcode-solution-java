package com.potato.study.leetcodecn.p0026t001;

import java.util.Arrays;

/**
 * 26. 删除排序数组中的重复项
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

  

 示例 1:

 给定数组 nums = [1,1,2],

 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

 你不需要考虑数组中超出新长度后面的元素。
 示例 2:

 给定 nums = [0,0,1,1,1,2,2,3,3,4],

 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

 你不需要考虑数组中超出新长度后面的元素。
  

 说明:

 为什么返回数值是整数，但输出的答案是数组呢?

 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

 你可以想象内部操作如下:

 // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 int len = removeDuplicates(nums);

 // 在函数里修改输入数组对于调用者是可见的。
 // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 for (int i = 0; i < len; i++) {
     print(nums[i]);
 }

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 思路 end 记录当前数组最后一个不重复的元素， cur 记录 当前比较元素
     * 如果 cur 与end 不重复 cur数 放到 end + 1位置
     * 否则 cur ++
     * 一遍循环 O(n)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int end = 0;
        // init cur 位置
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[end]) {
                continue;
            } else {
                if (i == end + 1) {
                    end++;
                    continue;
                }
                nums[end + 1] = nums[i];
                end++;
            }
        }
        return end + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,2};
        int len = solution.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(len);
    }
}