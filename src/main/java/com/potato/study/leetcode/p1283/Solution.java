package com.potato.study.leetcode.p1283;


/**
 * 
 * @author liuzhao11
 * 
 * 	1283. Find the Smallest Divisor Given a Threshold
 *  
 *
Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the array by it and sum the result of the division. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

It is guaranteed that there will be an answer.



Example 1:

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
Example 2:

Input: nums = [2,3,5,7,11], threshold = 11
Output: 3
Example 3:

Input: nums = [19], threshold = 5
Output: 4


Constraints:

1 <= nums.length <= 5 * 10^4
1 <= nums[i] <= 10^6
nums.length <= threshold <= 10^6
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold/solution/er-fen-cha-zhao-man-zu-yao-qiu-de-shu-zu-de-zui-xi/
 *
 *
 *
 */
public class Solution {

    public int smallestDivisor(int[] nums, int threshold) {

        int left=1;//除数能取到的最小值
        int max_nums=nums[0];
        for(int i=0;i<nums.length;i++){
            max_nums=Math.max(nums[i],max_nums);
        }
        int right=max_nums;//再大也没有意义了，都是1+1+1...
        int mid, res=-1;
        while (left<=right){
            mid=(left+right)/2;
            if(helper(nums,mid,threshold)){
                right=mid-1;res=mid;
            } else {
                //满足条件，为了找左边界，继续向左半区间缩小
                left=mid+1;//不满足条件，除数还不够大
            }
        }
        return res;
    }
    public boolean helper(int [] nums,int mid,int threshold){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%mid==0) {
                sum+=nums[i]/mid;
            } else {
                sum+=(nums[i]/mid+1);
            }
            if(sum>threshold) {
                return false;
            }
        }
        return true;
    }
}
