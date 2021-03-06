package com.potato.study.leetcodecn.p00260.t001;

import java.util.Arrays;

/**
 * 260. 只出现一次的数字 III
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

 示例 :

 输入: [1,2,1,3,2,5]
 输出: [3,5]
 注意：

 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/single-number-iii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 一直异或 能得到  n1 ^ n2 结果
     * 找到一个位置 一个为1的位置 按照这个位置，将nums 分成两步分
     * 对于 部分1 进行 遍历 异或
     * 对于 部分2 进行 遍历 异或
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        // 找到区分位置
        int bit = 1;
        while ((bit & n) == 0) {
            bit <<= 1;
        }
        int n1 = 0;
        int n2 = 0;
        for (int num : nums) {
            if ((bit & num) > 0) {
                n1 ^= num;
            } else {
                n2 ^= num;
            }
        }
        return new int[]{n1, n2};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,2,1,3,2,5};
        int[] res = solution.singleNumber(nums);
        System.out.println(Arrays.toString(res));
    }
}
