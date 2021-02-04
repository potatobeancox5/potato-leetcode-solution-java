package com.potato.study.leetcodecn.p00908.t001;

/**
 * 908. 最小差值 I
 *
 * 给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。

 返回数组 B 的最大值和最小值之间可能存在的最小差值。

  

 示例 1：

 输入：A = [1], K = 0
 输出：0
 解释：B = [1]
 示例 2：

 输入：A = [0,10], K = 2
 输出：6
 解释：B = [2,8]
 示例 3：

 输入：A = [1,3,6], K = 3
 输出：0
 解释：B = [3,3,3] 或 B = [4,4,4]
  

 提示：

 1 <= A.length <= 10000
 0 <= A[i] <= 10000
 0 <= K <= 10000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/smallest-range-i
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历 找到最大值和最小值 计算差值
     * @param arr
     * @param k
     * @return
     */
    public int smallestRangeI(int[] arr, int k) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        if (2 * k >= max - min) {
            return 0;
        } else {
            return max - min - 2 * k;
        }
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] arr = new int[] {4,2,5,7};
//        int[] ints = solution.sortArrayByParityII(arr);
//        System.out.println(Arrays.toString(ints)); // [4,5,2,7]
//
//
//        arr = new int[] {2,0,3,4,1,3};
//        ints = solution.sortArrayByParityII(arr);
//        System.out.println(Arrays.toString(ints)); // [2,3,0,1,4,3]
//    }


}
