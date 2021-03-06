package com.potato.study.leetcodecn.p00137.t001;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:

 输入: [2,2,3,2]
 输出: 3
 示例 2:

 输入: [0,1,0,1,0,1,99]
 输出: 99

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/single-number-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 搞不懂 bit compute
     * 还是计数吧
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            count++;
            countMap.put(num, count);
        }
        // 遍历 map
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (1 == entry.getValue()) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
