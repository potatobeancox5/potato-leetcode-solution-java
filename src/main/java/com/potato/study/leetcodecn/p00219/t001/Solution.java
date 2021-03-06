package com.potato.study.leetcodecn.p00219.t001;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

  

 示例 1:

 输入: nums = [1,2,3,1], k = 3
 输出: true
 示例 2:

 输入: nums = [1,0,1,1], k = 1
 输出: true
 示例 3:

 输入: nums = [1,2,3,1,2,3], k = 2
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 使用map记录 最近出现的index 以后每次出现比较先是不是 小于等于 k
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        // 先搞k 个元素 一旦 count > 1 return  true
        for (int i = 0; i < k + 1 && i < nums.length; i++) {
            Integer count = countMap.getOrDefault(nums[i], 0);
            count++;
            countMap.put(nums[i], count);
            if (count > 1) {
                return true;
            }
        }
        // 再往后 加一个元素就删一个元素，然后只加的那个元素即可
        for (int i = k + 1; i < nums.length; i++) {
            // 加一个元素就删一个元素
            Integer count = countMap.getOrDefault(nums[i], 0);
            count++;
            countMap.put(nums[i], count);
            // 删一个元素
            Integer countDel = countMap.get(nums[i-k-1]);
            countDel--;
            countMap.put(nums[i-k-1], countDel);
            if (countMap.get(nums[i]) > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {1,2,3,1};
        int k = 3;
        boolean res = solution.containsNearbyDuplicate(nums, k);
        System.out.println(res);
        Assert.assertEquals(true, res);


        nums = new int[] {1,0,1,1};
        k = 1;
        res = solution.containsNearbyDuplicate(nums, k);
        System.out.println(res);
        Assert.assertEquals(true, res);

        nums = new int[] {1,2,3,1,2,3};
        k = 2;
        res = solution.containsNearbyDuplicate(nums, k);
        System.out.println(res);
        Assert.assertEquals(false, res);

        nums = new int[] {1};
        k = 1;
        res = solution.containsNearbyDuplicate(nums, k);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }
}
