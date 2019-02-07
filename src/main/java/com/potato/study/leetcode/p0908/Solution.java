package com.potato.study.leetcode.p0908;

/**
 * 
 * @author liuzhao11
 * 
 * 	908. Smallest Range I
 *  
 *      Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].

After this process, we have some array B.

Return the smallest possible difference between the maximum value of B and the minimum value of B.



Example 1:

Input: A = [1], K = 0
Output: 0
Explanation: B = [1]
Example 2:

Input: A = [0,10], K = 2
Output: 6
Explanation: B = [2,8]
Example 3:

Input: A = [1,3,6], K = 3
Output: 0
Explanation: B = [3,3,3] or B = [4,4,4]


Note:

1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000

 *         
 *         题目含义：
 *
 *         思路：
 *         遍历数组 找到最大值 最小值
            计算相差值
            相差值在2k之间 直接为0
        否则 大的减去2 小的加上2 计算差值

 *
 *
 *
 */
public class Solution {

    public int smallestRangeI(int[] arr, int key) {
        int max = arr[0];
        int min = arr[arr.length - 1];
        for (int num : arr) {
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        int distance = max - min;
        if (distance <= key * 2) {
            return 0;
        } else {
            return distance - 2 * key;
        }
    }




    public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] arr = {1};
//        int key = 0;
//        int key = 2;
//        int[] arr = {0, 10};
        int key = 3;
        int[] arr = {1, 3, 6};
        int result = solution.smallestRangeI(arr, key);
        System.out.println(result);
    }
}
