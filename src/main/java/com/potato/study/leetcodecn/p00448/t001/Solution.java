package com.potato.study.leetcodecn.p00448.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

 找到所有在 [1, n] 范围之间没有出现在数组中的数字。

 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

 示例:

 输入:
 [4,3,2,7,8,2,3,1]

 输出:
 [5,6]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 nums 每个对于 val num【val%n】 += N
     * 遍历 nums 找到 小于 N的数字
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            int val = num % nums.length;
            nums[val] += nums.length;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                if (i == 0) {
                    result.add(nums.length);
                } else {
                    result.add(i);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {4,3,2,7,8,2,3,1};
        // [5,6]
        List<Integer> list = solution.findDisappearedNumbers(nums);
        System.out.println(list);
    }
}
