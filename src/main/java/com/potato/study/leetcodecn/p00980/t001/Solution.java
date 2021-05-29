package com.potato.study.leetcodecn.p00980.t001;

import java.util.ArrayList;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 *
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。

 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。

  

 示例 1：

 输入：A = [1,2,0,0], K = 34
 输出：[1,2,3,4]
 解释：1200 + 34 = 1234
 示例 2：

 输入：A = [2,7,4], K = 181
 输出：[4,5,5]
 解释：274 + 181 = 455
 示例 3：

 输入：A = [2,1,5], K = 806
 输出：[1,0,2,1]
 解释：215 + 806 = 1021
 示例 4：

 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 输出：[1,0,0,0,0,0,0,0,0,0,0]
 解释：9999999999 + 1 = 10000000000
  

 提示：

 1 <= A.length <= 10000
 0 <= A[i] <= 9
 0 <= K <= 10000
 如果 A.length > 1，那么 A[0] != 0

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     *
     * @param arr
     * @param k
     * @return
     */
    public List<Integer> addToArrayForm(int[] arr, int k) {
        int index = arr.length - 1;
        List<Integer> result = new ArrayList<>();
        int process = 0;
        while (index >= 0 && k > 0) {
            int num1 = arr[index--];
            int num2 = k % 10;
            k /= 10;
            int value = num1 + num2 + process;
            if (value > 9) {
                process = 1;
                value %= 10;
            } else {
                process = 0;
            }
            result.add(0, value);
        }
        while (index >= 0) {
            int num1 = arr[index--];
            int value = num1 + process;
            if (value > 9) {
                process = 1;
                value %= 10;
            } else {
                process = 0;
            }
            result.add(0, value);
        }
        while (k > 0) {
            int num2 = k % 10;
            k /= 10;
            int value = num2 + process;
            if (value > 9) {
                process = 1;
                value %= 10;
            } else {
                process = 0;
            }
            result.add(0, value);
        }
        if (process > 0) {
            result.add(0, process);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,0,0};
        int k = 34;
        List<Integer> list = solution.addToArrayForm(arr, k);
        System.out.println(list);

        arr = new int[]{2,7,4};
        k = 181;
        list = solution.addToArrayForm(arr, k);
        System.out.println(list);

        arr = new int[]{2,1,5};
        k = 806;
        list = solution.addToArrayForm(arr, k);
        System.out.println(list);

        arr = new int[]{9,9,9,9,9,9,9,9,9,9};
        k = 1;
        list = solution.addToArrayForm(arr, k);
        System.out.println(list);
    }

}
