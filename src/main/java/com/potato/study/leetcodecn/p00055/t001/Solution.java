package com.potato.study.leetcodecn.p00055.t001;

/**
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你是否能够到达最后一个位置。

 示例 1:

 输入: [2,3,1,1,4]
 输出: true
 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 示例 2:

 输入: [3,2,1,0,4]
 输出: false
 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/jump-game
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    /**
     * 数字 记录 每个位置是否可达 从第一个位置开始遍历数组
     * 当前index i
     * if i 可达或i为0
     *  根据i值依次修改状态 state 数组
     * if i 不可达 continue
     * 剪枝
     *  返回最后一个位置状态
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (null == nums || nums.length == 0) {
            return true;
        }
        boolean[] state = new boolean[nums.length];
        state[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int step = nums[i];
            if (!state[i]) {
                continue;
            } else {
                for (int j = 1; j <= step && i + j < nums.length; j++) {
                    state[i + j] = true;
                    if (i + j == nums.length - 1) {
                        return true;
                    }
                }
            }
        }
        return state[nums.length - 1];
    }
}
