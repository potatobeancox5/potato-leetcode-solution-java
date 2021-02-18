package com.potato.study.leetcodecn.p00888.t001;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 888. 公平的糖果棒交换
 *
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。

 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）

 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。

 如果有多个答案，你可以返回其中任何一个。保证答案存在。

  

 示例 1：

 输入：A = [1,1], B = [2,2]
 输出：[1,2]
 示例 2：

 输入：A = [1,2], B = [2,3]
 输出：[1,2]
 示例 3：

 输入：A = [2], B = [1,3]
 输出：[2,3]
 示例 4：

 输入：A = [1,2,5], B = [2,4]
 输出：[5,4]
  

 提示：

 1 <= A.length <= 10000
 1 <= B.length <= 10000
 1 <= A[i] <= 100000
 1 <= B[i] <= 100000
 保证爱丽丝与鲍勃的糖果总量不同。
 答案肯定存在。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/fair-candy-swap
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 求 sumA 和sum B
     * 计算 查 remind
     * y = x - （suma - sumb）/2
     * 求y 是否存在
     * @param a
     * @param b
     * @return
     */
    public int[] fairCandySwap(int[] a, int[] b) {
        long suma = 0;
        for (int i = 0; i < a.length; i++) {
            suma += a[i];
        }
        long sumb = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < b.length; i++) {
            sumb += b[i];
            set.add(b[i]);
        }
        int tmp = (int)((suma - sumb) / 2);
        for (int i = 0; i < a.length; i++) {
            int target = a[i] - tmp;
            if (set.contains(target)) {
                return new int[] {a[i], target};
            }
        }
        // 没有才会走到这
        return new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{1,1};
        int[] b = new int[]{2,2};
        int[] ints = solution.fairCandySwap(a, b);
        System.out.println(Arrays.toString(ints));// [1,2]
    }
}
