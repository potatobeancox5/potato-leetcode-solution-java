package com.potato.study.leetcode.p0454;


import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author liuzhao11
 * 
 *   454. 4Sum II
 * 
 *      Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * 
 *         思路：
 *         https://blog.csdn.net/qq508618087/article/details/53255924
 *
 *         先求ab的和 放到map 中 ，再计算 cd 和的时候从map 中找target
 * 				
 */	
public class Solution {

    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        // key ab的和 value 这个和出现的次数
        Map<Integer, Integer> valueCountMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int value = a[i] + b[j];
                Integer count = valueCountMap.get(value);
                if (count == null) {
                    valueCountMap.put(value, 1);
                } else {
                    valueCountMap.put(value, count + 1);
                }
            }
        }
        // cd 和
        int totalCount = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                int value = c[i] + d[j];
                Integer count = valueCountMap.get(0 - value);
                if (null != count) {
                    totalCount += count;
                }
            }
        }
        return totalCount;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
	}
}
