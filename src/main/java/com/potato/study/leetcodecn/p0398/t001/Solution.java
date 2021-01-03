package com.potato.study.leetcodecn.p0398.t001;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 398. 随机数索引
 *
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。

 注意：
 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。

 示例:

 int[] nums = new int[] {1,2,3,3,3};
 Solution solution = new Solution(nums);

 // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 solution.pick(3);

 // pick(1) 应该返回 0。因为只有nums[0]等于1。
 solution.pick(1);

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/random-pick-index
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    private int[] nums;
    private Random random;


    /**
     * 初始化蓄水池
     * 这个蓄水池应该是 一个 map
     * @param nums
     */
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /**
     * 每次遍历 nums 根据 taget 生成一个蓄水池，然后random 返回采样的坐标
     * 这个其实没有蓄水池淘汰的算法
     * @param target
     * @return
     */
    public int pick(int target) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                indexList.add(i);
            }
        }
        int targetIndex = random.nextInt(indexList.size());
        return indexList.get(targetIndex);
    }


//    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        String s = "abc";
//        String t = "ahbgdc";
//        boolean res = solution.isSubsequence(s, t);
//        System.out.println(res);
//        Assert.assertEquals(true, res);
//
//        s = "axc";
//        t = "ahbgdc";
//        res = solution.isSubsequence(s, t);
//        System.out.println(res);
//        Assert.assertEquals(false, res);
//    }
}

