package com.potato.study.leetcodecn.p00324.t001;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Assert;

/**
 * 324. 摆动排序 II
 *
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 *
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 *  
 *
 * 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 现在改成 都是倒序穿插
     * https://leetcode-cn.com/problems/wiggle-sort-ii/solution/3ms-99-xian-pai-xu-zai-chuan-cha-by-wang-o7pm/
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        // sort
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        // 倒序写入 res 1 - len
        for (int i = 1; i < nums.length; i+=2) {
            res[i] = nums[index];
            index--;
        }
        // 倒序写入 res 0 - len
        for (int i = 0; i < nums.length; i+=2) {
            res[i] = nums[index];
            index--;
        }
        // res ->num
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
        return;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {
                1,5,1,1,6,4
        };
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
