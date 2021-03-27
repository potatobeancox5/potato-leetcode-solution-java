package com.potato.study.leetcodecn.p00238.t001;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 *
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

  

 示例:

 输入: [1,2,3,4]
 输出: [24,12,8,6]
  

 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

 进阶：
 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 先生成结果 从右往左前缀乘积
     * 再生成 从左往右 前缀乘积
     * 最终遍历 获取结果
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            tmp *= nums[i];
            res[i] = tmp;
        }
        tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            tmp *= nums[i];
            nums[i] = tmp;
        }
        // generate result
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[0] = res[1];
            } else if (i == nums.length - 1) {
                res[i] = nums[i-1];
            } else {
                res[i] = res[i+1] * nums[i-1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{
                1,2,3,4
        };
        int[] kk = solution.productExceptSelf(nums);
        //[24,12,8,6]
        System.out.println(Arrays.toString(kk));
    }

}
