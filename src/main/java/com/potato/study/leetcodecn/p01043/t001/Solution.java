package com.potato.study.leetcodecn.p01043.t001;

import org.junit.Assert;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1043. 分隔数组以得到最大和
 *
 * 给你一个整数数组 arr，请你将该数组分隔为长度最多为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。

 返回将数组分隔变换后能够得到的元素最大和。

  

 注意，原数组和分隔后的数组对应顺序应当一致，也就是说，你只能选择分隔数组的位置而不能调整数组中的顺序。

  

 示例 1：

 输入：arr = [1,15,7,9,2,5,10], k = 3
 输出：84
 解释：
 因为 k=3 可以分隔成 [1,15,7] [9] [2,5,10]，结果为 [15,15,15,9,10,10,10]，和为 84，是该数组所有分隔变换后元素总和最大的。
 若是分隔成 [1] [15,7,9] [2,5,10]，结果就是 [1, 15, 15, 15, 10, 10, 10] 但这种分隔方式的元素总和（76）小于上一种。
 示例 2：

 输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 输出：83
 示例 3：

 输入：arr = [1], k = 1
 输出：1
  

 提示：

 1 <= arr.length <= 500
 0 <= arr[i] <= 109
 1 <= k <= arr.length

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/partition-array-for-maximum-sum
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
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // dp i 到i 为止最大的值
        int[] dp = new int[arr.length+1];
        // dp 0 就是 数量为 0 时的最大值
        dp[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            // 枚举最后一个位置 dpi 对应就是 i之前的数字
            int max = arr[i-1];
            for (int j = i-1; j >= 0; j--) {
                if (i - j > k) {
                    break;
                }
                // 计算当前最大值 k- i
                max = Math.max(max, arr[j]);
                // dp i 等于 max { j 从 0-idp j + i-j区间最大值 * ij间距
                dp[i] = Math.max(dp[i], dp[j] + max * (i - j));
            }
        }
        return dp[arr.length];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{
                1
        };
        int k = 1;
        int i = solution.maxSumAfterPartitioning(arr , k);
        System.out.println(i);
        Assert.assertEquals(1, i);

        arr = new int[]{
                1,4,1,5,7,3,6,1,9,9,3
        };
        k = 4;
        i = solution.maxSumAfterPartitioning(arr , k);
        System.out.println(i);
        Assert.assertEquals(83, i);

        arr = new int[]{
                1,15,7,9,2,5,10
        };
        k = 3;
        i = solution.maxSumAfterPartitioning(arr , k);
        System.out.println(i);
        Assert.assertEquals(84, i);
    }
}
