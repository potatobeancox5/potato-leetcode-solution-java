package com.potato.study.leetcode.p1013;


/**
 * 
 * @author liuzhao11
 * 
 * 	1013. Partition Array Into Three Parts With Equal Sum
 *  
 *        Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])



Example 1:

Input: A = [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
Example 2:

Input: A = [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false
Example 3:

Input: A = [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4


Constraints:

3 <= A.length <= 50000
-10^4 <= A[i] <= 10^4
 *         
 *         思路：
 *         https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/solution/java-shi-yong-shuang-zhi-zhen-by-sugar-31/
 */
public class Solution {

    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for(int i: arr){
            sum += i;
        }
        if(sum%3 != 0){
            // 总和不是3的倍数，直接返回false
            return false;
        }
        int s = 0;
        int flag = 0;
        for(int i:arr){
            s += i;
            if(s == sum/3){
                flag++;
                s = 0;
            }
        }
        // flag不一定等于3，例如[1,-1,1,-1,1,-1,1,-1]
        return flag >= 3;
    }
}
