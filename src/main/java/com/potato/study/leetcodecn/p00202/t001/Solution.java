package com.potato.study.leetcodecn.p00202.t001;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。

 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。

 如果 n 是快乐数就返回 True ；不是，则返回 False 。

  

 示例：

 输入：19
 输出：true
 解释：
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/happy-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * set 记录之前不快乐的数字，命中就返回不快乐， 就那么几种可能
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        /**
         * 之前遍历过的数字
         */
        Set<Integer> unhappyNumSet = new HashSet<>();
        int num = 0;
        int target = n;
        while (num != 1) {
            num = 0;
            // 计算 num
            while (target > 0) {
                int bit = target % 10;
                target /= 10;
                num += bit * bit;
            }
            if (num == 1) {
                return true;
            }
            if (unhappyNumSet.contains(num)) {
                return false;
            } else {
                unhappyNumSet.add(num);
            }
            target = num;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 19;
        boolean happy = solution.isHappy(n);
        System.out.println(happy);
        Assert.assertEquals(true, happy);
    }
}
