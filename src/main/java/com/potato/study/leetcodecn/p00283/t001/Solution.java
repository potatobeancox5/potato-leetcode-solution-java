package com.potato.study.leetcodecn.p00283.t001;


/**
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/move-zeroes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    /**
     * 顺序往后 遍历 记录目前0的位置和 数字位置 如果0的位置是 -1 说明 目前不需要移动 continue，如果不是 -1 那么将数字移动到 i位置
     * 并将当前位置数字变成0
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int insertZeroInde = -1;
        for (int i = 0; i < nums.length; i++) {
            if (insertZeroInde == -1 && nums[i] != 0) {
                continue;
            } else if (nums[i] == 0) {
                if (insertZeroInde == -1) {
                    insertZeroInde = i;
                }
                continue;
            } else {
                // i位置不是0 且i之前有0
                nums[insertZeroInde++] = nums[i];
                nums[i] = 0;
            }
        }
        return;
    }
}
