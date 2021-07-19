package com.potato.study.leetcodecn.p00453.t001;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;

/**
 * 453. 最小操作次数使数组元素相等
 *
 * 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 * [1,2,3]
 * 输出：
 * 3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // 453 找到最小值 判断 其他数字与最小值的差 就是次数
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int total = 0;
        for (int num : nums) {
            total += ( num - min);
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
