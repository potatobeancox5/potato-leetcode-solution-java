package com.potato.study.leetcodecn.p00169.t001;

/**
 * 169. 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

  

 示例 1：

 输入：[3,2,3]
 输出：3
 示例 2：

 输入：[2,2,1,1,1,2,2]
 输出：2
  

 进阶：

 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/majority-element
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     * 推论 如果多数为 1 其他数字为 -1 那么总和一定为正数
     * 依次遍历 nums 每个位置 i 记录当前 count 从0 开始 和 target，初始可以设置为 nums0
     * 如果当前 count = 0 那么 重置 target
     * 进行 target和numi 比较 相等 count++ 否则 count--
     * 最终留下的 target 一定为 多数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int target = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                target = nums[i];
            }
            if (target == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return target;
    }
}
