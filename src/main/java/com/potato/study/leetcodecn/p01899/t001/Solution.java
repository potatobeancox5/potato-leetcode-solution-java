package com.potato.study.leetcodecn.p01899.t001;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Assert;

/**
 * 1899. 合并若干三元组以形成目标三元组
 *
 * 三元组 是一个由三个整数组成的数组。给你一个二维整数数组 triplets ，其中 triplets[i] = [ai, bi, ci] 表示第 i 个 三元组 。同时，给你一个整数数组 target = [x, y, z]
 * ，表示你想要得到的 三元组 。
 *
 * 为了得到 target ，你需要对 triplets 执行下面的操作 任意次（可能 零 次）：
 *
 * 选出两个下标（下标 从 0 开始 计数）i 和 j（i != j），并 更新 triplets[j] 为 [max(ai, aj), max(bi, bj), max(ci, cj)] 。
 * 例如，triplets[i] = [2, 5, 3] 且 triplets[j] = [1, 7, 5]，triplets[j] 将会更新为 [max(2, 1), max(5, 7), max(3, 5)] = [2, 7,
 * 5] 。
 * 如果通过以上操作我们可以使得目标 三元组 target 成为 triplets 的一个 元素 ，则返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：triplets = [[2,5,3],[1,8,4],[1,7,5]], target = [2,7,5]
 * 输出：true
 * 解释：执行下述操作：
 * - 选择第一个和最后一个三元组 [[2,5,3],[1,8,4],[1,7,5]] 。更新最后一个三元组为 [max(2,1), max(5,7), max(3,5)] = [2,7,5] 。triplets = [[2,5,
 * 3],[1,8,4],[2,7,5]]
 * 目标三元组 [2,7,5] 现在是 triplets 的一个元素。
 * 示例 2：
 *
 * 输入：triplets = [[1,3,4],[2,5,8]], target = [2,5,8]
 * 输出：true
 * 解释：目标三元组 [2,5,8] 已经是 triplets 的一个元素。
 * 示例 3：
 *
 * 输入：triplets = [[2,5,3],[2,3,4],[1,2,5],[5,2,3]], target = [5,5,5]
 * 输出：true
 * 解释：执行下述操作：
 * - 选择第一个和第三个三元组 [[2,5,3],[2,3,4],[1,2,5],[5,2,3]] 。更新第三个三元组为 [max(2,1), max(5,2), max(3,5)] = [2,5,5] 。triplets =
 * [[2,5,3],[2,3,4],[2,5,5],[5,2,3]] 。
 * - 选择第三个和第四个三元组 [[2,5,3],[2,3,4],[2,5,5],[5,2,3]] 。更新第四个三元组为 [max(2,5), max(5,2), max(5,3)] = [5,5,5] 。triplets =
 * [[2,5,3],[2,3,4],[2,5,5],[5,5,5]] 。
 * 目标三元组 [5,5,5] 现在是 triplets 的一个元素。
 * 示例 4：
 *
 * 输入：triplets = [[3,4,5],[4,5,6]], target = [3,2,5]
 * 输出：false
 * 解释：无法得到 [3,2,5] ，因为 triplets 不含 2 。
 *  
 *
 * 提示：
 *
 * 1 <= triplets.length <= 105
 * triplets[i].length == target.length == 3
 * 1 <= ai, bi, ci, x, y, z <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-triplets-to-form-target-triplet
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 triplets 如果不满足 过滤 ，直接返回当前max 中值 是不是 和target一样
     * @param triplets
     * @param target
     * @return
     */
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] max = new int[] {
                Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE
        };
        for (int[] tri : triplets) {
            if (tri[0] > target[0] || tri[1] > target[1] || tri[2] > target[2]) {
                continue;
            }
            max[0] = Math.max(max[0], tri[0]);
            max[1] = Math.max(max[1], tri[1]);
            max[2] = Math.max(max[2], tri[2]);
        }
        return max[0] == target[0] && max[1] == target[1] && max[2] == target[2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.mergeTriplets();
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[] {5,1,3};
//        int i = solution.reductionOperations(nums);
//        System.out.println(i);
//        Assert.assertEquals(3, i);
//
//        nums = new int[] {1,1,1};
//        i = solution.reductionOperations(nums);
//        System.out.println(i);
//        Assert.assertEquals(0, i);
//
//        nums = new int[] {1,1,2,2,3};
//        i = solution.reductionOperations(nums);
//        System.out.println(i);
//        Assert.assertEquals(4, i);
//    }

}
