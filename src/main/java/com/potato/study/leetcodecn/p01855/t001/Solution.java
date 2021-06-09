package com.potato.study.leetcodecn.p01855.t001;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;

/**
 * 1855. 下标对中的最大距离
 *
 * 给你两个 非递增 的整数数组 nums1​​​​​​ 和 nums2​​​​​​ ，数组下标均 从 0 开始 计数。
 *
 * 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效
 * 下标对，该下标对的 距离 为 j - i​​ 。​​
 *
 * 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。
 *
 * 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
 * 输出：2
 * 解释：有效下标对是 (0,0), (2,2), (2,3), (2,4), (3,3), (3,4) 和 (4,4) 。
 * 最大距离是 2 ，对应下标对 (2,4) 。
 * 示例 2：
 *
 * 输入：nums1 = [2,2,2], nums2 = [10,10,1]
 * 输出：1
 * 解释：有效下标对是 (0,0), (0,1) 和 (1,1) 。
 * 最大距离是 1 ，对应下标对 (0,1) 。
 * 示例 3：
 *
 * 输入：nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
 * 输出：2
 * 解释：有效下标对是 (2,2), (2,3), (2,4), (3,3) 和 (3,4) 。
 * 最大距离是 2 ，对应下标对 (2,4) 。
 * 示例 4：
 *
 * 输入：nums1 = [5,4], nums2 = [3,2]
 * 输出：0
 * 解释：不存在有效下标对，所以返回 0 。
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length <= 105
 * 1 <= nums2.length <= 105
 * 1 <= nums1[i], nums2[j] <= 105
 * nums1 和 nums2 都是 非递增 数组
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-distance-between-a-pair-of-values
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {






    /**
     * 非递增数组 其实 是不断减小的
     * 要求 ij 保证 i <= j 且 nums1[i] <= nums2[j]
     * 遍历 nums1 对于每个位置i 在 num2 中找到最大的 满足 i <= j 且 nums1[i] <= nums2[j]
     * 之后每次都从 j 位置开始扫表
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxDistance(int[] nums1, int[] nums2) {
        // i 一直往后 j从 上一个位置开始往后
        int j = 0;
        int maxDistance = 0;
        for (int i = 0; i < nums1.length; i++) {
            while (j < nums2.length && nums1[i] <= nums2[j]) {
                if (i <= j) {
                    maxDistance = Math.max(maxDistance, Math.abs(i - j));
                }
                j++;
            }
            if (j == nums2.length) {
                break;
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[] {
                55,30,5,4,2
        };
        int[] nums2 = new int[] {
                100,20,10,10,5
        };
        int i = solution.maxDistance(nums1, nums2);
        System.out.println(i);
        Assert.assertEquals(2, i);

        nums1 = new int[] {
                10000,9997,9995,6219
        };
        nums2 = new int[] {
                6219,6217,6216
        };
        i = solution.maxDistance(nums1, nums2);
        System.out.println(i);
        Assert.assertEquals(0, i);
    }
}
