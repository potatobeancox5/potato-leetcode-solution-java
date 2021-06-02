package com.potato.study.leetcodecn.p00204.t001;

import java.util.Arrays;

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

    /**
     * 直接用一个 数组 记录 结果 每次判断
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int primeCount = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primeCount++;
                // 往后改变
                for (int j = i; j < n/i + 1; j++) {
                    int index = i * j;
                    if (index < n) {
                        isPrime[index] = false;
                    } else {
                        break;
                    }
                }
            }
        }
        return primeCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int count = solution.countPrimes(10);
        System.out.println(count);
        Assert.assertEquals(4, count);

        count = solution.countPrimes(0);
        System.out.println(count);
        Assert.assertEquals(0, count);

        count = solution.countPrimes(2);
        System.out.println(count);
        Assert.assertEquals(0, count);
    }
}
