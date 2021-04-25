package com.potato.study.leetcodecn.p00922.t001;

import java.util.Arrays;

/**
 * 922. 按奇偶排序数组 II
 *
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

 你可以返回任何满足上述条件的数组作为答案。

  

 示例：

 输入：[4,2,5,7]
 输出：[4,5,2,7]
 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
  

 提示：

 2 <= A.length <= 20000
 A.length % 2 == 0
 0 <= A[i] <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 一个只检查奇数 index 对应位置
     * 一个只检查偶数 index 对应位置
     * 交换 返回
     * @param arr
     * @return
     */
    public int[] sortArrayByParityII(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }
        int index0 = 0;
        int index1 = 1;

        while (index0 < arr.length && index1 < arr.length) {
            // 找到第一个奇数位置
            while (index0 < arr.length && arr[index0] % 2 == 0) {
                index0 += 2;
            }
            // 找到第一个偶数位置
            while (index1 < arr.length && arr[index1] % 2 == 1) {
                index1 += 2;
            }
            if (index0 >= arr.length || index1 >= arr.length) {
                break;
            }
            // 交换
            int tmp = arr[index0];
            arr[index0] = arr[index1];
            arr[index1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {4,2,5,7};
        int[] ints = solution.sortArrayByParityII(arr);
        System.out.println(Arrays.toString(ints)); // [4,5,2,7]


        arr = new int[] {2,0,3,4,1,3};
        ints = solution.sortArrayByParityII(arr);
        System.out.println(Arrays.toString(ints)); // [2,3,0,1,4,3]
    }


}
