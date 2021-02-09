package com.potato.study.leetcodecn.p01437.t001;

import org.junit.Assert;

/**
 * 1437. 是否所有 1 都至少相隔 k 个元素
 *
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。

  

 示例 1：



 输入：nums = [1,0,0,0,1,0,0,1], k = 2
 输出：true
 解释：每个 1 都至少相隔 2 个元素。
 示例 2：



 输入：nums = [1,0,0,1,0,1], k = 2
 输出：false
 解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
 示例 3：

 输入：nums = [1,1,1,1,1], k = 0
 输出：true
 示例 4：

 输入：nums = [0,1,0,1], k = 1
 输出：true
  

 提示：

 1 <= nums.length <= 10^5
 0 <= k <= nums.length
 nums[i] 的值为 0 或 1


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/check-if-all-1s-are-at-least-length-k-places-away
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 找到i 比较状态
     * @param nums
     * @param k
     * @return
     */
    public boolean kLengthApart(int[] nums, int k) {
        // 中间0 的个数
        int count = 0;
        boolean isStart = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                if (isStart) {
                    count = 0;
                    isStart = false;
                    continue;
                }
                // 如果是1 先进行结果校验，然后 重新初始化条件
                if (i != 0 && count < k) {
                    return false;
                }
                count = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,0,0,0,1,0,0,1};
        int k = 2;
        boolean res = solution.kLengthApart(nums, k);
        System.out.println(res);
        Assert.assertEquals(true, res);

        nums = new int[] {1,0,0,1,0,1};
        k = 2;
        res = solution.kLengthApart(nums, k);
        System.out.println(res);
        Assert.assertEquals(false, res);


        nums = new int[] {0,1, 0,0,1,0,0,};
        k = 2;
        res = solution.kLengthApart(nums, k);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
