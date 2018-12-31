package com.potato.study.leetcode.p0179;

/**
 * 
 * @author liuzhao11
 * 
 *    179. Largest Number
 *         
 *          
 *   Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.



 *         思路： 
 *         对数组进行排序，排序的规则就是谁在前边大谁就在前边
 *         
 *        
 */
public class Solution {

    public String largestNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return "";
        }
        if(nums.length == 1) {
            return "" + nums[0];
        }
        // 对数组进行插入排序
        for (int i = 1; i < nums.length; i++) {
            for (int j = i ; j > 0; j--) {
                if(isriority(nums[j-1], nums[j])) {
                    break;
                } else { // 交换位置
                    int tmp = nums[j];
                    nums[j] = nums[j -1];
                    nums[j -1] = tmp;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        boolean isZeroStart = false;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0 && nums[0] == 0) {
                isZeroStart = true;
                continue;
            }
            if(isZeroStart && nums[i] == 0) {
                continue;
            }
            if(isZeroStart && nums[i] != 0) {
                isZeroStart = false;
            }
            builder.append(nums[i]);
        }
        if (builder.length() == 0) {
            return "0";
        }
        return builder.toString();
    }

    /**
     * a 是否优先于 b
     * 判定规则是 谁放在前边组成的数组更大
     * @param a
     * @param b
     * @return
     */
    private boolean isriority(int a, int b) {
        String aNum = "" + a + b;
        String bNum = "" + b + a;
        if (compareNumStr(aNum, bNum) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    private int compareNumStr(String a, String b) {
        if(a.length() > b.length()) {
            return 1;
        } else if (a.length() < b.length()) {
            return -1;
        } else { // 数位相等比较字母
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i) == b.charAt(i)) {
                    continue;
                } else if (a.charAt(i) - b.charAt(i) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {10,2};
		String num = solution.largestNumber(nums);

        int[] nums1 = {3,30,34,5,9};
        num = solution.largestNumber(nums1);

		System.out.println(num);
	}
}
