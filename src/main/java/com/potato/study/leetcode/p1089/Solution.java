package com.potato.study.leetcode.p1089;


import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 * 	1089. Duplicate Zeros
 *  
 *       Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.



Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]


Note:

1 <= arr.length <= 10000
0 <= arr[i] <= 9
 *         
 *
 *
 *
 *         思路：
 *         遍历数组 并记录当前数组可能长度，一旦到达了最后一个位置break；
 *
 *         从后往前移动
 *
 *
 */
public class Solution {

    public void duplicateZeros(int[] arr) {
        int currentLen = 0;
        int lastIndex = 0;
        boolean isLastDouble = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                currentLen += 2;
            } else {
                currentLen++;
            }
            // 是否满足结束条件
            if (currentLen == arr.length) {
                lastIndex = i;
                break;
            } else if (currentLen == arr.length + 1) {
                lastIndex = i;
                isLastDouble = true;
                break;
            } else if (currentLen == arr.length + 2) {
                lastIndex = i - 1;
                break;
            }
        }

        int index = arr.length - 1;
        for (int i = lastIndex; i >= 0 ; i--) {
            arr[index--] = arr[i];
            if (index < 0) {
                break;
            }
            if (arr[i] == 0) {
                if (i != lastIndex || !isLastDouble) {
                    arr[index--] = arr[i];
                }
            }
            if (index < 0) {
                break;
            }
        }
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {1,0,2,3,0,4,5,0};
//		int[] arr = {8,4,5,0,0,0,0,7};
        solution.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
