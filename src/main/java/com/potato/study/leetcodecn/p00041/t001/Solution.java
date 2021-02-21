package com.potato.study.leetcodecn.p00041.t001;

import com.potato.study.leetcode.util.LeetcodeInputUtils;
import org.junit.Assert;

/**
 * 41. 缺失的第一个正数
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

  

 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？

  

 示例 1：

 输入：nums = [1,2,0]
 输出：3
 示例 2：

 输入：nums = [3,4,-1,1]
 输出：2
 示例 3：

 输入：nums = [7,8,9,11,12]
 输出：1
  

 提示：

 0 <= nums.length <= 300
 -231 <= nums[i] <= 231 - 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/first-missing-positive
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 终极算法 遍历 一遍nums 就知道缺失的第一个数字是多少
     * 遍历 nums 如果 num 大于等于 len 或者 小于 0 congtinue
     * 否则将其移动到正确的位置上 （交换）
     * 过一遍之后，从头开始 遍历数组 找到第一个对不上的元素
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (0 < nums[i] && nums[i] <= nums.length && i != nums[i] - 1) {
                // 如果待交换位置已经有了合适的数字就不用还了
                if (nums[nums[i] - 1] == nums[i]) {
                    break;
                }
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        // 过一遍之后，从头开始 遍历数组 找到第一个对不上的元素
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                return i + 1;
            }
        }
        // 都匹配上了
        return nums.length + 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = LeetcodeInputUtils.inputString2IntArray("[1,2,0]");
        int num = solution.firstMissingPositive(nums);
        System.out.println(num);
        Assert.assertEquals(3, num);

        nums = LeetcodeInputUtils.inputString2IntArray("[3,4,-1,1]");
        num = solution.firstMissingPositive(nums);
        System.out.println(num);
        Assert.assertEquals(2, num);

        nums = LeetcodeInputUtils.inputString2IntArray("[7,8,9,11,12]");
        num = solution.firstMissingPositive(nums);
        System.out.println(num);
        Assert.assertEquals(1, num);


        nums = LeetcodeInputUtils.inputString2IntArray("[1]");
        num = solution.firstMissingPositive(nums);
        System.out.println(num);
        Assert.assertEquals(2, num);

        nums = LeetcodeInputUtils.inputString2IntArray("[]");
        num = solution.firstMissingPositive(nums);
        System.out.println(num);
        Assert.assertEquals(1, num);


        nums = LeetcodeInputUtils.inputString2IntArray("[1,1]");
        num = solution.firstMissingPositive(nums);
        System.out.println(num);
        Assert.assertEquals(2, num);
    }
}
