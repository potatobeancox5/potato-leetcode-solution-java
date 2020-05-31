package com.potato.study.leetcode.p0995;


/**
 * 
 * @author liuzhao11
 * 
 * 	  995. Minimum Number of K Consecutive Bit Flips
 *  
 *         In an array A containing only 0s and 1s, a K-bit flip consists of choosing a (contiguous) subarray of length K and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.

Return the minimum number of K-bit flips required so that there is no 0 in the array.  If it is not possible, return -1.



Example 1:

Input: A = [0,1,0], K = 1
Output: 2
Explanation: Flip A[0], then flip A[2].
Example 2:

Input: A = [1,1,0], K = 2
Output: -1
Explanation: No matter how we flip subarrays of size 2, we can't make the array become [1,1,1].
Example 3:

Input: A = [0,0,0,1,0,1,1,0], K = 3
Output: 3
Explanation:
Flip A[0],A[1],A[2]: A becomes [1,1,1,1,0,1,1,0]
Flip A[4],A[5],A[6]: A becomes [1,1,1,1,1,0,0,0]
Flip A[5],A[6],A[7]: A becomes [1,1,1,1,1,1,1,1]


Note:

1 <= A.length <= 30000
1 <= K <= A.length
 *         
 *         思路：
 *  https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/k-lian-xu-wei-de-zui-xiao-fan-zhuan-ci-shu-by-leet/
 *
 */
public class Solution {


    public int minKBitFlips(int[] arr, int kk) {
        int len = arr.length;
        int[] hint = new int[len];
        int ans = 0, flip = 0;

        // 当我们翻转子数组形如 A[i], A[i+1], ..., A[i+K-1]
        // 我们可以在此位置置反翻转状态，并且在位置 i+K 设置一个提醒，告诉我们在那里也要置反翻转状态
        for (int i = 0; i < len; ++i) {
            flip ^= hint[i];
            if (arr[i] == flip) {  // 我们是否必须翻转从此开始的子数组
                ans++;  // 翻转子数组 A[i] 至 A[i+K-1]
                if (i + kk > len) {
                    return -1;  // 如果没办法翻转整个子数组了，那么就不可行
                }
                flip ^= 1;
                if (i + kk < len) {
                    hint[i + kk] ^= 1;
                }
            }
        }
        return ans;
    }
}
