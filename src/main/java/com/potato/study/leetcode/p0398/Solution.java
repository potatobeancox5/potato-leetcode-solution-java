package com.potato.study.leetcode.p0398;

import java.util.Random;

/**
 * 
 * @author liuzhao11
 * 
 *       398. Random Pick Index
 * 
 *     Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
 *         
 *         思路：
 *          给定一个数组， 外部调用pick方法 可以快速随机返回targer 对应的index 要求等概率
 *          https://www.jianshu.com/p/32120d856793
 *
 *
 *
 *         
 */
public class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (target != num) {
                continue;
            }
            count++;
            if (random.nextInt(count) == 0) {
                index = i;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        int[] nums = {};
        Solution solution = new Solution(nums);
        int pick = solution.pick(3);

    }
}

