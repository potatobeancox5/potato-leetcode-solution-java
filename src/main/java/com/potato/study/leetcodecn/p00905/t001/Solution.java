package com.potato.study.leetcodecn.p00905.t001;

import java.util.Arrays;

/**
 * 905. 按奇偶排序数组
 *
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。

 你可以返回满足此条件的任何数组作为答案。

  

 示例：

 输入：[3,1,2,4]
 输出：[2,4,3,1]
 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
  

 提示：

 1 <= A.length <= 5000
 0 <= A[i] <= 5000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 初始化 left 从 0 开始 right 从 1 开始
     * 会不会出现 左边 找到了 一个 奇数 右边找不到偶数， 那也就不用交换了 找到了临界点
     * while left < right
     *  左边找到第一个 奇数
     *  右边找到第一个偶数
     *  交换
     * @param arr
     * @return
     */
    public int[] sortArrayByParity(int[] arr) {
        if (null == arr || arr.length < 2) {
            return arr;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            // 左边找到第一个 奇数
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            // 右边找到第一个偶数
            while (left < right && arr[right] % 2 == 1) {
                right--;
            }
            // swap
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {3,1,2,4};
        int[] res = solution.sortArrayByParity(arr);
        System.out.println(Arrays.toString(res));
//        Assert.assertArrayEquals(, res);
    }

}
