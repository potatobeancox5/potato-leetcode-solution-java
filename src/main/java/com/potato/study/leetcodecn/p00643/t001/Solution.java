package com.potato.study.leetcodecn.p00643.t001;


/**
 * 643. 子数组最大平均数 I
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

  

 示例：

 输入：[1,12,-5,-6,50,3], k = 4
 输出：12.75
 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
  

 提示：

 1 <= k <= n <= 30,000。
 所给数据范围 [-10,000，10,000]。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 滑动窗口
     * 最大值就行
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int index = 0;
        while (index < k && index < nums.length) {
            sum += nums[index];
            index++;
        }
        // 遍历之后的数字找到最大值
        int max = sum;
        for (int i = index; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,12,-5,-6,50,3};
        int k = 4;
        double average = solution.findMaxAverage(nums, k);
        System.out.println(average);
    }

}
