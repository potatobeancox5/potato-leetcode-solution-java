package com.potato.study.leetcodecn.p00349.t001;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。

  

 示例 1：

 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 输出：[2]
 示例 2：

 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出：[9,4]
  

 说明：

 输出结果中的每个元素一定是唯一的。
 我们可以不考虑输出结果的顺序。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (int num : result) {
            res[i++] = num;
        }
        return res;
    }


//    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        int num = 2;
//        int[] countBits = solution.countBits(num);
//        System.out.println(Arrays.toString(countBits));
//        Assert.assertArrayEquals(new int[]{0,1,1}, countBits);
//
//        num = 5;
//        countBits = solution.countBits(num);
//        System.out.println(Arrays.toString(countBits));
//        Assert.assertArrayEquals(new int[]{0,1,1,2,1,2}, countBits);
//
//        num = 0;
//        countBits = solution.countBits(num);
//        System.out.println(Arrays.toString(countBits));
//        Assert.assertArrayEquals(new int[]{0}, countBits);
//    }
}
