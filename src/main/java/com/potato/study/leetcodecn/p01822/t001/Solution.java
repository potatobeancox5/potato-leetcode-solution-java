package com.potato.study.leetcodecn.p01822.t001;

import com.google.common.collect.Lists;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 1822. 数组元素积的符号
 *
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：

 如果 x 是正数，返回 1 。
 如果 x 是负数，返回 -1 。
 如果 x 是等于 0 ，返回 0 。
 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。

 返回 signFunc(product) 。

  

 示例 1：

 输入：nums = [-1,-2,-3,-4,3,2,1]
 输出：1
 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 示例 2：

 输入：nums = [1,5,0,2,-3]
 输出：0
 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 示例 3：

 输入：nums = [-1,1,-1,1,-1]
 输出：-1
 解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
  

 提示：

 1 <= nums.length <= 1000
 -100 <= nums[i] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sign-of-the-product-of-an-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历数组 计算 负数出现次数
     * 偶数 正 奇数 负数 有 0 立即返回0
     * @param nums
     * @return
     */
    public int arraySign(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("不是说了数组长度大于1么sb");
        }
        int negetiveCount = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negetiveCount++;
            }
        }
        if (negetiveCount % 2 == 1) {
            return -1;
        } else {
            return 1;
        }
    }
}
