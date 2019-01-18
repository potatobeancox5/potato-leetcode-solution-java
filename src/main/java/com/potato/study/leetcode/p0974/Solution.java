package com.potato.study.leetcode.p0974;

/**
 * 
 * @author liuzhao11
 * 
 * 	974. Subarray Sums Divisible by K
 *  
 *        Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.



Example 1:

Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

Note:

1 <= A.length <= 30000
-10000 <= A[i] <= 10000
2 <= K <= 10000
 *         
 *         思路：
 *          遍历数组，计算从index 0 到当前位置的和 sum
 *          设置一个remind[i] 记录 每个位置sum对于k的余数 i代表余数 注意保证i大于0
 *          遍历生成与的余数计数器，假设计数器数量为count
 *          那么 将会有 (count * （count -1） )/ 2 中可能得到 能被k整除的选择数
 *
 * 
 */
public class Solution {

    public int subarraysDivByK(int[] arr, int k) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int[] reminds = new int[k];
        int sum = 0;
        for (int ele :arr) {
            sum += ele;
            reminds[((sum % k) + k ) % k]++;
        }

        int result = 0;

        for (int remind : reminds) {
            if (remind > 0) {
                result += ((remind * (remind - 1)) / 2 );
            }
        }
        return result + reminds[0];
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] arr = {2,1,2};
//		int[] arr = {1,2,1};
//		int[] arr = {4,5,0,-2,-3,1};
		int[] arr = {5};
		int k = 9;
        int result = solution.subarraysDivByK(arr, k);
        System.out.println(result);
//        System.out.println(-6 % 5);
    }
}
