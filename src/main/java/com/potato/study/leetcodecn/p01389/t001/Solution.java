package com.potato.study.leetcodecn.p01389.t001;


import java.util.Arrays;

/**
 * 1389. 按既定顺序创建目标数组
 *
 * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：

 目标数组 target 最初为空。
 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
 请你返回目标数组。

 题目保证数字插入位置总是存在。

  

 示例 1：

 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
 输出：[0,4,1,3,2]
 解释：
 nums       index     target
 0            0        [0]
 1            1        [0,1]
 2            2        [0,1,2]
 3            2        [0,1,3,2]
 4            1        [0,4,1,3,2]
 示例 2：

 输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
 输出：[0,1,2,3,4]
 解释：
 nums       index     target
 1            0        [1]
 2            1        [1,2]
 3            2        [1,2,3]
 4            3        [1,2,3,4]
 0            0        [0,1,2,3,4]
 示例 3：

 输入：nums = [1], index = [0]
 输出：[1]
  

 提示：

 1 <= nums.length, index.length <= 100
 nums.length == index.length
 0 <= nums[i] <= 100
 0 <= index[i] <= i

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/create-target-array-in-the-given-order
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 从后往前遍历 index
     *      如果当前index 上面 没有数字 那么直接放数字，否则 一直往后找第一个没有数字的位置
     * @param nums
     * @param index
     * @return
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];
        // 根据条件选择 -1 标记 没有填充
        Arrays.fill(res, -1);
        for (int i = 0; i < index.length; i++) {
            if (res[index[i]] == -1) {
                res[index[i]] = nums[i];
            } else {
                // 找到后边第一个为-1的下标
                int j = index[i];
                while (res[j] != -1) {
                    j++;
                }
                // 从i-j 移动 然后将数值放到i位置
                for (int k = j; k > index[i]; k--) {
                    res[k] = res[k-1];
                }
                // 然后将数值放到i位置
                res[index[i]] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1};
        int[] index = new int[] {0};
        int[] targetArray = solution.createTargetArray(nums, index);
        System.out.println(Arrays.toString(targetArray));

        // nums = [1,2,3,4,0], index = [0,1,2,3,0]
        nums = new int[] {0,1,2,3,4};
        index = new int[] {0,1,2,2,1};
        targetArray = solution.createTargetArray(nums, index);
        // [0,4,1,3,2]
        System.out.println(Arrays.toString(targetArray));

    }
}
