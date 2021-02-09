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
     * 左侧 找到奇偶数 不同的位置 ，右边也找到
     * 交换 返回
     * @param arr
     * @return
     */
    public int[] sortArrayByParityII(int[] arr) {
        if (null == arr || arr.length == 0) {
            return arr;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < arr.length && right >= 0) {
            // 找到第一个 left 不匹配
            while ( left < arr.length && (arr[left]+ left) % 2 == 0) {
                left += 2;
            }
            if (left >= arr.length) {
                break;
            }
            // 找到第一个 right 不匹配
            while (right >= 0 && (arr[right]+ right) % 2 == 0) {
                right -= 2;
            }
            if (right < 0) {
                break;
            }
            // 匹配上 继续找
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
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
