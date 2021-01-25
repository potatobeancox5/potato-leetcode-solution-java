package com.potato.study.leetcodecn.p00930.t001;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. 和相同的二元子数组
 *
 * 在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。

  

 示例：

 输入：A = [1,0,1,0,1], S = 2
 输出：4
 解释：
 如下面黑体所示，有 4 个满足题目要求的子数组：
 [1,0,1,0,1]
 [1,0,1,0,1]
 [1,0,1,0,1]
 [1,0,1,0,1]
  

 提示：

 A.length <= 30000
 0 <= S <= A.length
 A[i] 为 0 或 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 还是前缀和 + countMap 计算 前缀出现过多少次
     * 遍历数组 arr 再map 中找到出现的次数，并累加加过
     * @param arr
     * @param s
     * @return
     */
    public int numSubarraysWithSum(int[] arr, int s) {
        int prefixSum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        // 增加从0 开始的情况 最开始什么都没有的情况
        countMap.put(0, 1);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            // 生成 prefixSum
            prefixSum += arr[i];
            // 计算 target prefixSum - prefixSum'(之前的) == s
            int target = prefixSum - s;
            // 累加加过
            Integer appearanceCount = countMap.getOrDefault(target, 0);
            result += appearanceCount;
            // 补充 countMap
            Integer count = countMap.getOrDefault(prefixSum, 0);
            count++;
            countMap.put(prefixSum, count);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] {1,0,1,0,1};
        int s = 2;
        int ints = solution.numSubarraysWithSum(arr, s);
        System.out.println(ints);
        Assert.assertEquals(4, ints);


    }


}
