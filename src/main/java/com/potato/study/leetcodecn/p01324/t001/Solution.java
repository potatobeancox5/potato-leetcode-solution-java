package com.potato.study.leetcodecn.p01324.t001;


import org.junit.Assert;

/**
 * 1323. 6 和 9 组成的最大数字
 *
 * 给你一个仅由数字 6 和 9 组成的正整数 num。

 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。

 请返回你可以得到的最大数字。

  

 示例 1：

 输入：num = 9669
 输出：9969
 解释：
 改变第一位数字可以得到 6669 。
 改变第二位数字可以得到 9969 。
 改变第三位数字可以得到 9699 。
 改变第四位数字可以得到 9666 。
 其中最大的数字是 9969 。
 示例 2：

 输入：num = 9996
 输出：9999
 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 示例 3：

 输入：num = 9999
 输出：9999
 解释：无需改变就已经是最大的数字了。
  

 提示：

 1 <= num <= 10^4
 num 每一位上的数字都是 6 或者 9 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-69-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 直接看代码吧
     * @param num
     * @return
     */
    public int maximum69Number (int num) {
        int cha = 3;
        int temp = num;
        int max = 0;
        while (temp > 0) {
            int bit = temp % 10;
            if (bit == 6) {
                max = Math.max(max, cha);
            }
            cha *= 10;
            temp /= 10;
        }
        return num + max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maximum69Number(9996);
        // [1,3,3]
        System.out.println(res);
        Assert.assertEquals(9999, res);
    }
}
