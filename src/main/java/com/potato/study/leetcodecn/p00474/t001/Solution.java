package com.potato.study.leetcodecn.p00474.t001;

/**
 * 470. 用 Rand7() 实现 Rand10()
 *
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。

 不要使用系统的 Math.random() 方法。

  

 示例 1:

 输入: 1
 输出: [7]
 示例 2:

 输入: 2
 输出: [8,4]
 示例 3:

 输入: 3
 输出: [8,1,10]
  

 提示:

 rand7 已定义。
 传入参数: n 表示 rand10 的调用次数。
  

 进阶:

 rand7()调用次数的 期望值 是多少 ?
 你能否尽量少调用 rand7() ?

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {


    public int rand7() {
        return -1;
    }

    /**
     * 生成一个 7进制的数字，然后转化成10进制
     * 1-7, 8-14,
     * @return
     */
    public int rand10() {
        // 生成 1 - 40
        int val = 0;
        do {
            int val1 = rand7();
            int val2 = rand7();
            val = val1 + (val2 - 1) * 7;
        } while (val > 40);
        // 生成 0 - 9
        int target = (val - 1 ) % 10;
        // 生成 1- 10
        return target + 1;
    }

}
