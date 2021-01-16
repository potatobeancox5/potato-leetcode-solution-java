package com.potato.study.leetcodecn.p01295.t001;


/**
 * 1295. 统计位数为偶数的数字
 *
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。

  

 示例 1：

 输入：nums = [12,345,2,6,7896]
 输出：2
 解释：
 12 是 2 位数字（位数为偶数） 
 345 是 3 位数字（位数为奇数）  
 2 是 1 位数字（位数为奇数） 
 6 是 1 位数字 位数为奇数） 
 7896 是 4 位数字（位数为偶数）  
 因此只有 12 和 7896 是位数为偶数的数字
 示例 2：

 输入：nums = [555,901,482,1771]
 输出：1
 解释：
 只有 1771 是位数为偶数的数字。
  

 提示：

 1 <= nums.length <= 500
 1 <= nums[i] <= 10^5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 遍历计算数组数量
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        // 偶数数字的个数
        int bitNum = 0;
        if(nums == null) {
            return bitNum;
        }
        for (int num : nums) {
            String s = String.valueOf(num);
            if (s.length() % 2 == 0) {
                bitNum++;
            }
        }
        return bitNum;
    }
}