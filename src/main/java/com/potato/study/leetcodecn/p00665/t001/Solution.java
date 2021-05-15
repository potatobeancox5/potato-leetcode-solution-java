package com.potato.study.leetcodecn.p00665.t001;

/**
 * 665. 非递减数列
 *
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。

 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

  

 示例 1:

 输入: nums = [4,2,3]
 输出: true
 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 示例 2:

 输入: nums = [4,2,1]
 输出: false
 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
  

 提示：

 1 <= n <= 10 ^ 4
 - 10 ^ 5 <= nums[i] <= 10 ^ 5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/non-decreasing-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 三种情况
     * 3，1，2 4 发生在第一个时 改变i == 0 时  出现 num i > num i + 1改变 i
     * 1，3  2 4  i== 1（不是0）时，出现 num i > num i + 1 且 num i-1 < num i+ 1,
     *  将i用i-1替换
     * 3 4 2 5 i== 1（不是0）时，出现 num i > num i + 1 且 num i-1 > num i+ 1 这个时候
     *  i-1换成
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {

        return true;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[][] ints = solution.imageSmoother(m);
//        System.out.println(Arrays.deepToString(ints));
    }
}
