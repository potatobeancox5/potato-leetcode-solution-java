package com.potato.study.leetcode.p0327;

import com.potato.study.leetcode.domain.ListNode;
import org.junit.Assert;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * 
 * @author liuzhao11
 * 
 *         327. Count of Range Sum
 * 
 *         Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:

Input: nums = [-2,5,-1], lower = -2, upper = 2,
Output: 3
Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 * 
 *         思路：
 *         https://blog.csdn.net/jmspan/article/details/51266931
 *          使用 TreeMap 记录 sum[j] 的值（相同的sum[j]） value ++
 *          使用 sum i 数组 记录 从 0 - i的和
 *          遍历 sum
 *          如果 sum i 位于 lower 和 upper 之间 count ++；
 *          计算出来 当前 sum[i] 到 [lower, upper] 之间的距离
 *          从 TreeMap 获取到 之前的值 然后统计有多少个 记录在 total中
 *
 *          将本次访问的sum i 添加到 TreeMap 中 并修改次数
 *
 *          subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) 
 *          方法用于返回此映射从fromKey到toKey范围的键值的部分视图。如果fromKey和toKey相等，
 *          则返回映射为空，除非fromExclusive和toExclusive都是true。返回的映射受此映射支持，因此改变返回映射反映在此映射中，反之亦然。原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/java/util/treemap_submap_inclusive.html


 *
 * 
 */
public class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        // 0. 生成 0-i的 sum
        long[] sums = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sums[i] = nums[0];
                continue;
            }
            sums[i] = sums[i-1] + nums[i];
        }
        // 1.遍历sum值 统计 sum 值出现的次数
        TreeMap<Long, Integer> sumTimesMap = new TreeMap<>();
        // 记录总共有多少个区间 满足 lower upper 的条件
        int total = 0;
        for (long sum : sums) {
            // 1.0 判断 当前 sum 是否合法
            if (lower <= sum && sum <= upper) {
                total++;
            }
            // 1.1 找到当前sum 距离 范围差多少，并在 sumTimesMap 中寻找
            long lowLimit = sum - upper;
            long upLimit = sum - lower;
            // 1.2 统计 sumTimesMap 找到值的次数
            Map<Long, Integer> subMap = sumTimesMap.subMap(lowLimit, true, upLimit, true);
            // 1.2.1 遍历次数并统计
            if (null != subMap) {
                for (Map.Entry<Long, Integer> entry: subMap.entrySet()) {
                    total += entry.getValue();
                }
            }
            // 1.3 将本次 sum i 加入到 sumTimesMap 中
            Integer count = sumTimesMap.get(sum);
            if (count == null) {
                sumTimesMap.put(sum, 1);
            } else {
                sumTimesMap.put(sum, count + 1);
            }
        }
        // 2 返回总计数
        return total;
    }
	
	public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,5,-1};
        int lower = -2;
        int upper = 2;
        int res = solution.countRangeSum(nums, lower, upper);
        System.out.println(res);
        Assert.assertEquals(3, res);
    }
}
