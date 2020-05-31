package com.potato.study.leetcode.p1053;


/**
 * 
 * @author liuzhao11
 * 
 * 	1053. Previous Permutation With One Swap
 *  
 *        Given an array A of positive integers (not necessarily distinct), return the lexicographically largest permutation that is smaller than A, that can be made with one swap (A swap exchanges the positions of two numbers A[i] and A[j]).  If it cannot be done, then return the same array.



Example 1:

Input: [3,2,1]
Output: [3,1,2]
Explanation: Swapping 2 and 1.
Example 2:

Input: [1,1,5]
Output: [1,1,5]
Explanation: This is already the smallest permutation.
Example 3:

Input: [1,9,4,6,7]
Output: [1,7,4,6,9]
Explanation: Swapping 9 and 7.
Example 4:

Input: [3,1,1,3]
Output: [1,3,1,3]
Explanation: Swapping 1 and 3.


Note:

1 <= A.length <= 10000
1 <= A[i] <= 10000
 *         
 *
 *       题目含义：
 *          https://leetcode-cn.com/problems/previous-permutation-with-one-swap/solution/han-xiang-xi-fen-xi-si-lu-jian-dan-ti-mu-you-qu-by/
 */
public class Solution {


    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        int curMax = -1;
        int index = -1;
        boolean hasResult = false;
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i+1] < arr[i]) {
                // 此处逆序，需要移动A[i]
                for (int j = i + 1; j < len; j++) {
                    // 寻找与 A[i] 交换的位置
                    if (arr[i] > arr[j]) {
                        // 必须满足 A[i] > A[j]，否则不能满足交换后的字典序小于原始字典序
                        hasResult = true;
                        if (arr[j] > curMax) {
                            curMax = arr[j];
                            index = j;
                        }
                    }
                }
                if (hasResult) {
                    int tmp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = tmp;
                    return arr;
                }
            }
        }
        return arr;
    }
}
