package com.potato.study.leetcodecn.p01342.t001;


import org.junit.Assert;

/**
 * 1342. 将数字变成 0 的操作次数
 *
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。

  

 示例 1：

 输入：num = 14
 输出：6
 解释：
 步骤 1) 14 是偶数，除以 2 得到 7 。
 步骤 2） 7 是奇数，减 1 得到 6 。
 步骤 3） 6 是偶数，除以 2 得到 3 。
 步骤 4） 3 是奇数，减 1 得到 2 。
 步骤 5） 2 是偶数，除以 2 得到 1 。
 步骤 6） 1 是奇数，减 1 得到 0 。
 示例 2：

 输入：num = 8
 输出：4
 解释：
 步骤 1） 8 是偶数，除以 2 得到 4 。
 步骤 2） 4 是偶数，除以 2 得到 2 。
 步骤 3） 2 是偶数，除以 2 得到 1 。
 步骤 4） 1 是奇数，减 1 得到 0 。
 示例 3：

 输入：num = 123
 输出：12
  

 提示：

 0 <= num <= 10^6

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 奇数就-- 偶数就 /2
     * @param num
     * @return
     */
    public int numberOfSteps (int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                num--;
            } else {
                num /= 2;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 14;
        int res = solution.numberOfSteps(num);
        System.out.println(res);
        Assert.assertEquals(6, res);
    }
}
