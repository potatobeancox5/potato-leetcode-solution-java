package com.potato.study.leetcode.p0493;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         493. Reverse Pairs
 * 
 *         Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.

 *
 *
 *         题目含义：
 *          给了一串数字和一个逆序判定规则， 判定符合这种条件的逆序有多少种
 *         思路：
 *          493 求逆序对数

https://blog.csdn.net/hyb1996/article/details/79052719

要求
i 小于j
num i 大于 num j *2
满足上述条件的 对数

分治法 每个数只需要比较其后的数
mergeandcompare
参数 num  start end
返回值 int 逆序数

start 必须小于 end 否则返回0

计算min

求出子数组的逆序数和
cnt = start mid    + mid+1 end
for i start mid
while j end
满足逆序cnt加加
j++


排序 start 到 end
返回cnt
 *
 *
 *
 *
 */
public class Solution {

    public int reversePairs(int[] nums) {
        return mergeAndCompare(nums, 0, nums.length - 1);
    }

    private int mergeAndCompare(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end)/2;
        int cnt = mergeAndCompare(nums, start, mid) + mergeAndCompare(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i]/2.0 > nums[j]) {
                j++;
            }
            cnt += (j - mid - 1);
        }
        Arrays.sort(nums, start, end + 1);
        return  cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,3,2,3,1};
        int du = solution.reversePairs(nums);
        System.out.println(du);
        Assert.assertEquals(2, du);

        int[] nums1 = {2,4,3,5,1};
        du = solution.reversePairs(nums1);
        System.out.println(du);
        Assert.assertEquals(3, du);

        int[] nums2 = {2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647};
        du = solution.reversePairs(nums2);
        System.out.println(du);
        Assert.assertEquals(9, du);
    }
}
