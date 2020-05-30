package com.potato.study.leetcode.p1346;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liuzhao11
 * 
 * 	1346. Check If N and Its Double Exist
 *  
 *
Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]


Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
Example 2:

Input: arr = [7,1,14,11]
Output: true
Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
Example 3:

Input: arr = [3,1,7,11]
Output: false
Explanation: In this case does not exist N and M, such that N = 2 * M.


Constraints:

2 <= arr.length <= 500
-10^3 <= arr[i] <= 10^3
 *         
 *         思路：
 *          https://leetcode-cn.com/problems/check-if-n-and-its-double-exist/solution/pai-xu-huo-bu-pai-xu-by-lzhlyle/
 *
 *
 *
 *
 */
public class Solution {

    public boolean checkIfExist(int[] arr) {
        // 负数...0...0...正数
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for (int value : arr) {
            // 只对非负数
            if (value <= 0) {
                continue;
            }
            if (set.contains(value)) {
                return true;
            }
            set.add(value * 2);
        }
        set.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            // 只对负数
            if (arr[i] > 0) {
                continue;
            }
            if (set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i] * 2);
        }
        return false;
    }

	public static void main(String[] args) {

    }
}
