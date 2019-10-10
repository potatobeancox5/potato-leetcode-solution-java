package com.potato.study.leetcode.p0384;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 *       384. Shuffle an Array
 * 
 *      Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 *         
 *         思路：
 *
 *
 *
 *
 */
public class Solution {

    private int[] nums;
    private Set<Integer> indexSet;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        indexSet = new HashSet<>();
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        indexSet = new HashSet<>();
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(nums.length);
            while (indexSet.contains(index)) {
                index = random.nextInt(nums.length);
            }
            newNums[i] = nums[index];
            indexSet.add(index);
        }
        return newNums;
    }


	
	public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution solution = new Solution(nums);
        int[] shuffle = solution.shuffle();
        System.out.println(shuffle);
        int[] reset = solution.reset();
        System.out.println(reset);
        int[] shuffle1 = solution.shuffle();
        System.out.println(shuffle1);
    }
}
