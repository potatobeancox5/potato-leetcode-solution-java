package com.potato.study.leetcode.p1187;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1187. Make Array Strictly Increasing
 *  
 *
Given two integer arrays arr1 and arr2, return the minimum number of operations (possibly zero) needed to make arr1 strictly increasing.

In one operation, you can choose two indices 0 <= i < arr1.length and 0 <= j < arr2.length and do the assignment arr1[i] = arr2[j].

If there is no way to make arr1 strictly increasing, return -1.



Example 1:

Input: arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
Output: 1
Explanation: Replace 5 with 2, then arr1 = [1, 2, 3, 6, 7].
Example 2:

Input: arr1 = [1,5,3,6,7], arr2 = [4,3,1]
Output: 2
Explanation: Replace 5 with 3 and then replace 3 with 4. arr1 = [1, 3, 4, 6, 7].
Example 3:

Input: arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
Output: -1
Explanation: You can't make arr1 strictly increasing.


Constraints:

1 <= arr1.length, arr2.length <= 2000
0 <= arr1[i], arr2[i] <= 10^9
 *         
 *         思路：
 *
 *          https://leetcode-cn.com/problems/make-array-strictly-increasing/solution/zhao-zhao-da-an-xie-de-javade-by-afan-k7/
 *

 *
 */
public class Solution {

    public  int makeArrayIncreasing(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length==0) {
            return -1;
        }
        Arrays.sort(arr2);
        int length1 = arr1.length;
        int length2 = arr2.length;
        int[][] dp = new int[length1][length1+1];

        dp[0][0] =  arr1[0];
        dp[0][1] = Math.min(arr1[0],arr2[0]);
        for(int i=1;i<length1;i++){
            int index1 = get2(dp[i-1][i],arr2);
            for(int j=i+1;j>=0;j--){
                int a,b;
                a = arr1[i]>dp[i-1][j==i+1?i:j] ? arr1[i] : Integer.MAX_VALUE;//不换a[i]
                index1 = j>0?get(dp[i-1][j-1],index1,arr2):length2;
                b = j!=0 && index1<length2 ?arr2[index1]:Integer.MAX_VALUE;// 换a[i]
                dp[i][j] = Math.min(a,b);
            }
        }
        int re = -1;
        for(int i=0;i<=length1;i++){
            if(dp[length1-1][i]<Integer.MAX_VALUE) {
                re = i;
                break;
            }
        }
        return re;
    }

    private int get(int n,int index,int[] arr){
        while(index<arr.length){
            if(arr[index]>n) {
                break;
            }
            index ++;
        }
        return index;
    }

    private int get2(int n,int[] arr){
        int l=0,r = arr.length-1;
        int re = -1;
        while(r-l>1){
            if(arr[l+r>>1]>n){
                r = l+r>>1;
            }else{
                l = l+r>>1;
            }
        }
        if(arr[l]>n) {
            re = l;
        } else {
            re = l+1;
        }
        return re;
    }
}
