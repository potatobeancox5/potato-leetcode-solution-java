package com.potato.study.leetcodecn.p00633.t001;


import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * 633. 平方数之和
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。

  

 示例 1：

 输入：c = 5
 输出：true
 解释：1 * 1 + 2 * 2 = 5
 示例 2：

 输入：c = 3
 输出：false
 示例 3：

 输入：c = 4
 输出：true
 示例 4：

 输入：c = 2
 输出：true
 示例 5：

 输入：c = 1
 输出：true

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 从 0 开始 生成平方数，直到 大于 c
     * 并在map 中查找已经生成过的平方，如果找到 返回，找不到，goodbye
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        Set<Long> squareNumSet = new HashSet<>();
        long num = 0;
        long temp;
        do {
            temp = num * num;
            squareNumSet.add(temp);
            if (squareNumSet.contains(c - temp)) {
                return true;
            }
            num++;
        } while (temp <= c);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int c = 5;
        boolean res = solution.judgeSquareSum(c);
        System.out.println(res);
        Assert.assertEquals(true, res);

        c = 3;
        res = solution.judgeSquareSum(c);
        System.out.println(res);
        Assert.assertEquals(false, res);

        c = 2;
        res = solution.judgeSquareSum(c);
        System.out.println(res);
        Assert.assertEquals(true, res);
    }

}
