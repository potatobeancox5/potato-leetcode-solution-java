package com.potato.study.leetcodecn.p00050.t001;


/**
 * 50. Pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。

  

 示例 1：

 输入：x = 2.00000, n = 10
 输出：1024.00000
 示例 2：

 输入：x = 2.10000, n = 3
 输出：9.26100
 示例 3：

 输入：x = 2.00000, n = -2
 输出：0.25000
 解释：2-2 = 1/22 = 1/4 = 0.25
  

 提示：

 -100.0 < x < 100.0
 -231 <= n <= 231-1
 -104 <= xn <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/powx-n
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 快速 幂等法 貌似 递归的下欧共比较好理解
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long nn = n;
        boolean isNegative = false;
        if (nn < 0) {
            isNegative = true;
            nn = -1 * nn;
        }
        double num = myPow(x, nn);
        if (isNegative){
            return 1.0 / num;
        }
        return num;
    }

    /**
     * 递归求 结果
     * @param x
     * @param n
     * @return
     */
    private double myPow(double x, long n) {
        if (n == 1) {
            return x;
        }
        // 计算
        if (n % 2 == 0) {
            double temp = myPow(x, n / 2);
            return temp * temp;
        } else {
            double temp = myPow(x, n / 2);
            return temp * temp * x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double x = 2.00000;
        int n = 10;
        double v = solution.myPow(x, n);
        System.out.println(v);
//        Assert.assertEquals(, v);
        x = 2.10000;
        n = 3;
        v = solution.myPow(x, n);
        System.out.println(v);

        x = 2;
        n = -2;
        v = solution.myPow(x, n);
        System.out.println(v);


        x = 1.00000;
        n = 2147483647;
        v = solution.myPow(x, n);
        System.out.println(v);




    }
}
