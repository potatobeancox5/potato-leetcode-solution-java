package com.potato.study.leetcodecn.p00060.t001;


import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 60. 排列序列
 *
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。

 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 给定 n 和 k，返回第 k 个排列。

  

 示例 1：

 输入：n = 3, k = 3
 输出："213"
 示例 2：

 输入：n = 4, k = 9
 输出："2314"
 示例 3：

 输入：n = 3, k = 1
 输出："123"
  

 提示：

 1 <= n <= 9
 1 <= k <= n!

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutation-sequence
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 通过每次计算可能性的数目 确定 使用哪个数字 作为开头
     * 1 有 n-1 ！ 种
     * 2 有 n-1 ！ 种
     * 那么计算 n！ / (n-1)!  =0 ->1, 1->2 依次类推可以确定第一个位置 当前数字k
     *
     * 然后计算 n！ - (k-1) * （n-1）！ 能计算出 当前当前数字确定了 k 之后 还需要确定的位置 同n那种确定方式 终止条件 是 1
     * 使用一个 list 不但移除元素 维护当前k 是个啥
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        // 计算 0 - n 阶乘使用
        getAllFactorial(n);
        // 存放下一个数字
        StringBuilder builder = new StringBuilder();
        List<Integer> unuseNumList = initUnuseList(n);
        boolean isMinus = false;
        while (n > 1) {
            // 当前数字是第几个 k / (n-1)!
            long num = k / getFactorial(n - 1);
            // 通过余数判定
            long remind = k % getFactorial(n-1);
            if (remind == 0 && num > 0) {
                // 那么就是 num 上一个系列的最后一个元素
                num--;
//                isMinus = true;
            }
            builder.append(unuseNumList.remove((int)(num)));
            // 往里找
//            if (isMinus) {
//                num++;
//                // 重置状态位
//                isMinus = false;
//            }
            if (num != 0) {
                k = (int) (k - num * getFactorial(n-1));
            }
            n--;
        }
        // 最后一个数字确认时发生的情况 正常情况 list 只能有一个元素了
        if (n == 1) {
            builder.append(unuseNumList.get(0));
        }
        return builder.toString();
    }

    /**
     * 初始化未使用的数字列表 1 - n
     * @param n
     * @return
     */
    private List<Integer> initUnuseList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }

    private Map<Integer, Long> factorialMap = new HashMap<>();
    /**
     * 计算从 0 - n的阶乘 缓存起来
     * @param n
     * @return
     */
    private void getAllFactorial(int n) {
        factorialMap.put(0, 1L);
        long tmp = 1;
        for (int i = 1; i <= n; i++) {
            tmp *= i;
            factorialMap.put(i, tmp);
        }
        return;
    }

    private long getFactorial(int target) {
        return factorialMap.get(target);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String permutation = solution.getPermutation(3, 3);
        System.out.println(permutation);
        Assert.assertEquals("213", permutation);


        permutation = solution.getPermutation(4, 9);
        System.out.println(permutation);
        Assert.assertEquals("2314", permutation);


        permutation = solution.getPermutation(3, 1);
        System.out.println(permutation);
        Assert.assertEquals("123", permutation);


        permutation = solution.getPermutation(3, 2);
        System.out.println(permutation);
        Assert.assertEquals("132", permutation);
    }
}
