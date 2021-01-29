package com.potato.study.leetcodecn.p00350.t001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。

  

 示例 1：

 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 输出：[2,2]
 示例 2:

 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出：[4,9]
  

 说明：

 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 我们可以不考虑输出结果的顺序。
 进阶：

 如果给定的数组已经排好序呢？你将如何优化你的算法？
 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 交集 带次数
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap1 = countNum(nums1);
        Map<Integer, Integer> countMap2 = countNum(nums2);

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap1.entrySet()) {
            Integer num = entry.getKey();
            if (!countMap2.containsKey(num)) {
                continue;
            }
            Integer count1 = entry.getValue();
            Integer count2 = countMap2.get(num);
            for (int i = 0; i < Math.min(count1, count2); i++) {
                list.add(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private Map<Integer, Integer> countNum(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            count++;
            countMap.put(num, count);
        }
        return countMap;
    }
}
