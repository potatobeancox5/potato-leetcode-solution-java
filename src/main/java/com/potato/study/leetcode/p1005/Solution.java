package com.potato.study.leetcode.p1005;


/**
 * 
 * @author liuzhao11
 * 
 * 	1005. Maximize Sum Of Array After K Negations
 *  
 *         Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.



Example 1:

Input: A = [4,2,3], K = 1
Output: 5
Explanation: Choose indices (1,) and A becomes [4,-2,3].
Example 2:

Input: A = [3,-1,0,2], K = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
Example 3:

Input: A = [2,-3,-1,5,-4], K = 2
Output: 13
Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].


Note:

1 <= A.length <= 10000
1 <= K <= 10000
-100 <= A[i] <= 100
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/solution/java-chao-yue-9966xiang-xi-jie-xi-by-flychenkai/
 *
 */
public class Solution {

    public int largestSumAfterKNegations(int[] arr, int kk) {
        //-100 <= A[i] <= 100,这个范围的大小是201
        int[] number = new int[201];
        for (int t : arr) {
            number[t + 100]++;//将[-100,100]映射到[0,200]上
        }
        int i = 0;
        while (kk > 0) {
            //找到A[]中最小的数字
            while (number[i] == 0) {
                i++;
            }
            number[i]--;//此数字个数-1
            number[200 - i]++;//其相反数个数+1
            if (i > 100) {//若原最小数索引>100,则新的最小数索引应为200-i.(索引即number[]数组的下标)
                i = 200 - i;
            }
            kk--;
        }
        int sum = 0;
        for (int j = i; j <number.length ; j++) {//遍历number[]求和
            sum += (j-100)*number[j];//j-100是数字大小,number[j]是该数字出现次数.
        }
        return sum;
    }
}
