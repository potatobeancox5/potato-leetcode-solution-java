package com.potato.study.leetcodecn.p01313.t001;


import java.util.Arrays;

/**
 * 1313. 解压缩编码列表
 *
 * 给你一个以行程长度编码压缩的整数列表 nums 。

 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。

 请你返回解压后的列表。

  

 示例：

 输入：nums = [1,2,3,4]
 输出：[2,4,4,4]
 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
 示例 2：

 输入：nums = [1,1,2,3]
 输出：[1,3,3]
  

 提示：

 2 <= nums.length <= 100
 nums.length % 2 == 0
 1 <= nums[i] <= 100

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/decompress-run-length-encoded-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 先算数组长度
     * @param nums
     * @return
     */
    public int[] decompressRLElist(int[] nums) {
        int arrayLen = 0;
        // 计算数组长度
        for (int i = 0; i < nums.length; i+=2) {
            arrayLen += nums[i];
        }
        int[] res = new int[arrayLen];
        // 记录当前写到 res 的位置
        int index = 0;
        for (int i = 0; i < nums.length; i+=2) {

            int value = nums[i + 1];
            int chNum = nums[i];
            int startIndex = index;
            index += chNum;
            Arrays.fill(res, startIndex, index, value);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,2,3};
        int[] res = solution.decompressRLElist(nums);
        // [1,3,3]
        System.out.println(Arrays.toString(res));
    }
}
