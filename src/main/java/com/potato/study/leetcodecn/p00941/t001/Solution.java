package com.potato.study.leetcodecn.p00941.t001;

/**
 * 941. 有效的山脉数组
 *
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。

 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：

 A.length >= 3
 在 0 < i < A.length - 1 条件下，存在 i 使得：
 A[0] < A[1] < ... A[i-1] < A[i]
 A[i] > A[i+1] > ... > A[A.length - 1]
  



  

 示例 1：

 输入：[2,1]
 输出：false
 示例 2：

 输入：[3,5,5]
 输出：false
 示例 3：

 输入：[0,3,2,1]
 输出：true
  

 提示：

 0 <= A.length <= 10000
 0 <= A[i] <= 10000 

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-mountain-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {
        int left = 0;
        while (left < arr.length - 1 && arr[left] <= arr[left+1]) {
            left++;
        }
        int right = left + 1;
        while (right < arr.length - 1 && arr[right] >= arr[right+1]) {
            right++;
        }
        // right 到不了最后一个位置
        return right == arr.length - 1;
    }


}
