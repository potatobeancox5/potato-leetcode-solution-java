package com.potato.study.leetcode.p0220;

import java.util.TreeSet;

/**
 * 
 * @author liuzhao11
 * 
 *      220. Contains Duplicate III
 * 
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
 * *
 *
 * 题目需求：
 *  判断是否 num[i]  -   nums[j]  最大不能超过t
 *  存在 i - j  k的距离内
 *
 * 思路：
 *     https://segmentfault.com/a/1190000009496516
 *     1. 申请一个treeset 内存储 k个元素 当前位置当作j
 *     2. 遍历 nums 利用treeset 的 floor(target) （小于等于 target的第一个数字 ）获取 floor(nums[j] + t)
 *     3. 遍历 nums 利用treeset 的 ceil(target) （大于等于 target的第一个数字 ）获取 ceil(nums[j] - t)
 *     4. 获取到了 可以直接返回true
 *     5. 将nums[j] 放入treeset中 判断当前j 是否 >= k 如果是的话 将 j - k 移除
 *
 *     注意：
 *     针对int 型最大值和最小值进行溢出处理
 *
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 只保留k 个元素
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int j = 0; j < nums.length; j++) {
            Long floor = treeSet.floor((long)nums[j] + t);
            Long ceiling = treeSet.ceiling((long)nums[j] - t);
            // 判断是否取到
            if ((floor != null && floor >= nums[j]) || (ceiling != null && ceiling <= nums[j])) {
                return true;
            }
            treeSet.add((long)nums[j]);
            if (j >= k) {
                // j 从 0 开始 到 k 是k+1个元素 j = k 时移除 0
                treeSet.remove((long)nums[j - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1,2,3,1};
        int k = 3;
        int t = 0;
//        boolean duplicate = solution.containsNearbyAlmostDuplicate(nums, k, t);
//        System.out.println("duplicate : " + duplicate); // true

//        int[] nums = {1,0,1,1};
//        k = 1;
//        t = 2;
//        boolean duplicate = solution.containsNearbyAlmostDuplicate(nums, k, t);
//        System.out.println("duplicate : " + duplicate); // true

//        int[] nums = {1,5,9,1,5,9};
//        k = 2;
//        t = 3;

        int[] nums = {-2147483648,-2147483647};
        k = 3;
        t = 3;
        boolean duplicate = solution.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println("duplicate : " + duplicate);
    }
}
