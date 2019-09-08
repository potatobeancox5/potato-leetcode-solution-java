package com.potato.study.leetcode.p0330;

/**
 * 
 * @author liuzhao11
 * 
 *         330. Patching Array
 * 
 *         Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

Example 1:

Input: nums = [1,3], n = 6
Output: 1
Explanation:
Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.
Example 2:

Input: nums = [1,5,10], n = 20
Output: 2
Explanation: The two patches can be [2, 4].
Example 3:

Input: nums = [1,2,2], n = 5
Output: 0
 * 
 *         思路：
 *         https://www.jianshu.com/p/5b2898f53eae
 *         让miss表示[0-n]中最小的一个可能miss掉的sum, 那么我们可以达到[0, miss)所有的sum。
对于当前的num, 如果num<=miss, 那么就可以组成[0, miss+num)的所有sum, 如果不能,则把miss加入其中。
 *
 *
 * 
 */
public class Solution {

    public int minPatches(int[] nums, int n) {
        // 总是 + 1处理 ，标示当前可以标示和 + 1
        long miss = 1;
        // 记录应该添加的个数
        int count = 0;
        // 确保能生成到n
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                count++;
                // 因为可以标示出来【1-miss-1】,那么添加了miss之后 可以标示出【1-2miss-1】
                miss += miss;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1,5,10};
		int n = 20;
        int count = solution.minPatches(nums, n);
        System.out.println(count);
    }
}
