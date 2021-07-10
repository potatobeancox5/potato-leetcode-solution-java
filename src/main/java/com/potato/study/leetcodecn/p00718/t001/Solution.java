package com.potato.study.leetcodecn.p00718.t001;

/**
 * 718. 最长重复子数组
 *
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *  
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 718
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        // dp ij 以ij结尾的后缀匹配情况 最长
        int[][] dp = new int[nums1.length][nums2.length];
        // 初始化 dp i0 0j 这种情况
        for (int i = 0; i < nums2.length; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
            }
        }
        // 生成 dp ij 生成过程中 比较最大值
        int max = 0;
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        // 返回生成过程中的最大值
        return max;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[]{1,7,3,6,5,6};
//        int index = solution.pivotIndex(nums);
//        System.out.println(index);
//        Assert.assertEquals(3, index);
    }
}
