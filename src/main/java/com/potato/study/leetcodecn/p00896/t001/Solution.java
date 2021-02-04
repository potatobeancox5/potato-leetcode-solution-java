package com.potato.study.leetcodecn.p00896.t001;

import org.junit.Assert;

/**
 * 896. 单调数列
 *
 * 如果数组是单调递增或单调递减的，那么它是单调的。

 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。

 当给定的数组 A 是单调数组时返回 true，否则返回 false。

  

 示例 1：

 输入：[1,2,2,3]
 输出：true
 示例 2：

 输入：[6,5,4,4]
 输出：true
 示例 3：

 输入：[1,3,2]
 输出：false
 示例 4：

 输入：[1,2,4,5]
 输出：true
 示例 5：

 输入：[1,1,1]
 输出：true
  

 提示：

 1 <= A.length <= 50000
 -100000 <= A[i] <= 100000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/monotonic-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 单调性判定
     * @param arr
     * @return
     */
    public boolean isMonotonic(int[] arr) {
        boolean isUp = false;
        int i = 1;
        while (i < arr.length && arr[i-1] == arr[i]) {
            i++;
        }
        if (i < arr.length && arr[i-1] < arr[i]) {
            isUp = true;
        }
        for (int j = i; j < arr.length; j++) {
            if (isUp && arr[j-1] > arr[j]) {
                return false;
            } else if (!isUp && arr[j-1] < arr[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,2,3};
        boolean monotonic = solution.isMonotonic(arr);
        System.out.println(monotonic);
        Assert.assertEquals(true, monotonic);
    }
}
