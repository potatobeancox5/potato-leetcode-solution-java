package com.potato.study.leetcode.p1073;


/**
 * 
 * @author liuzhao11
 * 
 * 	1073. Adding Two Negabinary Numbers
 *  
 *
Given two numbers arr1 and arr2 in base -2, return the result of adding them together.

Each number is given in array format:  as an array of 0s and 1s, from most significant bit to least significant bit.  For example, arr = [1,1,0,1] represents the number (-2)^3 + (-2)^2 + (-2)^0 = -3.  A number arr in array format is also guaranteed to have no leading zeros: either arr == [0] or arr[0] == 1.

Return the result of adding arr1 and arr2 in the same format: as an array of 0s and 1s with no leading zeros.



Example 1:

Input: arr1 = [1,1,1,1,1], arr2 = [1,0,1]
Output: [1,0,0,0,0]
Explanation: arr1 represents 11, arr2 represents 5, the output represents 16.


Note:

1 <= arr1.length <= 1000
1 <= arr2.length <= 1000
arr1 and arr2 have no leading zeros
arr1[i] is 0 or 1
arr2[i] is 0 or 1
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/adding-two-negabinary-numbers/solution/jian-dan-shu-xue-luo-ji-ji-bai-100-by-hao-da-da/
 *
 *
 */
public class Solution {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        if(arr1[0] == 0) {
            return arr2;
        }
        if(arr2[0] == 0) {
            return arr1;
        }
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len = Math.max(len1,len2) + 2;
        int[] ans = new int[len];
        int cur = len;
        int temp = len-1;
        while(len1 >= 1 || len2 >= 1 || cur >= 1){
            if(len1 >= 1){
                ans[cur-1] += arr1[len1-1];
                len1--;
            }
            if(len2 >= 1){
                ans[cur-1] += arr2[len2-1];
                len2--;
            }
            while(ans[cur-1]<0){
                ans[cur-1] = ans[cur-1]+2;
                ans[cur-2]++;
            }
            while(ans[cur-1]>1){
                ans[cur-1] -= 2;
                ans[cur-2]--;
            }
            cur--;
        }
        for(int i=0;i<len;i++){
            if(ans[i] == 1){
                temp = i;
                break;
            }
        }
        int[] res = new int[len-temp];
        for(int i=0,j = temp;j<len;j++,i++){
            res[i]=ans[j];
        }
        return res;
    }
	
	public static void main(String[] args) {
//		Solution solution = new Solution();
    }
}
