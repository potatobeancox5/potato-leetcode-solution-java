package com.potato.study.leetcodecn.p00978.t001;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

/**
 * 978. 最长湍流子数组
 *
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 *
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 *
 * 输入：[100]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1 计算 list 存放 arr i ， arr i-1 差 （正负即可）判断 计算正负顺序
     * 2 遍历 1 的list 计算 合法数组的长度
     * @param arr
     * @return
     */
    public int maxTurbulenceSize(int[] arr) {
        List<Integer> minusResultList = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            minusResultList.add(Integer.compare(arr[i], arr[i+1]));
        }
        // 遍历 1 的list 计算 合法数组的长度
        int max = 0;
        int len = 0;
        for (int i = 0; i < minusResultList.size(); i++) {
            Integer current = minusResultList.get(i);
            if (current == 0) {
                max = Math.max(max, len);
                len = 0;
                continue;
            }
            if (i == 0 || current != minusResultList.get(i-1)) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 1;
            }
        }
        max = Math.max(max, len);
        return max + 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {
                9,4,2,10,7,8,8,1,9
        };
        int size = solution.maxTurbulenceSize(arr);
        System.out.println(size);
        Assert.assertEquals(5, size);

        // [2,0,2,4,2,5,0,1,2,3]
        arr = new int[] {
                2,0,2,4,2,5,0,1,2,3
        };
        size = solution.maxTurbulenceSize(arr);
        System.out.println(size);
        Assert.assertEquals(6, size);
    }

}
