package com.potato.study.leetcodecn.p00507.t001;


import org.junit.Assert;

/**
 * 507. 完美数
 *
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。

 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false

  

 示例 1：

 输入：28
 输出：True
 解释：28 = 1 + 2 + 4 + 7 + 14
 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 示例 2：

 输入：num = 6
 输出：true
 示例 3：

 输入：num = 496
 输出：true
 示例 4：

 输入：num = 8128
 输出：true
 示例 5：

 输入：num = 2
 输出：false
  

 提示：

 1 <= num <= 108

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/perfect-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    /**
     * 遍历 到 i* i == num
     * 因为 如果上式成立 那么 小于i的因数 j * k = num 这样一下子就找到2个因数
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        // 1 肯定是因数
        int sum = 1;
        // 保证 i 之前的因数 每次都能确定2个 加到sum中
        for (int i = 2; i * i <= num; i++) {
            // 找到因数
            if (num / i * i == num) {
                sum += i;
                if (num != i * i) {
                    sum += (num / i);
                }
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 28;
        boolean res = solution.checkPerfectNumber(num);
        System.out.println(res);
        Assert.assertEquals(true, res);


        num = 6;
        res = solution.checkPerfectNumber(num);
        System.out.println(res);
        Assert.assertEquals(true, res);

        num = 2;
        res = solution.checkPerfectNumber(num);
        System.out.println(res);
        Assert.assertEquals(false, res);
    }

}
