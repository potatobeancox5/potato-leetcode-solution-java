package com.potato.study.leetcodecn.p01748.t001;

/**
 * 1748. 唯一元素的和
 *
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。

 请你返回 nums 中唯一元素的 和 。

  

 示例 1：

 输入：nums = [1,2,3,2]
 输出：4
 解释：唯一元素为 [1,3] ，和为 4 。
 示例 2：

 输入：nums = [1,1,1,1,1]
 输出：0
 解释：没有唯一元素，和为 0 。
 示例 3 ：

 输入：nums = [1,2,3,4,5]
 输出：15
 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
  

 提示：

 1 <= nums.length <= 100
 1 <= nums[i] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sum-of-unique-elements
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param nums
     * @return
     */
    public int sumOfUnique(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (count[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
