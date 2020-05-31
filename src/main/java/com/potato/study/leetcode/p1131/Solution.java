package com.potato.study.leetcode.p1131;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1131. Maximum of Absolute Value Expression
 *  
 *
 * Given two arrays of integers with equal lengths, return the maximum value of:

|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|

where the maximum is taken over all 0 <= i, j < arr1.length.



Example 1:

Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
Output: 13
Example 2:

Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
Output: 20


Constraints:

2 <= arr1.length == arr2.length <= 40000
-10^6 <= arr1[i], arr2[i] <= 10^6
 *         
 *      思路：
 *      https://leetcode-cn.com/problems/maximum-of-absolute-value-expression/solution/yi-xyzsan-zhou-fan-zhuan-chu-8-zhong-ke-neng-mei-z/
 *
 *
 */
public class Solution {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int[][] rotates=new int[][]{ // 在三維的情況下，有 8 種翻轉可能
                {1,1,1},{1,1,-1},{1,-1,1},{1,-1,-1},
                {-1,1,1},{-1,1,-1},{-1,-1,1},{-1,-1,-1}};
        int n = arr1.length; // 確認共有幾個點
        int[] rMxVls = new int[8]; // 記錄8種翻轉情況下，每種翻轉情況下的最大值
        Arrays.fill(rMxVls,Integer.MIN_VALUE); // 預填初始為最小
        for(int rIx=0;rIx<8;rIx++){ // 依序處理 8 種翻轉情況
            int[] r = rotates[rIx]; // 取出 翻轉 參數
            for(int ix=0;ix<n;ix++){ // 對每一個點 翻轉 後，取最大值
                rMxVls[rIx] = Math.max(rMxVls[rIx], r[0]*arr1[ix]+r[1]*arr2[ix]+r[2]*ix);
            }
        }
        int[] rMnVls = new int[8]; // 記錄8種翻轉情況下，每種翻轉情況下的最小值
        Arrays.fill(rMnVls,Integer.MAX_VALUE); // 預填初始為最大
        for(int rIx=0;rIx<8;rIx++){ // 依序處理 8 種翻轉情況
            int[] r=rotates[rIx]; // 取出 翻轉 參數
            for(int ix=0;ix<n;ix++){ // 對每一個點 翻轉 後，取最小值
                rMnVls[rIx]=Math.min(rMnVls[rIx], r[0]*arr1[ix]+r[1]*arr2[ix]+r[2]*ix);
            }
        }
        int mxV=0;
        for(int ix=0;ix<8;ix++){// 對每種翻轉情況，計算 "最大的曼哈頓距離"
            mxV=Math.max(mxV,rMxVls[ix]-rMnVls[ix]);//取最大值為解
        }
        return mxV;
    }

}
