package com.potato.study.leetcode.p0457;

import org.junit.Assert;

/**
 * 
 * @author liuzhao11
 * 
 *   457. Circular Array Loop
 * 
 *      You are given a circular array nums of positive and negative integers. If a number k at an index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward k steps. Since the array is circular, you may assume that the last element's next element is the first element, and the first element's previous element is the last element.

Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must not consist of both forward and backward movements.



Example 1:

Input: [2,-1,1,2,2]
Output: true
Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
Example 2:

Input: [-1,2]
Output: false
Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length is 1. By definition the cycle's length must be greater than 1.
Example 3:

Input: [-2,1,-1,-2,-2]
Output: false
Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement. All movements in a cycle must follow a single direction.


Note:

-1000 ≤ nums[i] ≤ 1000
nums[i] ≠ 0
1 ≤ nums.length ≤ 5000


Follow up:

Could you solve it in O(n) time complexity and O(1) extra space complexity?
 * 
 *         思路：
 *         457
https://blog.csdn.net/excellentlizhensbfhw/article/details/81151011

快慢指针, 是否相遇，
 *
 *
 *   有环的前提是，数组不能进行
 *   457. Circular Array Loop
https://blog.csdn.net/excellentlizhensbfhw/article/details/81151011

快慢指针

https://blog.csdn.net/excellentlizhensbfhw/article/details/81151011

子函数 getNextIndex index nums

返回 index + nums的index +nums.len ）-% len

主函数

每个点开始便利 i
j = i   k =getnext i
while ijk 同号
如果j等于k ret t
否则
j = getnext j
k getnext k
如果 jk 异号 break
k getnext
 *          
 *          
 * 			
 * 				
 */	
public class Solution {

    public boolean circularArrayLoop(int[] nums) {
        if (null == nums || nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int k = getNextIndex(j, nums);
            while (nums[i] * nums[j] > 0 && nums[i] * nums[k] > 0) {
                if (j == k) {
                    // 如果当前节点自己就是圈，那就不算了
                    if (j == getNextIndex(j, nums)) {
                        break;
                    }
                    return true;
                }
                j = getNextIndex(j, nums);
                k = getNextIndex(k, nums);
                if (nums[j] * nums[k] < 0) {
                    break;
                }
                k = getNextIndex(k, nums);
            }
        }
        return false;
    }

    /**
     * 获取当前 index 对应的下个位置的 index
     * @param index
     * @param nums
     * @return
     */
    private int getNextIndex(int index, int[] nums) {
        int nextIndex = index + nums[index] + nums.length;
        while (nextIndex < 0) {
            nextIndex += nums.length;
        }
        return nextIndex % nums.length;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
        int[] nums = {2,-1,1,2,2};
		boolean res = solution.circularArrayLoop(nums);
		System.out.println(res);
        Assert.assertEquals("", true, res);

        // [-1,2] false
        int[] nums1 = {-1, 2};
        res = solution.circularArrayLoop(nums1);
        System.out.println(res);
        Assert.assertEquals("", false, res);

//        [-1,-2,-3,-4,-5]

        int[] nums2 = {-1,-2,-3,-4,-5};
        res = solution.circularArrayLoop(nums2);
        System.out.println(res);
        Assert.assertEquals("", false, res);

        // [-2,-3,-9]

        int[] nums3 = {-2,-3,-9};
        res = solution.circularArrayLoop(nums3);
        System.out.println(res);
        Assert.assertEquals("", false, res);
    }

}
