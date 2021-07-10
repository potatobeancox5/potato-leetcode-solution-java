package com.potato.study.leetcodecn.p00474.t001;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

/**
 * 474. 一和零
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *  
 *
 * 提示：
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 474
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int max = 0;
        int tmpM = 0;
        int tmpN = 0;
        Map<Integer, int[]> indexCountMap = new HashMap<>();
        // 当前窗口大小
        int currentCount = 0;
        for (int i = 0; i < strs.length; i++) {
            int[] count = getZeroAndOneNum(strs[i]);
            tmpM += count[0];
            tmpN += count[1];
            indexCountMap.put(i, count);
            currentCount++;
            if (tmpM <= m && tmpN <= n) {
                max = Math.max(max, currentCount);
                continue;
            }
            // 处理 current
            while (currentCount > 0 && (tmpM > m || tmpN > n)) {
                int toDeleteIndex = i - currentCount + 1;
                int[] deleteCount = indexCountMap.get(toDeleteIndex);
                if (deleteCount != null) {
                    tmpM -= deleteCount[0];
                    tmpN -= deleteCount[1];
                }
                currentCount--;
            }
        }
        return max;
    }

    /**
     *
     * @param numStr
     * @return
     */
    private int[] getZeroAndOneNum(String numStr) {
        int[] count = new int[2];
        if (numStr == null) {
            return count;
        }
        for (char ch : numStr.toCharArray()) {
            count[ch - '0']++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[]{
                "10", "0001", "111001", "1", "0"
        };
        int m = 5;
        int n = 3;
        int maxForm = solution.findMaxForm(strs, m, n);
        System.out.println(maxForm);
        Assert.assertEquals(4, maxForm);
    }

}
