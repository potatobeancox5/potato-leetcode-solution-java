package com.potato.study.leetcodecn.p00018.t001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

 注意：

 答案中不可以包含重复的四元组。

 示例：

 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

 满足要求的四元组集合为：
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/4sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 注意 题目中 nums 可能存在相同的元素
     * 1. 对于 nums 排序 O nlogn
     * 2. ij 依次遍历 nums O n*n ，然后用两个指针 left 和 right 求和 生成结果 O n3
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        // 1. 对于 nums 排序 O nlogn
        Arrays.sort(nums);
        // 2. ij 依次遍历 nums O n*n ，然后用两个指针 left 和 right 求和 生成结果 O n3
        for (int i = 0; i < nums.length - 3; i++) {
            // i 也要做防重
            if (i != 0  && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 如果 当前j 和 j-1 一样 说明已经遍历过 直接返回吧
                if (j != i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == target - nums[i] - nums[j]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        // left 和 right 都往前移动 到不是当前值
                        while (left < right) {
                            right--;
                            if (nums[right] != nums[right + 1]) {
                                break;
                            }
                        }
                        while (left < right) {
                            left++;
                            if (nums[left] != nums[left - 1]) {
                                break;
                            }
                        }
                    } else if (sum > target - nums[i] - nums[j]) {
                        while (left < right) {
                            right--;
                            if (nums[right] != nums[right + 1]) {
                                break;
                            }
                        }
                    } else {
                        // sum < target - nums[i] - nums[j]
                        while (left < right) {
                            left++;
                            if (nums[left] != nums[left - 1]) {
                                break;
                            }
                        }
                    }
                }

            }
        }
        return result;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[] {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = solution.fourSum(nums, target);
        System.out.println(lists);


        nums = new int[] {-1,-5,-5,-3,2,5,0,4};
        target = -7;
        lists = solution.fourSum(nums, target);
        System.out.println(lists);
    }

}
