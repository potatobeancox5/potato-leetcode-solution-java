package com.potato.study.leetcodecn.p00454.t001;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // 454
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 使用两个map 记录 12的和 和34的和，每个和出现次数
        Map<Integer, Integer> countMap12 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int key = nums1[i] + nums2[j];
                Integer count = countMap12.getOrDefault(key, 0);
                count++;
                countMap12.put(key, count);
            }
        }
        Map<Integer, Integer> countMap34 = new HashMap<>();
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int key = nums3[i] + nums4[j];
                Integer count = countMap34.getOrDefault(key, 0);
                count++;
                countMap34.put(key, count);
            }
        }
        // 遍历 map 找下 当前key的 -key 出现系数乘法
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : countMap12.entrySet()) {
            int target = -1 * entry.getKey();
            if (countMap34.containsKey(target)) {
                total += entry.getValue() * countMap34.get(target);
            }
        }
        return total;
    }


//    public static void main(String[] args) {
//
//        Solution solution = new Solution();
//
//        int[][] points = new int[][] {
//                {10,16},{2,8},{1,6},{7,12}
//        };
//        int arrowCount = solution.findMinArrowShots(points);
//        System.out.println(arrowCount);
//        Assert.assertEquals(2, arrowCount);
//
//        points = new int[][] {
//                {1,2},{3,4},{5,6},{7,8}
//        };
//        arrowCount = solution.findMinArrowShots(points);
//        System.out.println(arrowCount);
//        Assert.assertEquals(4, arrowCount);
//
//        points = new int[][] {
//                {1,2},{3,4},{5,6},{7,8}
//        };
//        arrowCount = solution.findMinArrowShots(points);
//        System.out.println(arrowCount);
//        Assert.assertEquals(4, arrowCount);
//    }
}
