package com.potato.study.leetcode.p0698;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 * 698. Partition to K Equal Sum Subsets
 *  
 *       Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.



Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.


Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.



 *         题目解释：
 *
 *          https://www.jianshu.com/p/d82dd9be044e
 *
 *
 *
 * 
 */
public class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        // 1. 计算出 每组的大小
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / k;

        if (target * k != sum) {
            return false;
        }

        boolean[] isVisited = new boolean[nums.length];
        // 2. dfs 依次找到 每个组是否能组成求得的个数
        boolean result = this.dfsForGetTheResult(isVisited, target, 0, k, 0, nums, 0);
        return result;
    }



    /**
     *
     * @param isVisited     当前i位置的数字是否被使用过
     * @param target        每子组最终 达到的 sum
     * @param curentSum     当前组的 sum
     * @param k             当前还需要构造多少组
     * @param setNum        当前组包含了多少个元素
     * @param nums          原来的num数组
     * @param startIndex    开始遍历的位置
     * @return
     */
    private boolean dfsForGetTheResult(boolean[] isVisited, int target, int curentSum,
                                       int k, int setNum, int[] nums, int startIndex) {

        // 0 判断 k 是否已经是 1
        if (k == 1) {
            return true;
        }
        // 1. 判断是否已经满足终止条件： curentSum == target  且  setNum > 0 (防止 target 为0 的情况)
        if (curentSum == target && setNum > 0) {
            return dfsForGetTheResult(isVisited, target, 0, k-1,  0, nums, 0);
        }
        // 3. 遍历  nums 选择没有visit 的进行判断 如果 curentSum + 当前值 < target 递归找，并返回
        for (int i = startIndex; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            if (curentSum + nums[i] <= target) {
                isVisited[i] = true;
                // 2. 设置当前标记为
                if (dfsForGetTheResult(isVisited, target, curentSum + nums[i], k, setNum++, nums, i+1)) {
                    // 条件为 true
                    return true;
                }
                // 4. 重置标记为
                isVisited[i] = false;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		Solution solution = new Solution();


        int[] nums = {4, 3, 2, 3, 5, 2, 1};// 6
        int k = 4;
        boolean res = solution.canPartitionKSubsets(nums, k);
        System.out.println(res);
        Assert.assertEquals(true, res);

        int[] nums1 = {1,2,3,4};// 6
        k = 3;
        res = solution.canPartitionKSubsets(nums1, k);
        System.out.println(res);
        Assert.assertEquals(false, res);


        int[] nums2 = {18,20,39,73,96,99,101,111,114,190,207,295,471,649,700,1037};
        k = 4;
        res = solution.canPartitionKSubsets(nums2, k);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }
}
