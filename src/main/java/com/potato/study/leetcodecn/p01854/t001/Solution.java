package com.potato.study.leetcodecn.p01854.t001;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;

/**
 * 1854. 人口最多的年份
 *
 * 给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
 *
 * 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
 *
 * 返回 人口最多 且 最早 的年份。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：logs = [[1993,1999],[2000,2010]]
 * 输出：1993
 * 解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
 * 示例 2：
 *
 * 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
 * 输出：1960
 * 解释：
 * 人口最多为 2 ，分别出现在 1960 和 1970 。
 * 其中最早年份是 1960 。
 *  
 *
 * 提示：
 *
 * 1 <= logs.length <= 100
 * 1950 <= birthi < deathi <= 2050
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-population-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 1. 遍历 logs map （有序map） key 记录年份
     * 2. 遍历 logs 对于每个 key 找到中间的 位于 两个数字中间的key ++
     * @param logs
     * @return
     */
    public int maximumPopulation(int[][] logs) {
        if (null == logs || logs[0] == null) {
            throw new RuntimeException("参数必须非空");
        }
        java.util.SortedMap<Integer, Integer> countMap = new TreeMap<>();
        for (int[] log : logs) {
            countMap.put(log[0], 0);
            countMap.put(log[1], 0);
        }
        // 遍历 logs 对于每个 key 找到中间的 位于 两个数字中间的key ++
        for (int[] log : logs) {
            int startKey = log[0];
            int endKey = log[1];
            java.util.SortedMap<Integer, Integer> liveMap = countMap.subMap(startKey, endKey);
            if (null == liveMap) {
                continue;
            }
            for (int liveYear : liveMap.keySet()) {
                countMap.put(liveYear, countMap.get(liveYear) + 1);
            }
        }
        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {

            if (maxKey == 0) {
                maxKey = entry.getKey();
                continue;
            }

            if (entry.getValue() > countMap.get(maxKey)) {
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] logs = new int[][] {
                {1993,1999},{2000,2010}
        };
        int i = solution.maximumPopulation(logs);
        System.out.println(i);
        Assert.assertEquals(1993, i);
    }
}
