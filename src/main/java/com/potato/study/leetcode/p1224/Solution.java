package com.potato.study.leetcode.p1224;


import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 * 	1224. Maximum Equal Frequency
 *  
 *
Given an array nums of positive integers, return the longest possible length of an array prefix of nums, such that it is possible to remove exactly one element from this prefix so that every number that has appeared in it will have the same number of occurrences.

If after removing one element there are no remaining elements, it's still considered that every appeared number has the same number of ocurrences (0).



Example 1:

Input: nums = [2,2,1,1,5,3,3,5]
Output: 7
Explanation: For the subarray [2,2,1,1,5,3,3] of length 7, if we remove nums[4]=5, we will get [2,2,1,1,3,3], so that each number will appear exactly twice.
Example 2:

Input: nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
Output: 13
Example 3:

Input: nums = [1,1,1,2,2,2]
Output: 5
Example 4:

Input: nums = [10,2,8,9,3,8,1,5,2,3,7,6]
Output: 8


Constraints:

2 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/maximum-equal-frequency/solution/hashmapji-lu-pin-ci-yi-ci-bian-li-de-chu-jie-guo-b/
 *
 *
 *
 */
public class Solution {

    public int maxEqualFreq(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 1;
        int max = 0;
        int maxCount = 0;
        int oneCount = 0;
        int maxSubOneCount = 0;
        for(int i=0;i<nums.length;i++){
            // map存储 数字+出现次数
            Integer count = map.get(nums[i]);
            if(count==null){
                count = 0;
            }
            map.put(nums[i],++count);
            // 计算频次为1的个数
            if(count==1){
                oneCount++;
            }else if(count==2){
                oneCount--;
            }
            // 计算最大频次-1的个数
            if(max>=2){ // 最大频次大于等于二才需要计算
                if(count==max-1){
                    // 达到频次最大值-1 计入一个
                    maxSubOneCount++;
                }else if(count == max){
                    // 达到max,之前为max-1,max-1计数减少一个
                    maxSubOneCount--;
                }
            }
            // 计算最大频次
            if(count == max){
                maxCount++;
            }
            // 最大频次发生变化
            if(count>max){
                // 频次最大值变化
                max = count;
                // 前最大频次-1的个数=前最大频次个数>0?前最大频次个数-1:0
                maxSubOneCount = maxCount > 0 ? maxCount - 1 : 0;
                // 频次最大当前只有一个了
                maxCount = 1;
            }
            int size = map.size();
            // 1.一个最大频次其他全为最大频次减1；2.一个频次为1其他全为最大频次；3.频次全为1；
            if((maxCount+maxSubOneCount==size&&maxCount==1)
                    ||(maxCount+oneCount==size&&oneCount==1)
                    ||(oneCount==size)){
                res = i+1;
            }
        }
        return res;
    }


	
	public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{10,2,8,9,3,8,1,5,2,3,7,6};
        int res = solution.maxEqualFreq(nums);
        System.out.println(res);
        Assert.assertEquals(8, res);
    }
}
