package com.potato.study.leetcodecn.p00810.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 810. 黑板异或游戏
 *
 * 黑板上写着一个非负整数数组 nums[i] 。Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。如果擦除一个数字后，剩余的所有数字按位异或运算得出的结果等于 0 的话，当前玩家游戏失败。 
 * (另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。）
 *
 * 并且，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。
 *
 * 假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。
 *
 *  
 *
 * 示例：
 *
 * 输入: nums = [1, 1, 2]
 * 输出: false
 * 解释:
 * Alice 有两个选择: 擦掉数字 1 或 2。
 * 如果擦掉 1, 数组变成 [1, 2]。剩余数字按位异或得到 1 XOR 2 = 3。那么 Bob 可以擦掉任意数字，因为 Alice 会成为擦掉最后一个数字的人，她总是会输。
 * 如果 Alice 擦掉 2，那么数组变成[1, 1]。剩余数字按位异或得到 1 XOR 1 = 0。Alice 仍然会输掉游戏。
 *  
 *
 * 提示：
 *
 * 1 <= N <= 1000
 * 0 <= nums[i] <= 2^16
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chalkboard-xor-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * https://leetcode-cn.com/problems/chalkboard-xor-game/solution/hei-ban-yi-huo-you-xi-by-leetcode-soluti-eb0c/
     * 数学 推导证明题
     * 简单说证明结论
     * 利用异或性质推导
     * 如果 当前剩余数组长度为偶数是 先手方一定获胜
     * 如果当前 长度为奇数，那么直接判定是否 满足 【如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。】
     * 否则后手方一定获胜
     * @param nums
     * @return
     */
    public boolean xorGame(int[] nums) {
        // 如果 当前剩余数组长度为偶数是 先手方一定获胜
        if (nums.length % 2 == 0) {
            return true;
        }
        // 如果当前 长度为奇数，那么直接判定是否 满足 【如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。】
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res == 0;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String s = "abbxxxxzzy";
//        List<List<Integer>> list = solution.largeGroupPositions(s);
//        System.out.println(list);
//
//        s = "abc";
//        list = solution.largeGroupPositions(s);
//        System.out.println(list);
//
//        s = "abcdddeeeeaabbbcd";
//        list = solution.largeGroupPositions(s);
//        System.out.println(list);
//
//        s = "aaa";
//        list = solution.largeGroupPositions(s);
//        System.out.println(list);
    }
}
