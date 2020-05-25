package com.potato.study.leetcode.p0923;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	923. 3Sum With Multiplicity
 *  
 *      Given an integer array A, and an integer target, return the number of tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.

As the answer can be very large, return it modulo 10^9 + 7.



Example 1:

Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation:
Enumerating by the values (A[i], A[j], A[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.
Example 2:

Input: A = [1,1,2,2,2,2], target = 5
Output: 12
Explanation:
A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.


Note:

3 <= A.length <= 3000
0 <= A[i] <= 100
0 <= target <= 300

 *         
 *         题目含义：
 *
 *         思路：
 *         https://leetcode-cn.com/problems/3sum-with-multiplicity/solution/san-shu-zhi-he-de-duo-chong-ke-neng-by-leetcode/
 *
 *
 * 
 */
public class Solution {


    public int threeSumMulti(int[] arr, int target) {
        int mod = 1_000_000_007;
        long ans = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; ++i) {
            // We'll try to find the number of i < j < k
            // with A[j] + A[k] == T, where T = target - A[i].

            // The below is a "two sum with multiplicity".
            int tt = target - arr[i];
            int j = i+1, k = arr.length - 1;

            while (j < k) {
                // These steps proceed as in a typical two-sum.
                if (arr[j] + arr[k] < tt) {
                    j++;
                } else if (arr[j] + arr[k] > tt) {
                    k--;
                } else if (arr[j] != arr[k]) {  // We have A[j] + A[k] == T.
                    // Let's count "left": the number of A[j] == A[j+1] == A[j+2] == ...
                    // And similarly for "right".
                    int left = 1, right = 1;
                    while (j+1 < k && arr[j] == arr[j+1]) {
                        left++;
                        j++;
                    }
                    while (k-1 > j && arr[k] == arr[k-1]) {
                        right++;
                        k--;
                    }

                    ans += left * right;
                    ans %= mod;
                    j++;
                    k--;
                } else {
                    // M = k - j + 1
                    // We contributed M * (M-1) / 2 pairs.
                    ans += (k-j+1) * (k-j) / 2;
                    ans %= mod;
                    break;
                }
            }
        }

        return (int) ans;
    }



    public static void main(String[] args) {
		Solution solution = new Solution();
        int[] arr = new int[]{1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        int num = solution.threeSumMulti(arr, target);
        System.out.println(num);
        Assert.assertEquals(20, num);
    }
}
