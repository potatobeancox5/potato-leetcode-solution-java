package com.potato.study.leetcode.p0473;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 
 * @author liuzhao11
 * 
 *         473. Matchsticks to Square
 * 
 *        Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.

Example 1:
Input: [1,1,2,2,2]
Output: true

Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:
Input: [3,3,3,3,4]
Output: false

Explanation: You cannot find a way to form a square with all the matchsticks.
Note:
The length sum of the given matchsticks is in the range of 0 to 10^9.
The length of the given matchstick array will not exceed 15.

 *         思路：
 *         473. Matchsticks to Square

给定一组火柴长度 求能否将这些火柴https://blog.csdn.net/u013383813/article/details/88380061


473. Matchsticks to Square

boolean dfs 返回值是结果true 是能构成
dfs nums index target【4】
if index 小于0
返回 target 是否都减到0
for i0-4
if target i 大于 num index
target -等于 num index
if dfs index -1
返回true
target 加回来
end for
返回false

主函数
求和 能否被4整除
可以的话
排序
return dfs  len -1
 *
 *         题意：
 * 
 */
public class Solution {

    public boolean makesquare(int[] nums) {
        // 求和 能否被4整除
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum <= 0 || sum % 4 != 0) {
            return false;
        }
        // 排序
        Arrays.sort(nums);
        int[] target = {sum /4, sum /4, sum /4, sum /4};
        return dfs(nums, nums.length - 1, target);
    }


    /**
     * dfs 查找目前结果是否能够够正一个正方形
     * @param nums      当前数组
     * @param index     当前用到的index 从大到小
     * @param target    目前每个边还差的数字
     * @return
     */
    private boolean dfs(int[] nums, int index, int[] target) {
        // 终止条件
        if (index < 0 && target[0] + target[1] + target[2] + target[3] == 0) {
            return true;
        }
        // 遍历每个边 找到是否可以存在组成情况
        for (int i = 0; i < 4; i++) {
            if (target[i] >= nums[index]) {
                target[i] -= nums[index];
                if (dfs(nums, index - 1, target)) {
                    return true;
                }
                target[i] += nums[index];
            }
        }
        return false;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,2,2,2};
        boolean res = solution.makesquare(nums);
        System.out.println(res);
        Assert.assertEquals(true, res);


        int[] nums1 = {3,3,3,3,4};
        res = solution.makesquare(nums1);
        System.out.println(res);
        Assert.assertEquals(false, res);

        int[] nums2 = {};
        res = solution.makesquare(nums2);
        System.out.println(res);
        Assert.assertEquals(false, res);

    }
}
