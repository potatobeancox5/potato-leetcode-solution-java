package com.potato.study.leetcodecn.p00974.t001;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。

  

 示例：

 输入：A = [4,5,0,-2,-3,1], K = 5
 输出：7
 解释：
 有 7 个子数组满足其元素之和可被 K = 5 整除：
 [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
  

 提示：

 1 <= A.length <= 30000
 -10000 <= A[i] <= 10000
 2 <= K <= 10000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 还是所谓，前缀和，也就是将前缀看成一个整体，然后计算前缀拥有的属性，使用map
     * 通过 计算target形式，找到前缀之间的操作方法 达到目的
     * 本题 map int int key前缀和%k， value 得到key这个结果的前缀谁 空前缀key = 0 value = 1
     * @param arr
     * @param k
     * @return
     */
    public int subarraysDivByK(int[] arr, int k) {
        int prefixSum = 0;
        Map<Integer, Integer> remainderCountMap = new HashMap<>();
        // 初始化 空集前缀和 = 0 余数也是 0
        remainderCountMap.put(0, 1);
        int totalCount = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int remind = prefixSum % k;
            if (remind < 0) {
                remind += k;
            }
            // 计算要从map 中过去的数量 必须表征 remind 被删去才能是整除
            Integer targetCount = remainderCountMap.getOrDefault(remind, 0);
            totalCount += targetCount;
            // update map
            remainderCountMap.put(remind, targetCount + 1);
        }
        return totalCount;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{4,5,0,-2,-3,1};
        int k = 5;
        int count = solution.subarraysDivByK(arr, k);
        System.out.println(count);
        Assert.assertEquals(7, count);

        arr = new int[]{-1,2,9};
        k = 2;
        count = solution.subarraysDivByK(arr, k);
        System.out.println(count);
        Assert.assertEquals(2, count);
    }

}
