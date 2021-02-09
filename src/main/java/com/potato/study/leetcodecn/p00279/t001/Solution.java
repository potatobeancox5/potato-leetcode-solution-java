package com.potato.study.leetcodecn.p00279.t001;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 279. 完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

  

 示例 1：

 输入：n = 12
 输出：3
 解释：12 = 4 + 4 + 4
 示例 2：

 输入：n = 13
 输出：2
 解释：13 = 4 + 9
  
 提示：

 1 <= n <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/perfect-squares
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 生成平方数 list 升序排列
     * minCount 全部初始化为 -1 表示不可达
     * minCount i 为达到1 需要的完全平方数量
     * minCount 1 = 1
     * minCount 0 = 0
     *
     * minCount i = min {list 中值 k， list k 小于等于 i  minCount[i - list k] + 1}
     * @param n
     * @return
     */
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        int tmp;
        int num = 0;
        do {
            tmp = num * num;
            list.add(tmp);
            num++;
        } while (tmp <= n);
        int[] minCount = new int[n+1];
        Arrays.fill(minCount, -1);
        minCount[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 遍历 map
            int min = Integer.MAX_VALUE;
            for (int factor : list) {
                if (factor > i) {
                    break;
                }
                // 这个组合不太行
                if (minCount[i - factor] == -1) {
                    continue;
                }
                min = Math.min(min, minCount[i - factor] + 1);
            }
            if (min != Integer.MAX_VALUE) {
                minCount[i] = min;
            }
        }
        return minCount[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nn = solution.numSquares(12);
        System.out.println(nn);
        Assert.assertEquals(3, nn);


        nn = solution.numSquares(13);
        System.out.println(nn);
        Assert.assertEquals(2, nn);
    }
}

