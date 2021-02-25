package com.potato.study.leetcodecn.p00204.t001;

import org.junit.Assert;

/**
 * 204. 计数质数
 *
 * 统计所有小于非负整数 n 的质数的数量。

  

 示例 1：

 输入：n = 10
 输出：4
 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 示例 2：

 输入：n = 0
 输出：0
 示例 3：

 输入：n = 1
 输出：0
  

 提示：

 0 <= n <= 5 * 106

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/count-primes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 判断 数字是否为素数
     * @param i
     * @return
     */
    private boolean isPrime(int i) {
        if (i == 1) {
            return false;
        }
        for (int j = 2; j < i; j++) {
            if (i / j * j == i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int count = solution.countPrimes(10);
        System.out.println(count);
        Assert.assertEquals(4, count);
    }
}
