package com.potato.study.leetcodecn.p00845.t001;


import org.junit.Assert;

/**
 * 845. 数组中的最长山脉
 *
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 845
     * @param arr
     * @return
     */
    public int longestMountain(int[] arr) {
        // 从当前位置往左有多少个下降
        int[] left = new int[arr.length];
        left[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                left[i] = left[i-1] + 1;
            }
        }
        int[] right = new int[arr.length];
        right[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                right[i] = right[i+1] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (left[i] > 0 && right[i] > 0) {
                max = Math.max(max, left[i] + right[i] + 1);
            }
        }
        if (max < 3) {
            max = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {
                2,1,4,7,3,2,5
        };
        int i = solution.longestMountain(arr);
        System.out.println(i);
        Assert.assertEquals(5, i);


        arr = new int[] {
                2,2,2
        };
        i = solution.longestMountain(arr);
        System.out.println(i);
        Assert.assertEquals(0, i);

        arr = new int[] {
                1,2,3
        };
        i = solution.longestMountain(arr);
        System.out.println(i);
        Assert.assertEquals(0, i);
    }
}
