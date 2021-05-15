package com.potato.study.leetcodecn.p00315.t001;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 *
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

  

 示例：

 输入：nums = [5,2,6,1]
 输出：[2,1,1,0]
 解释：
 5 的右侧有 2 个更小的元素 (2 和 1)
 2 的右侧仅有 1 个更小的元素 (1)
 6 的右侧有 1 个更小的元素 (1)
 1 的右侧有 0 个更小的元素
  

 提示：

 0 <= nums.length <= 10^5
 -10^4 <= nums[i] <= 10^4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 粗犷的方式是每个位置都往后遍历 n*n 的时间复杂度
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String input = "bcabc";
//        String s = solution.removeDuplicateLetters(input);
//        System.out.println(s);
//        Assert.assertEquals("abc", s);
//
//
//        input = "cbacdcbc";
//        s = solution.removeDuplicateLetters(input);
//        System.out.println(s);
//        Assert.assertEquals("acdb", s);
    }
}
